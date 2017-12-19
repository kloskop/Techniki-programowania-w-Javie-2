
import java.util.Random;
import java.util.Scanner;

class TicTacToe {
	
	private String[][] tabOfGame;
	private int numbersOfWins;
	private boolean computerTurn;
	private int turnCounter;
	private String resultOfMatch;
	private boolean isSharpSymbol;
	
	

	public String[][] getTabOfGame() {
		return tabOfGame;
	}


	public int getNumbersOfWins() {
		return numbersOfWins;
	}


	public boolean isSharpSymbol() {
		return isSharpSymbol;
	}


	public int getTurnCounter() {
		return turnCounter;
	}


	public int getNumbersOfWin() {
		return numbersOfWins;
	}



	public String getResultOfMatch() {
		return resultOfMatch;
	}


	public String getTabOfGame(int x, int y) {
		return tabOfGame[x][y];
	}


	public boolean isComputerTurn() {
		return computerTurn;
	}


	public TicTacToe() {
		isSharpSymbol=true; //zalo¿enie, ¿e zaczynamy od symbolu X
		turnCounter=0;
		resultOfMatch=null;
		numbersOfWins=0;
		tabOfGame=new String[3][3];
		
		for (int i = 0; i < tabOfGame.length; i++) {
			for (int j = 0; j < tabOfGame.length; j++) {
				tabOfGame[i][j]=" ";
			}
		}
		
		Random random = new Random();
		if(random.nextInt(2)==0) {
			computerTurn=false;
		}
		else {
			computerTurn=true;
		}
		
	}

	public void printBoard() {
		String row = "_ _ _";
		String whiteSpace = "     "; 
		String columna = "|";
		String yAxis="Y\n"+"^\n"+"|\n"+"\n";
		String xAxis=" -----> X";
		
		String row1 =yAxis+"2  "+"  "+getTabOfGame(0,2)+"  " + columna + "  "+getTabOfGame(1,2)+"  " + columna + "  "+getTabOfGame(2,2)+"  " +
				"\n" +"   "+ row + columna + row + columna+ row+"\n";
		String row2="1  "+"  "+getTabOfGame(0,1)+"  " + columna + "  "+getTabOfGame(1,1)+"  " + columna + "  "+getTabOfGame(2,1)+"  " +
				"\n" +"   "+ row + columna + row + columna+ row+"\n";
		String row3="0  "+"  "+getTabOfGame(0,0)+"  " + columna + "  "+getTabOfGame(1,0)+"  " + columna + "  "+getTabOfGame(2,0)+"  "
				+"\n"+"   "+whiteSpace + columna + whiteSpace + columna + whiteSpace+
				"\n"+ "   "+"  "+"0"+"  "+"  "+" 1"+"  "+"  "+"  2"+"  "+xAxis;
		
		String board= row1+row2+row3+"\n\n";	
		System.out.print(board);
		
	
	}
	
	public boolean move(int[] coordinates) {
		int x= coordinates[0];
		int y= coordinates[1];
		if (tabOfGame[x][y] == " ")
		{
			if (isSharpSymbol) {
				tabOfGame[x][y]="X";
				isSharpSymbol=false;
			}
			else {
				tabOfGame[x][y]="O";
				isSharpSymbol=true;
			}
		turnCounter++;
		updateBoard();
		return true;
		}
		else {
			return false;
		}
		
	}

	public void updateBoard() {
		printBoard();
	}
	

	public String checkWhoWon() {
		if(turnCounter<5) { //nikt nie mia³ szans zd¹¿yæ wygraæ
			return null;
		}
		else if (
				(getTabOfGame(0, 0)=="X" && getTabOfGame(1, 0)=="X" && getTabOfGame(2, 0)=="X") ||
				(getTabOfGame(0, 1)=="X" && getTabOfGame(1, 1)=="X" && getTabOfGame(2, 1)=="X") ||
				(getTabOfGame(0, 2)=="X" && getTabOfGame(1, 2)=="X" && getTabOfGame(2,2)=="X")	||
				(getTabOfGame(0, 0)=="X" && getTabOfGame(0, 1)=="X" && getTabOfGame(0,2)=="X")	||
				(getTabOfGame(1, 0)=="X" && getTabOfGame(1, 1)=="X" && getTabOfGame(1,2)=="X")	||
				(getTabOfGame(2, 0)=="X" && getTabOfGame(2, 1)=="X" && getTabOfGame(2,2)=="X")	||
				(getTabOfGame(0, 2)=="X" && getTabOfGame(1, 1)=="X" && getTabOfGame(2,0)=="X")	||
				(getTabOfGame(2, 2)=="X" && getTabOfGame(1, 1)=="X" && getTabOfGame(0,0)=="X")	
			)
						
				{
					return "\n\nWygra³ u¿ytkownik z symbolem X!";
				}
		else if (
					(getTabOfGame(0, 0)=="O" && getTabOfGame(1, 0)=="O" && getTabOfGame(2, 0)=="O") ||
					(getTabOfGame(0, 1)=="O" && getTabOfGame(1, 1)=="O" && getTabOfGame(2, 1)=="O") ||
					(getTabOfGame(0, 2)=="O" && getTabOfGame(1, 2)=="O" && getTabOfGame(2,2)=="O")	||
					(getTabOfGame(0, 0)=="O" && getTabOfGame(0, 1)=="O" && getTabOfGame(0,2)=="O")	||
					(getTabOfGame(1, 0)=="O" && getTabOfGame(1, 1)=="O" && getTabOfGame(1,2)=="O")	||
					(getTabOfGame(2, 0)=="O" && getTabOfGame(2, 1)=="O" && getTabOfGame(2,2)=="O")	||
					(getTabOfGame(0, 2)=="O" && getTabOfGame(1, 1)=="O" && getTabOfGame(2,0)=="O")	||
					(getTabOfGame(2, 2)=="O" && getTabOfGame(1, 1)=="O" && getTabOfGame(0,0)=="O")	
					
				) {
					return "\n\nWygra³ u¿ytkownik z symbolem O!";
				}
		else if (turnCounter==9) {
				return "\\n\\nNikt nie wygra³";
			}
		else {
			return null; //nikt jeszcze nie wygra³
		}

	}
	
	public int[] getCoordinatesByPlayer() {  
		int[] coordinates = new int[2];
		boolean isValid=false;
		while(!isValid) {
			Scanner scanner= new Scanner(System.in);
			System.out.println("Enter X,Y coordinates for your move (x,y): ");
			String xy= scanner.next();
			int x= Integer.parseInt((xy.charAt(0)+""));
			int y= Integer.parseInt((xy.charAt(2)+""));
			if (x<3 && y<3) {
				coordinates[0]= Integer.parseInt((xy.charAt(0)+""));
				coordinates[1]= Integer.parseInt((xy.charAt(2)+""));
				isValid=true;
			}
			else {
				System.out.println("Wartoœæ X i Y musi byæ w przedziale <1;2>");
			}

		}
		return coordinates;

	}
	
	public int[] getCoordinatesByComputer(){
		int[] coordinates = new int[2];
		Random random = new Random();
		coordinates[0]= random.nextInt(3);
		coordinates[1]= random.nextInt(3);
		return coordinates;
	}
	
	public int[] getCoordinates(){
		
		if(computerTurn==true) {
			int[] computerCoordinates=getCoordinatesByComputer();
			computerTurn=false;	
			return computerCoordinates;
			//move(computerCoordinates[0], computerCoordinates[1]); do usuniecia
		}
		else {
			int[] playerCoordinates=getCoordinatesByPlayer();
			computerTurn=true;	
			return playerCoordinates;
			//move(playerCoordinates[0], playerCoordinates[1]); do usuniecia
		}
				
	}

	public void startGame() {
		System.out.println("\n\nThis is the game of Tic Tac Toe.");
		System.out.println("You will be playing against the computer.\n");
		printBoard();
			while(resultOfMatch==null) {
				boolean moveAllowed = false;
				while(!moveAllowed) {  //checking if move is allowed
					moveAllowed=move(getCoordinates());
				}
				resultOfMatch=checkWhoWon();
			}
			System.out.println(resultOfMatch);
				
	}
	
	
}
public class Main{
	public static void main(String[] args) {	

			TicTacToe game= new TicTacToe();
			game.startGame();
		}
	}


