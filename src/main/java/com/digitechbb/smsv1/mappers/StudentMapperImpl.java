package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.StudentDto;
import com.digitechbb.smsv1.model.entities.Student;
import org.springframework.stereotype.Component;


@Component
public class StudentMapperImpl implements StudentMapper{

    @Override
    public StudentDto toDto(Student student) {
//        StudentDto studentDto = new StudentDto();
        if (student == null){
            return null;
        }
//        String firstName=student.getFirstName();
//        String lastName=student.getLastName();
//        String address=student.getAddress();
//        Gender gender=student.getGender();
//        LocalDate dateOfBirth=student.getDateOfBirth();
//        String email=student.getEmail();
//        String phone=student.getPhone();
//        Statut statut=student.getStatut();
//        String schoolLevel=student.getSchoolLevel();
//        String modeOfPayment=student.getModeOfPayment();
//        LocalDate startDate=student.getStartDate();
//        String parentContact=student.getParentContact();
//        StudentDto studentDto = new StudentDto(firstName,lastName,address,gender,dateOfBirth,email,phone,statut,schoolLevel,modeOfPayment,startDate,parentContact);
//
//        return studentDto;
        return new StudentDto(
                student.getStudentNumber(),
                student.getFirstName(),
                student.getLastName(),
                student.getAddress(),
                student.getGender(),
                student.getDateOfBirth(),
                student.getEmail(),
                student.getPhone(),
                student.getStatut(),
                student.getSchoolLevel(),
                student.getModeOfPayment(),
                student.getStartDate(),
                student.getParentContact()
        );
    }

    @Override
    public Student ToStudent(StudentDto studentDto) {
        if (studentDto==null)
        return null;
        Student student = new Student();
        student.setStudentNumber(studentDto.studentNumber());
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setAddress(studentDto.address());
        student.setGender(studentDto.gender());
        student.setDateOfBirth(studentDto.dateOfBirth());
        student.setEmail(studentDto.email());
        student.setPhone(studentDto.phone());
        student.setStatut(studentDto.statut());
        student.setSchoolLevel(studentDto.schoolLevel());
        student.setModeOfPayment(studentDto.modeOfPayment());
        student.setStartDate(studentDto.startDate());
        student.setParentContact(studentDto.parentContact());

        return student;
    }
}
