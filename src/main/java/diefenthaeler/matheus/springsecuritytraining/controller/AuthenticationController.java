package diefenthaeler.matheus.springsecuritytraining.controller;

import diefenthaeler.matheus.springsecuritytraining.dto.request.AuthRequest;
import diefenthaeler.matheus.springsecuritytraining.dto.response.AuthResponse;
import diefenthaeler.matheus.springsecuritytraining.security.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authManager;

    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = (User) authentication.getPrincipal();
        String accessToken = jwtTokenUtil.generateAcessToken(user);
        AuthResponse response = AuthResponse.builder()
                .username(user.getUsername())
                .accessToken(accessToken)
                .build();
        return ResponseEntity.ok().body(response);
    }
}
