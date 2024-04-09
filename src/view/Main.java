package view;

import controller.StudentManager;
import model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("======== MENU ========");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nDanh sách sinh viên:");
                    StudentManager.displayStudents();
                    break;
                case 2:
                    Student newStudent = createNew(scanner);
                    StudentManager.addNewStudent(newStudent);
                    break;
                case 3:
                    System.out.print("Nhập mã sinh viên cần sửa: ");
                    String studentIdToEdit = scanner.nextLine();
                    Student updatedStudent = createNew(scanner);
                    StudentManager.editStudent(studentIdToEdit, updatedStudent);
                    break;
                case 4:
                    System.out.println("Nhập mã sinh viên cần xóa: ");
                    String studentId = scanner.nextLine();
                    StudentManager.removeStudent(studentId);
                    break;
                case 5:
                    System.out.println("Sắp xếp sinh viên: ");
                    StudentManager.sortStudent();
                    break;
                case 0:
                    System.out.println("Thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);

        scanner.close();
    }


    public static Student createNew(Scanner scanner) {
        System.out.print("Nhập ID: ");
        String studentID = scanner.nextLine();

        System.out.print("Nhập họ và tên: ");
        String fullName = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();

        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        System.out.print("Nhập điểm trung bình: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

        return new Student(studentID, fullName, age, gender, address, gpa);
    }
}

