import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestClassInput {
    public static void main(String[] args) {
        ArrayList<MaintenanceReport> reports = new ArrayList<>();
        List<String> messages = new ArrayList<>();
        Principal principal = new Principal("Dr. Smith");
        MaintenanceTeam maintenanceTeam = new MaintenanceTeam("Maintenance Team");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            File inputFile = new File("input1.txt");
            Scanner sc = new Scanner(inputFile);

            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split("\\|");

                if (data.length != 8) {
                    System.out.println("Incorrect number of fields in line: " + String.join("|", data));
                    continue;
                }

                for (int i = 0; i < data.length; i++) {
                    data[i] = data[i].trim();
                }

                LocalDate reportDate = LocalDate.parse(data[6], formatter);
                LocalDate lastUpdated = LocalDate.parse(data[7], formatter);
                String branch = USNParser.getBranchFromUSN(data[1]);

                MaintenanceReport report = new MaintenanceReport(data[0], data[1],data[2],data[3],data[4],data[5],reportDate,
			lastUpdated,branch);
                reports.add(report);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }

        System.out.println("Maintenance Reports:");
        for (MaintenanceReport report : reports) {
            report.displayReportDetails();
            System.out.println("Branch: " + report.getDepartment());
            System.out.println("-------------------------------");

            Department department = new Department(report.getDepartment());

            if ("Pending".equalsIgnoreCase(report.getStatus())) {
                maintenanceTeam.assignTask(report.getAssignedTo());
            } else if (report.needsEscalation()) {
                maintenanceTeam.assignTask(department.getHodName());
                String message = "Notifying HOD: " + department.getHodName() + " about report: " + report.getReportId();
                System.out.println(message);
                messages.add(message);
                department.notifyHOD(report);
                report.updateStatus("Notified");
            }

            if (report.escalateToPrincipal()) {
                maintenanceTeam.closeReport();
                String message = "Principal " + principal.getPrincipalName() + " is taking action on report: " + report.getReportId();
                System.out.println(message);
                messages.add(message);
                principal.takeAction(report);
                report.updateStatus("Escalated");
            }
        }

        TestClassOutput.writeReportsToFile(reports, messages);
    }
}
