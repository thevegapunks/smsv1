package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.AbsenceDto;
import com.digitechbb.smsv1.model.entities.Absence;
import com.digitechbb.smsv1.model.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class AbsenceMapperImpl implements AbsenceMapper {
    @Override
    public Absence toEntity(AbsenceDto absenceDto) {
        Absence absence = new Absence();
        absence.setAbsenceNumber(absenceDto.absenceNumber());
        absence.setDate(absenceDto.date());
        absence.setHour(absenceDto.hour());
        absence.setNumberOfHour(absenceDto.numberOfHour());
        absence.setSubject(absenceDto.subject());
        absence.setReason(absenceDto.reason());
        absence.setStudent(absenceDtoToStudent(absenceDto));


        return absence;
    }

    @Override
    public AbsenceDto toDto(Absence absence) {
        Long studentId  = absenceToStudentId(absence);

        return new AbsenceDto(
                absence.getAbsenceNumber(),
                absence.getDate(),
                absence.getHour(),
                absence.getNumberOfHour(),
                absence.getSubject(),
                absence.getReason(),
                studentId
                );
    }

    private Long absenceToStudentId(Absence absence){
        if (absence==null) return null;
        Student student = absence.getStudent();
        if(student==null) return null;
        Long studentId = student.getId();
        if (studentId==null) return null;
        return studentId;
    }

    protected Student absenceDtoToStudent(AbsenceDto absenceDto) {
        if ( absenceDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setId(absenceDto.studentId());

        return student;
    }
}
