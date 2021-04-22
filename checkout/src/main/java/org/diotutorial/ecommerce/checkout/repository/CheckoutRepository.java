package org.diotutorial.ecommerce.checkout.repository;

import org.diotutorial.ecommerce.checkout.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long> {
}
