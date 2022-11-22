package MineSweeper;

import java.util.ArrayList;

public class Bomb {
	int X;
	int Y;
	
	public Bomb(int X, int Y) {
		this.X=X;
		this.Y=Y;		
	}
	public Bomb() {		
	}
	
	public void randomXY(ArrayList<Bomb> bombsCoord) {
		for (int i = 0; i < 10; i++) {
			int randomX = (int) (Math.random()*10);
			int randomY = (int) (Math.random()*10);
			Bomb current= new Bomb(this.X = randomX, this.Y = randomY);
			bombsCoord.add(current);
		}
		
	}
	

}
