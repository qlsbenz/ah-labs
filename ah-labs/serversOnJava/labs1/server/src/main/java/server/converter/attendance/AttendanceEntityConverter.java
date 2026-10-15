package server.converter.attendance;

import server.DTO.response.attendance.AttendanceResponse;
import server.DTO.response.group.GroupResponse;
import server.DTO.response.lesson.LessonResponse;
import server.DTO.response.student.StudentResponse;
import server.DTO.response.subject.SubjectResponse;
import server.DTO.response.teacher.TeacherResponse;
import server.entity.*;
import server.model.AttendanceStatus;

public class AttendanceEntityConverter {
    public AttendanceResponse toResponse(AttendanceEntity attendance, LessonEntity lesson, StudentEntity student,
                                         GroupEntity studentGroup, GroupEntity group,
                                         SubjectEntity subject, TeacherEntity teacher) {

        return new AttendanceResponse(
                attendance.getId(),
                new LessonResponse(
                        lesson.getId(),
                        new SubjectResponse(
                                subject.getId(),
                                subject.getName()
                        ),
                        new TeacherResponse(
                                teacher.getId(),
                                teacher.getLastName(),
                                teacher.getFirstName(),
                                teacher.getMiddleName()
                        ),
                        new GroupResponse(group.getId(), group.getName()),
                        lesson.getDate(),
                        lesson.getLessonNumber()
                ),
                new StudentResponse(
                        student.getId(),
                        student.getLastName(),
                        student.getFirstName(),
                        student.getMiddlename(),
                        student.getStatus(),
                        new GroupResponse(
                                studentGroup.getId(),
                                studentGroup.getName()
                        )
                ),
                attendance.getStatus()
        );
    }
}

