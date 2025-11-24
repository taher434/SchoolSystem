class Department {
    private int departmentId;
    private String departmentName;
    private String inchargeName;
    private String[] memberList; 
    private int memberCount; 

    public Department(int departmentId, String departmentName, String inchargeName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.inchargeName = inchargeName;
        this.memberList = new String[50]; 
        this.memberCount = 0;
    }

    public void addMember(String member) {
        if (memberCount < memberList.length) {
            memberList[memberCount] = member;
            memberCount++;
            System.out.println("Member added: " + member);
        } else {
            System.out.println("Department is full!");
        }
    }

    public void departmentDetails() {
        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Incharge Name: " + inchargeName);
        System.out.println("Members:");
        for (int i = 0; i < memberCount; i++) {
            System.out.println("- " + memberList[i]);
        }
    }
}
//Ibrahim Sarran -  451000513