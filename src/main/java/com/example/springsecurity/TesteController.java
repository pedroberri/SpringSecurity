package com.example.springsecurity;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teste")
public class TesteController {

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Acessou");
    }

}
