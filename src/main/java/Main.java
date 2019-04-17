import conditionchecker.ConditionCheckerService;
import contentfile.ContentFileRetrieverService;
import rankingsystem.RankingSystemFacade;
import rankingsystem.RankingSystemService;
import view.KeyBoardTeacherView;

public class Main {

    public static void main(String[] args) {

        ConditionCheckerService conditionCheckerService = new ConditionCheckerService();
        ContentFileRetrieverService contentFileRetrieverService = new ContentFileRetrieverService();
        KeyBoardTeacherView keyBoardTeacherView = new KeyBoardTeacherView();
        RankingSystemService rankingSystem = new RankingSystemService(contentFileRetrieverService);
        RankingSystemFacade rankingSystemFacade = new RankingSystemFacade(rankingSystem,keyBoardTeacherView);

        KeyBoardTeacherEngine keyBoardTeacherEngine = new KeyBoardTeacherEngine(contentFileRetrieverService,
                conditionCheckerService, keyBoardTeacherView, rankingSystemFacade);
        keyBoardTeacherEngine.startKeyBoardTeacherEngine();
    }
}


