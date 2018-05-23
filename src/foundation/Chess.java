package foundation;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class Chess extends Application {
	public enum Turn {
		WHITE, BLACK, CHOOSEPAWN
	}
	
	private static Group root = new Group ();
	private Scene scene;
	
	public Turn turn = Turn.WHITE;
	public static int[][] board = Board.SETUP;
	public static Rectangle[][] boardGraphics = Board.EMPTYGRAPHICS;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Chess");
		scene = new Scene(root, 600, 600, Color.BLACK);
		
		resetBoard ();
		drawPieces ();
		
		scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent event) {
		    		int xLoc = getChessPosition (event)[0];
		    		int yLoc = getChessPosition (event)[1];
		    		
		    		if (turn == Turn.CHOOSEPAWN) { return; }
		    		
			    	if (boardGraphics[yLoc][xLoc].getFill() == Color.RED) {
			    		resetBoard();
			    		drawPieces();
			    		
			    		return;
			    	} else if (boardGraphics[yLoc][xLoc].getFill() == Color.ORANGE) {
			    		
			    		
			    		if (turn == Turn.WHITE)
				    		turn = Turn.BLACK;
				    	else
				    		turn = Turn.WHITE;
			    		

			    		
			    		
			    		if (getSelected() == null) { System.out.println("Bye"); return; }
			    		System.out.println(board[getSelected()[0]][getSelected()[1]]);
			    		if (board[getSelected()[0]][getSelected()[1]] == 11 && getSelected()[1] == 1) {
						 Rectangle rect = new Rectangle (225, 150, 300, 150);
						 rect.setFill(Color.CHARTREUSE);
						 
						 root.getChildren().add(rect);
					 } else if (board[getSelected()[0]][getSelected()[1]] == 1 && yLoc == 6) {
						 Rectangle rect = new Rectangle (225, 150, 300, 150);
						 rect.setFill(Color.CHARTREUSE);
						 
						 root.getChildren().add(rect);
					 }
			    		
			    		movePiece(xLoc, yLoc);
			    		resetBoard();
			    		drawPieces();
			    		
			    		return;
			    	} else {
			    		resetBoard();
			    		drawPieces();
			    	}
			    	
			    	if (board[yLoc][xLoc] < 10 && turn == Turn.BLACK) {
			    		return;
			    	} else if (board[yLoc][xLoc] > 10 && board[yLoc][xLoc] != 0 && turn == Turn.WHITE) {
			    		return;
			    	}
			    	
			    	switch (board[yLoc][xLoc]) {
			    		case 0: break;
			    		
			    		case 1: case 11: Piece.pawnMovement(yLoc, xLoc, board[yLoc][xLoc] < 10); break;
			    		case 2: case 12: Piece.rookMovement(yLoc, xLoc, board[yLoc][xLoc] < 10); break;
			    		case 3: case 13: Piece.knightMovement(yLoc, xLoc, board[yLoc][xLoc] < 10); break;
			    		case 4: case 14: Piece.bishopMovement(yLoc, xLoc, board[yLoc][xLoc] < 10); break;
			    		case 5: case 15: Piece.queenMovement(yLoc, xLoc, board[yLoc][xLoc] < 10); break;
			    		case 6: case 16: Piece.kingMovement(yLoc, xLoc, board[yLoc][xLoc] < 10); break;
			    	}
		    }
		});

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void drawPieces () {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				String piece = null;
				
				switch (board[i][j]) {
					case 0: continue;
					
					case 1: case 11: piece = "Pawn"; break;
					case 2: case 12: piece = "Rook"; break;
					case 3: case 13: piece = "Knight"; break;
					case 4: case 14: piece = "Bishop"; break;
					case 5: case 15: piece = "Queen"; break;
					case 6: case 16: piece = "King"; break;
					
					default:
						System.err.println ("Huh?! You are an extra terrestrial piece, Mr. (" + i + ", " + j + ")");
						continue;
				}
				
				ImageView im = createImage (String.format("/assets/%s.png", piece), j * 75, i * 75, 75, 75);
				
				Lighting l = new Lighting ();
		        l.setLight(new Light.Distant(45, 45, board[i][j] < 10 ? Color.WHITE : Color.BLACK));
		        im.setEffect(l);
				
				root.getChildren().add (im);
			}
		}
	}
		
	private void resetBoard () {
		boolean drawWhite = false;
		for (int i = 0; i < 8; i++) {
			
			for (int j = 0; j < 8; j++) {
				boardGraphics[j][i] = new Rectangle (75 * i, 75 * j, 75, 75);
				boardGraphics[j][i].setFill (drawWhite ? Color.rgb(107,142,35) : Color.BEIGE);
				
				boardGraphics[j][i].setStroke(Color.BLACK);
				boardGraphics[j][i].setStrokeType(StrokeType.INSIDE);
				
				root.getChildren().add(boardGraphics[j][i]);
				
				drawWhite = !drawWhite;
			}
			drawWhite = !drawWhite;
		}
	}
	
	private void redrawBoard () {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				boardGraphics[i][j].setY(i * 75);
				boardGraphics[i][j].setX(j * 75);
			}
		}
	}
	
	private ImageView createImage (String filePath, double x, double y, double width, double height) {
		ImageView imv = new ImageView (new Image (filePath));
		imv.setX(x); imv.setY(y);
		imv.setFitWidth(width); imv.setFitHeight(height);
		
		return imv;
	}
	
	private static void movePiece(int xLoc, int yLoc) {
		for (int i = 0; i < boardGraphics.length; i++) {
			for (int j = 0; j < boardGraphics[i].length; j++) {
				if (boardGraphics[i][j].getFill() == Color.RED) {
					 board[yLoc][xLoc] = board[i][j];
					 board[i][j] = 0;
				}
			}
		}
	}
	
	private static int[] getSelected() {
		for (int i = 0; i < boardGraphics.length; i++) {
			for (int j = 0; j < boardGraphics[i].length; j++) {
				if (boardGraphics[i][j].getFill() == Color.RED) {
					 int[] s = new int[] {i, j};
					 return s;
				}
			}
		}
		
		return null;
	}
	
	private static int[] getChessPosition (MouseEvent event) {
		int xLoc = 0;
    		int yLoc = 0;
    	
    		int incr = 1;
    		while (incr <= 8) {
    			if (event.getX() <= incr * 75) {
    				xLoc = incr;
    				break;
    			}
    		
    			incr++;
    		}
    	
    		incr = 1;
    		while (incr <= 8) {
    			if (event.getY() <= incr * 75) {
    				yLoc = incr;
    				break;
    			}
    		
    			incr++;
    		}
    
    		xLoc--;
    		yLoc--;
    		
    		return new int[] {xLoc, yLoc};
	}

	@SuppressWarnings("unchecked")
	private static void flipBoard () {
		
		int[][] temp = new int[8][8];
		
		for (int i = board.length - 1; i > -1; i--) {
			temp[board.length - 1 - i] = board[i];
		}
		
		board = temp.clone();
		
		for (int i = 0; i < board.length; i++) {
			
			board[i] = flipIntArray (board[i]);
		}
	}
	
	private static int[] flipIntArray (int[] arr) {
		int[] returnArr = new int[arr.length];
		
		for (int i = arr.length; i <= 0; i--) {
			returnArr[arr.length - 1 - i] = arr[i];
		}
		
		return returnArr;
	}
}