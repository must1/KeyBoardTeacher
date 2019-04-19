package rankingsystem;

import contentfile.ContentFileRetrieverService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RankingSystemServiceTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private ContentFileRetrieverService contentFileRetrieverService = new ContentFileRetrieverService();
    private RankingSystemService rankingSystemService = new RankingSystemService(contentFileRetrieverService);

    @Test
    public void getLinkedHashMappedRankingArray() {
        String[] testedArray = {"Piotr 3", "Anna 1", "Andrzej 2"};
        Map<String, Long> linkedSortedHashMappedRankingArray = rankingSystemService.getSortedLinkedHashMappedRankingArray(testedArray);
        Map<String, Long> expectedLinkedSortedHashMappedRankingArray = new LinkedHashMap<>();
        expectedLinkedSortedHashMappedRankingArray.put("Anna", 1L);
        expectedLinkedSortedHashMappedRankingArray.put("Andrzej", 2L);
        expectedLinkedSortedHashMappedRankingArray.put("Piotr", 3L);

        int actualPosition = rankingSystemService.findGivenNameInRanking("Piotr", linkedSortedHashMappedRankingArray);
        int exceptedPosition = rankingSystemService.findGivenNameInRanking("Piotr", expectedLinkedSortedHashMappedRankingArray);

        assertEquals(exceptedPosition, actualPosition);
    }

    @Test
    public void overwriteFileWithGivenResult() throws IOException {
        File rankingFile = tempFolder.newFile("rankingText.txt");
        String rankingFilePath = rankingFile.getPath();

        String[] actualResultBeforeOverwriting = rankingSystemService.retrieveRankingData(rankingFilePath);
        String[] expectedResultBeforeOverwriting = {};

        assertArrayEquals(expectedResultBeforeOverwriting, actualResultBeforeOverwriting);

        rankingSystemService.overwriteFileWithGivenResult("Piotr", 1L, rankingFilePath);

        String[] afterOverwriting = rankingSystemService.retrieveRankingData(rankingFilePath);
        String[] expectedResultAfterOverwriting = {"Piotr 1"};

        rankingFile.deleteOnExit();
        assertArrayEquals(expectedResultAfterOverwriting, afterOverwriting);
    }

}