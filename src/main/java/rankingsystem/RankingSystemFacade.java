package rankingsystem;

import view.GameMessages;

import java.util.Map;
import java.util.Scanner;

public class RankingSystemFacade {
    private RankingSystemService rankingSystemService;
    private GameMessages gameMessages;
    private Scanner scanner;

    public RankingSystemFacade(RankingSystemService rankingSystem, GameMessages gameMessages) {
        this.rankingSystemService = rankingSystem;
        this.gameMessages = gameMessages;
        scanner = new Scanner(System.in);
    }

    public void executeRankingSystemProcess(String name, long timeOfFinishGame) {
        String rankingPathFile = getPathOfRankingFile();
        rankingSystemService.overwriteFileWithGivenResult(name, timeOfFinishGame,rankingPathFile);
        String[] rankingArray = rankingSystemService.retrieveRankingData(rankingPathFile);
        Map<String, Long> linkedSortedHashMappedRankingArray = rankingSystemService.getSortedLinkedHashMappedRankingArray(rankingArray);
        int position = rankingSystemService.findGivenNameInRanking(name, linkedSortedHashMappedRankingArray);

        gameMessages.executeMessageAboutPlaceInRankingOfPlayer(++position, linkedSortedHashMappedRankingArray.size());
    }

    private String getPathOfRankingFile()
    {
        gameMessages.executeGettingRankingFilePathMessage();
        return scanner.nextLine();
    }
}
