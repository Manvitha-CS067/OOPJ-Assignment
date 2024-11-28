public class Principal {
    private String principalName;

    public Principal(String principalName) {
        this.principalName = principalName;
    }

    public void takeAction(MaintenanceReport report) {
        System.out.println("Principal " + principalName + " is taking action on report: " + report.getReportId());
    }

    public String getPrincipalName() {
        return principalName;
    }
}
