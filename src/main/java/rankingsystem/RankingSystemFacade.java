package rankingsystem;

import view.GameMessages;

import java.util.Map;

public class RankingSystemFacade {
    private RankingSystemService rankingSystemService;
    private GameMessages gameMessages;

    public RankingSystemFacade(RankingSystemService rankingSystem, GameMessages gameMessages) {
        this.rankingSystemService = rankingSystem;
        this.gameMessages = gameMessages;
    }

    public void executeRankingSystemProcess(String name, long timeOfFinishGame) {
        rankingSystemService.overwriteFileWithGivenResult(name, timeOfFinishGame);
        String[] rankingArray = rankingSystemService.retrieveRankingData();
        Map<String, Long> linkedHashMappedRankingArray = rankingSystemService.getLinkedHashMappedRankingArray(rankingArray);
        int position = rankingSystemService.findGivenNameInRanking(name, linkedHashMappedRankingArray);

        gameMessages.executeMessageAboutPlaceInRankingOfPlayer(++position, linkedHashMappedRankingArray.size());
    }
}
