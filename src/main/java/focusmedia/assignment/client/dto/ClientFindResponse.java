package focusmedia.assignment.client.dto;

import focusmedia.assignment.client.domain.Client;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientFindResponse {

    private Long id;

    private String name;

    private String email;

    private Integer countryCode;

    private String phoneNumber;

    private Boolean personalInformationAgreement;

    public static ClientFindResponse from(Client client) {
        return new ClientFindResponse(
            client.getId(),
            client.getName(),
            client.getEmail(),
            client.getCountryCode(),
            client.getPhoneNumber(),
            client.getPersonalInformationAgreement()
        );
    }
}
