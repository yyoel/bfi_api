package bfiAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    public static Logger logger = LoggerFactory.getLogger(MainApplication.class);

    @Autowired
    private KafkaTemplate<String, String> template;

    @PostMapping("/transaction")
    void publishTopic(@RequestBody String newTransaction){
         System.out.println(newTransaction);
         this.template.send("transactionTopic", newTransaction);
         logger.info("All Received");
    }
}