import java.util.ArrayList;

class Department {
    private int departmentId;
    private String departmentName;
    private String inchargeName;
    private ArrayList<String> memberList;

    public Department(int departmentId, String departmentName, String inchargeName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.inchargeName = inchargeName;
        this.memberList = new ArrayList<>();
    }

    public void addMember(String member) {
        memberList.add(member);
        System.out.println("Member added to department: " + departmentName);
    }

    public void departmentDetails() {
        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Incharge Name: " + inchargeName);

        if (memberList.isEmpty()) {
            System.out.println("No members in this department.");
        } else {
            System.out.println("Department Members:");
            for (String member : memberList) {
                System.out.println("- " + member);
            }
        }
    }
}