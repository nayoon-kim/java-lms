package nextstep.courses.domain.session;

import nextstep.courses.domain.registration.RegistrationOpenType;
import nextstep.courses.domain.registration.SessionRegistration;
import nextstep.users.domain.Student;
import nextstep.users.domain.Students;

import java.time.LocalDateTime;
import java.util.Objects;

public class Session {
    private Long id;
    private Long courseId;
    private String title;
    private String cover;
    private int cardinalNumber;
    private SessionCostType sessionCostType;
    private RegistrationOpenType registrationOpenType;
    private SessionRegistration sessionRegistration;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    Session(Long courseId, String title, String cover, int cardinalNumber, SessionCostType sessionCostType, RegistrationOpenType registrationOpenType, State state, int maxUser, LocalDateTime startDate, LocalDateTime endDate) {
        this(0L, courseId, title, cover, cardinalNumber, sessionCostType, registrationOpenType, state, maxUser, startDate, endDate);
    }

    Session(Long id, Long courseId, String title, String cover, int cardinalNumber, SessionCostType sessionCostType, RegistrationOpenType registrationOpenType, State state, int maxUser, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.cover = cover;
        this.cardinalNumber = cardinalNumber;
        this.sessionCostType = sessionCostType;
        this.registrationOpenType = registrationOpenType;
        this.sessionRegistration = new SessionRegistration(state, maxUser);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Session of(Long id, Long courseId, String title, String cover, int cardinalNumber, SessionCostType sessionCostType, RegistrationOpenType registrationOpenType, State state, int maxUser, LocalDateTime startDate, LocalDateTime endDate) {
        return new Session(id, courseId, title, cover, cardinalNumber, sessionCostType, registrationOpenType, state, maxUser, startDate, endDate);
    }

    public static Session of(Long courseId, String title, String cover, int cardinalNumber, SessionCostType sessionCostType, RegistrationOpenType registrationOpenType, State state, int maxUser, LocalDateTime startDate, LocalDateTime endDate) {
        return new Session(courseId, title, cover, cardinalNumber, sessionCostType, registrationOpenType, state, maxUser, startDate, endDate);
    }

    public Students enroll(Student student) {
        return sessionRegistration.register(student);
    }

    public Long getId() {
        return id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public int getCardinalNumber() {
        return cardinalNumber;
    }

    public SessionCostType getSessionCostType() {
        return sessionCostType;
    }

    public RegistrationOpenType getRegistrationOpenType() {
        return registrationOpenType;
    }

    public SessionRegistration getSessionRegistration() {
        return sessionRegistration;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return cardinalNumber == session.cardinalNumber && Objects.equals(id, session.id) && Objects.equals(courseId, session.courseId) && Objects.equals(title, session.title) && Objects.equals(cover, session.cover) && sessionCostType == session.sessionCostType && registrationOpenType == session.registrationOpenType && Objects.equals(sessionRegistration, session.sessionRegistration) && Objects.equals(startDate, session.startDate) && Objects.equals(endDate, session.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, title, cover, cardinalNumber, sessionCostType, registrationOpenType, sessionRegistration, startDate, endDate);
    }
}
