package foundation;

import javafx.scene.paint.Color;

public abstract class Piece {
	public static void rookMovement(int y, int x, boolean isWhite) {

		Chess.boardGraphics[y][x].setFill(Color.RED);

		for (int j = y - 1; j >= 0; j--) {
			if (isWhite ? Chess.board[j][x] > 10 : Chess.board[j][x] < 10 && Chess.board[j][x] != 0) {
				Chess.boardGraphics[j][x].setFill(Color.ORANGE);
				break;
			} else if (Chess.board[j][x] == 0) {
				Chess.boardGraphics[j][x].setFill(Color.ORANGE);
			} else {
				break;
			}
		}

		for (int j = x + 1; j < 8; j++) {
			if (isWhite ? Chess.board[y][j] > 10 : Chess.board[y][j] < 10 && Chess.board[y][j] != 0) {
				Chess.boardGraphics[y][j].setFill(Color.ORANGE);
				break;
			} else if (Chess.board[y][j] == 0) {
				Chess.boardGraphics[y][j].setFill(Color.ORANGE);
			} else {
				break;
			}
		}

		for (int j = x - 1; j >= 0; j--) {
			if (isWhite ? Chess.board[y][j] > 10 : Chess.board[y][j] < 10 && Chess.board[y][j] != 0) {
				Chess.boardGraphics[y][j].setFill(Color.ORANGE);
				break;
			} else if (Chess.board[y][j] == 0) {
				Chess.boardGraphics[y][j].setFill(Color.ORANGE);
			} else {
				break;
			}
		}

		for (int j = y + 1; j < 8; j++) {
			if (isWhite ? Chess.board[j][x] > 10 : Chess.board[j][x] < 10 && Chess.board[j][x] != 0) {
				Chess.boardGraphics[j][x].setFill(Color.ORANGE);
				break;
			} else if (Chess.board[j][x] == 0) {
				Chess.boardGraphics[j][x].setFill(Color.ORANGE);
			} else {
				break;
			}
		}
	}

	public static void bishopMovement(int y, int x, boolean isWhite) {

		Chess.boardGraphics[y][x].setFill(Color.RED);

		int selNum = -1;

		int yEqu = y + selNum;
		int xEqu = x + selNum;

		ex: while (yEqu >= 0 && xEqu >= 0) {
			if (isWhite ? Chess.board[yEqu][xEqu] > 10 : Chess.board[yEqu][xEqu] < 10 && Chess.board[yEqu][xEqu] != 0) {
				Chess.boardGraphics[yEqu][xEqu].setFill(Color.ORANGE);
				break ex;
			} else if (Chess.board[yEqu][xEqu] == 0) {
				Chess.boardGraphics[yEqu][xEqu].setFill(Color.ORANGE);
			} else {
				break ex;
			}

			selNum -= 1;
			yEqu = y + selNum;
			xEqu = x + selNum;
		}

		selNum = -1;

		yEqu = y - selNum;
		xEqu = x - selNum;

		ex: while (yEqu <= 7 && xEqu <= 7) {
			if (isWhite ? Chess.board[yEqu][xEqu] > 10 : Chess.board[yEqu][xEqu] < 10 && Chess.board[yEqu][xEqu] != 0) {
				Chess.boardGraphics[yEqu][xEqu].setFill(Color.ORANGE);
				break ex;
			} else if (Chess.board[yEqu][xEqu] == 0) {
				Chess.boardGraphics[yEqu][xEqu].setFill(Color.ORANGE);
			} else {
				break ex;
			}

			selNum -= 1;
			yEqu = y - selNum;
			xEqu = x - selNum;
		}

		selNum = -1;

		yEqu = y + selNum;
		xEqu = x - selNum;

		ex: while (yEqu >= 0 && yEqu < 8 && xEqu < 8) {
			if (isWhite ? Chess.board[yEqu][xEqu] > 10 : Chess.board[yEqu][xEqu] < 10 && Chess.board[yEqu][xEqu] != 0) {
				Chess.boardGraphics[yEqu][xEqu].setFill(Color.ORANGE);
				break ex;
			} else if (Chess.board[yEqu][xEqu] == 0) {
				Chess.boardGraphics[yEqu][xEqu].setFill(Color.ORANGE);
			} else {
				break ex;
			}

			selNum -= 1;
			yEqu = y + selNum;
			xEqu = x - selNum;
		}

		selNum = -1;

		yEqu = y - selNum;
		xEqu = x + selNum;

		ex: while (yEqu <= 7 && xEqu >= 0) {
			if (isWhite ? Chess.board[yEqu][xEqu] > 10 : Chess.board[yEqu][xEqu] < 10 && Chess.board[yEqu][xEqu] != 0) {
				Chess.boardGraphics[yEqu][xEqu].setFill(Color.ORANGE);
				break ex;
			} else if (Chess.board[yEqu][xEqu] == 0) {
				Chess.boardGraphics[yEqu][xEqu].setFill(Color.ORANGE);
			} else {
				break ex;
			}

			selNum -= 1;
			yEqu = y - selNum;
			xEqu = x + selNum;
		}
	}

	public static void pawnMovement(int y, int x, boolean isWhite) {
		Chess.boardGraphics[y][x].setFill(Color.RED);
		
		if (isWhite) {
			if (y - 1 < 0) {
				return;
			}
			
			if (Chess.board[y - 1][x] == 0) {
				Chess.boardGraphics[y - 1][x].setFill(Color.ORANGE);
				
				if (y - 2 >= 0)
					if (Chess.board[y - 2][x] == 0 && y == 6) {
						Chess.boardGraphics[y - 2][x].setFill(Color.ORANGE);
					}
			}
			
			if (x + 1 < 8) {
				if (Chess.board[y - 1][x + 1] > 10) {
					Chess.boardGraphics[y - 1][x + 1].setFill(Color.ORANGE);
				}
			}
			
			if (x - 1 >= 0) {
				if (Chess.board[y - 1][x - 1] > 10) {
					Chess.boardGraphics[y - 1][x - 1].setFill(Color.ORANGE);
				}
			}
			
		} else {
			if (y + 1 > 7) {
				return;
			}
			
			if (Chess.board[y + 1][x] == 0) {
				Chess.boardGraphics[y + 1][x].setFill(Color.ORANGE);
				
				if (Chess.board[y + 2][x] == 0 && y == 1) {
					Chess.boardGraphics[y + 2][x].setFill(Color.ORANGE);
				}
			}
			if (x + 1 < 8) {
				if (Chess.board[y + 1][x + 1] < 10 && Chess.board[y + 1][x + 1] != 0) {
					Chess.boardGraphics[y + 1][x + 1].setFill(Color.ORANGE);
				}
			}
			
			if (x - 1 >= 0) {
				if (Chess.board[y + 1][x - 1] < 10 && Chess.board[y + 1][x - 1] != 0) {
					Chess.boardGraphics[y + 1][x - 1].setFill(Color.ORANGE);
				}
			}
		}
		
	}

	public static void queenMovement(int y, int x, boolean isWhite) {
		bishopMovement (y, x, isWhite);
		rookMovement (y, x, isWhite);

	}

	public static void knightMovement(int y, int x, boolean isWhite) {
		Chess.boardGraphics[y][x].setFill(Color.RED);
		
		if (x - 1 >= 0 && y - 2 >= 0) {
			if (isWhite ? Chess.board[y - 2][x - 1] > 10 || Chess.board[y - 2][x - 1] == 0 : Chess.board[y - 2][x - 1] < 10) {
				Chess.boardGraphics[y - 2][x - 1].setFill(Color.ORANGE);
			}
		}
		
		if (x - 2 >= 0 && y - 1 >= 0) {
			if (isWhite ? Chess.board[y - 1][x - 2] > 10 || Chess.board[y - 1][x - 2] == 0 : Chess.board[y - 1][x - 2] < 10) {
				Chess.boardGraphics[y - 1][x - 2].setFill(Color.ORANGE);
			}
		}
		
		if (x + 2 < 8 && y - 1 >= 0) {
			if (isWhite ? Chess.board[y - 1][x + 2] > 10 || Chess.board[y - 1][x + 2] == 0 : Chess.board[y - 1][x + 2] < 10) {
				Chess.boardGraphics[y - 1][x + 2].setFill(Color.ORANGE);
			}
		}

		if (x + 1 < 8 && y - 2 >= 0) {
			if (isWhite ? Chess.board[y - 2][x + 1] > 10 || Chess.board[y - 2][x + 1] == 0 : Chess.board[y - 2][x + 1] < 10) {
				Chess.boardGraphics[y - 2][x + 1].setFill(Color.ORANGE);
			}
		}		
		
		if (x + 1 < 8 && y + 2 < 8) {
			if (isWhite ? Chess.board[y + 2][x + 1] > 10 || Chess.board[y + 2][x + 1] == 0 : Chess.board[y + 2][x + 1] < 10) {
				Chess.boardGraphics[y + 2][x + 1].setFill(Color.ORANGE);
			}
		}
		
		if (x + 2 < 8 && y + 1 < 8) {
			if (isWhite ? Chess.board[y + 1][x + 2] > 10 || Chess.board[y + 1][x + 2] == 0 : Chess.board[y + 1][x + 2] < 10) {
				Chess.boardGraphics[y + 1][x + 2].setFill(Color.ORANGE);
			}
		}
		
		if (x - 2 >= 0 && y + 1 < 8) {
			if (isWhite ? Chess.board[y + 1][x - 2] > 10 || Chess.board[y + 1][x - 2] == 0 : Chess.board[y + 1][x - 2] < 10) {
				Chess.boardGraphics[y + 1][x - 2].setFill(Color.ORANGE);
			}
		}

		if (x - 1 >= 0 && y + 2 < 8) {
			if (isWhite ? Chess.board[y + 2][x - 1] > 10 || Chess.board[y + 2][x - 1] == 0 : Chess.board[y + 2][x - 1] < 10) {
				Chess.boardGraphics[y + 2][x - 1].setFill(Color.ORANGE);
			}
		}
	}

	public static void kingMovement(int y, int x, boolean isWhite) {
		Chess.boardGraphics[y][x].setFill(Color.RED);
		
		int xPos = x + 1;
		int yPos = y - 1;
		if (xPos < 8 && yPos >= 0) {
			if (isWhite ? Chess.board[yPos][xPos] > 10 ||  Chess.board[yPos][xPos] == 0 : Chess.board[yPos][xPos] < 10) {
				Chess.boardGraphics[yPos][xPos].setFill(Color.ORANGE);
			}
		}
		
		xPos = x - 1;
		yPos = y - 1;
		if (xPos >= 0 && yPos >= 0) {
			if (isWhite ? Chess.board[yPos][xPos] > 10 ||  Chess.board[yPos][xPos] == 0 : Chess.board[yPos][xPos] < 10) {
				Chess.boardGraphics[yPos][xPos].setFill(Color.ORANGE);
			}
		}
		
		xPos = x - 1;
		yPos = y + 1;
		if (xPos >= 0 && yPos < 8) {
			if (isWhite ? Chess.board[yPos][xPos] > 10 ||  Chess.board[yPos][xPos] == 0 : Chess.board[yPos][xPos] < 10) {
				Chess.boardGraphics[yPos][xPos].setFill(Color.ORANGE);
			}
		}
		
		xPos = x + 1;
		yPos = y + 1;
		if (xPos < 8 && yPos < 8) {
			if (isWhite ? Chess.board[yPos][xPos] > 10 ||  Chess.board[yPos][xPos] == 0 : Chess.board[yPos][xPos] < 10) {
				Chess.boardGraphics[yPos][xPos].setFill(Color.ORANGE);
			}
		}
		
		xPos = x;
		yPos = y + 1;
		if (yPos < 8) {
			if (isWhite ? Chess.board[yPos][xPos] > 10 ||  Chess.board[yPos][xPos] == 0 : Chess.board[yPos][xPos] < 10) {
				Chess.boardGraphics[yPos][xPos].setFill(Color.ORANGE);
			}
		}
		
		xPos = x;
		yPos = y - 1;
		if (yPos >= 0) {
			if (isWhite ? Chess.board[yPos][xPos] > 10 ||  Chess.board[yPos][xPos] == 0 : Chess.board[yPos][xPos] < 10) {
				Chess.boardGraphics[yPos][xPos].setFill(Color.ORANGE);
			}
		}
		
		xPos = x + 1;
		yPos = y;
		if (xPos < 8) {
			if (isWhite ? Chess.board[yPos][xPos] > 10 ||  Chess.board[yPos][xPos] == 0 : Chess.board[yPos][xPos] < 10) {
				Chess.boardGraphics[yPos][xPos].setFill(Color.ORANGE);
			}
		}
		
		xPos = x - 1;
		yPos = y;
		if (xPos >= 0) {
			if (isWhite ? Chess.board[yPos][xPos] > 10 ||  Chess.board[yPos][xPos] == 0 : Chess.board[yPos][xPos] < 10) {
				Chess.boardGraphics[yPos][xPos].setFill(Color.ORANGE);
			}
		}
	}
}
