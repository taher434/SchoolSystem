import java.util.Scanner;

public class SchoolManagement {
    private String schoolName;
    private String address;
    private String contactNumber;
    private String mediumOfStudy;

    private Auditorium auditorium;
    private Playground playground;
    private NoticeBoard noticeBoard;
    private Employee[] employees;
    private Classroom[] classrooms;
    private Lab[] labs;

    private Bus[] buses = new Bus[100];
    private int busCount = 0;
    private Student[] students = new Student[100];
    private int studentCount = 0;

    private Department[] departments = new Department[20];
    private int deptCount = 0;

    public SchoolManagement(String schoolName, String address, String contactNumber, String mediumOfStudy) {
        this.schoolName = schoolName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.mediumOfStudy = mediumOfStudy;
    }

    public void createDepartment(int id, String name, String incharge) {
        if (deptCount < departments.length) {
            departments[deptCount] = new Department(id, name, incharge);
            deptCount++;
        }
    }

    public void showDepartments() {
        System.out.println("\n--- School Departments ---");
        for (int i = 0; i < deptCount; i++) {
            departments[i].departmentDetails();
        }
    }

    public void initialize(Auditorium auditorium, Playground playground, NoticeBoard noticeBoard, Employee[] employees, Classroom[] classrooms, Lab[] labs) {
        this.auditorium = auditorium;
        this.playground = playground;
        this.noticeBoard = noticeBoard;
        this.employees = employees;
        this.classrooms = classrooms;
        this.labs = labs;
    }

    public void isOpen() {
        System.out.println("The School is Open.");
    }

    public void schoolDetails() {
        System.out.println("School Name: " + schoolName);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Medium Of Study: " + mediumOfStudy);
    }

    public void runSchool() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSchool Management Menu:");
            System.out.println("A- Bus");
            System.out.println("B- Student");
            System.out.println("C- Employee");
            System.out.println("D- Class");
            System.out.println("E- Notice Board");
            System.out.println("F- Audotorium");
            System.out.println("G- ShowSchoolDetails");
            System.out.println("I- Departments");
            System.out.println("H- Exit");

            System.out.print("Select option: ");
            String choice = scanner.next().toUpperCase();

            switch (choice) {
                case "A":
                    System.out.println("1- Add Bus");
                    System.out.println("2- Show Bus Details");
                    System.out.println("3- Show Seats");
                    System.out.println("4- Go back");
                    int busChoice = scanner.nextInt();
                    if (busChoice == 1) {
                        System.out.print("Bus ID: "); int bid = scanner.nextInt();
                        System.out.print("Driver ID: "); int did = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Area List: "); String area = scanner.nextLine();
                        System.out.print("Bus Number: "); String bnum = scanner.nextLine();
                        System.out.print("Capacity: "); int cap = scanner.nextInt();
                        buses[busCount] = new Bus(bid, did, area, bnum, cap);
                        busCount++;
                    } else if (busChoice == 2) {
                        for(int i=0; i<busCount; i++) { 
                             if(buses[i] != null) buses[i].busDetails();
                        }
                    } else if (busChoice == 3) {
                        for(int i=0; i<busCount; i++) { 
                             if(buses[i] != null) buses[i].showSeats();
                        }
                    }
                    break;

                case "B":
                    System.out.println("1- Add Student");
                    System.out.println("2- Show Student Details");
                    System.out.println("3- Pay Fee");
                    System.out.println("4- Go back");
                    int stuChoice = scanner.nextInt();
                    if (stuChoice == 1) {
                        scanner.nextLine();
                        System.out.print("Name: "); String name = scanner.nextLine();
                        System.out.print("Class ID: "); int cid = scanner.nextInt();
                        System.out.print("Section: "); String sec = scanner.next();
                        System.out.print("Bus ID: "); int bid = scanner.nextInt();
                        System.out.print("Student ID: "); int sid = scanner.nextInt();
                        System.out.print("Type (P/H): ");
                        char type = scanner.next().toUpperCase().charAt(0);
                        if(type == 'P') {
                            students[studentCount] = new PrimaryStudent(sid, name, cid, sec, bid);
                            studentCount++;
                        } else if (type == 'H') {
                            students[studentCount] = new HigherSecondaryStudent(sid, name, cid, sec, bid);
                            studentCount++;
                        }
                    } else if (stuChoice == 2) {
                        for(int i=0; i<studentCount; i++) {
                            if(students[i] != null) students[i].studentDetails();
                        }
                    } else if (stuChoice == 3) {
                         for(int i=0; i<studentCount; i++) {
                            if(students[i] != null) students[i].payFees();
                        }
                    }
                    break;

                case "C":
                    System.out.println("1- Teacher");
                    System.out.println("2- Support Staff");
                    System.out.println("3- Go back");
                    int empChoice = scanner.nextInt();
                    if(empChoice == 1) {
                        System.out.println("1- Show Teacher Details");
                        System.out.println("2- Receive Salary");
                        System.out.println("3- Go back");
                        int tChoice = scanner.nextInt();
                        if (tChoice == 1) {
                             for(Employee emp : employees) {
                                 if (emp instanceof Teacher) emp.employeeDetails();
                             }
                        } else if (tChoice == 2) {
                            for(Employee emp : employees) {
                                 if (emp instanceof Teacher) emp.receiveSalary();
                             }
                        }
                    } else if (empChoice == 2) {
                        System.out.println("1- Show Support Staff Details");
                        System.out.println("2- Receive Salary");
                        System.out.println("3- Go back");
                        int sChoice = scanner.nextInt();
                         if (sChoice == 1) {
                             for(Employee emp : employees) {
                                 if (emp instanceof SupportStaff) emp.employeeDetails();
                             }
                        } else if (sChoice == 2) {
                            for(Employee emp : employees) {
                                 if (emp instanceof SupportStaff) emp.receiveSalary();
                             }
                        }
                    }
                    break;

                case "D":
                    System.out.println("1- Add Students");
                    System.out.println("2- Assign Teacher");
                    System.out.println("3- Show Details");
                    System.out.println("4- Go back");
                    int clsChoice = scanner.nextInt();
                    if (clsChoice == 3) {
                        for(Classroom cls : classrooms) {
                            if(cls != null) cls.classDetails();
                        }
                    }
                    break;

                case "E":
                    System.out.println("1- Display");
                    System.out.println("2- AddContent");
                    System.out.println("3- Go back");
                    int nbChoice = scanner.nextInt();
                    if (nbChoice == 1) noticeBoard.display();
                    if (nbChoice == 2) {
                        scanner.nextLine();
                        System.out.print("Content: ");
                        String content = scanner.nextLine();
                        noticeBoard.addContent(content);
                    }
                    break;

                case "F":
                    System.out.println("1- BookAuditorium");
                    System.out.println("2- Show Event Details");
                    System.out.println("3- Show Seats");
                    System.out.println("4- Go back");
                    int audChoice = scanner.nextInt();
                    if (audChoice == 1) {
                        scanner.nextLine();
                        System.out.print("EventName: "); String en = scanner.nextLine();
                        System.out.print("EventDate: "); String ed = scanner.nextLine();
                        System.out.print("EventTime: "); String et = scanner.nextLine();
                        System.out.print("Participants: "); int p = scanner.nextInt();
                        auditorium.bookAuditorium(en, ed, et, p);
                    } else if (audChoice == 2) {
                        auditorium.eventDetails();
                    } else if (audChoice == 3) {
                        auditorium.displaySeats();
                    }
                    break;

                case "G":
                    schoolDetails();
                    break;
                
                case "I":
                    System.out.println("1- Add Department");
                    System.out.println("2- Show Departments");
                    System.out.println("3- Go back");
                    int depChoice = scanner.nextInt();
                    if (depChoice == 1) {
                        System.out.print("Dept ID: "); int did = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Dept Name: "); String dname = scanner.nextLine();
                        System.out.print("Incharge Name: "); String dinch = scanner.nextLine();
                        createDepartment(did, dname, dinch);
                    } else if (depChoice == 2) {
                        showDepartments();
                    }
                    break;

                case "H":
                    running = false;
                    System.out.println("Thank You!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter School Name: "); 
        String name = scanner.nextLine();
        System.out.print("Enter Address: "); 
        String address = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Medium of Study: "); 
        String medium = scanner.nextLine();

        SchoolManagement school = new SchoolManagement(name, address, contact, medium);

        System.out.print("How many Departments? ");
        int depNum = scanner.nextInt();
        for(int i=0; i < depNum; i++) {
            System.out.println("Department " + (i+1));
            System.out.print("Dept ID: "); int did = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Dept Name: "); String dname = scanner.nextLine();
            System.out.print("Incharge Name: "); String dinch = scanner.nextLine();
            school.createDepartment(did, dname, dinch);
        }

        System.out.print("How many Teachers? ");
        int teachNum = scanner.nextInt();
        System.out.print("How many Support Staff? ");
        int staffNum = scanner.nextInt();
        
        Employee[] employees = new Employee[teachNum + staffNum];
        int empIndex = 0;

        for(int i=0; i<teachNum; i++) {
            System.out.println("Teacher " + (i+1));
            scanner.nextLine();
            System.out.print("Name: "); 
            String ename = scanner.nextLine();
            System.out.print("Salary: "); 
            double sal = scanner.nextDouble();
            System.out.print("Dept ID: "); 
            int did = scanner.nextInt();
            System.out.print("Employee ID: "); 
            int eid = scanner.nextInt();
            employees[empIndex++] = new Teacher(eid, ename, sal, did);
        }

        for(int i=0; i<staffNum; i++) {
            System.out.println("Support Staff " + (i+1));
            scanner.nextLine();
            System.out.print("Name: "); 
            String ename = scanner.nextLine();
            System.out.print("Salary: "); 
            double sal = scanner.nextDouble();
            System.out.print("Dept ID: "); 
            int did = scanner.nextInt();
            System.out.print("Employee ID: "); 
            int eid = scanner.nextInt();
            employees[empIndex++] = new SupportStaff(eid, ename, sal, did);
        }

        System.out.print("Auditorium Seats: "); 
        int seats = scanner.nextInt();
        Auditorium auditorium = new Auditorium(seats);

        System.out.print("Playground Area: "); 
        int area = scanner.nextInt();
        Playground playground = new Playground(area);

        System.out.print("How many Classrooms? ");
        int classNum = scanner.nextInt();
        Classroom[] classrooms = new Classroom[classNum];
      
        for (int i = 0; i < classNum; i++) {
            System.out.println("Classroom " + (i+1));
            System.out.print("Enter Class ID: "); 
            int cid = scanner.nextInt();
            System.out.print("Enter Class Name: "); 
            scanner.nextLine(); 
            String cn = scanner.nextLine();
            
            System.out.print("Enter Teacher ID to assign: "); 
            int tid = scanner.nextInt();
            
            Teacher assignedTeacher = null;
            for(Employee emp : employees) {
                if(emp instanceof Teacher && emp.employeeId == tid) {
                    assignedTeacher = (Teacher) emp;
                    break;
                }
            }

            System.out.print("Enter Student Count: "); 
            int sc = scanner.nextInt();
            System.out.print("Enter Equipment ID: "); 
            int eid = scanner.nextInt();

            classrooms[i] = new Classroom(cid, cn, assignedTeacher, sc, eid);
        }

        System.out.print("How many Labs? ");
        int labNum = scanner.nextInt();
        Lab[] labs = new Lab[labNum];
        for(int i=0; i < labNum; i++) {
            System.out.println("Lab " + (i+1));
            System.out.print("Lab Name: "); scanner.nextLine(); String ln = scanner.nextLine();
            System.out.print("Lab ID: "); int lid = scanner.nextInt(); 
            System.out.print("Incharge ID: "); int inchid = scanner.nextInt();
            System.out.print("Equipment ID: "); int eqid = scanner.nextInt();
            System.out.print("Equipment cost: "); int eqco = scanner.nextInt();
            System.out.print("Equipment Name: "); scanner.nextLine(); String eqna = scanner.nextLine();
            System.out.print("Equipment count: "); int eqcount = scanner.nextInt();

            labs[i] = new Lab(lid, inchid, ln, eqid, eqco, eqna, eqcount);
        }

        NoticeBoard noticeBoard = new NoticeBoard();

        school.initialize(auditorium, playground, noticeBoard, employees, classrooms, labs);

        school.runSchool();
    }
}