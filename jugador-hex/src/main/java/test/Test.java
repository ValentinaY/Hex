package test;

import co.edu.javeriana.algoritmos.proyecto.*;
import cavaj.*;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Tablero tablero = new Board();
		JugadorHex jugador = new Player();
		
		jugador.jugar(tablero, ColorJugador.BLANCO);
	}

}
