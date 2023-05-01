package com.reactive.wf.model.pagination.gateways;

import com.reactive.wf.model.pagination.PageSupport;
import reactor.core.publisher.Mono;

public interface PageSupportGateway<T> {

    Mono<PageSupport<T>> getPage(int page, int size);

}
