package br.com.avocat.agenda;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import br.com.avocat.agenda.persistence.Agenda;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AgendaControllerTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void salvar_entao200() throws JsonProcessingException {

        Agenda agenda = Agenda.builder()
                .titulo("Teste com RestAssured")
                .descricao("Testa o salvar.")
                .build();

        String agendaJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(agenda);

        given()
            .contentType("application/json")
            .body(agendaJson)
        .when()
            .post("http://localhost:" + port + "/v1/api/agenda")
        .then()
            .log().all()
            .statusCode(200)
            .body("id", notNullValue())
            .body("dataCadastro", notNullValue());
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

    @Test
    void pesquisarPorPeriodo_entao200() {
        LocalDate dataInicial = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
        LocalDate dataFinal = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 30);

        given().log().all()
            .param("dt-ini", dataInicial.toString())
            .param("dt-fin", dataFinal.toString())
            .param("page", 0)
            .param("size", 5)
        .when()
            .get("http://localhost:" + port + "/v1/api/agenda/pesquisar")
        .then()
            .log().all()
            .statusCode(200);
    }
}
