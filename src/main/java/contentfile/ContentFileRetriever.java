package contentfile;

import java.util.stream.Stream;

public interface ContentFileRetriever {
    
    Stream<String> getContentFile(String pathName);
}
