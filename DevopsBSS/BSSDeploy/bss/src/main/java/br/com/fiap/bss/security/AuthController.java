package br.com.fiap.bss.security;

import br.com.fiap.bss.model.Login;
import br.com.fiap.bss.security.JwtUtil;
import br.com.fiap.bss.repository.LoginRepository;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginRepository loginRepo;
    private final JwtUtil jwtUtil;

    public AuthController(LoginRepository loginRepo, JwtUtil jwtUtil) {
        this.loginRepo = loginRepo;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String senha) {
        return loginRepo.findByUsername(username)
                .filter(login -> login.getSenha().equals(senha))
                .map(login -> ResponseEntity.ok(jwtUtil.generateToken(username)))
                .orElse(ResponseEntity.status(401).body("Credenciais inválidas"));
    }
}