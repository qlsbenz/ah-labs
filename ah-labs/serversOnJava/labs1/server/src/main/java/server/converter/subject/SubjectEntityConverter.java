package server.converter.subject;

import server.DTO.response.subject.SubjectResponse;
import server.entity.SubjectEntity;

public class SubjectEntityConverter {
    public SubjectResponse toRespone(SubjectEntity subject) {
        return new SubjectResponse(
                subject.getId(),
                subject.getName()
        );
    }
}
