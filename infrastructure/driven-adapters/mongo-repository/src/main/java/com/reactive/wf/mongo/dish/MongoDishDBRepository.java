package com.reactive.wf.mongo.dish;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDishDBRepository
        extends ReactiveMongoRepository<DishDB, String>, ReactiveQueryByExampleExecutor<DishDB> {
}
