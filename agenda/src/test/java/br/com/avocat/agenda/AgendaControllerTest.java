package br.com.avocat.agenda;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AgendaControllerTest {

    @LocalServerPort
    private Integer port;

    @Test
    void salvar_entao200() {

    }

    @Test
    void pesquisarPorId_entao200() {

        String id = "62fa7a1b67a0a30f9ce2353a";

        when()
            .get("http://localhost:" + port + "/v1/api/agenda/" + id)
                .then()
            .statusCode(200)
            .body("id", equalTo(id));
    }
}
