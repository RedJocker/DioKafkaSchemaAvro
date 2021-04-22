package org.diotutorial.ecommerce.checkout.service;

import lombok.RequiredArgsConstructor;
import org.diotutorial.ecommerce.checkout.entity.CheckoutEntity;
import org.diotutorial.ecommerce.checkout.repository.CheckoutRepository;
import org.diotutorial.ecommerce.checkout.resource.checkout.CheckoutRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService{

    final CheckoutRepository checkoutRepository;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .build();
        return Optional.of(checkoutRepository.save(checkoutEntity));

    }
}
