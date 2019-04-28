package com.thewonggei;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.regex.Matcher;

import static java.util.stream.Collectors.toList;

public class FileFinder {
    private FinderProperties finderProps;

    public FileFinder(final FinderProperties finderProps) {
        this.finderProps = finderProps;
    }

    public List<File> list() {
        try {
            return Files
                    .find(finderProps.getSearchRoot(), finderProps.getMaxSearchDepth(), this::acceptFile)
                    .map(Path::toFile)
                    .collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected boolean acceptFile(Path path, BasicFileAttributes fileAttributes) {
        String absolutePath = path.toFile().getAbsolutePath();
        Matcher matcher = finderProps.getFilenameRegex().matcher(absolutePath);
        boolean matchFound = matcher.find();
//        System.out.println(absolutePath);
        return matchFound;
    }

}
