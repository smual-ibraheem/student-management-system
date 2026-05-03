package model;

public class Student {
    private final int id;
    private String fullName;
    private String email;
    private StudentStatus status;

    public Student(final int id, String fullName, String email, StudentStatus status) {
        if (id <= 0) throw new
                IllegalArgumentException("Id must be positive!!");
        if (fullName == null || fullName.trim().isEmpty()) throw new
                IllegalArgumentException("FullName is required!!");
        if (email == null || email.trim().isEmpty()) throw new
                IllegalArgumentException("Email is required!!");
        if (status == null) throw new
                IllegalArgumentException("Status is required!!");
        this.id = id;
        this.fullName = fullName.trim();
        this.email = email.trim();
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void changeFullName(String newName) {
        if (newName == null || newName.trim().isEmpty()) throw new
                IllegalArgumentException("FullName is required!!");
        this.fullName = newName.trim();
    }

    public void changeEmail(String newEmail) {
        if (newEmail == null || newEmail.trim().isEmpty()) throw new
                IllegalArgumentException("Email is required!!");
        this.email = newEmail.trim();//Normalization & Hidden Bugs
    }

    public void changeStatus(StudentStatus newStatus) {
        if (newStatus == null) throw new
                IllegalArgumentException("Status is required!!");
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return "[ [" + id + "] | " + fullName + " | " + email + " | " + status + " ]";
    }
}
