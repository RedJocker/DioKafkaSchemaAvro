package org.diotutorial.ecommerce.checkout.config;

import org.diotutorial.ecommerce.checkout.listener.MyKafkaListener;
import org.diotutorial.ecommerce.checkout.streaming.CheckoutCreatedSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class,
        MyKafkaListener.class
})
public class StreamingConfig {
}
