package focusmedia.assignment.common.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import focusmedia.assignment.user.exception.NotExistUserException;
import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionType {
    NOT_EXIST_USER("존재하지 않는 회원입니다.", BAD_REQUEST, NotExistUserException.class);

    private final String message;
    private final HttpStatus status;
    private final Class<? extends Exception> type;

    public static ExceptionType findException(Class<? extends BaseException> type) {
        return Arrays.stream(ExceptionType.values())
            .filter(exceptionType -> exceptionType.getType().equals(type))
            .findAny()
            .orElseThrow(UnexpectedException::new);
    }
}
