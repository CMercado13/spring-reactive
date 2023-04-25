package com.reactive.wf.mongo.dish;

import com.reactive.wf.model.dish.Dish;
import com.reactive.wf.model.dish.gateways.DishGateway;
import com.reactive.wf.mongo.helper.AdapterOperations;
import lombok.extern.slf4j.Slf4j;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@Slf4j
public class MongoRepositoryAdapter
        extends AdapterOperations<Dish, DishDB, String, MongoDishDBRepository>
        implements DishGateway {

    public MongoRepositoryAdapter(MongoDishDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.mapBuilder(d, Dish.DishBuilder.class).build());
    }

    @Override
    public Mono<Dish> saveDish(Dish dish) {
        log.info("::saveDish Dish: {}", dish);
        return this.save(dish)
                .doOnNext(dishDB -> log.info("::saveDish ClientDB: {}", dishDB));
    }

    @Override
    public Mono<Dish> updateDish(Dish dish) {
        log.info("::updateDish Dish: {}", dish);
        return this.save(dish)
                .doOnNext(dishDB -> log.info("::updateDish ClientDB: {}", dishDB));
    }

    @Override
    public Flux<Dish> findDishes() {
        log.info("::findDishes");
        return this.findAll();
    }

    @Override
    public Mono<Dish> findDishById(String id) {
        log.info("::findDishById idDish: {}", id);
        return this.findById(id)
                .doOnNext(dishDB -> log.info("::findDishById ClientDB: {}", dishDB));
    }

    @Override
    public Mono<Void> deleteDishById(String id) {
        log.info("::deleteDishById idDish: {}", id);
        return this.findById(id)
                .doOnNext(dishDB -> log.info("::deleteDishById ClientDB: {}", dishDB))
                .flatMap(dish -> this.deleteById(dish.getId()));
    }
}
