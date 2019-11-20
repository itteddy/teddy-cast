package com.itteddy;

import java.io.File;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("fileExists")
public class FileExists {

    public Boolean fileExists (String filename) {
        return new File(filename).exists();
    }
}
