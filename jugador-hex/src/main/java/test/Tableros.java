package test;

import co.edu.javeriana.algoritmos.proyecto.*;
import cavaj.*;

public class Tableros {

	public Tableros() {
		// TODO Auto-generated constructor stub
	}

	public static Tablero getT1() {
		Tablero tablero1 = new Board();
		Jugada jugada1 = new Jugada(0, 3);
		Jugada jugada2 = new Jugada(2, 4);
		Jugada jugada3 = new Jugada(4, 5);
		Jugada jugada4 = new Jugada(6, 5);
		Jugada jugada5 = new Jugada(6, 6);
		Jugada jugada6 = new Jugada(6, 7);
				
		tablero1.aplicarJugada(jugada1, ColorJugador.BLANCO);
		tablero1.aplicarJugada(jugada2, ColorJugador.BLANCO);
		tablero1.aplicarJugada(jugada3, ColorJugador.BLANCO);
		tablero1.aplicarJugada(jugada4, ColorJugador.NEGRO);
		tablero1.aplicarJugada(jugada5, ColorJugador.NEGRO);
		tablero1.aplicarJugada(jugada6, ColorJugador.NEGRO);
		
		
		return tablero1;
	}
	
	//Tablero en el que blanco está a un movimiento de ganar
	public static Tablero getT2() {
		Tablero tablero2 = new Board();
		//jugadas negros
		Jugada [] negros = new Jugada[10];
		negros[0] = new Jugada(0, 0);
		negros[1] = new Jugada(0, 1);
		negros[2] = new Jugada(0, 2);
		negros[3] = new Jugada(0, 3);
		negros[4] = new Jugada(1, 0);
		negros[5] = new Jugada(1, 1);
		negros[6] = new Jugada(1, 2);
		negros[7] = new Jugada(1, 3);
		negros[8] = new Jugada(2, 0);
		negros[9] = new Jugada(2, 1);
		
		
		//jugadas blancos
		Jugada [] blancos = new Jugada[10];
		blancos[0] = new Jugada(5, 0);
		blancos[1] = new Jugada(5, 1);
		blancos[2] = new Jugada(5, 2);
		blancos[3] = new Jugada(5, 3);
		blancos[4] = new Jugada(5, 4);
		blancos[5] = new Jugada(5, 5);
		blancos[6] = new Jugada(5, 6);
		blancos[7] = new Jugada(5, 7);
		blancos[8] = new Jugada(5, 8);
		blancos[9] = new Jugada(5, 9);

		for(int i = 0 ; i < negros.length ; ++i) {
			tablero2.aplicarJugada(blancos[i], ColorJugador.BLANCO);
			tablero2.aplicarJugada(negros[i], ColorJugador.NEGRO);
		}
		
		return tablero2;
	}
	
	//Tablero en el que blanco deberia bloquear al negro
	public static Tablero getT3() {
		Tablero tablero3 = new Board();
		//jugadas negros
		Jugada [] negros = new Jugada[10];
		negros[0] = new Jugada(0, 9);
		negros[1] = new Jugada(1, 9);
		negros[2] = new Jugada(2, 9);
		negros[3] = new Jugada(3, 9);
		negros[4] = new Jugada(5, 9);
		negros[5] = new Jugada(6, 9);
		negros[6] = new Jugada(7, 9);
		negros[7] = new Jugada(8, 9);
		negros[8] = new Jugada(9, 9);
		negros[9] = new Jugada(10, 9);
		
		
		//jugadas blancos
		Jugada [] blancos = new Jugada[10];
		blancos[0] = new Jugada(0, 0);
		blancos[1] = new Jugada(0, 1);
		blancos[2] = new Jugada(0, 2);
		blancos[3] = new Jugada(0, 3);
		blancos[4] = new Jugada(1, 0);
		blancos[5] = new Jugada(1, 1);
		blancos[6] = new Jugada(1, 2);
		blancos[7] = new Jugada(1, 3);
		blancos[8] = new Jugada(2, 0);
		blancos[9] = new Jugada(3, 1);

		for(int i = 0 ; i < negros.length ; ++i) {
			tablero3.aplicarJugada(blancos[i], ColorJugador.BLANCO);
			tablero3.aplicarJugada(negros[i], ColorJugador.NEGRO);
		}
		
		return tablero3;
	}
	
	//Tablero vacio
	public static Tablero getT4() {
		Tablero tablero4 = new Board();
				
		return tablero4;
	}
	
	
}
