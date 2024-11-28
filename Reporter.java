public class Reporter {
    private String reporterName;
    private String usn;

    public Reporter(String reporterName, String usn) {
        this.reporterName = reporterName;
        this.usn = usn;
    }

    public String getReporterName() {
        return reporterName;
    }

    public String getUsn() {
        return usn;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public void displayReporterDetails() {
        System.out.println("Reporter Name: " + reporterName);
        System.out.println("USN: " + usn);
    }
}
