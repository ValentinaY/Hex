package cavaj;
import java.util.ArrayList;

import co.edu.javeriana.algoritmos.proyecto.*;

public class Board implements Tablero{

	private static int INF= 9999;
	
	private int[][] waysW;
	private int[][] waysB;
	
	private int[][] board;
	
	public Board()  {
		this.waysW = new int[11+2][11+1];
		this.waysB = new int[11+1][11+2];

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
		if(colorJugador == ColorJugador.BLANCO) {
			board[jugada.getFila()][jugada.getColumna()]=2;
		}
		if(colorJugador == ColorJugador.NEGRO) {
			board[jugada.getFila()][jugada.getColumna()]=1;
		}
	}

	@Override
	public ColorJugador ganador() {
		// TODO Auto-generated method stubboard.shortestwayB();
		shortestwayW();
		shortestwayB();
		int minb=INF;
		int minw=INF;
		for (int i=1; i<12; i++) {
			if (minw > waysB[11][i]) {
				minw = waysB[11][i];
			}
			if (minb > waysW[i][11]) {
				minb = waysW[i][11];
			}
		}
		return minb<minw? ColorJugador.BLANCO: ColorJugador.NEGRO;
	}

	@Override
	public ColorJugador casilla(int fila, int columna) {
		return board[fila][columna]==1? ColorJugador.NEGRO: ColorJugador.BLANCO;
	}
	
//	Nuestros métodos

	/**
	 * Retorna el número del color que está ganando con el tablero actual.
	 * Negro = 1, Blanco = 2.
	 * @return
	 */
	public int ganadortemp() {
		shortestwayW();
		shortestwayB();
		int minb=INF;
		int minw=INF;
		for (int i=1; i<12; i++) {
			if (minb > waysB[11][i]) {
				minb = waysB[11][i];
			}
			if (minw > waysW[i][11]) {
				minw = waysW[i][11];
			}
		}
		return minb<minw? 1: minb>minw? 2: 0;
	}
	
	/**
	 * Devuelve un tablero nuevo con los datos del tablero dado.
	 * @param tablero
	 * @return
	 */
	public Board clone(Tablero tablero) {
		Board board= new Board();
		int t=0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				/*
				 * Leer t, dado tablero.
				 */
				board.setMove(i, j, t);
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
				board.setMove(i, j, getMove(i, j));
			}
		}
		return board;
	}
	
	/**
	 * Llena la matriz waysB (Vertical)
	 * @return
	 */
	public int shortestwayB() {
		for(int i=0;i<12;i++) {
			for(int j=0;j<13;j++){
				waysB[i][j]=-1;
				if(j==0 || j==12) waysB[i][j]=INF;
				if(i==0) waysB[i][j]=0;
			}
		}
		
		for (int i=1;i<12;i++) {
			for (int j=1;j<12;j++) {
				if(waysB[i][j]==-1) {
					waysB[i][j]=shortestwayB(i,j);
				}
			}			
		}
		return 0;
	}
	
	/**
	 * Encuentra el mínimo costo. Formato 1
	 * @param i
	 * @param j
	 * @return
	 */
	public int shortestwayB(int i, int j) {
		int sum=1;
		if (board[i-1][j-1] == 1) {
			return INF;
		}
		if (board[i-1][j-1] == 2) {
			sum=0;
		}
		int a=waysB[i-1][j];
		int b=waysB[i-1][j-1];
		int c=waysB[i][j+1];
		if (c==-1) {
			c=shortestwayB(i,j+1);
		}
		
		return Math.min(Math.min(a,b),c)+sum;
	}

	/**
	 * Llena la matriz waysW. (Horizontal)
	 * @return
	 */
	public int shortestwayW() {
		for(int i=0;i<13;i++) {
			for(int j=0;j<12;j++){
				waysW[i][j]=-1;
				if(i==0 || i==12) waysW[i][j]=INF;
				if(j==0) waysW[i][j]=0;
			}
		}
		
		for (int j=1;j<12;j++) {
			for (int i=1;i<12;i++) {
				if(waysW[i][j]==-1) {
					waysW[i][j]=shortestwayW(i,j);
				}
			}			
		}
		return 0;
	}
	
	/**
	 * Encuentra el mínimo costo. Formato 1
	 * @param i
	 * @param j
	 * @return
	 */
	public int shortestwayW(int i, int j) {
		int sum=1;
		if (board[i-1][j-1] == 2) {
			return INF;
		}
		if (board[i-1][j-1] == 1) {
			sum=0;
		}
		int a=waysW[i][j-1];
		int b=waysW[i-1][j-1];
		int c=waysW[i+1][j];
		if (c==-1) {
			c=shortestwayW(i+1,j);
		}
		
		return Math.min(Math.min(a,b),c)+sum;
	}
	
	/**
	 * Muestra la matriz con la menor ruta vertical.
	 */
	public void showWaysW() {
		for (int i=0;i<13;i++) {
			for (int j=0;j<12;j++) {
				System.out.print(waysW[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * Muestra la matriz con la menor ruta horizontal.
	 */
	public void showWaysB() {
		for (int i=0;i<12;i++) {
			for (int j=0;j<13;j++) {
				System.out.print(waysB[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * Dado un color, se retornan las jugadas necesarias para completar esa ruta.
	 * Cuando el color es blanco, se intenta hacer una ruta horizontal, para el negro es vertical.
	 * @param color
	 * @return
	 */
	public ArrayList<Jugada> gapssw(int color){
		ArrayList<Jugada> jugadas = new ArrayList<Jugada>();
		int minValue, val_i, val_j;
		
		if(color == 1) {
			for(int i = 11; i < 1; i--) {
				minValue = board[i][0];
				val_i = i;
				val_j = 0;
				for(int j = 0; j < 11; j++) {
					if(board[i][j] < minValue){
						minValue = board[i][j];
						val_i = i;
						val_j = j;
					}
				}
				Jugada jugada = new Jugada(val_i, val_j);
				jugadas.add(jugada);
			}
		}
		
		if(color == 2) {
			for(int j = 11; j < 1; j--) {
				minValue = board[0][j];
				val_i = 0;
				val_j = j;
				for(int i = 0; i < 11; i++) {
					if(board[i][j] < minValue){
						minValue = board[i][j];
						val_i = i;
						val_j = j;
					}
				}
				Jugada jugada = new Jugada(val_i, val_j);
				jugadas.add(jugada);
			}
		}
		
		return jugadas;
		
	}
	
	/**
	 * Dado un color, se retorna el mínimo costo de completar la mínima ruta.
	 * @param color
	 * @return
	 */
	public int costsw(int color) {
		/*
		 * Terminar
		 */
		return 0;
	}

	public void setMove(int i, int j, int color) {
		this.board[i][j]=color;
	}
	
	public int getMove(int i, int j) {
		return board[i][j];
	}
	
	public void showBoard() {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

}
