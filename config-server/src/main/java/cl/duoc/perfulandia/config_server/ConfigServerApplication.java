package cl.duoc.perfulandia.config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer; // Asegúrate de que esta línea esté

@SpringBootApplication
@EnableConfigServer // <--- ESTA ES LA CLAVE
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}