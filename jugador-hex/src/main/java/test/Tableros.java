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
}
