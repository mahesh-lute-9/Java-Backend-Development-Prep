package com.example.crudSpringBootDemo.service;

import com.example.crudSpringBootDemo.dto.CreateStudentRequestDto;
import com.example.crudSpringBootDemo.dto.CreateStudentResponseDto;
import com.example.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import com.example.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.exception.DuplicateResourceException;
import com.example.crudSpringBootDemo.exception.ResourceNotFoundException;
import com.example.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    // =========================================================
    // CREATE
    // =========================================================

    public CreateStudentResponseDto createStudent(
            CreateStudentRequestDto studentReqDto) {

        Student student = mapToEntity(studentReqDto);

        if (emailExists(student)) {
            throw new DuplicateResourceException(
                    "Student with email "
                            + student.getEmail()
                            + " already exists"
            );
        }

        Student studentResp =
                studentRepository.save(student);

        return mapToDto(studentResp);
    }


    // =========================================================
    // GET ONE
    // =========================================================

    public CreateStudentResponseDto getStudent(Long id) {

        Student studentResp =
                studentRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Student with id "
                                                + id
                                                + " not found"
                                )
                        );

        return mapToDto(studentResp);
    }


    // =========================================================
    // GET ALL
    // =========================================================

    public List<CreateStudentResponseDto> getAllStudent() {

        List<Student> studentList =
                studentRepository.findByDeletedIsFalse();

        return studentList.stream()
                .map(this::mapToDto)
                .toList();
    }


    // =========================================================
    // UPDATE
    // =========================================================

    public UpdateStudentResponseDto updateStudent(
            Long id,
            UpdateStudentRequestDto studentReq) {

        Student existingStudent =
                studentRepository
                        .findByIdAndDeletedIsFalse(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Student with id "
                                                + id
                                                + " not found"
                                )
                        );

        existingStudent.setName(
                studentReq.getName()
        );

        existingStudent.setRollNo(
                studentReq.getRollNo()
        );

        existingStudent.setSubject(
                studentReq.getSubject()
        );

        existingStudent.setAge(
                studentReq.getAge()
        );

        existingStudent.setDeleted(false);

        existingStudent.setUpdatedAt(
                LocalDateTime.now()
        );

        Student savedStudent =
                studentRepository.save(existingStudent);

        return mapToUpdateDto(savedStudent);
    }


    // =========================================================
    // HARD DELETE
    // =========================================================

    public void deleteStudent(Long id) {

        Student studentToBeDeleted =
                studentRepository
                        .findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Student with id "
                                                + id
                                                + " not found"
                                )
                        );

        studentRepository.delete(studentToBeDeleted);
    }


    // =========================================================
    // SOFT DELETE
    // =========================================================

    public void deleteStudentSoftly(Long id) {

        Student studentToBeDeleted =
                studentRepository
                        .findByIdAndDeletedIsFalse(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Student with id "
                                                + id
                                                + " not found"
                                )
                        );

        studentToBeDeleted.setDeleted(true);

        studentRepository.save(studentToBeDeleted);
    }


    // =========================================================
    // REQUEST DTO -> ENTITY
    // =========================================================

    private Student mapToEntity(
            CreateStudentRequestDto studentReqDto) {

        Student student = new Student();

        student.setName(
                studentReqDto.getName()
        );

        student.setAge(
                studentReqDto.getAge()
        );

        student.setEmail(
                studentReqDto.getEmail()
        );

        student.setRollNo(
                studentReqDto.getRollNo()
        );

        student.setSubject(
                studentReqDto.getSubject()
        );

        student.setCreatedAt(
                LocalDateTime.now()
        );

        student.setUpdatedAt(
                LocalDateTime.now()
        );

        student.setDeleted(false);

        return student;
    }


    // =========================================================
    // ENTITY -> CREATE RESPONSE DTO
    // =========================================================

    private CreateStudentResponseDto mapToDto(
            Student student) {

        CreateStudentResponseDto responseDto =
                new CreateStudentResponseDto();

        responseDto.setId(
                student.getId()
        );

        responseDto.setName(
                student.getName()
        );

        responseDto.setAge(
                student.getAge()
        );

        responseDto.setEmail(
                student.getEmail()
        );

        responseDto.setRollNo(
                student.getRollNo()
        );

        responseDto.setSubject(
                student.getSubject()
        );

        responseDto.setMessage(
                "Student saved successfully"
        );

        responseDto.setCreatedAt(
                student.getCreatedAt()
        );

        responseDto.setUpdatedAt(
                student.getUpdatedAt()
        );

        return responseDto;
    }


    // =========================================================
    // ENTITY -> UPDATE RESPONSE DTO
    // =========================================================

    private UpdateStudentResponseDto mapToUpdateDto(
            Student student) {

        UpdateStudentResponseDto responseDto =
                new UpdateStudentResponseDto();

        responseDto.setId(
                student.getId()
        );

        responseDto.setName(
                student.getName()
        );

        responseDto.setAge(
                student.getAge()
        );

        responseDto.setEmail(
                student.getEmail()
        );

        responseDto.setRollNo(
                student.getRollNo()
        );

        responseDto.setSubject(
                student.getSubject()
        );

        responseDto.setMessage(
                "Student updated successfully"
        );

        responseDto.setUpdatedAt(
                student.getUpdatedAt()
        );

        return responseDto;
    }


    // =========================================================
    // EMAIL CHECK
    // =========================================================

    private boolean emailExists(Student student) {

        return studentRepository
                .existsByEmail(student.getEmail());
    }
}