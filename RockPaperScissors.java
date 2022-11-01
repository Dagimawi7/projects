import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
  
  private static String[] choices = { "Rock", "Paper", "Scissors" };
  
  public static void main (String[] args){
    
    Scanner scan = new Scanner(System.in);
    Random rGen = new Random();
    
    String name;
    int playerChoiceNum;
    String playerChoice;
    
    int computerChoiceNum;
    String computerChoice;
    
    char tryAgain;
    String playerMessage;
    
    System.out.print("What is your name? ");
    name = scan.nextLine();
    System.out.println();
    
    System.out.print("1 = Rock\n2 = Paper\n3 = Scissors\nPlease choose 1, 2, or 3: ");
    playerChoiceNum = scan.nextInt(); scan.nextLine();
    playerChoice = choices[playerChoiceNum - 1];
    System.out.println();
    
    computerChoiceNum = Math.abs(rGen.nextInt()) % 3 + 1;
    computerChoice = choices[computerChoiceNum - 1];
    
    // If the player and computer are tied OR the 
    // computer is beating the player, then...
    //   Ask the user if he is sure about his choice, 
    //      as a yes/no
    //   Store the first character of the user's 
    //      response in the variable tryAgain
    //   If the answer is no, then...
    //      Repeat the lines of code that got the 
    //         user's choice the first time
    
    // YOUR CODE GOES HERE
 

// rest of body of loop
 int differnce =  computerChoiceNum - playerChoiceNum;
 if ( differnce == 0 || differnce == 2||  differnce == -1 ){
   System.out.println(" are you sure about your choice? ");
   
   tryAgain = scan.nextLine().charAt(0);
   
   if (tryAgain== 'n' ){
     
     System.out.print("1 = Rock\n2 = Paper\n3 = Scissors\nPlease choose 1, 2, or 3: ");
     playerChoiceNum = scan.nextInt(); scan.nextLine();
     playerChoice = choices[playerChoiceNum - 1];
     System.out.println();
     
   }
 }

    
    
    System.out.printf("%s, you chose %s.%n", name, playerChoice);
    System.out.printf("The computer chose %s.%n", computerChoice);
   
    
    
    // If the player and computer made the same choice, then...
    //    Announce that it's a tie.
    // Otherwise, based upon the player's and computer's 
    //    respective choices, announce what beats what and 
    //    and tell the player whether he wins or loses.

    // YOUR CODE GOES HERE
    
 if (computerChoiceNum == playerChoiceNum);
  playerMessage = "it's a tie.";

   
       
     
   System.out.println(playerMessage);

  }
}
 
