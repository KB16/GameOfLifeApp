package com.gameoflife;

import java.util.Scanner;

public class GameofLifeApp {
    
    String[][] game;
    int width;
    int height;
    int count;
    
    public static void main(String[] args) { 
    
        new GameofLifeApp();
    
    }

    public GameofLifeApp() {
 
       setState();
       turn(game);
       turn(game);
       
    }
 
 public void setState(){
     
       //get string input from user    
     
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the intial state of your Game of life grid: \n");
        String state = in.nextLine();
        
       //eg: .....newLine.....newLine.***.newLine.....newLine.....
        
       //convert string input to matrix

         String[] rows = state.split("newLine");
         String[][] game = new String[rows.length][];
         
         this.game = game;
         
         width = game.length;
         height = game.length;
         
         System.out.print("\n");
         
                for (int i = 0; i < rows.length; i++) {
             
                    String[] gameCell = rows[i].split("");
                    game[i] = new String[gameCell.length];
         
                         for (int j = 0; j < game[i].length; j++) {
                             
                         game[i][j] = gameCell[j];
                         System.out.print(game[i][j] + " ");
                         
                         }
             
                        System.out.print("\n");
            
                }
                
          System.out.print("\n");
         
         }
          
         
        public void turn(String[][] game) {
            
            //make new temporary game 
            
            String[][] newGame = new String[width][height];
            
            //iterate through initial grid and, for each index, check the count of neighbours
            
                 int count = 0;
                 String deadCell = ".";
                 String liveCell = "*";
             
                for (int x = 0; x < game.length; x++) {
                    
                    for (int y = 0; y < game[x].length; y++) {
    
                        if (((y > 0)) && (game[x][y-1]).equals(liveCell)) {
                        count++;
                        }
                  
                        if (((x > 0)) && (game[x-1][y]).equals(liveCell)) {
                        count++;
                        }
                  
                        if (((y<(game.length)-1)) && (game[x][y+1]).equals(liveCell)) {
                        count++;
                        }
                 
                        if (((x<(game.length)-1)) && (game[x+1][y]).equals(liveCell)) {
                        count++;
                        }
                  
                        if (((y<(game.length)-1)&&(x<(game.length)-1)) && (game[x+1][y+1]).equals(liveCell)) {
                        count++;
                        }
                  
                        if (((x > 0)&&(y<(game.length)-1)) && (game[x-1][y+1]).equals(liveCell)) {
                        count++;
                        }
                   
                        if (((y > 0)&&(x<(game.length)-1)) && (game[x+1][y-1]).equals(liveCell)) {
                        count++;
                        }
                    
                        if (((y > 0)&&(x > 0)) && (game[x-1][y-1]).equals(liveCell)) {
                        count++;
                        } 
                     
             // determine new state of index    

                        if (game[x][y].equals("*")) {
                            if (count < 2) {
                            newGame[x][y] = (".");}} else {
                            newGame[x][y] = ("*");}
                                     
                        if (game[x][y].equals("*")) {
                            if (count > 3) {
                            newGame[x][y] = (".");}} else  {
                            newGame[x][y] = (".");}
                                    
                                    if (game[x][y].equals("*")) {
                                    if (count < 2) {
                                    newGame[x][y] = (".");}} else  {
                                        newGame[x][y] = (".");}
                                    
                                    if (game[x][y].equals("*")) {
                                    if (count == 2) {
                                    newGame[x][y] = ("*");}} else  {
                                        newGame[x][y] = (".");}
                                        
                                    if (game[x][y].equals("*")) {
                                    if (count == 3) {
                                    newGame[x][y] = ("*");}} else  {
                                        newGame[x][y] = (".");}
                                    
                                    if (game[x][y].equals(".")) {
                                    if (count == 3) {
                                    newGame[x][y] = ("*");}} else  {
                                        newGame[x][y] = ("*");}
                                    
                                    if (game[x][y].equals(".")) {
                                    if (count == 0) {
                                    newGame[x][y] = (".");}} 
                                    
                                    if (game[x][y].equals("*")) {
                                    if (count == 1) {
                                    newGame[x][y] = (".");}} 

                       count = 0;
                       
                    }
             }
                
             //print the outcome of the turn
                
                for (int i = 0; i < newGame.length; i++) {
                           
                    for (int j = 0; j < newGame[i].length; j++) {
                                    
                             System.out.print(newGame[i][j] + " ");      
                             
                            } 
                    
                             System.out.print("\n");
                             
                             }  
                    
            //set latest view of the game     
                
                System.out.print("\n");
                game = newGame;
                this.game = game;
                    
                System.out.print("\n");
                
            //ask user whether they would like to see the next iteration of the current game
                    
                Scanner in = new Scanner(System.in);
                System.out.println("Turn again? Y or N: \n");
                String play = in.nextLine();
                    
                    if (play.equals("Y")) {
                    System.out.println("\n");    
                    turn(game);
                    } else {
                        System.out.println("\nOK. Thank you for playing. Goodbye.\n");
                        System.exit(1);
                    }
        }                    
}
                         

               
            
       
        
        
