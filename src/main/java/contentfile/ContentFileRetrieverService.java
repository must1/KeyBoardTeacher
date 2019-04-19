package contentfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ContentFileRetrieverService implements ContentFileRetriever {

    @Override
    public String[] getContent(String pathName) {

        try (Stream<String> contentFileStream = Files.lines(Paths.get(pathName))) {
            return contentFileStream.toArray(String[]::new);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}