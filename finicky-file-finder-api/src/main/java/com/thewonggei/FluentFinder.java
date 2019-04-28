package com.thewonggei;

import java.io.File;
import java.util.List;

import static java.lang.System.getProperty;

public class FluentFinder {
    private FileFinder finder;
    private FinderProperties finderProperties;

    public FluentFinder(FinderProperties finderProperties) {
        this.finderProperties = finderProperties;
        this.finder = new FileFinder(this.finderProperties);
    }

    public FluentFinder() {
        this.finderProperties = new FinderProperties(getProperty("user.dir"), "*.*", null,
                false, Integer.MAX_VALUE);
        this.finder = new FileFinder(this.finderProperties);
    }

    public List<File> listFiles() {
        List<File> fileList = finder.list();
        return fileList;
    }

}
