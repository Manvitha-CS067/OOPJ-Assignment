import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestClassOutput {
    public static void writeReportsToFile(ArrayList<MaintenanceReport> reports, List<String> messages) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("output.txt"))) {
            
            String format = "%-10s|%-10s|%-27s|%-25s|%-15s|%-20s|%-15s|%-15s|%-20s%n";
            pw.printf(format, "Report ID", "USN", "Problem Description", "Reporter Name", "Status", "Assigned To", "Report Date", "Last Updated", "Department");
            				 		pw.println("-----------------------------------------------------------------------------------------------------------------------------");

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            for (MaintenanceReport report : reports) {
                pw.printf(format,
                        report.getReportId(),
                        report.getUsn(),
                        report.getProblemDescription(),
                        report.getReporterName(),
                        report.getStatus(),
                        report.getAssignedTo(),
                        report.getReportDate().format(dateFormatter),
                        report.getLastUpdated().format(dateFormatter),
                        report.getDepartment());
            }

            pw.println("\nAdditional Messages:");
            for (String message : messages) {
                pw.println(message);
            }

            System.out.println("Output has been written to output.txt");

        } catch (IOException e) {
            System.out.println("Error writing to the output file: " + e.getMessage());
        }
    }
}
