package focusmedia.assignment.client.dto;

import focusmedia.assignment.client.domain.Client;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientSaveRequest {

    @NotBlank(message = "이름을 입력해주세요.")
    @ApiModelProperty(example = "홍길동", value = "고객 이름", required = true)
    private String name;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식대로 입력해주세요.")
    @ApiModelProperty(example = "hong@email.com", value = "고객 이메일", required = true)
    private String email;

    @NotNull(message = "국가 코드를 선택해주세요.")
    @ApiModelProperty(example = "82", value = "국가 코드", required = true)
    private Integer countryCode;

    @NotBlank(message = "연락처를 입력해주세요.")
    @ApiModelProperty(example = "01011112222", value = "고객 연락처", required = true)
    private String phoneNumber;

    @NotNull(message = "개인정보 수집 동의 여부는 필수 입니다.")
    @ApiModelProperty(example = "true", value = "개인정보 수집 동의 여부", required = true)
    private Boolean personalInformationAgreement;

    public Client toClient() {
        return Client.builder()
            .name(name)
            .email(email)
            .countryCode(countryCode)
            .phoneNumber(phoneNumber)
            .personalInformationAgreement(personalInformationAgreement)
            .build();
    }
}
