package com.renanll.flatfile.service;

import com.renanll.flatfile.converter.Converter;
import com.renanll.flatfile.converter.FlatFileConverter;
import com.renanll.flatfile.io.DATFileStream;
import com.renanll.flatfile.io.FileManager;
import com.renanll.flatfile.io.FileStream;
import com.renanll.flatfile.model.DataRow;
import com.renanll.flatfile.model.Summary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DataRowStatisticService implements StatisticService {
	
	private final SummarizerService summarizerService;
	private final FileManager fileManager;

	@Override
	public void process() throws Exception {
		List<Path> paths = fileManager.getAllFilesFromDirectory();
		for (Path path : paths) {
			List<String> lines = readFile(path);
			List<DataRow> dataRows = rowsToDataRows(lines);
			writeStatistics(dataRows, path);
		}
	}
	
	private List<String> readFile(Path path) throws IOException {
		FileStream file = new DATFileStream(path.toString(), fileManager.getFileConfig().getLineBreak());
		List<String> lines = file.read();
		file.delete(path.toFile());
		return lines;
	}	
	
	private void writeStatistics(List<DataRow> rows, Path path) throws IOException {
		String fileName = fileManager.extractFileName(path);
		Summary summary = summarizerService.summarize(rows);
		FileStream fileStream = new DATFileStream(
				String.format(fileManager.getFileConfig().getOutPath().toString(), fileName),
				fileManager.getFileConfig().getLineBreak());

		fileStream.write(summary.toLines());
	}
	
	private List<DataRow> rowsToDataRows(List<String> lines) throws Exception{
		List<DataRow> dataRows = new ArrayList<>();
		Converter<DataRow> converter = new FlatFileConverter();
		for (String line : lines) {
			DataRow row = converter.convert(line);
			dataRows.add(row);
		}
		return dataRows;
	}
}
