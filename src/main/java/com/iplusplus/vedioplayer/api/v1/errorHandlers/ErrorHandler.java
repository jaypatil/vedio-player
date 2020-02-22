package com.iplusplus.vedioplayer.api.v1.errorHandlers;

import com.iplusplus.vedioplayer.exceptions.VideoNotFoundException;
import com.iplusplus.vedioplayer.model.helpers.Error;
import com.iplusplus.vedioplayer.model.helpers.ErrorBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ErrorHandler {

    private static final Log logger = LogFactory.getLog(ErrorHandler.class);

    public ErrorHandler() {
        logger.info("Initialising error handler class");
    }

    public static Mono<ServerResponse> handleError(Throwable throwable, ServerRequest request) {

        if (throwable instanceof VideoNotFoundException) {
            return handleNotFound(request, throwable);
        }

        return ServerResponse
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .build();
    }

    private static Mono<ServerResponse> handleNotFound(ServerRequest request, Throwable throwable) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
        String errorDate = dateFormat.format(new Date());
        Error errorResponse = new ErrorBuilder()
                .setStatus(404)
                .setPath(request.path())
                .setError("Video not found. It most likely does not exist")
                .setTimestamp(errorDate)
                .createError();

        logger.error("The video at ["+ request.path() + "] could not be found");
        return ServerResponse.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(errorResponse), Error.class);
    }
}
