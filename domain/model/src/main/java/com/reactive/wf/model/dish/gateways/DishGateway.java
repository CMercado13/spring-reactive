package com.reactive.wf.model.dish.gateways;

import com.reactive.wf.model.dish.Dish;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DishGateway {
    Mono<Dish> saveDish(Dish dish);

    Mono<Dish> updateDish(Dish dish);

    Flux<Dish> findDishes();

    Mono<Dish> findDishById(String id);

    Mono<Void> deleteDishById(String id);
}
