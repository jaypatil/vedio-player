package com.iplusplus.vedioplayer.api.v1.handlers;

import com.iplusplus.vedioplayer.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.Exceptions;
import reactor.core.publisher.Mono;

import java.util.Set;

@Component
public class FileRouteHandler {


    private FileService fileService;

    @Autowired
    public FileRouteHandler(FileService fileService) {
        this.fileService = fileService;
    }

    public Mono<ServerResponse> returnPath(ServerRequest request) {
        ParameterizedTypeReference p = new ParameterizedTypeReference<Set<String>>() {
        };
        return fileService.listFilesUsingDirectoryStream()
                .flatMap(person -> {
                    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue (person))
                            .doOnError(throwable -> {
                                throw Exceptions.propagate(throwable);
                            });
                });
    }
}