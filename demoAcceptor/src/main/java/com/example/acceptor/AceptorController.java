package com.example.acceptor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
public class AceptorController {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @RequestMapping(value = "/hello2")
    public String sfs() throws InterruptedException, ExecutionException {

        final Future<String> future = executorService.submit(new Callable<String>() {
            public String call() throws InterruptedException {
                Thread.sleep(7000);
              return "1111111111111";
            }
        });

        try {
            String result = future.get(5, TimeUnit.SECONDS);
            System.out.println(result);
        } catch (TimeoutException e) {
            Thread.sleep(5000);
            System.out.println(3333);
            future.cancel(true);
            return "Open JDK11111";
        }

        return "Open JDK";

    }

}
