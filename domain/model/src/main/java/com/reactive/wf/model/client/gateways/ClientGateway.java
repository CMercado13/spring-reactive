package com.reactive.wf.model.client.gateways;

import com.reactive.wf.model.client.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientGateway {

    Mono<Client> saveClient(Client Client);

    Mono<Client> updateClient(Client Client);

    Flux<Client> findClients();

    Mono<Client> findClientById(String id);

    Mono<Void> deleteClientById(String id);
}
