package lv.tdd.coding.test_retry;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RetryController {

    private final RetryService retryService;

    @RequestMapping(value = "/springRetry", method = RequestMethod.GET)
    public ResponseEntity<String> springReTryTest() {
        System.out.println("springReTryTest controller");
        try {
            retryService.springReTryTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new  ResponseEntity<>("abcd", HttpStatus.OK);
    }

    @RequestMapping(value = "/springRetryReturn", method = RequestMethod.GET)
    public ResponseEntity<String> springReTryReturnTest() {
        System.out.println("springReTryReturnTest controller");
        String s = "";
        try {
            s = retryService.springRetryReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new  ResponseEntity<>("RESULT : " + s, HttpStatus.OK);
    }
}
