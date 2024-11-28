import java.util.HashMap;
import java.util.Map;

public class Department {
    private String departmentName;
    private String hodName;
    private static Map<String, String> hodMap = new HashMap<>();

    static {
        hodMap.put("Computer Science", "Dr. Jack");
        hodMap.put("Electronics", "Dr. John");
        hodMap.put("Mechanical", "Dr. Jane");
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.hodName = hodMap.get(departmentName);
    }

    public void notifyHOD(MaintenanceReport report) {
        System.out.println("Notifying HOD: " + hodName + " about report: " + report.getReportId());
    }

    public String getHodName() {
        return hodName;
    }
}
