package repository;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryStudentRepository implements StudentRepository {
    private final Map<Integer, Student> studentsById = new HashMap<>();

    @Override
    public boolean add(Student student) {
        if (studentsById.containsKey(student.getId())) {
            return false;
        }
        studentsById.put(student.getId(), student);//اضافة الطالب باستخدام ال id كمفتاح
        return true;
    }

    @Override
    public Student findById(int id) {
        return studentsById.get(id); // يعيد الطالب بناءً على الـ id، وإذا مو موجود يرجع null
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentsById.values()); // تحويل Collection إلى List
    }

    @Override
    public boolean deleteById(int id) {
        return studentsById.remove(id) != null; // إذا كان الطالب موجودًا وتم حذفه، نرجع true، وإلا نرجع false
    }
}