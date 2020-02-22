package com.iplusplus.vedioplayer.model.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {
    @JsonProperty("time")
    public String timestamp;
    public String error;
    public Integer status;
    public String path;

    public Error(String timestamp, String error, Integer status, String path) {
        this.timestamp = timestamp;
        this.error = error;
        this.status = status;
        this.path = path;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "{" +
                "\"timestamp\":\"" + timestamp + '\"' +
                ", \"error\":\"" + error + '\"' +
                ", \"status\" : " + status +
                ", \"path\": \"" + path + '\"' +
                '}';
    }


}
