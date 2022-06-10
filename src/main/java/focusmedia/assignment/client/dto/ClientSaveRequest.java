package focusmedia.assignment.client.dto;

import focusmedia.assignment.client.domain.Client;
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
    private String name;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식대로 입력해주세요.")
    private String email;

    @NotNull(message = "국가 코드를 선택해주세요.")
    private Integer countryCode;

    @NotBlank(message = "연락처를 입력해주세요.")
    private String phoneNumber;

    @NotNull(message = "개인정보 수집 동의 여부는 필수 입니다.")
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
