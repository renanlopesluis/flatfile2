package com.renanll.flatfile.stub;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathStub {

    public static List<Path> buildList(String pathString, String extension) throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get(pathString))) {
            return stream.filter(Files::isRegularFile).filter(x -> x.toString().endsWith(extension))
                    .collect(Collectors.toList());
        }
    }
}
