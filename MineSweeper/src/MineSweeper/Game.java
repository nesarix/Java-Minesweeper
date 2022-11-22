package MineSweeper;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
			
		boolean alive = true;
		ArrayList<Bomb> bombLocation= new ArrayList<Bomb>();
		Bomb load = new Bomb();
		Scanner scanner = new Scanner(System.in);
		Board seen = new Board(10,10);
		int count = 0;
		
		load.randomXY(bombLocation);
		bombLocation.get(0).X=0;
		bombLocation.get(0).Y=0;
		
		for (int i = 0; i < bombLocation.size(); i++) {
			System.out.println(bombLocation.get(i).X+" , "+bombLocation.get(i).Y);			
		}
			seen.genHiddenBoard(bombLocation);
			seen.printFirstBoard();
			System.out.println("========= Try not to blow up!! (ﾉ*･ω･)ﾉ  ●⁀⁕ =========");
			System.out.println("Lets Go!");
			System.out.println("Please enter two numbers between 0 and 9 inclusive seperated by a ','" );
			System.out.println("such as 4,2");
			
			
			while(alive == true) {
				
				String[] currentXY = scanner.nextLine().replaceAll(" ", "").split(",");
				if(currentXY.length!=2) {
	                System.out.println("Please put two numbers seperated by a ',' .... like this 4,2 ");
	            }else if(!isNumeric(currentXY[0]) || !isNumeric(currentXY[1])) {
	                System.out.println("Please use Numbers!!");
	            }          
	            else if(Integer.parseInt(currentXY[0]) < 0||Integer.parseInt(currentXY[0])>9 || Integer.parseInt(currentXY[1])< 0 || Integer.parseInt(currentXY[1]) > 9) {
	            System.out.println("Please keep the numbers between 0 and 9 inclusive!!");
	            } else {
	            	System.out.println("lets see... you entered " + currentXY[0]+","+ currentXY[1]);
	            	int X = Integer.parseInt(currentXY[0]);
	            	int Y = Integer.parseInt(currentXY[1]);
	            	if(seen.hiddenBoard[X][Y]>10) {
	            		seen.seenBoard[X][Y]= "●⁀⁕";
		            	seen.printBoard();
	            		System.out.println("BOOM!! YOU HIT A MINE");
	            		System.out.println("--GAME--OVER--");
	            		alive = false;
	            	}
	            	else if(count >=90) {
	            		System.out.println("YOU FOUND ALL THE BOMBS! YOU WON!!");
	            		alive = false;
	            	}else {
	            		count++;
	            		System.out.println("count = "+count);
	            		
	            		String hiddenLocation = Integer.toString(seen.hiddenBoard[X][Y]);
	            		seen.seenBoard[X][Y] = "[ "+hiddenLocation+"]";
	            		seen.printBoard();	            		
	            	}
	            	
	            }
				
			}
		
	}
	
	
	
	
	public static boolean isNumeric(String strNum) {
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

}
