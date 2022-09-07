package com.eacution.app.kafka;


import com.eacution.app.entity.Buyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducerBuy {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, Buyer> kafkaTemplateBuy;

    public JsonKafkaProducerBuy(KafkaTemplate<String, Buyer> kafkaTemplateBuy) {
        this.kafkaTemplateBuy = kafkaTemplateBuy;
    }

    public void sendMessage(Buyer data){

        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<Buyer> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "eauction_buyer_json")
                .build();

        kafkaTemplateBuy.send(message);
    }

}
