package com.reactive.wf.model.dish;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Dish {

    private String id;

    private String name;

    private Double price;

    private Boolean status;
}
