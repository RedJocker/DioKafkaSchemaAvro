package org.diotutorial.ecommerce.checkout.resource.checkout;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.diotutorial.ecommerce.checkout.event.CheckoutCreatedEvent;
import org.diotutorial.ecommerce.checkout.service.CheckoutService;
import org.diotutorial.ecommerce.checkout.streaming.CheckoutCreatedSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@Slf4j
@CrossOrigin
@RestController
@ControllerAdvice
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutResource {

    private final CheckoutService checkoutService;


    @PostMapping(value = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Void> createFromForm(CheckoutRequest checkoutRequest) {
        log.info("createFromForm requested " + LocalTime.now().toString());
        log.info(checkoutRequest.toString());
//        checkoutService.create(checkoutRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createFromJson(@RequestBody CheckoutRequest checkoutRequest) {
        log.info("createFromJson requested " + LocalTime.now().toString());
        log.info(checkoutRequest.toString());
        checkoutService.create(checkoutRequest);
        return ResponseEntity.ok().build();
    }
}
