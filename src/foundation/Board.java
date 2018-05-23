package foundation;

import javafx.scene.shape.Rectangle;

public class Board {

	public static final int[][] SETUP = new int[][] { 
		{ 12, 13, 14, 15, 16, 14, 13, 12 }, 
		{ 11, 11, 11, 11, 11, 11, 11, 11 },
		{ 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
		{ 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
		{ 1, 1, 1, 1, 1, 1, 1, 1 }, 
		{ 2, 3, 4, 5, 6, 4, 3, 2 },
	};
	
	public static final Rectangle[][] EMPTYGRAPHICS = new Rectangle[8][8];
}
