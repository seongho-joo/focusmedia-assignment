package focusmedia.assignment.client.domain;

import static org.assertj.core.api.Assertions.assertThat;

import focusmedia.assignment.common.BaseRepositoryTest;
import focusmedia.assignment.client.exception.NotExistClientException;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@BaseRepositoryTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    private Client client;

    @BeforeEach
    void setUp() {
        client = Client.builder()
            .countryCode(82)
            .name("홍길동")
            .email("test@test.com")
            .phoneNumber("01011112222")
            .personalInformationAgreement(true)
            .build();
    }

    @Test
    @DisplayName("회원 등록 테스트")
    void saveClient() {
        // when
        clientRepository.save(client);

        // then
        assertThat(client.getId()).isNotNull();
    }

    @Test
    @DisplayName("회원 조회 테스트")
    void findClientById() {
        // given
        Client savedClient = clientRepository.save(client);

        // when
        Client foundClient = clientRepository.findById(savedClient.getId())
            .orElseThrow(NotExistClientException::new);

        // then
        assertThat(foundClient).isEqualTo(savedClient);
    }

    @Test
    @DisplayName("회원 조회 실패 - 존재하지 않는 회원을 조회")
    void findClientById_fail() {
        // given
        Long clientId = 100L;

        // when
        Optional<Client> optionalClient = clientRepository.findById(clientId);

        // then
        assertThat(optionalClient).isEmpty();
    }
}