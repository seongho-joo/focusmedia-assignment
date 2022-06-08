package focusmedia.assignment.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import focusmedia.assignment.common.BaseRepositoryTest;
import focusmedia.assignment.user.exception.NotExistUserException;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@BaseRepositoryTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
            .countryCode(82)
            .name("홍길동")
            .email("test@test.com")
            .phoneNumber("01011112222")
            .personalInformationAgreement(true)
            .build();
    }

    @Test
    @DisplayName("회원 등록 테스트")
    void createUser() {
        // when
        userRepository.save(user);

        // then
        assertThat(user.getId()).isNotNull();
    }

    @Test
    @DisplayName("회원 조회 테스트")
    void findUserById() {
        // given
        User savedUser = userRepository.save(user);

        // when
        User foundUser = userRepository.findById(savedUser.getId())
            .orElseThrow(NotExistUserException::new);

        // then
        assertThat(foundUser).isEqualTo(savedUser);
    }

    @Test
    @DisplayName("회원 조회 실패 - 존재하지 않는 회원을 조회")
    void findUserById_fail() {
        // given
        Long userId = 100L;

        // when
        Optional<User> optionalUser = userRepository.findById(userId);

        // then
        assertThat(optionalUser).isEmpty();
    }
}