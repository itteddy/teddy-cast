package com.itteddy;

import java.io.File;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("fileUtils")
public class FileUtils {

    public Boolean fileExists (String filename) {
        return new File(filename).exists();
    }

    public File load(String filename){
        return new File(filename);
    }
}
