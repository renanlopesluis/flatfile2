package com.renanll.flatfile.io;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public abstract class FileStream {
	
	protected String path;
	protected String lineBreak;
	
	public abstract void write(List<String> lines) throws IOException;
	public abstract List<String> read() throws IOException;
	public  abstract void delete(File file);
}
