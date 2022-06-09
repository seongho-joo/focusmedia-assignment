package focusmedia.assignment.client.ui;

import static focusmedia.assignment.client.ui.ClientResponseMessage.FIND_CLIENT_SUCESS;
import static focusmedia.assignment.client.ui.ClientResponseMessage.SAVE_CLIENT_SUCCESS;

import focusmedia.assignment.common.dto.CommonResponse;
import focusmedia.assignment.client.application.ClientService;
import focusmedia.assignment.client.dto.ClientFindResponse;
import focusmedia.assignment.client.dto.ClientSaveRequest;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ApiOperation(value = "고객 정보 저장 API")
    public CommonResponse<Void> saveClient(@Valid @RequestBody ClientSaveRequest request) {
        clientService.saveClient(request);
        return CommonResponse.from(SAVE_CLIENT_SUCCESS.getMessage());
    }

    @GetMapping("/{clientId}")
    @ApiOperation(value = "고객 정보 조회 API")
    public CommonResponse<ClientFindResponse> findClient(@PathVariable Long clientId) {
        return CommonResponse.of(clientService.findClient(clientId), FIND_CLIENT_SUCESS.getMessage());
    }
}
