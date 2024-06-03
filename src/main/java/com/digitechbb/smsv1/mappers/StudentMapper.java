package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.StudentDto;
import com.digitechbb.smsv1.model.entities.Student;

public interface StudentMapper {
     StudentDto studentToDto(Student student);
     Student ToStudent(StudentDto studentDto);
}
