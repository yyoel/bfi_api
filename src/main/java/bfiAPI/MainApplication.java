package bfiAPI;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;

@SpringBootApplication
public class MainApplication {

    public static Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String... args){
        SpringApplication.run(MainApplication.class, args);
    }

    private final CountDownLatch latch = new CountDownLatch(3);

    // @Override
    // public void run(String... args) throws Exception{
        
    //     this.template.send("myTopic", "foo2");
    //     this.template.send("myTopic", "foo3");
    //     latch.await(60, TimeUnit.SECONDS);
    //     logger.info("All Received");
    // }

    @KafkaListener(topics = "myTopic")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception{
        logger.info(cr.toString());
        latch.countDown();
    }
}
