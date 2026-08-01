class Student {
    int studentId;
    String name;
    String course;
    double marks;

    // Method to set student details
    void setDetails(int id, String studentName, String studentCourse, double studentMarks) {
        studentId = id;
        name = studentName;
        course = studentCourse;
        marks = studentMarks;
    }

    // Method to display student details
    void displayDetails() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("Marks      : " + marks);
    }

    public static void main(String[] args) {
        Student s1 = new Student();

        s1.setDetails(101, "Deekshitha", "B.Tech CSE", 92.5);

        System.out.println("Student Information");
        System.out.println("-------------------");
        s1.displayDetails();
    }
}