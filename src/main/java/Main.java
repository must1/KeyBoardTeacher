import conditionchecker.ConditionCheckerService;
import contentfile.ContentFileRetrieverService;

public class Main {

    public static void main(String[] args) {

        //C:\Users\Admin\IdeaProjects\KeyboardTeacher\tekst.txt
        ConditionCheckerService conditionCheckerService = new ConditionCheckerService();
        ContentFileRetrieverService contentFileRetrieverService = new ContentFileRetrieverService();

        KeyBoardTeacherEngine keyBoardTeacherEngine = new KeyBoardTeacherEngine(contentFileRetrieverService, conditionCheckerService);
        keyBoardTeacherEngine.startKeyBoardTeacherEngine();
    }
}


