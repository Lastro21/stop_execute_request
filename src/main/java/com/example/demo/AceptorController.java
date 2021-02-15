package com.example.demo;

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
                return "Any_string";
            }
        });

        try {
            final String result = future.get(5, TimeUnit.SECONDS);
            System.out.println(result);
        } catch (TimeoutException e) {
            System.out.println("TimeOut");
            future.cancel(true);
            return "Error: TimeOut";
        }

        return "Success!";

    }

}
