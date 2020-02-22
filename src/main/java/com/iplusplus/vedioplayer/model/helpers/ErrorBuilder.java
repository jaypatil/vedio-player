package com.iplusplus.vedioplayer.model.helpers;

public class ErrorBuilder {
    private String timestamp;
    private String error;
    private Integer status;
    private String path;

    public ErrorBuilder setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public ErrorBuilder setError(String error) {
        this.error = error;
        return this;
    }

    public ErrorBuilder setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public ErrorBuilder setPath(String path) {
        this.path = path;
        return this;
    }

    public Error createError() {
        return new Error(timestamp, error, status, path);
    }
}