package com.renanll.flatfile.io;

import com.renanll.flatfile.config.FileConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class FileManager {

	private final FileConfig fileConfig;

	public List<Path> getAllFilesFromDirectory() throws IOException {
		try (Stream<Path> stream = Files.walk(Paths.get(fileConfig.getInPath().toString()))) {
			return stream.filter(Files::isRegularFile).filter(x -> x.toString().endsWith(fileConfig.getExtension()))
					.collect(Collectors.toList());
		}
	}
	
	public String extractFileName(Path path) {
		String[] files = path.toString().split("/");
		return files[files.length - 1].split("/")[0];
	}
}
