package org.example.repositoy;

import org.example.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    private final Map<Long, Student> studentDb;

    public StudentRepository(){
        studentDb = new HashMap<>();
    }

    public Student save(Student studentReq){
        studentDb.put(studentReq.getId(), studentReq);
        return studentReq;
    }

    public Student findById(Long id){
        return studentDb.get(id);
    }

    public List<Student> findAll(){
        return new ArrayList<>(studentDb.values());
    }
}
