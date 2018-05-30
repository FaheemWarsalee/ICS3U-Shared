/*
 Program:ICS3U Summative; Pokemon
 Programmer: Faheem Warsalee
 Course: ICS3U
 Date: May 17th 2018
 
 Brief Description: This program is a simulation of the Pokemon Trading Card Game, done in Java and text based.*/

//Imports
import java.util.ArrayList;
import java.util.Collections;

class Pokemon
{
  // MAIN METHOD
  public static void main(String[] args)
  {
    mainMenu();
  }
  
  //METHOD 1: MAIN MENU
  public static void mainMenu()
  {
    //Varaibles & Arrays
    String menuPick, playPick;
    int menuChoice, playChoice;
    
    System.out.println("-_-_-_-_-_-P O K E M O N  C A R D  G A M E-_-_-_-_-_- \n\ncreated by: Faheem Warsalee");
    System.out.println("\n[1] Play \n[2] Rules \n[3] Exit");
    System.out.print("Choose an option: ");
    
    do
    {
      menuPick = In.getString();
      
      parsingInt(menuPick); 
    } while (isInputValid(parsingInt(menuPick)));
    
    menuChoice = parsingInt(menuPick);
    
    if (menuChoice == 1) //PLAYER PICK PLAY
    {
      System.out.println("Play!");
      System.out.println("[1] Multiplayer \n[2]CPU");
      
      System.out.println("Choose an option: ");
      do
      {
        playPick = In.getString();
        
        parsingInt(playPick);
      }while(isInputValidB(parsingInt(playPick)));
      
      cards();
    }
    else if (menuChoice == 2)//PLAYER PICK RULES
    {
      System.out.println("Rules : ");
      rulesDisp();
    }
    else //PLAYER PICK EXIT GAME
    {
      System.out.println("Thanks for Playing!!" );
    }
  }
  
//METHOD 2: PARSING INTEGERS
  public static int parsingInt(String toNum)
  {
    int newNum;
    
    try
    {
      newNum = Integer.parseInt(toNum);
      return newNum;
    }
    catch (NumberFormatException e)
    {
      newNum = 0;
      return newNum;//Return new num as 0, it will automatically be false in the isInputValid() method.
    }
  }
  
//METHOD 3: ARE INPUTS ACCEPTABLE?
  public static boolean isInputValid (int numCheck)
  {
    if (numCheck < 0 || numCheck > 3)
    {
      System.out.println("Invalid Input. Choose 1, 2 or 3. ");
      return true;//Is out of bounds
    }
    else
    {
      return false;//Is inside Bounds
    }
    
  }
  
//METHOD 3: ARE INPUTS ACCEPTALBE? OL
  public static boolean isInputValidB (int numCheck)
  {
    if (numCheck < 0 || numCheck > 2)
    {
      System.out.println("Invalid Input. Choose 1, 2 or 3. ");
      return true;//Is out of bounds
    }
    else
    {
      return false;//Is inside Bounds
    }
    
  }
  
//METHOD 4: DISPLAY RULES
  public static void rulesDisp()
  {
    System.out.println("1. All players will get a deck of 10 cards. Each card is a Pokemon.");
    System.out.println("2. Each player will select 6 cards to play on the field.");
    System.out.println("3. Out of the 6 cards each player chooses one active Pokemon.");
    System.out.println("4. A coin is flipped to see who goes first.");
    System.out.println("5. Players will take turns attacking until a player has eliminated all of their opponnents Pokemon.");
  }
  
//METHOD 5: CARDS
  public static void cards() 
  {
    ArrayList<String> pkmns = new ArrayList<String>();
    
    pkmns.add("Pikachu 25 34");//1
    pkmns.add("Charizard 50 37");//2
    pkmns.add("Bulbasaur 15 28");//3
    pkmns.add("Wartortle 30 35");//4
    pkmns.add("Gyrados 65 72");//5
    pkmns.add("Gengar 51 61");//6
    pkmns.add("Medicham 32 45");//7
    pkmns.add("Lapras 48 63");//8
    pkmns.add("Suicune 69 82");//9
    pkmns.add("Entei 70 78");//10
    pkmns.add("Raikou 67 85");//11
    pkmns.add("Mewtwo 0 120");//12
    pkmns.add("Nidoqueen 55 64");//13
    pkmns.add("Rhydon 54 68");//14
    pkmns.add("Dragonite 78 88");//15
    
    for (int i = 0; i <= 5; i++)
    {
      Collections.sort(pkmns); //Shuffles pkmn cards
    }
    System.out.println("\n"+pkmns);
    
  }
  
  public static int decks (ArrayList<Integer> pkmns)
  {
    int rand;
    int[] p1Deck = new int[6];
    int[] p2Deck = new int[6];
    
    for (int i = 0; i < p1Deck.length; i++)
    {
      rand = (int) (15*Math.random())+1;
      p1Deck[i] = pkmns.get(rand);
    }
    return p1Deck;
  }
}



//End of Program