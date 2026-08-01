import java.sql.*;
import java.util.Scanner;

public class StudentDAO {

    Scanner sc = new Scanner(System.in);

    // Add Student
    public void addStudent() {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();
            sc.nextLine();

            String sql = "INSERT INTO students(name, course, marks) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, course);
            ps.setDouble(3, marks);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Added Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Students
    public void viewStudents() {

        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM students");

            System.out.println("\nID\tName\tCourse\tMarks");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("course") + "\t" +
                        rs.getDouble("marks"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent() {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM students WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Deleted Successfully!");
            else
                System.out.println("Student Not Found!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Student Marks
    public void updateStudent() {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Marks: ");
            double marks = sc.nextDouble();

            String sql = "UPDATE students SET marks=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, marks);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student Updated Successfully!");
            else
                System.out.println("Student Not Found!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}