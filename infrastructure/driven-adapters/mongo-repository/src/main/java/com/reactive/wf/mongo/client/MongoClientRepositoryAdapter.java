package com.reactive.wf.mongo.client;

import com.reactive.wf.model.client.Client;
import com.reactive.wf.model.client.gateways.ClientGateway;
import com.reactive.wf.mongo.helper.AdapterOperations;
import lombok.extern.slf4j.Slf4j;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@Slf4j
public class MongoClientRepositoryAdapter
        extends AdapterOperations<Client, ClientDB, String, MongoClientDBRepository>
        implements ClientGateway {

    public MongoClientRepositoryAdapter(MongoClientDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Client.class));
    }

    @Override
    public Mono<Client> saveClient(Client Client) {
        log.info("::saveClient Client: {}", Client);
        return this.save(Client)
                .doOnNext(ClientDB -> log.info("::saveClient ClientDB: {}", ClientDB));
    }

    @Override
    public Mono<Client> updateClient(Client Client) {
        log.info("::updateClient Client: {}", Client);
        return this.save(Client)
                .doOnNext(ClientDB -> log.info("::updateClient ClientDB: {}", ClientDB));
    }

    @Override
    public Flux<Client> findClients() {
        log.info("::findClients");
        return this.findAll();
    }

    @Override
    public Mono<Client> findClientById(String id) {
        log.info("::findClientById idClient: {}", id);
        return this.findById(id)
                .doOnNext(ClientDB -> log.info("::findClientById ClientDB: {}", ClientDB));
    }

    @Override
    public Mono<Void> deleteClientById(String id) {
        log.info("::deleteClientById idClient: {}", id);
        return this.findById(id)
                .doOnNext(ClientDB -> log.info("::deleteClientById ClientDB: {}", ClientDB))
                .flatMap(Client -> this.deleteById(Client.getId()));
    }
}
