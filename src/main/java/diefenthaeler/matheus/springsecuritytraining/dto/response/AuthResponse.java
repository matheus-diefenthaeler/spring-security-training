package diefenthaeler.matheus.springsecuritytraining.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthResponse {
    private String username;
    private String accessToken;
}
