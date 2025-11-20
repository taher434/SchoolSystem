class Department {
    private int departmentId;
    private String departmentName;
    private String inchargeName;
    private String[] memberList; 

    public Department(int departmentId, String departmentName, String inchargeName,String [] memberList) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.inchargeName = inchargeName;
        this.memberList = memberList; 
        
    }

    public void departmentDetails() {
        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Incharge Name: " + inchargeName);
       if (memberList != null) {
            System.out.println("Members:");
            for (String member : memberList) {
                if (member != null) {
                    System.out.println("- " + member);
                }
            }
        }
    
    }
}
<<<<<<< HEAD
//Taher Ramzi - 451000573
=======

//Ibrahim Sarran  - 451000513
>>>>>>> 592a22d0f6f21ff0899e9d2e00074fd551884244
