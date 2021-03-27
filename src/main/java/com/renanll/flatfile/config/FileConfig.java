package com.renanll.flatfile.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
@Configuration
public class FileConfig {

	@Value("${application.file.directory.in}")
	private String inDirectory;
	@Value("${application.file.directory.out}")
	public String outDirectory;
	@Value("${application.file.extension}")
	private String extension;
	@Value("${application.file.linebreak}")
	private String lineBreak;

	public Path getInPath(){
		return Paths.get(System.getProperty("user.dir") + inDirectory);
	}

	public Path getOutPath() {
		return Paths.get(System.getProperty("user.dir") + outDirectory);
	}

	
}