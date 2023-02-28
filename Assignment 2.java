import java.util.*;
//vikash katiyar
class Player{
	int guessVal;
    Scanner sc = new Scanner(System.in);
    public int getPlayerGuess(int i){
       System.out.println("Enter Player " + Integer.toString(i) + " guess value : ");
       guessVal = sc.nextInt();
       return guessVal;
    }
}

class Umpire{
   
   int numOfPlayer;
   int randomGuess;

   
   public int getRandomGuess() {
       return randomGuess;
   }
   public void setRandomGuess(int randomGuess) {
       this.randomGuess = randomGuess;
   }
   public int getNumOfPlayer() {
       return numOfPlayer;
   }
   public void setNumOfPlayer(int numOfPlayer) {
       this.numOfPlayer = numOfPlayer;
   }

   public int[] playerGuess(int n){
       
       Player p = new Player();
       int[] playerGuesses = new int[n];

       for(int i=0;i<n;i++){
           playerGuesses[i] = p.getPlayerGuess(i);
       }
       
       return  playerGuesses;
   }

   public int[] match(int[] playerGuesses,int guessValue){
    
       for(int i=0;i<playerGuesses.length;i++){
           if(playerGuesses[i] != guessValue){
               playerGuesses[i] = -1;
           }

       }

       return playerGuesses;
   }	
}


public class GuessGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean allFail = false;

        int winnerPlayer = 0;
        
        System.out.print("\n\nEnter Number of the player :: ");
        
        int numOfPlayer = sc.nextInt();
        int round = 1;
        String[] s = new String[numOfPlayer];
        Arrays.fill(s,"Pass");

        while(numOfPlayer > 1){
            int countTemp = 0;
            System.out.println(" \n\nRound "+ Integer.toString(round) + " Starts : \n\n");


            Umpire umpire = new Umpire();
            umpire.setNumOfPlayer(numOfPlayer);
            umpire.setRandomGuess(random.nextInt(11));
            System.out.println("Random Guess is :: " + Integer.toString(umpire.getRandomGuess())) ;
            int[] playerGuesses = new int[numOfPlayer];

            playerGuesses = umpire.playerGuess(numOfPlayer);

            playerGuesses = umpire.match(playerGuesses,umpire.getRandomGuess());
            int k = 0;
            for(int i=0;i<s.length;i++){
                
                if(s[i] == "Pass"){
                    if(playerGuesses[k] == -1){
                        s[i] = "Fail";
                        k++;
                    }
                    else{
                        k++;
                        countTemp++;
                    }
                }
            }
            numOfPlayer = countTemp;
            round++;

            if(numOfPlayer == 0){
                allFail = true;
            }
            else if(numOfPlayer == 1){
                for(int i=0;i<s.length;i++){
                    if(s[i] == "Pass"){
                        winnerPlayer = i;
                    }
                }
            }
        }

        if(allFail){
            System.out.println("\n\n All Player Failed Please Restart The Game");
        }
        else{
            System.out.println("\n\nPlayer " + Integer.toString(winnerPlayer) + " wins the game");
        }              
    }

}

