import conditionchecker.ConditionCheckerService;
import contentfile.ContentFileService;

public class Main {

    public static void main(String[] args) {

        //C:\Users\Admin\IdeaProjects\KeyboardTeacher\tekst.txt
        ConditionCheckerService conditionCheckerService = new ConditionCheckerService();
        ContentFileService contentFileService = new ContentFileService();

        KeyBoardTeacherEngine keyBoardTeacherEngine = new KeyBoardTeacherEngine(contentFileService, conditionCheckerService);
        keyBoardTeacherEngine.startKeyBoardTeacherEngine();
    }
}


