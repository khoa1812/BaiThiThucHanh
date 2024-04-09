package controller;

import model.Student;
import storage.IReadWriteFile;
import storage.ReadWriteFile;

import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private static IReadWriteFile readWriteFile = new ReadWriteFile();
    private static List<Student> students = readWriteFile.readFile();

    public static void addNewStudent(Student student) {
        students.add(student);
        readWriteFile.writeFile(students);
        System.out.println("Sản phẩm đã được thêm thành công.");
    }

    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Không có sản phẩm nào.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void removeStudent(String studentId) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getStudentID().equals(studentId)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            readWriteFile.writeFile(students);
            System.out.println("Sản phẩm đã được xóa.");
        } else {
            System.out.println("Không tìm thấy sản phẩm với mã: " + studentId);
        }
    }

    public static void editStudent(String studentId, Student updatedStudent) {
        int studentIndex = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID().equals(studentId)) {
                studentIndex = i;
                break;
            }
        }
        if (studentIndex != -1) {

            students.set(studentIndex, updatedStudent);
            readWriteFile.writeFile(students);
            System.out.println("Sản phẩm đã được cập nhật thành công.");
        } else {
            System.out.println("Không tìm thấy sản phẩm với mã: " + studentId);
        }
    }

    public static void sortStudent() {
        students.sort(Comparator.comparing(Student::getStudentID));
        displayStudents();
    }
}
