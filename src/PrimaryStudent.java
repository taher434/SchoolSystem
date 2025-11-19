class PrimaryStudent extends Student {
    public PrimaryStudent(int studentId, String studentName, int classId, String section, int busId) {
        super(studentId, studentName, classId, section, busId);
    }

    @Override
    public void payFees() {
        System.out.println("Fees paid for Primary Student: " + getStudentName());
    }
}

//Ibrahim Sarran -  451000513