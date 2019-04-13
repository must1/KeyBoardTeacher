package contentfile;

import java.util.stream.Stream;

public interface ContentFileGetter {
    Stream<String> getContentFile(String pathName);
}
