package focusmedia.assignment.client.ui;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ClientResponseMessage {
    SAVE_CLIENT_SUCCESS("유저 정보 저장 성공"),
    FIND_CLIENT_SUCESS("유저 정보 조회 성공");

    private final String message;
}
