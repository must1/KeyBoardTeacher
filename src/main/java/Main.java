import conditionchecker.ConditionChecker;
import conditionchecker.ConditionCheckerService;
import contentfile.ContentFileRetriever;
import contentfile.ContentFileRetrieverService;
import rankingsystem.RankingSystemFacade;
import rankingsystem.RankingSystemService;
import view.GameMessages;
import view.KeyBoardTeacherView;

public class Main {

    public static void main(String[] args) {

        ConditionChecker conditionChecker = new ConditionCheckerService();
        ContentFileRetriever contentFileRetriever = new ContentFileRetrieverService();
        GameMessages gameMessages = new KeyBoardTeacherView();
        RankingSystemService rankingSystemService = new RankingSystemService(contentFileRetriever);
        RankingSystemFacade rankingSystemFacade = new RankingSystemFacade(rankingSystemService, gameMessages);

        KeyBoardTeacherEngine keyBoardTeacherEngine = new KeyBoardTeacherEngine(contentFileRetriever,
                conditionChecker, gameMessages, rankingSystemFacade);
        keyBoardTeacherEngine.startKeyBoardTeacherEngine();
    }
}


