import conditionchecker.ConditionChecker;
import contentfile.ContentFileRetriever;
import rankingsystem.RankingSystemFacade;
import view.GameMessages;

import java.util.Arrays;
import java.util.Scanner;

class KeyBoardTeacherEngine {

    private static final int NANOSECONDS_IN_SECOND = 1000000000;
    private ConditionChecker conditionChecker;
    private ContentFileRetriever contentFileRetriever;
    private GameMessages gameMessages;
    private RankingSystemFacade rankingSystemFacade;
    private Scanner scanner;

    KeyBoardTeacherEngine(ContentFileRetriever contentFileRetriever, ConditionChecker conditionChecker,
                          GameMessages gameMessages, RankingSystemFacade rankingSystemFacade) {
        this.contentFileRetriever = contentFileRetriever;
        this.conditionChecker = conditionChecker;
        this.gameMessages = gameMessages;
        this.rankingSystemFacade = rankingSystemFacade;
        scanner = new Scanner(System.in);
    }

    void startKeyBoardTeacherEngine() {
        String name = getName();
        String[] contentFileArray = contentFileRetriever.getContent(getPathFileOfGame());
        String lineGivenByUser;
        long startTime = System.nanoTime();
        for (String modelLine : contentFileArray) {
            do {
                System.out.println(modelLine);
                lineGivenByUser = scanner.nextLine();

                if (modelLine.equals(lineGivenByUser)) {
                    break;
                }

                for (int index = 0; index < modelLine.length(); index++) {
                    int lineNumber = Arrays.asList(contentFileArray).indexOf(modelLine);

                    if (conditionChecker.checkIfCharactersAreUnequal(modelLine.charAt(index), lineGivenByUser.charAt(index))) {
                        gameMessages.executeBadIndexMessage(index);
                        break;
                    } else if ((lineGivenByUser.length() < contentFileArray[lineNumber].length())) {
                        if (conditionChecker.checkIfIndexEqualsToLengthOfLineGivenByUser(index, lineGivenByUser)) {
                            gameMessages.executeMessageOfCaseWhenGivenLineIsShorterThanProper(lineGivenByUser);
                            break;
                        }
                    } else if ((lineGivenByUser.length() > contentFileArray[lineNumber].length())) {
                        gameMessages.executeMessageOfCaseWhenGivenLineIsLongerThanProper();
                        break;
                    }
                }
            }
            while (true);
        }

        long endTime = System.nanoTime();
        long durationTimeInSeconds = (endTime - startTime) / NANOSECONDS_IN_SECOND;
        rankingSystemFacade.executeRankingSystemProcess(name, durationTimeInSeconds);
        gameMessages.executeCongratulationsAboutEndingGame(durationTimeInSeconds, name);
    }

    private String getPathFileOfGame() {
        gameMessages.executeGettingContentPathMessage();
        return scanner.nextLine();
    }

    private String getName() {
        gameMessages.askAboutName();
        return scanner.nextLine();
    }
}
