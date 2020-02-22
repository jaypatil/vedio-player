package com.iplusplus.vedioplayer.services;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Set;

public interface FileService {
    Mono<Set<String>> listFilesUsingDirectoryStream();
}
