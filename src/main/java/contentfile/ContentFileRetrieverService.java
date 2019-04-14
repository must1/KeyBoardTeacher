package contentfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ContentFileRetrieverService implements ContentFileRetriever {

    @Override
    public Stream<String> getContentFile(String pathName) {

        Stream<String> contentFileStream = null;
        try {
            contentFileStream = Files.lines(Paths.get(pathName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentFileStream;
    }
}