package conditionchecker;

public class ConditionCheckerService implements ConditionChecker {
    @Override
    public boolean checkIfTwoCharactersAreUnequal(int lineNumber, String lineGivenByUser, String[] contentFileArray, int index) {
        return !(contentFileArray[lineNumber].charAt(index) == lineGivenByUser.charAt(index));
    }

    //if index equals to length of line given by user (which is shorter than proper),
    // then we know that there is bad index at the end of given line.
    @Override
    public boolean checkIfIndexEqualsToLengthOfLineGivenByUser(int index, String lineGivenByUser) {
        if (index + 1 == lineGivenByUser.length()) {
            System.out.println("Bad character at " + lineGivenByUser.length() + " index.");
            return true;
        }
        return false;
    }

    //if index equals to length, then we know that there is no bad indexes in given line
    @Override
    public boolean checkIfIndexEqualsToLengthOfProperLine(int index, int lineNumberOfFile, String[] contentFileArray) {
        return index + 1 == contentFileArray[lineNumberOfFile].length();
    }
}
