class HigherSecondaryStudent extends Student {
    public HigherSecondaryStudent(int studentId, String studentName, int classId, String section, int busId) {
        super(studentId, studentName, classId, section, busId);
    }

    @Override
    public void payFees() {
        System.out.println("Fees paid for Higher Secondary Student: " + getStudentName());
    }
}

// Ibrahim Sarran - 451000513