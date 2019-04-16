package conditionchecker;

public interface ConditionChecker {

    boolean checkIfTwoCharactersAreUnequal(int lineNumber, String lineGivenByUser, String[] contentFileArray, int index);

    boolean checkIfIndexEqualsToLengthOfLineGivenByUser(int index, String lineGivenByUser);

    boolean checkIfIndexEqualsToLengthOfProperLine(int index, int lineNumberOfFile, String[] contentFileArray);
}
