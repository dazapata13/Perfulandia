package com.example.auth_service.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class BaseController {

    @Value("${app.nombre}")
    private String nombreApp;

    @Value("${app.version}")
    private String version;

    @GetMapping("")
    public Map<String, String> base() {
        Map<String, String> info = new HashMap<>();
        info.put("nombre", nombreApp);
        info.put("version", version);
        return info;
    }

    protected ResponseEntity<Map<String, Object>> successResponse(Object data, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", message);
        response.put("data", data);
        return ResponseEntity.ok(response);
    }
}