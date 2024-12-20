public class MaintenanceTeam implements MaintenanceActions {
    private String teamName;

    public MaintenanceTeam(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public void assignTask(String assignedTo) {
        System.out.println("Task assigned to: " + assignedTo);
    }

    @Override
    public void closeReport() {
        System.out.println("Report has been closed.");
    }
}
