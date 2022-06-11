package focusmedia.assignment.client.dto;

import focusmedia.assignment.client.domain.Client;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientFindResponse {

    @ApiModelProperty(value = "식별자")
    private Long id;

    @ApiModelProperty(example = "홍길동", value = "고객 이름")
    private String name;

    @ApiModelProperty(example = "hong@email.com", value = "고객 이메일")
    private String email;

    @ApiModelProperty(example = "82", value = "국가 코드")
    private Integer countryCode;

    @ApiModelProperty(example = "01011112222", value = "고객 연락처")
    private String phoneNumber;

    @ApiModelProperty(example = "true", value = "개인정보 수집 동의 여부")
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
