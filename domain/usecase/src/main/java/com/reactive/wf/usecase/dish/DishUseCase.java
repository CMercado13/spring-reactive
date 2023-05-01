package com.reactive.wf.usecase.dish;

import com.reactive.wf.model.dish.Dish;
import com.reactive.wf.model.dish.gateways.DishGateway;
import com.reactive.wf.model.pagination.PageSupport;
import com.reactive.wf.model.pagination.gateways.PageSupportGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class DishUseCase {

    private final DishGateway dishGateway;

    private final PageSupportGateway<Dish> dishPageSupportGateway;

    public Flux<Dish> findAll() {
        return dishGateway.findDishes();
    }

    public Mono<Dish> findById(String id) {
        return dishGateway.findDishById(id);
    }

    public Mono<Dish> save(Dish dish) {
        return dishGateway.saveDish(dish);
    }

    public Mono<Dish> update(String id, Dish dish) {
        dish.setId(id);
        Mono<Dish> monoBody = Mono.just(dish);
        Mono<Dish> monoDB = dishGateway.findDishById(id);
        return monoDB.zipWith(monoBody, (db, b) -> {
                    db.setId(b.getId());
                    db.setName(b.getName());
                    db.setPrice(b.getPrice());
                    db.setStatus(b.getStatus());
                    return db;
                })
                .flatMap(dishGateway::updateDish);
    }

    public Mono<Boolean> delete(String id) {
        return dishGateway.findDishById(id)
                .flatMap(dish -> dishGateway.deleteDishById(dish.getId()))
                .thenReturn(Boolean.TRUE)
                .switchIfEmpty(Mono.empty());
    }

    public Mono<PageSupport<Dish>> getPage(int page, int size) {
        return dishPageSupportGateway.getPage(page, size);
    }

}
