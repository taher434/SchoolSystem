
import java.util.ArrayList;
import java.util.Scanner;
public class SchoolManagement {
    // School basic information fields
    private String schoolName;
    private String address;
    private String contactNumber;
    private String mediumOfStudy;

    // School facility components
    private Auditorium auditorium;
    private Playground playground;
    private NoticeBoard noticeBoard;
    
    /// Ibrahim 
    private ArrayList<Employee> employees;
    private ArrayList<Student> students;
    private ArrayList<Bus> buses;
    private ArrayList<Classroom> classrooms;
    private ArrayList<Lab> labs;

    // Constructor to initialize basic school information
    public SchoolManagement(String schoolName, String address, String contactNumber, String mediumOfStudy) {
        this.schoolName = schoolName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.mediumOfStudy = mediumOfStudy;
        this.employees = new ArrayList<>();
        this.students = new ArrayList<>();
        this.buses = new ArrayList<>();
        this.classrooms = new ArrayList<>();
        this.labs = new ArrayList<>();
    }

    // Initializes major school facilities
    public void initialize(Auditorium auditorium, Playground playground, NoticeBoard noticeBoard) {
        this.auditorium = auditorium;
        this.playground = playground;
        this.noticeBoard = noticeBoard;
    }

    // Setter methods for various collections
    public void setClassrooms(ArrayList<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public void setLabs(ArrayList<Lab> labs) {
        this.labs = labs;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    // Displays basic school information
    public void schoolDetails() {
        System.out.println("School Name: " + schoolName);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Medium of Study: " + mediumOfStudy);
    }

    // Main school management menu and control loop
    public void runSchool() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSchool Management Menu (SMS):");
            System.out.println("A. Manage Buses");
            System.out.println("B. Manage Students");
            System.out.println("C. Manage Employees");
            System.out.println("D. Manage Classes");
            System.out.println("E. Manage NoticeBoard");
            System.out.println("F. Manage Auditorium");
            System.out.println("G. Show School Details");
            System.out.println("H. Exit");

            System.out.print("Select an option: ");
            String choice = scanner.next().toUpperCase();

            switch (choice) {
                case "A":
                    manageBuses(scanner);
                    break;
                case "B":
                    manageStudents(scanner);
                    break;
                case "C":
                    manageEmployees(scanner);
                    break;
                case "D":
                    manageClasses(scanner);
                    break;
                case "E":
                    manageNoticeBoard(scanner);
                    break;
                case "F":
                    manageAuditorium(scanner);
                    break;
                case "G":
                    schoolDetails();
                    break;
                case "H":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Bus management subsystem
    private void manageBuses(Scanner scanner) {
        boolean busMenu = true;
        while (busMenu) {
            System.out.println("\nBus Management:");
            System.out.println("1. Add Bus");
            System.out.println("2. Show Bus Details");
            System.out.println("3. Go back");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Bus creation logic
                    System.out.print("Enter Bus ID: ");
                    int busId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Driver Name: ");
                    String driverName = scanner.nextLine();
                    System.out.print("Enter Areas Covered: ");
                    String areaList = scanner.nextLine();
                    System.out.print("Enter Bus Number: ");
                    String busNumber = scanner.nextLine();
                    System.out.print("Enter Capacity: ");
                    int capacity = scanner.nextInt();
                    Bus newBus = new Bus(busId, driverName, areaList, busNumber, capacity);
                    buses.add(newBus);
                    System.out.println("Bus added successfully!");
                    break;
                case 2:
                    if (buses.isEmpty()) {
                        System.out.println("No buses available.");
                    } else {
                        for (Bus bus : buses) {
                            bus.busDetails();
                            System.out.println("-----------------");
                        }
                    }
                    break;
                case 3:
                    busMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Student management subsystem
    private void manageStudents(Scanner scanner) {
        boolean studentMenu = true;
        while (studentMenu) {
            System.out.println("\nStudent Management:SM");
            System.out.println("1. Add Student");
            System.out.println("2. Show Student Details");
            System.out.println("3. Pay Fee");
            System.out.println("4. Go back");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Student creation logic
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Class ID: ");
                    int classId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Section: ");
                    String section = scanner.nextLine();
                    System.out.print("Enter Bus ID: ");
                    int busId = scanner.nextInt();

                    // Student type selection
                    System.out.print("Is the student Primary or Higher Secondary? (P/H): ");
                    char type = scanner.next().toUpperCase().charAt(0);
                    Student newStudent = null;

                    if (type == 'P') {
                        newStudent = new PrimaryStudent(studentId, studentName, classId, section, busId);
                    } else if (type == 'H') {
                        newStudent = new HigherSecondaryStudent(studentId, studentName, classId, section, busId);
                    }

                    if (newStudent != null) {
                        students.add(newStudent);
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Invalid student type!");
                    }
                    break;
                case 2:
                    // Display all students
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        for (Student student : students) {
                            student.studentDetails();
                            System.out.println("-----------------");
                        }
                    }
                    break;
                case 3:
                    // Fee payment logic
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        System.out.print("Enter Student ID to pay fees: ");
                        int id = scanner.nextInt();
                        Student found = null;
                        for (Student student : students) {
                            if (student.studentId == id) {
                                found = student;
                                break;
                            }
                        }
                        if (found != null) {
                            found.payFees();
                        } else {
                            System.out.println("Student not found!");
                        }
                    }
                    break;
                case 4:
                    studentMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Employee management subsystem
    private void manageEmployees(Scanner scanner) {
        boolean employeeMenu = true;
        while (employeeMenu) {
            System.out.println("\nEmployee Management:");
            System.out.println("1. Add Employee");
            System.out.println("2. Show Employee Details");
            System.out.println("3. Receive Salary");
            System.out.println("4. Go back");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Employee creation logic
                    System.out.print("Enter Employee ID: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String employeeName = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Enter Department ID: ");
                    int departmentId = scanner.nextInt();
                    scanner.nextLine();

                    // Employee type selection
                    System.out.print("Is the employee a Teacher or Support Staff? (T/S): ");
                    char type = scanner.next().toUpperCase().charAt(0);
                    Employee newEmployee = null;

                    if (type == 'T') {
                        newEmployee = new Teacher(employeeId, employeeName, salary, departmentId);
                    } else if (type == 'S') {
                        newEmployee = new SupportStaff(employeeId, employeeName, salary, departmentId);
                    }

                    if (newEmployee != null) {
                        employees.add(newEmployee);
                        System.out.println("Employee added successfully!");
                    } else {
                        System.out.println("Invalid employee type!");
                    }
                    break;
                case 2:
                    // Display all employees
                    if (employees.isEmpty()) {
                        System.out.println("No employees available.");
                    } else {
                        for (Employee employee : employees) {
                            employee.employeeDetails();
                            System.out.println("-----------------");
                        }
                    }
                    break;
                case 3:
                    // Salary payment logic
                    if (employees.isEmpty()) {
                        System.out.println("No employees available.");
                    } else {
                        System.out.print("Enter Employee ID to receive salary: ");
                        int id = scanner.nextInt();
                        Employee found = null;
                        for (Employee employee : employees) {
                            if (employee.employeeId == id) {
                                found = employee;
                                break;
                            }
                        }
                        if (found != null) {
                            found.receiveSalary();
                        } else {
                            System.out.println("Employee not found!");
                        }
                    }
                    break;
                case 4:
                    employeeMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Classroom management subsystem
    private void manageClasses(Scanner scanner) {
        boolean classMenu = true;
        while (classMenu) {
            System.out.println("\nClass Management:");
            System.out.println("1. Add Classroom");
            System.out.println("2. Show Classroom Details");
            System.out.println("3. Go back");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Classroom creation logic
                    System.out.print("Enter Class Name: ");
                    String className = scanner.nextLine();
                    System.out.print("Enter Student Count: ");
                    int studentCount = scanner.nextInt();
                    System.out.print("Enter Class Equipment ID: ");
                    int classEquipmentId = scanner.nextInt();
                    System.out.print("Enter Bench Count: ");
                    int benchCount = scanner.nextInt();
                    System.out.print("Enter Fan Count: ");
                    int fanCount = scanner.nextInt();
                    System.out.print("Enter Light Count: ");
                    int lightCount = scanner.nextInt();
                    classrooms.add(new Classroom(studentCount, className, classEquipmentId, benchCount, fanCount, lightCount));
                    System.out.println("Classroom added successfully!");
                    break;
                case 2:
                    // Display all classrooms
                    if (classrooms.isEmpty()) {
                        System.out.println("No classrooms available.");
                    } else {
                        for (Classroom classroom : classrooms) {
                            classroom.classDetails();
                            System.out.println("-----------------");
                        }
                    }
                    break;
                case 3:
                    classMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Notice Board management subsystem
    private void manageNoticeBoard(Scanner scanner) {
        boolean noticeBoardMenu = true;
        while (noticeBoardMenu) {
            System.out.println("\nNotice Board Management:");
            System.out.println("1. Display Notice Board");
            System.out.println("2. Add Content to Notice Board");
            System.out.println("3. Go back");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    noticeBoard.display();
                    break;
                case 2:
                    System.out.print("Enter announcement to add to the Notice Board: ");
                    String content = scanner.nextLine();
                    noticeBoard.addContent(content);
                    break;
                case 3:
                    noticeBoardMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Auditorium management subsystem
    private void manageAuditorium(Scanner scanner) {
        boolean auditoriumMenu = true;
        while (auditoriumMenu) {
            System.out.println("\nAuditorium Management:");
            System.out.println("1. Book Auditorium");
            System.out.println("2. Show All Event Details");
            System.out.println("3. Show Seats");
            System.out.println("4. Go back");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Auditorium booking logic
                    System.out.print("Enter Event Name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter Event Date (YYYY-MM-DD): ");
                    String eventDate = scanner.nextLine();
                    System.out.print("Enter Event Time (HH:MM): ");
                    String eventTime = scanner.nextLine();
                    System.out.print("Enter number of participants: ");
                    int participants = scanner.nextInt();
                    auditorium.bookAuditorium(eventName, eventDate, eventTime, participants);
                    break;
                case 2:
                    auditorium.eventDetails();
                    break;
                case 3:
                    auditorium.displaySeats();
                    break;
                case 4:
                    auditoriumMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Main program entry point
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // School setup
        System.out.print("Enter School Name: ");
        String schoolName = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter Medium of Study: ");
        String mediumOfStudy = scanner.nextLine();

        SchoolManagement school = new SchoolManagement(schoolName, address, contactNumber, mediumOfStudy);

        // Notice Board setup
        NoticeBoard noticeBoard = new NoticeBoard();
        System.out.print("Do you want to add a notice to the notice board? (Y/N): ");
        char addNotice = scanner.next().toUpperCase().charAt(0);
        scanner.nextLine();
        if (addNotice == 'Y') {
            System.out.print("Enter your announcement: ");
            String announcement = scanner.nextLine();
            noticeBoard.addContent(announcement);
        }

        // Facility setup
        System.out.print("Enter number of seats in Auditorium: ");
        int numberOfSeats = scanner.nextInt();
        Auditorium auditorium = new Auditorium(numberOfSeats);

        System.out.print("Enter Playground size (in square meters): ");
        int playgroundArea = scanner.nextInt();
        Playground playground = new Playground(playgroundArea);

        school.initialize(auditorium, playground, noticeBoard);

        // Classroom setup
        System.out.print("How many classrooms to create? ");
        int numClassrooms = scanner.nextInt();
        ArrayList<Classroom> classrooms = new ArrayList<>();
        for (int i = 1; i <= numClassrooms; i++) {
            System.out.println("Enter details for Classroom " + i + ":");
            System.out.print("Enter Class Name: ");
            scanner.nextLine();
            String className = scanner.nextLine();
            System.out.print("Enter Student Count: ");
            int studentCount = scanner.nextInt();
            System.out.print("Enter Class Equipment ID: ");
            int classEquipmentId = scanner.nextInt();
            System.out.print("Enter Bench Count: ");
            int benchCount = scanner.nextInt();
            System.out.print("Enter Fan Count: ");
            int fanCount = scanner.nextInt();
            System.out.print("Enter Light Count: ");
            int lightCount = scanner.nextInt();
            classrooms.add(new Classroom(studentCount, className, classEquipmentId, benchCount, fanCount, lightCount));
        }

        // Lab setup
        System.out.print("How many labs to create? ");
        int numLabs = scanner.nextInt();
        ArrayList<Lab> labs = new ArrayList<>();
        for (int i = 1; i <= numLabs; i++) {
            System.out.println("Enter details for Lab " + i + ":");
            System.out.print("Enter Lab Name: ");
            scanner.nextLine();
            String labName = scanner.nextLine();
            System.out.print("Enter Lab Equipment Count: ");
            int labEquipmentCount = scanner.nextInt();
            ArrayList<String> labEquipment = new ArrayList<>();
            for (int j = 1; j <= labEquipmentCount; j++) {
                System.out.print("Enter Equipment Name: ");
                String equipmentName = scanner.next();
                labEquipment.add(equipmentName);
            }
            System.out.print("Enter Bench Count: ");
            int benchCount = scanner.nextInt();
            System.out.print("Enter Fan Count: ");
            int fanCount = scanner.nextInt();
            System.out.print("Enter Light Count: ");
            int lightCount = scanner.nextInt();
            labs.add(new Lab(labName, labEquipmentCount, labEquipment, benchCount, fanCount, lightCount));
        }

        // Employee setup
        System.out.print("How many teachers to add? ");
        int numTeachers = scanner.nextInt();
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= numTeachers; i++) {
            System.out.println("Enter details for Teacher " + i + ":");
            System.out.print("Enter Employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Teacher's Name: ");
            String teacherName = scanner.nextLine();
            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            System.out.print("Enter Department ID: ");
            int departmentId = scanner.nextInt();
            employees.add(new Teacher(employeeId, teacherName, salary, departmentId));
        }

        System.out.print("How many support staff to add? ");
        int numSupportStaff = scanner.nextInt();
        for (int i = 1; i <= numSupportStaff; i++) {
            System.out.println("Enter details for Support Staff " + i + ":");
            System.out.print("Enter Employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Support Staff's Name: ");
            String staffName = scanner.nextLine();
            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            System.out.print("Enter Department ID: ");
            int departmentId = scanner.nextInt();
            employees.add(new SupportStaff(employeeId, staffName, salary, departmentId));
        }

        // Final system initialization
        school.setClassrooms(classrooms);
        school.setLabs(labs);
        school.setEmployees(employees);

        // Start the main program loop
        school.runSchool();
    }
}