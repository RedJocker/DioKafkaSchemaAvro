package org.diotutorial.ecommerce.checkout.listener;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;


@Builder
@Data
public class ListenedEntityDao {


    @Column
    private String code;
}
