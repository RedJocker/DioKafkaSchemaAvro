package org.diotutorial.ecommerce.checkout.listener;


import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.reflect.ReflectData;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.diotutorial.ecommerce.checkout.entity.CheckoutEntity;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class MyKafkaListener {

    @KafkaListener(
            topics = "checkout-created-output",
            groupId = "streaming.ecommerce.checkout.created.consumer",
            properties = {
                    ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG + ":org.apache.kafka.common.serialization.StringDeserializer",
                    ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG + ":io.confluent.kafka.serializers.KafkaAvroDeserializer",
                    ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG + ":true",
                    ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG + ":localhost:9092",
                    ConsumerConfig.AUTO_OFFSET_RESET_CONFIG + ":earliest",
                    "schema.registry.url:http://localhost:8081",



            })
    public void processMessage(ConsumerRecord<String, GenericData.Record> record) {
        System.out.println("From Listener: ");

        final Schema schema = record.value().getSchema();

        System.out.println(record.offset() + " -> " + record.value());
        final ListenedEntityDao entityDeserialized = mapRecordToObject(record.value(), ListenedEntityDao.builder().build());
        System.out.println("Deserialized entity: " + entityDeserialized);

    }

    private static <T> T mapRecordToObject(GenericRecord record, T object) {
        // https://karengryg.io/2018/08/25/avro-and-pojo-conversionstips-for-kafka-devs/

        Assert.notNull(record, "record must not be null");
        Assert.notNull(object, "object must not be null");
        final Schema schema = ReflectData.get().getSchema(object.getClass());

        Assert.isTrue(schema.getFields().equals(record.getSchema().getFields()), "Schema fields didn’t match");
        record.getSchema().getFields().forEach(d ->
                PropertyAccessorFactory.forDirectFieldAccess(object).
                        setPropertyValue(d.name(), record.get(d.name()) == null ? record.get(d.name()) : record.get(d.name()).toString()));
        return object;
    }
}