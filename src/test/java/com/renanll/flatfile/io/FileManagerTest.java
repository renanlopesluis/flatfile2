package com.renanll.flatfile.io;

import com.renanll.flatfile.config.FileConfig;
import com.renanll.flatfile.stub.ContentStub;
import com.renanll.flatfile.stub.PathStub;
import org.junit.After;
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

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FileManagerTest {

    private final Path IN_PATH = Paths.get(System.getProperty("user.dir") + "/data/in");
    private final String EXTENSION = ".dat";
    private final String FILE_NAME = "data";
    private final String LINE_BREAK = "\n";
    private final FileStream fileStream = new DATFileStream(IN_PATH +"/"+ FILE_NAME + EXTENSION, LINE_BREAK);

    @InjectMocks
    private FileManager fileManager;
    @Mock
    private FileConfig fileConfig;


    @Before
    public void setUp() throws IOException {
        fileStream.write(ContentStub.build());
    }

    @After
    public void destroy() throws IOException {
        List<Path> paths = PathStub.buildList(IN_PATH.toString(), EXTENSION);
        for (Path path : paths) {
            fileStream.delete(path.toFile());
        }
    }

    @Test
    public void shouldGetAllPaths() throws IOException {
        when(fileConfig.getInPath()).thenReturn(IN_PATH);
        when(fileConfig.getExtension()).thenReturn(EXTENSION);

        List<Path> paths = fileManager.getAllFilesFromDirectory();

        Assert.assertFalse(paths.isEmpty());
    }

    @Test
    public void shouldExtractFileName(){
        final Path given = Paths.get(System.getProperty("user.dir") + "/data/in/"+FILE_NAME);
        Assert.assertEquals(FILE_NAME, fileManager.extractFileName(given));
    }

}
