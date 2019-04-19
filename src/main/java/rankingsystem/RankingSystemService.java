package rankingsystem;

import contentfile.ContentFileRetriever;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class RankingSystemService {

    private static final int FIRST_PART = 0;
    private static final int SECOND_PART = 1;
    private ContentFileRetriever contentFileRetriever;

    public RankingSystemService(ContentFileRetriever contentFileRetriever) {
        this.contentFileRetriever = contentFileRetriever;
    }

    int findGivenNameInRanking(String name, Map<String, Long> sortedRankingArray) {
        return new ArrayList<>(sortedRankingArray.keySet()).indexOf(name);
    }

    Map<String, Long> getSortedLinkedHashMappedRankingArray(String[] rankingArray) {
        return Arrays
                .stream(rankingArray)
                .map(it -> it.split("\\s+"))
                .collect(Collectors.toMap(it -> it[FIRST_PART], it -> Long.valueOf(it[SECOND_PART])))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    String[] retrieveRankingData(String rankingPathFile) {
        return contentFileRetriever.getContent(rankingPathFile);
    }

    void overwriteFileWithGivenResult(String name, long timeOfFinishingGame, String rankingPathFile) {

        try (FileWriter writer = new FileWriter(rankingPathFile, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(name + " " + timeOfFinishingGame);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
