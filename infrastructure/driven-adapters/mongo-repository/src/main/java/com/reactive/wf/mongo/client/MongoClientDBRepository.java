package com.reactive.wf.mongo.client;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoClientDBRepository
        extends ReactiveMongoRepository<ClientDB, String>, ReactiveQueryByExampleExecutor<ClientDB> {
}
