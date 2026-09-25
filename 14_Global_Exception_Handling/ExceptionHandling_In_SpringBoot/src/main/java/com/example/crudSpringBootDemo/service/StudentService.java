package com.example.crudSpringBootDemo.service;

import com.example.crudSpringBootDemo.dto.CreateStudentRequestDTO;
import com.example.crudSpringBootDemo.dto.StudentResponseDTO;
import com.example.crudSpringBootDemo.dto.UpdateStudentRequestDTO;
import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    // =========================================================
    // CREATE
    // =========================================================

    public StudentResponseDTO createStudent(
            CreateStudentRequestDTO requestDTO) {

        // Request DTO -> Entity
        Student student = new Student();

        student.setName(requestDTO.getName());
        student.setEmail(requestDTO.getEmail());
        student.setAge(requestDTO.getAge());
        student.setRollNo(requestDTO.getRollNo());
        student.setSubject(requestDTO.getSubject());

        // Newly created student is active.
        student.setDeleted(false);

        // Set timestamps.
        LocalDateTime now = LocalDateTime.now();
        student.setCreatedAt(now);
        student.setUpdatedAt(now);

        // Save entity into database.
        Student savedStudent = studentRepository.save(student);

        // Entity -> Response DTO
        return mapToResponseDTO(
                savedStudent,
                "Student created successfully"
        );
    }


    // =========================================================
    // GET ONE
    // =========================================================

    public StudentResponseDTO getStudent(Long id) {

        Optional<Student> student =
                studentRepository.findByIdAndDeletedFalse(id);

//        if (student.isEmpty()) {
//            return null;
//        }

        return mapToResponseDTO(
                student.get(),      // chances of getting NoSuchElementException it returns Optional
                "Student fetched successfully"
        );
    }


    // =========================================================
    // GET ALL
    // =========================================================

    public List<StudentResponseDTO> getAllStudents() {

        List<Student> students =
                studentRepository.findByDeletedFalse();

        return students
                .stream()
                .map(student ->
                        mapToResponseDTO(
                                student,
                                "Student fetched successfully"
                        )
                )
                .toList();
    }


    // =========================================================
    // UPDATE
    // =========================================================

    public StudentResponseDTO updateStudent(
            Long id,
            UpdateStudentRequestDTO requestDTO) {

        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedFalse(id);

        if (existingStudent.isEmpty()) {
            return null;
        }

        Student student = existingStudent.get();

        // Update fields from DTO.
        student.setName(requestDTO.getName());
        student.setEmail(requestDTO.getEmail());
        student.setAge(requestDTO.getAge());
        student.setRollNo(requestDTO.getRollNo());
        student.setSubject(requestDTO.getSubject());

        // Update timestamp.
        student.setUpdatedAt(LocalDateTime.now());

        // Save updated entity.
        Student updatedStudent =
                studentRepository.save(student);

        return mapToResponseDTO(
                updatedStudent,
                "Student updated successfully"
        );
    }


    // =========================================================
    // HARD DELETE
    // =========================================================

    public boolean deleteStudent(Long id) {

        /*
            existsById() checks the physical database record.

            We intentionally don't use:
            findByIdAndDeletedFalse()

            because hard delete should also be able to permanently
            remove a previously soft-deleted record.
        */

        if (!studentRepository.existsById(id)) {
            return false;
        }

        studentRepository.deleteById(id);

        return true;
    }


    // =========================================================
    // SOFT DELETE
    // =========================================================

    public boolean softDeleteStudent(Long id) {

        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedFalse(id);

        if (existingStudent.isEmpty()) {
            return false;
        }

        Student student = existingStudent.get();

        // Instead of deleting the row, mark it as deleted.
        student.setDeleted(true);

        // Save updated entity.
        studentRepository.save(student);

        return true;
    }


    // =========================================================
    // ENTITY -> RESPONSE DTO
    // =========================================================

    private StudentResponseDTO mapToResponseDTO(
            Student student,
            String message) {

        StudentResponseDTO responseDTO =
                new StudentResponseDTO();

        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setAge(student.getAge());
        responseDTO.setRollNo(student.getRollNo());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setCreatedAt(student.getCreatedAt());
        responseDTO.setUpdatedAt(student.getUpdatedAt());
        responseDTO.setMessage(message);

        return responseDTO;
    }
}