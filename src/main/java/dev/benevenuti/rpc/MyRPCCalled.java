package dev.benevenuti.rpc;

import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Log
public class MyRPCCalled {

    @RabbitListener(queues = "my.rpc.requests")
    // @SendTo("my.rpc.replies") used when the
    // client doesn't set replyTo.
    public Long fibonacci(int n) {
        log.warning(" [x] Received request for " + n);
        Long result = fib(n);
        log.warning(" [.] Returned " + result);
        return result;
    }

    public Long fib(int n) {
        return n == 0 ? 0 : n == 1 ? 1 : (fib(n - 1) + fib(n - 2));
    }

}
