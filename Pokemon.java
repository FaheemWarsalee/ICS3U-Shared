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
      menuPick = In.getString().trim();
      
      parsingInt(menuPick); 
    } while (isInputValid(parsingInt(menuPick)));
    
    menuChoice = parsingInt(menuPick);
    
    if (menuChoice == 1) //PLAYER PICK PLAY
    {
      System.out.println("Play!");
      System.out.println("[1] Multiplayer \n[2] CPU");
      
      System.out.println("Choose an option: ");
      do
      {
        playPick = In.getString().trim();
        
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
    if (numCheck < 1 || numCheck > 3)
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
    if (numCheck < 1 || numCheck > 2)
    {
      System.out.println("Invalid Input. Choose 1 or 2. ");
      return true;//Is out of bounds
    }
    else
    {
      return false;//Is inside Bounds
    }
    
  }
  
  //METHOD 3: ARE INPUTS ACCEPTALBE? OL for cards
  public static boolean isInputValidC (int numCheck)
  {
    if (numCheck < 1 || numCheck > 6)
    {
      System.out.println("Invalid Input. Choose a number between 1-6. ");
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
    System.out.println("");
    
    mainMenu();
  }
  
//METHOD 5: CARDS
  public static void cards() 
  {
    String[] p1Deck = new String[6];//Creating 2 decks, 1 per player
    String[] p2Deck = new String[6];
    
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
    
   decks(pkmns, p1Deck, p2Deck);//Fills empty deck arrays with cards
   
   activPkmn(p1Deck, p2Deck);//choose an active pokemon out of decks
  }
  
  //METHOD 6: DECK DISTRIBUTION
  public static void decks(ArrayList<String> pkmns, String[] deck1, String[] deck2)
  {
    int rand;
    
    for (int i = 0; i < deck1.length; i++)
    {
      rand = (int) (15*Math.random());//Random number between 0-15
      deck1[i] = pkmns.get(rand);//rand is an index of the array list pkmns
    }
    
    
    for (int i = 0; i < deck2.length; i++)
    {
      rand = (int) (15*Math.random());
      deck2[i] = pkmns.get(rand);
    }
    
  }
  
  //METHOD 7: ACTIVE POKEMON
  public static void activPkmn (String[] deck1, String[] deck2)
  {
    String p1ActivPck, p2ActivPck;
    String p1Activ, p2Activ;
    
    System.out.println("\nPlayer 1. Choose your Active pokemon:");
    System.out.println("\nACTIVE POKEMON: ");
    
    for (int i = 0; i< deck1.length ; i++)
    {
      System.out.print("[" + (i+1) + "] "+ deck1[i].substring(0,deck1[i].indexOf(" ")));
      System.out.print(" ");
    }
    
    do
    {
      p1ActivPck = In.getString().trim();
      
      parsingInt(p1ActivPck);
    }while (isInputValidC(parsingInt(p1ActivPck)));//Not isinvputvalid C
    
    
    p1Activ = deck1[parsingInt(p1ActivPck)-1];//Sets p1Activ to chosen number-1 at the index of the 
    
    
    System.out.println("\nPlayer 2. Choose your Active pokemon:");
    System.out.println("\nACTIVE POKEMON: ");
    
    for (int i = 0; i< deck2.length ; i++)
    {
      System.out.print("[" + (i+1) + "] "+ deck2[i].substring(0,deck2[i].indexOf(" ")));
      System.out.print(" ");
    }
    
    do
    {
      p2ActivPck = In.getString().trim();
      
      parsingInt(p2ActivPck);
    }while (isInputValidC(parsingInt(p2ActivPck)));//Not isinvputvalid C
    
    p2Activ = deck2[parsingInt(p2ActivPck)-1];
    
    fight(p1Activ, p2Activ);
  }
  
  //METHOD 8: FIGHTING SYSTEM
  public static void fight(String p1Activ, String p2Activ)
  { 
    int turn = 0;
    
    String[] pkmnName = new String[2];//Holds pokemon names
    String[] pkmnAtckS = new String[4];//String version of attacks
    int[] pkmnAtck = new int[4];
    int[] pkmnHealth = new int[2];
    
    
    pkmnName[0]= p1Activ.substring(0,p1Activ.indexOf(" "));
    pkmnName[1]= p2Activ.substring(0,p2Activ.indexOf(" "));

    //Player 1 attacks as Strings
    pkmnAtckS[0] = p1Activ.substring(p1Activ.indexOf(" ")+1);
    pkmnAtckS[1] = pkmnAtckS[0].substring(pkmnAtckS[0].indexOf(" ")+1);   
    pkmnAtckS[0] = pkmnAtckS[0].substring(0,pkmnAtckS[0].indexOf(" "));
    
    //Player 2 attacks as Strings
    pkmnAtckS[2] = p2Activ.substring(p2Activ.indexOf(" ")+1);
    pkmnAtckS[3] = pkmnAtckS[2].substring(pkmnAtckS[2].indexOf(" ")+1);   
    pkmnAtckS[2] = pkmnAtckS[2].substring(0,pkmnAtckS[2].indexOf(" "));
    
    //Sets all player attacks to integers
    for(int i = 0; i < pkmnAtck.length; i++)
    {
      pkmnAtck[i] = parsingInt(pkmnAtckS[i]);
    }
    
    do
    {
      if (turn % 2 == 0)
      {
        //P1 turn
      }
      else
      {
        //p2 turn
      }
      
      turn++;
    }
    while(isNotWinner);
   
    
    
  }
  
}



//End of Program