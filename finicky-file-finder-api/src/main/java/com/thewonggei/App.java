package com.thewonggei;

import java.io.File;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FileFinder fileFinder = new FileFinder();
        fileFinder.list().forEach(f -> System.out.println(f.getAbsolutePath()));

        System.out.println();

        fileFinder = new FileFinder(new File("."), Pattern.compile(".*git.*"));
        fileFinder.list().forEach(f -> System.out.println(f.getAbsolutePath()));
    }
}