package cavaj;
import java.util.ArrayList;

import co.edu.javeriana.algoritmos.proyecto.*;

public class Board implements Tablero{

	private static int INF= 9999;
	
	private int[][] waysB;
	private int[][] waysR;
	
	private int[][] board;
	
	public Board()  {
		this.waysB = new int[11+2][11+1];
		this.waysR = new int[11+1][11+2];

		board = new int[11][11];
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				board[i][j]=0;
			}
		}
	}

	@Override
	public void aplicarJugada(Jugada jugada, ColorJugador colorJugador) {
		//Negro es 1, blanco es 2
		board[jugada.getFila()][jugada.getColumna()]=colorJugador.ordinal()+1;
	}

	@Override
	public ColorJugador ganador() {
		// TODO Auto-generated method stubboard.shortestwayB();
		shortestwayW();
		shortestwayB();
		int minb=INF;
		int minw=INF;
		for (int i=1; i<12; i++) {
			if (minw > waysR[11][i]) {
				minw = waysR[11][i];
			}
			if (minb > waysB[i][11]) {
				minb = waysB[i][11];
			}
		}
		return minb<minw? ColorJugador.BLANCO: ColorJugador.NEGRO;
	}

	@Override
	public ColorJugador casilla(int fila, int columna) {
		return board[fila][columna]==1? ColorJugador.NEGRO: ColorJugador.BLANCO;
	}
	
//	Nuestros métodos

	public int ganadortemp() {
		// TODO Auto-generated method stubboard.shortestwayB();
		shortestwayW();
		shortestwayB();
		int minb=INF;
		int minw=INF;
		for (int i=1; i<12; i++) {
			if (minw > waysR[11][i]) {
				minw = waysR[11][i];
			}
			if (minb > waysB[i][11]) {
				minb = waysB[i][11];
			}
		}
		return minb<minw? 2: minb>minw? 1: 0;
	}
	/**
	 * Devuelve un tablero nuevo con los datos del tablero dado.
	 * @param tablero
	 * @return
	 */
	public Board clone(Tablero tablero) {
		Board board= new Board();
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				board.setMove(i, j, 0);
//				board.setMove(i, j, tablero.casilla(i, j).ordinal()+1);
			}
		}
		return board;
	}
	
	/**
	 * Devuelve un tablero nuevo con los mismos datos.
	 */
	public Board clone() {
		Board board= new Board();
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				board.setMove(i, j, 0);
			}
		}
		return board;
	}
	
	/**
	 * Llena la matriz ways 
	 * @return
	 */
	public int shortestwayW() {
		for(int i=0;i<12;i++) {
			for(int j=0;j<13;j++){
				waysR[i][j]=-1;
				if(j==0 || j==12) waysR[i][j]=INF;
				if(i==0) waysR[i][j]=0;
			}
		}
		
		for (int i=1;i<12;i++) {
			for (int j=1;j<12;j++) {
				if(waysR[i][j]==-1) {
					waysR[i][j]=shortestwayW(i,j);
				}
			}			
		}
		return 0;
	}
	
	public int shortestwayW(int i, int j) {
		int sum=1;
		if (board[i-1][j-1] == 1) {
			return INF;
		}
		if (board[i-1][j-1] == 2) {
			sum=0;
		}
		int a=waysR[i-1][j];
		int b=waysR[i-1][j-1];
		int c=waysR[i][j+1];
		if (c==-1) {
			c=shortestwayW(i,j+1);
		}
		
		return Math.min(Math.min(a,b),c)+sum;
	}

	public int shortestwayB() {
		for(int i=0;i<13;i++) {
			for(int j=0;j<12;j++){
				waysB[i][j]=-1;
				if(i==0 || i==12) waysB[i][j]=INF;
				if(j==0) waysB[i][j]=0;
			}
		}
		
		for (int j=1;j<12;j++) {
			for (int i=1;i<12;i++) {
				if(waysB[i][j]==-1) {
					waysB[i][j]=shortestwayB(i,j);
				}
			}			
		}
		return 0;
	}
	
	public int shortestwayB(int i, int j) {
		int sum=1;
		if (board[i-1][j-1] == 2) {
			return INF;
		}
		if (board[i-1][j-1] == 1) {
			sum=0;
		}
		int a=waysB[i][j-1];
		int b=waysB[i-1][j-1];
		int c=waysB[i+1][j];
		if (c==-1) {
			c=shortestwayB(i+1,j);
		}
		
		return Math.min(Math.min(a,b),c)+sum;
	}
	
	public void showWaysB() {
		for (int i=0;i<13;i++) {
			for (int j=0;j<12;j++) {
				System.out.print(waysB[i][j]+" ");
			}
			System.out.println();
		}
	}

	public void showWaysW() {
		for (int i=0;i<12;i++) {
			for (int j=0;j<13;j++) {
				System.out.print(waysR[i][j]+" ");
			}
			System.out.println();
		}
	}

	public ArrayList<Jugada> gapssw(int color){
		return null;
	}
	
	public int costsw(int color) {
		return 0;
	}

	public void setMove(int i, int j, int color) {
		this.board[i][j]=color;
	}
	
	public int getMove(int i, int j) {
		return board[i][j];
	}
}
