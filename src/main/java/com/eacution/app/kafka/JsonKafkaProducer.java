package com.eacution.app.kafka;
import com.eacution.app.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, Product> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Product> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Product data){

        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<Product> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "eauction_product_json")
                .build();

        kafkaTemplate.send(message);
    }
}
