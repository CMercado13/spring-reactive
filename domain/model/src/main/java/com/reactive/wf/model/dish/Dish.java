package com.reactive.wf.model.dish;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Dish {

    private String id;

    private String name;

    private Double price;

    private Boolean status;
}
