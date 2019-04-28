package com.thewonggei;

import java.io.File;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class FinderProperties {
    private Path searchRoot;
    private Pattern filenameRegex;
    private Pattern inFileRegex;
    private boolean searchInArchives;
    private int maxSearchDepth;

    public FinderProperties(String searchRoot, String filenameRegex, String inFileRegex, boolean searchInArchives,
                            int maxSearchDepth)
    {
        this.searchRoot = new File(searchRoot).toPath();
        this.filenameRegex = Pattern.compile(filenameRegex);
//        this.inFileRegex = Pattern.compile(inFileRegex);
        this.searchInArchives = searchInArchives;
        this.maxSearchDepth = maxSearchDepth;
    }

    public Path getSearchRoot() {
        return searchRoot;
    }

    public void setSearchRoot(Path searchRoot) {
        this.searchRoot = searchRoot;
    }

    public Pattern getFilenameRegex() {
        return filenameRegex;
    }

    public void setFilenameRegex(Pattern filenameRegex) {
        this.filenameRegex = filenameRegex;
    }

    public Pattern getInFileRegex() {
        return inFileRegex;
    }

    public void setInFileRegex(Pattern inFileRegex) {
        this.inFileRegex = inFileRegex;
    }

    public boolean isSearchInArchives() {
        return searchInArchives;
    }

    public void setSearchInArchives(boolean searchInArchives) {
        this.searchInArchives = searchInArchives;
    }

    public int getMaxSearchDepth() {
        return maxSearchDepth;
    }

    public void setMaxSearchDepth(int maxSearchDepth) {
        this.maxSearchDepth = maxSearchDepth;
    }

    @Override
    public String toString() {
        return "FinderProperties{" +
                "searchRoot=" + searchRoot +
                ", filenameRegex=" + filenameRegex +
                ", inFileRegex=" + inFileRegex +
                ", searchInArchives=" + searchInArchives +
                ", maxSearchDepth=" + maxSearchDepth +
                '}';
    }

}
