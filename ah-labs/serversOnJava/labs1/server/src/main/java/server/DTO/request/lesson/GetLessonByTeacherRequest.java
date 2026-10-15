package server.DTO.request.lesson;

public class GetLessonByTeacherRequest {
    private final String startDate;
    private final String endDate;
    private final long teacherId;

    public GetLessonByTeacherRequest(String startDate, String endDate, long teacherId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public long getTeacherId() {
        return teacherId;
    }
}
