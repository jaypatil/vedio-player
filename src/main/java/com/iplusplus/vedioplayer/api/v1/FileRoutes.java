package com.iplusplus.vedioplayer.api.v1;

import com.iplusplus.vedioplayer.api.v1.errorHandlers.ErrorHandler;
import com.iplusplus.vedioplayer.api.v1.handlers.FileRouteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FileRoutes {

    @Bean
    RouterFunction<ServerResponse> fileEndPoint(FileRouteHandler fileRouteHandler) {

        return route(GET("/file"), fileRouteHandler::returnPath)
//                .andRoute(GET("/video/{name}"), videoRouteHandler::getPartialVideoByName)
//                .andRoute(GET("/video/{name}/full"), videoRouteHandler::getFullLengthVideo)
                .filter((request, next) -> next.handle(request)
                        .onErrorResume(throwable -> ErrorHandler.handleError(throwable, request)));
    }
}
