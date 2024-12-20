import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MaintenanceReport implements MaintenanceActions {
    private String reportId;
    private String usn;
    private String problemDescription;
    private String reporterName;
    private String status;
    private String assignedTo;
    private LocalDate reportDate;
    private LocalDate lastUpdated;
    private String department;

    public MaintenanceReport(String reportId, String usn, String problemDescription, String reporterName, String status, String assignedTo, LocalDate reportDate, LocalDate lastUpdated, String department) {
        this.reportId = reportId;
        this.usn = usn;
        this.problemDescription = problemDescription;
        this.reporterName = reporterName;
        this.status = status;
        this.assignedTo = assignedTo;
        this.reportDate = reportDate;
        this.lastUpdated = lastUpdated;
        this.department = department;
    }

    public void displayReportDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Report ID: " + reportId);
        System.out.println("USN: " + usn);
        System.out.println("Problem: " + problemDescription);
        System.out.println("Reporter: " + reporterName);
        System.out.println("Status: " + status);
        System.out.println("Assigned To: " + assignedTo);
        System.out.println("Report Date: " + reportDate.format(formatter));
        System.out.println("Last Updated: " + lastUpdated.format(formatter));
        System.out.println("Department: " + department);
        System.out.println("-------------------------------");
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        this.lastUpdated = LocalDate.now();
    }

    public boolean needsEscalation() {
        long daysSinceReport = ChronoUnit.DAYS.between(reportDate, LocalDate.now());
        return daysSinceReport > 4 && !"Closed".equalsIgnoreCase(status);
    }

    public boolean escalateToPrincipal() {
        long daysSinceReport = ChronoUnit.DAYS.between(reportDate, LocalDate.now());
        return daysSinceReport > 7 && !"Closed".equalsIgnoreCase(status);
    }

    @Override
    public void assignTask(String assignedTo) {
        this.assignedTo = assignedTo;
        this.status = "In Progress";
        this.lastUpdated = LocalDate.now();
        System.out.println("Task assigned to: " + assignedTo);
    }

    @Override
    public void closeReport() {
        this.status = "Closed";
        this.lastUpdated = LocalDate.now();
        System.out.println("Report closed.");
    }

    public String getReportId() {
        return reportId;
    }

    public String getUsn() {
        return usn;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public String getReporterName() {
        return reporterName;
    }

    public String getStatus() {
        return status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public String getDepartment() {
        return department;
    }
}
