import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ProbabilityTest {
    
    public static final int NUMBER_OF_TRAILS = 100000;
    
    @Test
    public void testSuccessRateKeepAnswer() {

        int successCounter = 0;
        
        for (int i = 0; i < NUMBER_OF_TRAILS; i++) {
            boolean[] doors = GameShow.getRandomDoorAllocation();
            int userChoice = GameShow.getRandomPlayerChoice();
            
            if (doors[userChoice]) {
                successCounter++;
            }
        }
        
        assertEquals(33, getSuccessPercentage(successCounter), 1);
    }

    @Test
    public void testSuccessRateSwitchAnswer() {

        int successCounter = 0;

        for (int i = 0; i < NUMBER_OF_TRAILS; i++) {
            boolean[] doors = GameShow.getRandomDoorAllocation();
            int playerChoice = GameShow.getRandomPlayerChoice();
            int gameMasterChoice = GameShow.getRandomGameMasterChoice(doors, playerChoice);
            playerChoice = GameShow.getRemainingOption(playerChoice, gameMasterChoice);
            
            if (doors[playerChoice]) {
                successCounter++;
            }
        }
        
        assertEquals(67, getSuccessPercentage(successCounter), 1);
    }

    private double getSuccessPercentage(int numberOfSuccesses) {
        
        return 100.0 * numberOfSuccesses / NUMBER_OF_TRAILS;
    }
}
