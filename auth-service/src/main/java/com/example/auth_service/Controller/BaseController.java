package com.example.auth_service.Controller; 

import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {
    protected ResponseEntity<Map<String, Object>> successResponse(Object data, String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", message);
        response.put("data", data);
        return ResponseEntity.ok(response);
    }
}