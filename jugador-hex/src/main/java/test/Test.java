package test;

import co.edu.javeriana.algoritmos.proyecto.*;
import cavaj.*;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		JugadorHex jugador = new Player();
		Jugada jugada =jugador.jugar(Tableros.getT2(), ColorJugador.BLANCO);
		System.out.println(jugada);
	}

}
