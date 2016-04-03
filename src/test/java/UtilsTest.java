import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class UtilsTest {
    
    public static final int NUMBER_OF_TRAILS = 100000;
    
    @Test
    public void testGetRandomSolution() {
        
        boolean[] solution = Utils.getRandomSolution();
        
        assertEquals(3, solution.length);
        assertEquals(1, getNumberOfThruthValues(solution));
    }
    
    private int getNumberOfThruthValues(boolean[] solution) {
        
        int result = 0;
        
        for (boolean i : solution) {
            if (i == true) {
                result++;
            }
        }
        
        return result;
    }
    
    @Test
    public void testGetUserChoice() {
        
        int userChoice = Utils.getRandomUserChoice();
        
        assertTrue(userChoice < 3);
        assertTrue(userChoice >= 0);
    }
    
    @Test
    public void testGameMasterChoice() {
        
        // test user choice right
        boolean[] solution1 = new boolean[] {true,  false, false};
        int gameMasterChoice1 = Utils.getGameMasterChoice(solution1, 0);
        assertTrue(gameMasterChoice1 == 1 || gameMasterChoice1 == 2);
        
        // test user choice wrong
        boolean[] solution2 = new boolean[] {false, true,  false};
        int gameMasterChoice2 = Utils.getGameMasterChoice(solution2, 0);
        assertTrue(gameMasterChoice2 == 2);        
    }
    
    @Test
    public void testSuccessKeep() {
        
        boolean[] doors;
        int userChoice;
        int successCounter = 0;
        
        for (int i=0; i<NUMBER_OF_TRAILS; i++) {
            doors = Utils.getRandomSolution();
            userChoice = Utils.getRandomUserChoice();
            
            if (doors[userChoice]) {
                successCounter++;
            }
        }
        
        double successPercentage = 100.0 * successCounter / NUMBER_OF_TRAILS;
        assertEquals(33, successPercentage, 1);
    }
    
    @Test
    public void testSuccessChange() {

        boolean[] doors;
        int userChoice;
        int gameMasterChoice;
        int successCounter = 0;

        for (int i=0; i<NUMBER_OF_TRAILS; i++) {
            doors = Utils.getRandomSolution();
            
            // User makes a choice
            userChoice = Utils.getRandomUserChoice();

            // Game master reveals wrong answer
            gameMasterChoice = Utils.getGameMasterChoice(doors, userChoice);

            // User changes his choice
            userChoice = Utils.getRemainingOption(userChoice, gameMasterChoice);
            
            if (doors[userChoice]) {
                successCounter++;
            }
        }
        
        double successPercentage = 100.0 * successCounter / NUMBER_OF_TRAILS;
        assertEquals(67, successPercentage, 1);
    }
    
    @Test
    public void testGetRemainingOption() {

        int doorPlayer;
        int doorGameMaster;
        int doorRemaining;
       
        doorPlayer = 0;
        doorGameMaster = 1;
        doorRemaining = Utils.getRemainingOption(doorPlayer, doorGameMaster);
        assertEquals(2, doorRemaining);
        
        doorPlayer = 1;
        doorGameMaster = 2;
        doorRemaining = Utils.getRemainingOption(doorPlayer, doorGameMaster);
        assertEquals(0, doorRemaining);
        
        doorPlayer = 2;
        doorGameMaster = 0;
        doorRemaining = Utils.getRemainingOption(doorPlayer, doorGameMaster);
        assertEquals(1, doorRemaining);        
    }
}
