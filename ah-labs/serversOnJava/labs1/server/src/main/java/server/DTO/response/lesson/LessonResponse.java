package server.DTO.response.lesson;

import server.DTO.response.group.GroupResponse;
import server.DTO.response.subject.SubjectResponse;
import server.DTO.response.teacher.TeacherResponse;

public class LessonResponse {
    private final long id;
    private final SubjectResponse subject;
    private final TeacherResponse teacher;
    private final GroupResponse group;
    private final String date;
    private final int lessonNumber;

    public LessonResponse(long id, SubjectResponse subject, TeacherResponse teacher, GroupResponse group, long date, int lessonNumber) {
        this.id = id;
        this.subject = subject;
        this.teacher = teacher;
        this.group = group;
        this.date = date;
        this.lessonNumber = lessonNumber;
    }

    public long getId() {
        return id;
    }

    public SubjectResponse getSubject() {
        return subject;
    }

    public TeacherResponse getTeacher() {
        return teacher;
    }

    public GroupResponse getGroup() {
        return group;
    }

    public String getDate() {
        return date;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }
}
