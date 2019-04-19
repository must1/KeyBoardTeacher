package view;

public class KeyBoardTeacherView implements GameMessages {

    @Override
    public void executeCongratulationsAboutEndingGame(long durationTimeInSeconds, String name) {
        System.out.println("Congratulations " + name + ", you have ended in " + durationTimeInSeconds + " seconds.");
    }

    @Override
    public void executeBadIndexMessage(int index) {
        System.out.println("Bad " + index + " index. (starting from 0)");
    }

    @Override
    public void executeGettingContentPathMessage() {
        System.out.println("Provide path of the file in which we can find text for the game(if the file is in the project" +
                " folder, then just write a name of the file)");
    }

    @Override
    public void executeMessageOfCaseWhenGivenLineIsShorterThanProper(String lineGivenByUser) {
        System.out.println("Bad character at " + lineGivenByUser.length() + " index. (starting from 0)");
    }

    @Override
    public void askAboutName() {
        System.out.println("Please, put your name");
    }

    @Override
    public void executeMessageOfCaseWhenGivenLineIsLongerThanProper() {
        System.out.println("Your line is longer than proper, please try again!");
    }

    @Override
    public void executeMessageAboutPlaceInRankingOfPlayer(int position, int size) {
        System.out.println("You are " + position + " of " + size + " players in ranking!!!!");
    }

    @Override
    public void executeGettingRankingFilePathMessage() {
        System.out.println("Provide path of the ranking file(if the file is in the project folder, then just write a name of the file)");
    }
}
