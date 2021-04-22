package org.diotutorial.ecommerce.checkout.service;

import org.diotutorial.ecommerce.checkout.entity.CheckoutEntity;
import org.diotutorial.ecommerce.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

}
