package server.DTO.request.lesson;

public class EditLessonRequest {
    private final long id;
    private final long subjectId;
    private final String name;
    private final long teacherId;
    private final long groupId;
    private final String date;
    private final int lessonNumber;

    public EditLessonRequest(long id, long subjectId, String name, long teacherId, long groupId, String date, int lessonNumber) {
        this.id = id;
        this.subjectId = subjectId;
        this.name = name;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.date = date;
        this.lessonNumber = lessonNumber;
    }

    public long getId() {
        return id;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public long getGroupId() {
        return groupId;
    }

    public String getDate() {
        return date;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }
}
