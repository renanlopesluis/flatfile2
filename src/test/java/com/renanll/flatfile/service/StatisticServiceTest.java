package com.renanll.flatfile.service;

import com.renanll.flatfile.config.FileConfig;
import com.renanll.flatfile.io.DATFileStream;
import com.renanll.flatfile.io.FileManager;
import com.renanll.flatfile.model.Summary;
import com.renanll.flatfile.stub.ContentStub;
import com.renanll.flatfile.stub.PathStub;
import com.renanll.flatfile.stub.SummaryStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatisticServiceTest {

	private final Path IN_PATH = Paths.get(System.getProperty("user.dir") + "/data/in");
	private final Path OUT_PATH = Paths.get(System.getProperty("user.dir") + "/data/out/%s.done.dat");
	private final String EXTENSION = ".dat";
	private final String FILENAME = "data";
	private final String LINE_BREAK = "\n";

	@InjectMocks
	private DataRowStatisticService statistic;
	@Mock
	private SummarizerService summarizerService;
	@Mock
	private FileManager fileManager;
	@Mock
	private FileConfig fileConfig;

	@Before
	public void setUp() throws IOException {
		final String inPath = IN_PATH +"/"+ FILENAME + EXTENSION;
		final List<String> lines = ContentStub.build();
		new DATFileStream(inPath, LINE_BREAK).write(lines);
	}

	@Test
	public void shouldProcessStatistics() throws Exception {
		final String outPath = String.format(OUT_PATH.toString(), FILENAME);
		final List<Path> paths = PathStub.buildList(IN_PATH.toString(), EXTENSION);
		final Summary expected = SummaryStub.build();

		when(fileManager.getAllFilesFromDirectory()).thenReturn(paths);
		when(fileManager.extractFileName(any(Path.class))).thenReturn(FILENAME);
		when(fileManager.getFileConfig()).thenReturn(fileConfig);
		when(fileConfig.getOutPath()).thenReturn(OUT_PATH);
		when(fileConfig.getLineBreak()).thenReturn(LINE_BREAK);
		when(summarizerService.summarize(anyList())).thenReturn(expected);

		statistic.process();

		List<String> actual = new DATFileStream(outPath, LINE_BREAK).read();
		Assert.assertEquals(expected.toLines(), actual);
	}
}
