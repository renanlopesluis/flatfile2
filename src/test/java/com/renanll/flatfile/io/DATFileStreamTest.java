package com.renanll.flatfile.io;

import com.renanll.flatfile.stub.ContentStub;
import com.renanll.flatfile.stub.PathStub;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DATFileStreamTest {

    private final String FOLDER = "/data/in/";
    private final Path IN_PATH = Paths.get(System.getProperty("user.dir") + FOLDER);
    private final String EXTENSION = ".dat";
    private final String FILE_NAME = "data";
    private FileStream fileStream;
    private IOException error;

    @Before
    public void setUp(){

        final String lineBreak = "\n";
        fileStream = new DATFileStream(IN_PATH +"/"+ FILE_NAME + EXTENSION, lineBreak);
    }

    @After
    public void destroy() throws IOException {
        List<Path> paths = PathStub.buildList(IN_PATH.toString(), EXTENSION);
        for (Path path : paths) {
            fileStream.delete(path.toFile());
        }
    }

    @Test
    public void shouldWriteAFile(){
        final List<String> given = ContentStub.build();
        try {
            fileStream.write(given);
        } catch (IOException e) {
           error = e;
        }finally {
            Assert.assertNull(error);
        }
    }

    @Test
    public void shouldReadAFile(){
        try {
            fileStream.write(ContentStub.build());
            fileStream.read();
        } catch (IOException e) {
            error = e;
        }finally {
            Assert.assertNull(error);
        }
    }

    @Test
    public void shouldRemoveAFile(){
        try {
            final Path inPath = Paths.get(System.getProperty("user.dir") + FOLDER + FILE_NAME + EXTENSION);
            fileStream.write(ContentStub.build());
            fileStream.delete(inPath.toFile());
        } catch (IOException e) {
            error = e;
        }finally {
            Assert.assertNull(error);
        }
    }

    @Test(expected = IOException.class)
    public void shouldNotRemoveAFile() throws IOException{
        fileStream.write(ContentStub.build());
        fileStream.delete(IN_PATH.toFile());
    }
}
