package conditionchecker;

public class ConditionCheckerService implements ConditionChecker {
    @Override
    public boolean checkIfCharactersAreUnequal(char firstCharacter, char secondCharacter) {
        return firstCharacter != secondCharacter;
    }

    //if index+1 equals to length of line given by user (which is shorter than proper),
    // then we know that there is bad index at the end of given line.
    @Override
    public boolean checkIfIndexEqualsToLengthOfLineGivenByUser(int index, String lineGivenByUser) {
        return index + 1 == lineGivenByUser.length();
    }
}
