package bfiAPI;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;
import java.io.*;

@RestController
public class APIController {
    
    @Autowired
    private KafkaTemplate<String, String> template;

    @PostMapping("/transaction")
    TransactionModel publishTopic(String newTransaction){
        TransactionModel transaction = ObjectMapper().readValue(jsonString, TransactionModel.class);
        return System.out.print(transaction);
    }
}
