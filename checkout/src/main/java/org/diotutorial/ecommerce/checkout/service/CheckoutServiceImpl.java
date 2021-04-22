package org.diotutorial.ecommerce.checkout.service;

import lombok.RequiredArgsConstructor;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.diotutorial.ecommerce.checkout.entity.CheckoutEntity;
import org.diotutorial.ecommerce.checkout.repository.CheckoutRepository;
import org.diotutorial.ecommerce.checkout.resource.checkout.CheckoutRequest;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService{

    final CheckoutRepository checkoutRepository;
//    final CheckoutCreatedSource checkoutCreatedSource;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .build();

        final KafkaProducer<String, GenericData.Record> kafkaProducer = getProducer();
        final ProducerRecord<String, GenericData.Record> message = getMessage(Map.of("code", checkoutEntity.getCode()));
        kafkaProducer.send(message);

//        checkoutCreatedSource.output().send(message);

        return Optional.of(checkoutRepository.save(checkoutEntity));

    }

    private KafkaProducer<String, GenericData.Record> getProducer(){
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                org.apache.kafka.common.serialization.StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        props.put("schema.registry.url", "http://localhost:8081");
        return new KafkaProducer<String, GenericData.Record>(props);
    }

    private ProducerRecord<String, GenericData.Record> getMessage(Map<String, Object> fieldValueMap) {
        final Schema schema = SchemaBuilder.record("CheckoutCreatedEvent")
                .namespace("org.diotutorial.ecommerce.checkout.event")
                .fields().requiredString("code").endRecord();
        final GenericData.Record record = new GenericData.Record(schema);

        // populate message
        for(var entry : fieldValueMap.entrySet()) {
            record.put(entry.getKey(), entry.getValue());
        }
        MessageBuilder.withPayload(record).build();

        return new ProducerRecord<String, GenericData.Record>("checkout-created-output", "key", record);
    }
}
