package lv.tdd.coding.test_retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

    private int count = 0;

    @Retryable(maxAttempts=4,value=Exception.class,backoff=@Backoff(delay = 2000))
    public void springReTryTest() throws Exception {
            System.out.println("try!");
            throw new Exception();
    }

    @Retryable(maxAttempts=5,value=Exception.class,backoff=@Backoff(delay = 1000))
    public String springRetryReturn() throws Exception {
        count++;
        System.out.println("try!");

        if (count < 4)
            throw new Exception();
        else
            return "bla";
    }
}
