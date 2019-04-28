package com.thewonggei;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FluentFinderTest {

    @Test
    public void test () {
        FinderProperties finderProperties = new FinderProperties("/Users/nick/dev", ".*\\.sh", null, false, 10);
        FluentFinder fluentFinder = new FluentFinder(finderProperties);

        List<File> files = fluentFinder.listFiles();
        files.stream().forEach(file -> System.out.println(file.getAbsolutePath()));

        assertTrue(files.size() > 0);
    }

}
