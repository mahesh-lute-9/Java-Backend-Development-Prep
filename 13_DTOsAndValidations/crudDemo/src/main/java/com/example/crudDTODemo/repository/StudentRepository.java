package com.example.crudDTODemo.repository;

import com.example.crudDTODemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
