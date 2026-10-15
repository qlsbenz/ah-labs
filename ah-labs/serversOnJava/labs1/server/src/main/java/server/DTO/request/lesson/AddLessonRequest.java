package server.DTO.request.lesson;

public class AddLessonRequest {
    private final long subjectId;
    private final long teacherId;
    private final long groupId;
    private final String date;
    private final int lessonNumber;

    public AddLessonRequest(long subjectId, long teacherId, long groupId, String date, int lessonNumber) {
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.date = date;
        this.lessonNumber = lessonNumber;
    }

    public String getDate() {
        return date;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }
    public long getSubjectId() {
        return subjectId;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public long getGroupId() {
        return groupId;
    }

}
