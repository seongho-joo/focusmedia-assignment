package focusmedia.assignment.common.dto;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class CommonResponse<T> {

    @ApiModelProperty(value = "응답 데이터")
    private T data;

    @ApiModelProperty(value = "응답 메시지")
    private String message;

    public static <T> CommonResponse<T> of(T data, String message) {
        return new CommonResponse<>(data, message);
    }

    public static <T> CommonResponse<T> from(String message) {
        return new CommonResponse<>(null, message);
    }
}
