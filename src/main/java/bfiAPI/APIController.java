package bfiAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;
import java.io.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RestController
public class APIController {

    public static Logger logger = LoggerFactory.getLogger(MainApplication.class);
    private final CountDownLatch latch = new CountDownLatch(3);

    @Autowired
    private KafkaTemplate<String, String> template;

    @PostMapping("/transaction")
    void publishTopic(@RequestBody String newTransaction){
         System.out.println(newTransaction);
         this.template.send("transactionTopic", newTransaction);
         logger.info("All Received");
    }
}
