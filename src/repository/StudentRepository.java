package repository;

import model.Student;

import java.util.List;

public interface StudentRepository {
    public abstract boolean add(Student student);

    public abstract Student findById(int id);

    public abstract List<Student> findAll();

    public abstract boolean deleteById(int id);
}
