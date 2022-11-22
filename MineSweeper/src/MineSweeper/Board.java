package MineSweeper;

import java.util.ArrayList;

public class Board {
	
	int hight;
	int width;
	String[][] seenBoard;
	int[][] hiddenBoard;
	
	public Board(int hight, int width) {
		this.hight = hight;
		this.width = width;
		hiddenBoard = new int[hight][width];
		seenBoard = new String[hight][width];
	}
	
	public void printFirstBoard() {
		System.out.println("  0   1   2   3   4   5   6   7   8   9");
		for (int i = 0; i < this.hight; i++) {
			System.out.print(i);
			for (int j = 0; j < this.width; j++) {
				seenBoard[i][j] = "[  ]";
				System.out.print(this.seenBoard[i][j]);
				}		
			System.out.print(i);
			System.out.println();
		}
		System.out.println("  0   1   2   3   4   5   6   7   8   9");
	}
	
	public void printBoard() {
		System.out.println("  0   1   2   3   4   5   6   7   8   9");
		for (int i = 0; i < this.hight; i++) {
			System.out.print(i);
			for (int j = 0; j < this.width; j++) {
				System.out.print(this.seenBoard[i][j]);
				}		
			System.out.print(i);
			System.out.println();
		}
		System.out.println("  0   1   2   3   4   5   6   7   8   9");
	}
	
	public void genHiddenBoard(ArrayList<Bomb> bombList) {
		int count = 1;
		for (int i = 0; i < bombList.size(); i++) {
			int X = bombList.get(i).X;
			int Y = bombList.get(i).Y;
			this.hiddenBoard[X][Y] = 11;			
				if(X!=9 && X!=0 && Y!=9 &&Y!=0) 
				{
					this.hiddenBoard[X+1][Y]+= count;//B					
					this.hiddenBoard[X-1][Y]+= count;//T
					this.hiddenBoard[X][Y+1]+= count;//R
					this.hiddenBoard[X][Y-1]+= count;//L
					this.hiddenBoard[X+1][Y+1]+= count;//BR
					this.hiddenBoard[X+1][Y-1]+= count;//BL
					this.hiddenBoard[X-1][Y+1]+=count;//TR
					this.hiddenBoard[X-1][Y-1]+= count;//TL
				}
					else if(X==0&&Y==0) 
						{
							this.hiddenBoard[X+1][Y]+= count;//B					
							this.hiddenBoard[X][Y+1]+= count;//R
							this.hiddenBoard[X+1][Y+1]+= count;//BR	
						}
					else if(X==9&&Y==9) 
					{
						this.hiddenBoard[X][Y-1]+= count;//L
						this.hiddenBoard[X-1][Y]+= count;//T
						this.hiddenBoard[X-1][Y-1]+= count;//TL						
					}
					else if(X==0 && Y==9) 
					{
						this.hiddenBoard[X+1][Y]+= count;//B					
						this.hiddenBoard[X][Y-1]+= count;//L
						this.hiddenBoard[X+1][Y-1]+= count;//BL						
					}
					else if(X==9&&Y==0) 
					{
						this.hiddenBoard[X-1][Y]+= count;//T
						this.hiddenBoard[X][Y+1]+= count;//R
						this.hiddenBoard[X-1][Y+1]+=count;//TR						
					}
					else if(X==0 && Y!=0 &&Y!=9) 
					{
						this.hiddenBoard[X+1][Y]+= count;//B					
						this.hiddenBoard[X][Y+1]+= count;//R
						this.hiddenBoard[X+1][Y+1]+= count;//BR					
						this.hiddenBoard[X][Y-1]+= count;//L
						this.hiddenBoard[X+1][Y-1]+= count;//BL							
					}
					else if (X==9 && Y!=0&&Y!=9)
					{
						this.hiddenBoard[X-1][Y]+= count;//T
						this.hiddenBoard[X-1][Y-1]+= count;//TL						
						this.hiddenBoard[X-1][Y+1]+=count;//TR						
						this.hiddenBoard[X][Y+1]+= count;//R
						this.hiddenBoard[X][Y-1]+= count;//L						
					}
					else if(X!=9 && X!=0 &&Y==0) 
					{
						this.hiddenBoard[X-1][Y]+= count;//T
						this.hiddenBoard[X-1][Y+1]+=count;//TR						
						this.hiddenBoard[X][Y+1]+= count;//R
						this.hiddenBoard[X+1][Y+1]+= count;//BR					
						this.hiddenBoard[X+1][Y]+= count;//B						
					}else {
						this.hiddenBoard[X-1][Y]+= count;//T
						this.hiddenBoard[X-1][Y-1]+= count;//TL						
						this.hiddenBoard[X][Y-1]+= count;//L						
						this.hiddenBoard[X+1][Y-1]+= count;//BL							
						this.hiddenBoard[X+1][Y]+= count;//B								
					}			
				}			
	}
}


