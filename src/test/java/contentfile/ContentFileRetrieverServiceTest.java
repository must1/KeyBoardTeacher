package contentfile;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class ContentFileRetrieverServiceTest {

    private ContentFileRetriever contentFileRetriever = new ContentFileRetrieverService();

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void getContentFile() throws IOException {
        File textFile = tempFolder.newFile("testText.txt");
        String pathFile = textFile.getPath();
        FileWriter fileWriter = new FileWriter(textFile);
        fileWriter.write("Line1 a\nLine2 b c\nLine 3");
        fileWriter.close();

        String[] testedContent = contentFileRetriever.getContent(pathFile);
        String[] expected = {"Line1 a", "Line2 b c", "Line 3"};

        textFile.deleteOnExit();
        assertArrayEquals(expected, testedContent);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getContentFileWhenFileDoesNotExist() {
        String pathFile = "unknown";
        String[] testedContent = contentFileRetriever.getContent(pathFile);
    }
}