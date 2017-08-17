package es.dg.avan.jtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * DGASAN01 - 10/08/2017
 * Clase de Springboot para establecer el producto dg como Java tools.
 *
 * Ejecucion java -jar xx/xx/xxxxxx-0.0.1-SNAPSHOT.jar
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
