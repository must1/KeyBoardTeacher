import conditionchecker.ConditionChecker;
import contentfile.ContentFileGetter;

import java.util.Scanner;
import java.util.stream.Stream;

class KeyBoardTeacherEngine {
    private ConditionChecker conditionChecker;
    private ContentFileGetter contentFileGetter;
    private Scanner scanner;
    private boolean isTrue;

    KeyBoardTeacherEngine(ContentFileGetter contentFileGetter, ConditionChecker conditionChecker) {
        this.contentFileGetter = contentFileGetter;
        this.conditionChecker = conditionChecker;
        scanner = new Scanner(System.in);
    }

     void startKeyBoardTeacherEngine() {

        Stream<String> contentFileStream = contentFileGetter.getContentFile(getPath());
        String[] contentFileArray = contentFileStream.toArray(String[]::new);
        String lineGivenByUser;

        for (int lineNumberOfFile = 0; lineNumberOfFile < contentFileArray.length; lineNumberOfFile++) {
            isTrue = true;
            do {
                System.out.println(contentFileArray[lineNumberOfFile]);
                lineGivenByUser = scanner.nextLine();
                if (lineGivenByUser.length() < contentFileArray[lineNumberOfFile].length()) {
                    executeCaseWhenGivenLineIsShorterThanProper(lineGivenByUser, lineNumberOfFile, contentFileArray);
                } else {
                    executeCaseWhenGivenLineHasLengthAsProper(lineGivenByUser, lineNumberOfFile, contentFileArray);
                }
            } while (isTrue);
        }
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
                isTrue = false;
                break;
            }
        }
    }
}