package view;

public interface GameMessages {

    void executeCongratulationsAboutEndingGame(long durationTimeInSeconds, String name);
    void executeBadIndexMessage(int index);
    void executeGettingContentPathMessage();
    void executeMessageOfCaseWhenGivenLineIsShorterThanProper(String lineGivenByUser);
    void askAboutName();
    void executeMessageOfCaseWhenGivenLineIsLongerThanProper();
    void executeMessageAboutPlaceInRankingOfPlayer(int position, int size);
    void executeGettingRankingFilePathMessage();
}
