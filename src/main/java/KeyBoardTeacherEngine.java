import conditionchecker.ConditionChecker;
import contentfile.ContentFileRetriever;

import java.util.Scanner;

class KeyBoardTeacherEngine {

    private static final int NANOSECONDS_IN_SECOND = 1000000000;
    private ConditionChecker conditionChecker;
    private ContentFileRetriever contentFileRetriever;
    private Scanner scanner;
    private boolean isIteratedLineNotProper;

    KeyBoardTeacherEngine(ContentFileRetriever contentFileRetriever, ConditionChecker conditionChecker) {
        this.contentFileRetriever = contentFileRetriever;
        this.conditionChecker = conditionChecker;
        scanner = new Scanner(System.in);
    }

    void startKeyBoardTeacherEngine() {

        String[] contentFileArray = contentFileRetriever.getContentFile(getPath());
        String lineGivenByUser;
        long startTime = System.nanoTime();
        for (int lineNumberOfFile = 0; lineNumberOfFile < contentFileArray.length; lineNumberOfFile++) {
            isIteratedLineNotProper = true;
            do {
                System.out.println(contentFileArray[lineNumberOfFile]);
                lineGivenByUser = scanner.nextLine();
                for (int index = 0; index < lineGivenByUser.length(); index++) {
                    if (conditionChecker.checkIfTwoCharactersAreUnequal(lineNumberOfFile, lineGivenByUser, contentFileArray, index)) {
                        System.out.println("Bad character at " + index + " index.");
                        break;
                    } else if ((lineGivenByUser.length() < contentFileArray[lineNumberOfFile].length())) {
                        if (conditionChecker.checkIfIndexEqualsToLengthOfLineGivenByUser(index, lineGivenByUser)) {
                            break;
                        }
                    } else if ((lineGivenByUser.length() == contentFileArray[lineNumberOfFile].length())) {
                        if (conditionChecker.checkIfIndexEqualsToLengthOfProperLine(index, lineNumberOfFile, contentFileArray)) {
                            isIteratedLineNotProper = false;
                            break;
                        }
                    }
                }
            } while (isIteratedLineNotProper);
        }

        long endTime = System.nanoTime();
        long durationTimeInSeconds = (endTime - startTime) / NANOSECONDS_IN_SECOND;
        System.out.println("Congratulations, you have completed it in: " + durationTimeInSeconds + " seconds.");
    }

    private String getPath() {
        System.out.println("Provide path of the file(if the file is in the project folder, then just write a name of the file)");
        return scanner.nextLine();
    }
}
