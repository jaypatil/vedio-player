package com.iplusplus.vedioplayer.exceptions;

import java.io.FileNotFoundException;

public class VideoNotFoundException extends FileNotFoundException {

    public VideoNotFoundException() {
        super("video was not found");
    }
}
