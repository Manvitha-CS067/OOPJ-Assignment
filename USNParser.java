public class USNParser {
    public static String getBranchFromUSN(String usn) {
        String branchCode = usn.substring(5, 7);
        switch (branchCode) {
            case "CS":
                return "Computer Science";
            case "EC":
                return "Electronics";
            case "ME":
                return "Mechanical";
            default:
                return "Unknown Branch";
        }
    }
}
