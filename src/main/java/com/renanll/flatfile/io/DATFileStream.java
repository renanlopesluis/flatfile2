package com.renanll.flatfile.io;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
@Getter
public class DATFileStream extends FileStream {

	public DATFileStream(String path, String lineBreak) {
		super();
		super.path = path;
		this.lineBreak = lineBreak;
	}
	
	@Override
	public void write(List<String> lines) throws IOException {
		File file = new File(super.path);
		file.getParentFile().mkdirs();
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			if(!file.createNewFile()) {
				for (String line : lines) {
					outputStream.write(line.getBytes());
					outputStream.write(lineBreak.getBytes());
				}
			}
		} catch (IOException e) {
			log.error("An error occurred while writting files {}", e);
			throw e;
		} finally {
			if(outputStream != null){
				outputStream.close();
			}
		}
	}

	@Override
	public List<String> read() throws IOException {
		List<String> lines = new ArrayList<>();
		try {
			InputStream is = new FileInputStream(super.path);
			Scanner reader = new Scanner(is);
			while (reader.hasNext()) {
				lines.add(reader.nextLine());
			}
			reader.close();
			is.close();
		} catch (IOException e) {
			log.error("An error occurred while reading files {}", e);
			throw e;
		}
		return lines;
	}

	@Override
	public void delete(File file)  {
		file.delete();
	}

}
