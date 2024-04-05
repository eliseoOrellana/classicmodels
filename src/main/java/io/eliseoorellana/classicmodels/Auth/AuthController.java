package io.eliseoorellana.classicmodels.Auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:8080"})
public class AuthController {


private final AuthService authService;

    @PostMapping(value = "login")
    public String login(@ModelAttribute LoginRequest request, Model model) {
        // Manejar la lógica de login
        AuthResponse authResponse = authService.login(request);
        // Puedes hacer algo con la respuesta, por ejemplo, guardarla en el modelo
        model.addAttribute("authResponse", authResponse);
        // Devolver la vista de la página de inicio (o una página de bienvenida, etc.)
        return "/"; // Suponiendo que tienes una vista llamada "index.html"
    }

    @PostMapping(value = "register")
    public String register(@ModelAttribute RegisterRequest request, Model model) {
        // Manejar la lógica de registro
        AuthResponse authResponse = authService.register(request);
        // Puedes hacer algo con la respuesta, por ejemplo, guardarla en el modelo
        model.addAttribute("authResponse", authResponse);
        // Devolver la vista de la página de inicio (o una página de bienvenida, etc.)
        return "/"; // Suponiendo que tienes una vista llamada "index.html"
    }

}
