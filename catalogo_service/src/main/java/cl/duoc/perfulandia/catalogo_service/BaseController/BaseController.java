package cl.duoc.perfulandia.catalogo_service.BaseController;

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


    protected ResponseEntity<Map<String, Object>> errorResponse(String message, int status) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", message);
        return ResponseEntity.status(status).body(response);
    }
}