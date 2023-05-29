package nextstep.courses.domain;

import nextstep.courses.DuplicateSessionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

public class CourseTest {
    private Course c1;

    @BeforeEach
    void setUp() {
        c1 = new Course(1L, "clean code", 1L
                , LocalDateTime.of(2023, 5, 6, 12, 0, 0)
                , LocalDateTime.of(2023, 12, 6, 12, 0, 0));
    }

    @Test
    @DisplayName("강의 등록")
    void addSession() {
        c1.addSession(SessionTest.readySession);
        Sessions sessions = SessionsTest.ss1;

        assertThat(c1.getSessions()).isEqualTo(sessions);
    }

    @Test
    @DisplayName("동일 강의 등록 불가")
    void addSession_exception() {
        c1.addSession(SessionTest.readySession);
        assertThatThrownBy(() -> {
            c1.addSession(SessionTest.readySession);
        }).isInstanceOf(DuplicateSessionException.class).hasMessageContaining("동일 강의 등록 불가합니다.");
    }
}
