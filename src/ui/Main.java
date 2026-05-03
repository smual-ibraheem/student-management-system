package ui;

import model.Student;
import repository.InMemoryStudentRepository;
import repository.StudentRepository;
import service.StudentService;
import service.Result;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentRepository repo = new InMemoryStudentRepository();
        StudentService service = new StudentService(repo);//Composition Root
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n1) Add student");
            System.out.println("2) Find student by id");
            System.out.println("3) Delete student by id");
            System.out.println("4) List all students");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": {
                    System.out.println("\n=== Add Student ===");

                    System.out.print("Full name: ");
                    String fullName = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Result<Student> result = service.createStudent(fullName, email);

                    System.out.println(result.getMessage());

                    if (result.isSuccess()) {
                        System.out.println("Student info:");
                        System.out.println(result.getData());
                    }
                    break;
                }

                case "2": {
                    System.out.println("\n=== Find Student By ID ===");

                    // نقرأ الـid بطريقة آمنة
                    Integer id = readInt(scanner, "Enter id: ");
                    if (id == null) {
                        break; // إدخال غير صالح → نرجع على الـmenu
                    }

                    // ننادي الخدمة
                    Result<Student> result = service.findStudentById(id);

                    // نطبع رسالة النتيجة
                    System.out.println(result.getMessage());

                    // إذا العملية نجحت نطبع معلومات الطالب
                    if (result.isSuccess()) {
                        System.out.println("Student info:");
                        System.out.println(result.getData());
                    }
                    break;
                }

                case "3": {
                    System.out.println("\n=== Delete Student By ID ===");

                    Integer id = readInt(scanner, "Enter id: ");
                    if (id == null) {
                        break; // إدخال غير صالح → رجوع للـmenu
                    }

                    Result<Void> result = service.deleteStudentById(id);

                    System.out.println(result.getMessage());
                    break;
                }

                case "4": {
                    System.out.println("\n=== Find All Students ===");

                    Result<List<Student>> result = service.findAllStudents();

                    System.out.println(result.getMessage());

                    if (result.isSuccess()) {
                        List<Student> students = result.getData();

                        if (students.isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            System.out.println("\n--- Students List ---");
                            for (Student student : students) {
                                System.out.println(student);
                            }
                            System.out.println("---------------------");
                        }
                    }
                    break;
                }

                case "0": {
                    System.out.println("\nExiting Student Management System...");
                    System.out.println("Good luck on your journey 🚀");
                    running = false;   // المتغيّر اللي شغّال عليه الـwhile
                    break;
                }

                default: {
                    System.out.println("\nInvalid choice!");
                    System.out.println("Available options: 0 - 4");
                    break;
                }
            }
        }
    }

    private static Integer readInt(Scanner scanner, String prompt) {
        // نطبع الرسالة للمستخدم (مثال: Enter id:)
        System.out.print(prompt);

        // نقرأ الإدخال كسطر كامل كنص ونشيل الفراغات
        String input = scanner.nextLine().trim();

        try {
            // نحاول نحول النص إلى رقم صحيح
            // إذا النص كان رقم → التحويل ينجح
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // إذا النص مو رقم (حروف، فراغ، رموز...)
            // نطبع رسالة خطأ واضحة
            System.out.println("Invalid number. Please enter a valid integer.");

            // نرجّع null لنخبر الـUI إن الإدخال غير صالح
            return null;
        }
    }
}
