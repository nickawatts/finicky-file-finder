package com.thewonggei;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileFinder {
    private final int MAX_SEARCH_DEPTH = Integer.MAX_VALUE;
    private Path searchRoot;
    private Pattern filenameFilter;
    private boolean searchInArchives;

    public FileFinder() {
        searchRoot = new File(".").toPath();
        searchInArchives = false;
        filenameFilter = Pattern.compile(".*");
    }

    public FileFinder(File searchRoot, Pattern filenameFilter) {
        this.searchRoot = searchRoot.toPath();
        this.filenameFilter = filenameFilter;
    }

    public List<File> list() {
        try {
            return Files
                    .find(searchRoot, MAX_SEARCH_DEPTH, this::acceptFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected boolean acceptFile(Path path, BasicFileAttributes fileAttributes) {
        String absolutePath = path.toFile().getAbsolutePath();
        Matcher matcher = filenameFilter.matcher(absolutePath);
        return matcher.find();
    }

}
