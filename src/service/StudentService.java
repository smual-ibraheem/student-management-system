package service;

import model.Student;
import model.StudentStatus;
import repository.StudentRepository;

import java.util.List;

public class StudentService {

    private final StudentRepository repo;
    private int nextId = 1;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // Use Case 1: Create Student
    public Result<Student> createStudent(String fullName, String email) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return Result.fail("Full name is required!!");
        }
        if (email == null || email.trim().isEmpty()) {
            return Result.fail("Email is required!!");//Validation...
        }
        int id = nextId++;
        Student student = new Student(id, fullName, email, StudentStatus.ACTIVE);
        boolean added = repo.add(student);
        if (!added) {
            return Result.fail("Student already exists..");
        }
        return Result.ok("Student created successfully. ", student);
    }

    // Use Case 2: Find Student by ID
    public Result<Student> findStudentById(int id) {
        if (id <= 0) {
            return Result.fail("Invalid student id!");
        }
        Student student = repo.findById(id);
        if (student == null) {
            return Result.fail("Student not found!");
        }
        return Result.ok("Student found. ", student);
    }

    // Use Case 3: Delete Student
    public Result<Void> deleteStudentById(int id) {
        // implementation now
        if (id <= 0) {
            return Result.fail("Invalid student id!");
        }
        boolean deleted = repo.deleteById(id);
        if (!deleted) {
            return Result.fail("Student not found!");
        }
        return Result.ok("Student deleted successfully. ", null);
    }

    //Use Case 4: Find All Students
    public Result<List<Student>> findAllStudents() {
        List<Student> students = repo.findAll();
        if (students.isEmpty()) {
            return Result.fail("No students found!!");
        }
        return Result.ok("Students list found. ", students);
    }
}
