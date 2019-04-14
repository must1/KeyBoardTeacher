import conditionchecker.ConditionChecker;
import contentfile.ContentFileRetriever;

import java.util.Scanner;
import java.util.stream.Stream;

class KeyBoardTeacherEngine {

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

        Stream<String> contentFileStream = contentFileRetriever.getContentFile(getPath());
        String[] contentFileArray = contentFileStream.toArray(String[]::new);
        String lineGivenByUser;
        long startTime = System.nanoTime();
        for (int lineNumberOfFile = 0; lineNumberOfFile < contentFileArray.length; lineNumberOfFile++) {
            isIteratedLineNotProper = true;
            do {
                System.out.println(contentFileArray[lineNumberOfFile]);
                lineGivenByUser = scanner.nextLine();
                if (lineGivenByUser.length() < contentFileArray[lineNumberOfFile].length()) {
                    executeCaseWhenGivenLineIsShorterThanProper(lineGivenByUser, lineNumberOfFile, contentFileArray);
                } else {
                    executeCaseWhenGivenLineHasLengthAsProper(lineGivenByUser, lineNumberOfFile, contentFileArray);
                }
            } while (isIteratedLineNotProper);
        }

        long endTime = System.nanoTime();
        long durationTimeInSeconds = (endTime - startTime) / 1000000000; // we must divide the result in nanoseconds by 1000000000 to get result in seconds
        System.out.println("Congratulations, you have completed it in: " + durationTimeInSeconds + " seconds.");
    }

    private String getPath() {
        System.out.println("Provide path of the file(if the file is in the project folder, then just write a name of the file)");
        return scanner.nextLine();
    }

    private void executeCaseWhenGivenLineIsShorterThanProper(String lineGivenByUser, int lineNumberOfFile, String[] contentFileArray) {
        for (int index = 0; index < lineGivenByUser.length(); index++) {
            if (conditionChecker.checkIfTwoCharactersAreEqual(lineNumberOfFile, lineGivenByUser, contentFileArray, index)) {
                System.out.println("Bad character at " + index + " index.");
                break;
            } else if (index + 1 == lineGivenByUser.length()) {
                System.out.println("Bad character at " + lineGivenByUser.length() + " index.");
                break;
            }
        }
    }

    private void executeCaseWhenGivenLineHasLengthAsProper(String lineGivenByUser, int lineNumberOfFile, String[] contentFileArray) {
        for (int index = 0; index < lineGivenByUser.length(); index++) {
            if (conditionChecker.checkIfTwoCharactersAreEqual(lineNumberOfFile, lineGivenByUser, contentFileArray, index)) {
                System.out.println("Bad character at " + index + " index.");
                break;
            } else if (index + 1 == contentFileArray[lineNumberOfFile].length()) {
                isIteratedLineNotProper = false;
                break;
            }
        }
    }
}