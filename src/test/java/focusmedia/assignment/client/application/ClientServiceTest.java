package focusmedia.assignment.client.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import focusmedia.assignment.client.domain.Client;
import focusmedia.assignment.client.domain.ClientRepository;
import focusmedia.assignment.client.dto.ClientFindResponse;
import focusmedia.assignment.client.dto.ClientSaveRequest;
import focusmedia.assignment.client.exception.NotExistClientException;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private Client client;
    private final ClientSaveRequest request = new ClientSaveRequest("홍길동", "hong@gmail.com", 82, "01011112222", true);

    @BeforeEach
    void setUp() {
        client = Client.builder()
            .id(10L)
            .name(request.getName())
            .email(request.getEmail())
            .countryCode(request.getCountryCode())
            .phoneNumber(request.getPhoneNumber())
            .personalInformationAgreement(request.getPersonalInformationAgreement())
            .build();
    }

    @Test
    @DisplayName("유저 등록 성공")
    void saveClient() {
        // given
        given(clientRepository.save(any(Client.class))).willReturn(client);

        // when
        clientService.saveClient(request);

        // then
        verify(clientRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("유저 조회 성공")
    void findClient_success() {
        // given
        ClientFindResponse response = new ClientFindResponse(
            client.getId(),
            client.getName(),
            client.getEmail(),
            client.getCountryCode(),
            client.getPhoneNumber(),
            client.getPersonalInformationAgreement()
        );

        given(clientRepository.findById(anyLong())).willReturn(Optional.ofNullable(client));

        // when
        ClientFindResponse findResponse = clientService.findClient(10L);

        // then
        assertThat(findResponse.getId()).isEqualTo(response.getId());
    }

    @Test
    @DisplayName("유저 조회 실패 - 존재하지 않는 유저 조회")
    void findClient_failure() {
        // given
        given(clientRepository.findById(anyLong())).willThrow(NotExistClientException.class);

        // when, then
        assertThrows(NotExistClientException.class, () -> clientService.findClient(100L));
    }
}