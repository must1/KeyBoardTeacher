package conditionchecker;

public class ConditionCheckerService implements ConditionChecker {

    @Override
    public boolean checkIfTwoCharactersAreEqual(int lineNumber, String lineGivenByUser, String[] contentFileArray, int index) {
        return !(contentFileArray[lineNumber].charAt(index) == lineGivenByUser.charAt(index));
    }
}
