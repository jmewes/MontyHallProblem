import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class GameShowTest {
        
    @Test
    public void testGetRandomDoorAllocation() {
        
        boolean[] solution = GameShow.getRandomDoorAllocation();
        
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
        
        int userChoice = GameShow.getRandomPlayerChoice();
        
        assertTrue(userChoice < 3);
        assertTrue(userChoice >= 0);
    }
    
    @Test
    public void testGameMasterChoice() {
        
        // test for user choice right
        boolean[] solution1 = new boolean[] {true,  false, false};
        int gameMasterChoice1 = GameShow.getRandomGameMasterChoice(solution1, 0);
        assertTrue(gameMasterChoice1 == 1 || gameMasterChoice1 == 2);
        
        // test for user choice wrong
        boolean[] solution2 = new boolean[] {false, true,  false};
        int gameMasterChoice2 = GameShow.getRandomGameMasterChoice(solution2, 0);
        assertTrue(gameMasterChoice2 == 2);        
    }
        
    @Test
    public void testGetRemainingOption() {

        int doorPlayer;
        int doorGameMaster;
        int doorRemaining;
       
        doorPlayer = 0;
        doorGameMaster = 1;
        doorRemaining = GameShow.getRemainingOption(doorPlayer, doorGameMaster);
        assertEquals(2, doorRemaining);
        
        doorPlayer = 1;
        doorGameMaster = 2;
        doorRemaining = GameShow.getRemainingOption(doorPlayer, doorGameMaster);
        assertEquals(0, doorRemaining);
        
        doorPlayer = 2;
        doorGameMaster = 0;
        doorRemaining = GameShow.getRemainingOption(doorPlayer, doorGameMaster);
        assertEquals(1, doorRemaining);        
    }
}
