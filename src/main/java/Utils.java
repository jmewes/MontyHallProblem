import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    
    private final static int NUMBER_OF_DOORS = 3;
    private final static Random rand = new Random();
    
    public static boolean[] getRandomSolution() {
        
        boolean[] solution = new boolean[NUMBER_OF_DOORS];
        int solutionIndex = rand.nextInt(NUMBER_OF_DOORS);
        solution[solutionIndex] = true;
        
        return solution;
    }
    
    public static int getRandomUserChoice() {
        
        return rand.nextInt(NUMBER_OF_DOORS);
    }
    
    public static int getGameMasterChoice(boolean[] doors, int userChoice) {
       
        List<Integer> wrongAnswers = new ArrayList<Integer>();
        for(int i=0; i<NUMBER_OF_DOORS; i++) {
            boolean answer = doors[i];
            if (answer == false) {
                wrongAnswers.add(i);
            }
        }
        
        if (wrongAnswers.contains(userChoice)) {
            wrongAnswers.remove(new Integer(userChoice));
            return wrongAnswers.get(0);
        }
        
        return wrongAnswers.get(rand.nextInt(NUMBER_OF_DOORS - 1));
    }
    
    public static int getRemainingOption(int userChoice, int gameMasterChoice) {
        return NUMBER_OF_DOORS - userChoice - gameMasterChoice;
    }
}
