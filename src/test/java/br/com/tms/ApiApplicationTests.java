package br.com.tms;

import br.com.tms.service.TerminalService;
import com.tms.service.RequestFlow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {

    @Autowired
    TerminalService terminalService;

    RequestFlow request = new RequestFlow();
    String postRequest = "/rest/api/v1/terminais";

    @Test
    public void testPostTerminal() {
        String corpo = "44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";
        request.createFlow(corpo, postRequest);
    }

    @Test
    public void testInvalidFormat() {
        String corpo = "44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3";
        request.badRequestFlow(corpo, postRequest);
    }

    @Test
    public void testMissedLogicField() {
        String corpo = ";44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN;";
        request.badRequestFlow(corpo, postRequest);
    }

    @Test
    public void testMissedSerialField() {
        String corpo = "44332211;;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN;";
        request.badRequestFlow(corpo, postRequest);
    }

    @Test
    public void testMissedModelField() {
        String corpo = "44332211;123;;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN;";
        request.badRequestFlow(corpo, postRequest);
    }

    @Test
    public void testMissedVersionField() {
        String corpo = "44332211;123;PWWIN;0;F04A2E4088B;4;;0;16777216;PWWIN;";
        request.badRequestFlow(corpo, postRequest);
    }

}
