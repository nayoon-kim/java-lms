package nextstep.users.domain;

import nextstep.courses.domain.registration.RegistrationStatus;

import java.util.Objects;

public class Student {
    private Long id;
    private Long nsUserId;
    private Long sessionId;
    private RegistrationStatus registrationStatus;

    public Student(Long nsUserId, Long sessionId) {
        this(0L, nsUserId, sessionId, registrationStatus.PENDING);
    }

    public Student(Long id, Long nsUserId, Long sessionId, RegistrationStatus registrationStatus) {
        this.id = id;
        this.nsUserId = nsUserId;
        this.sessionId = sessionId;
        this.registrationStatus = registrationStatus;
    }

    public Long getNsUserId() {
        return nsUserId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public RegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(nsUserId, student.nsUserId) && Objects.equals(sessionId, student.sessionId) && registrationStatus == student.registrationStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nsUserId, sessionId, registrationStatus);
    }
}
