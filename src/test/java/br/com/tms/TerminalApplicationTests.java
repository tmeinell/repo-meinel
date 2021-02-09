package br.com.tms;

import br.com.tms.controller.domain.model.TerminalModel;
import br.com.tms.resource.TerminalResource;
import br.com.tms.service.TerminalService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TerminalApplicationTests {

    @MockBean
    TerminalService terminalService;

    @Autowired
    TerminalResource terminalResource;

    String path = "/rest/api/v1/terminais";

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(this.terminalService);
    }

    @Test
    public void testPostTerminalSucess() {
        String payload = "44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";
        given().contentType("text/html").body(payload)
                .when().post("http://localhost:8080" + path)
                .then().statusCode(HttpStatus.CREATED.value());
    }

    public void testPostTterminalFail() {
        String payload = "";
        given().contentType("text/html").body(payload)
                .when().post("http://localhost:8080" + path)
                .then().statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void testInvalidFormat() {
        String payload = ";49673917;643;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";
        given().contentType("text/html").body(payload)
                .when().post("http://localhost:8080" + path)
                .then().statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void testMissedLogicField() {
        String payload = ";44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN;";
        given().contentType("text/html").body(payload)
                .when().post("http://localhost:8080" + path)
                .then().statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void testMissedSerialField() {
        String payload = "44332211;;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN;";
        given().contentType("text/html").body(payload)
                .when().post("http://localhost:8080" + path)
                .then().statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void testGetTerminalSucess() {
        when(this.terminalService.findById(49673917)).thenReturn(new TerminalModel());

        given().contentType(ContentType.JSON)
                .when().get("/terminais")
                .then().statusCode(HttpStatus.OK.value());
    }

    @Test
    public void testGetTerminalNotFound() {
        when(this.terminalService.findById(1)).thenReturn(null);

        given().contentType(ContentType.JSON)
                .when().get("/terminais")
                .then().statusCode(HttpStatus.NOT_FOUND.value());
    }

}
