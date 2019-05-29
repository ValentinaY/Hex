package cavaj;
import java.util.ArrayList;

import co.edu.javeriana.algoritmos.proyecto.*;

public class Player implements JugadorHex{

	Board board;
	int mycolor = 0;
	int hercolor = 0;
	ColorJugador mycolor_;
	ColorJugador hercolor_;
	
	public Player() {
		board = new Board();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Jugada jugar(Tablero tablero, ColorJugador color) {
		board = board.clone(tablero);
		
//		Sólo para test
		board.shortestwayB();
		board.shortestwayW();
		board.showWaysB();
		board.showWaysW();
//		Sólo para test
		
		/*
		if(color.toString().compareTo("NEGRO") == 0) {
			this.mycolor_ = ColorJugador.NEGRO;
			this.hercolor_ = ColorJugador.BLANCO;
			this.mycolor = 1;
			this.hercolor =2;
		}
		if(color.toString().compareTo("BLANCO") == 0) {
			this.mycolor_ = ColorJugador.BLANCO;
			this.hercolor_ = ColorJugador.NEGRO;
			this.mycolor = 2;
			this.hercolor = 1;
		}
		
		if (board.ganadortemp() == this.mycolor) {
			return construir();
		}
		else {
			return destruir();
		}
		
		*/
		
		return null;
	}

	@Override
	public String nombreJugador() {
		return "cavaj";
	}

//	Nuestros métodos
	
	/**
	 * Busca la mejor jugada para la ruta más corta, prefiriendo aquellas que le cuesten más al oponente.
	 * @return
	 */
	public Jugada construir() {
		
		ArrayList<Jugada> moves = board.gapssw(mycolor);
		int max = 0;
		
//		La jugada más dañina para el oponente.
		Jugada hmove = null;
		
		for (Jugada jugada : moves) {
			
//			Tablero temporal para ensayar todas las jugadas
			Board tempboard = board.clone();
			tempboard.aplicarJugada(jugada, mycolor_);
			int mycost = tempboard.costsw(mycolor);
			int hercost = tempboard.costsw(hercolor);
			if (max < hercost/mycost){
				max = hercost/mycost;
				hmove = jugada;
			}
		}
		return hmove;
	}
	
	/**
	 * Busca la jugada que le cuesta más al oponente, prefiriendo aquellas que beneficien más.
	 * @return
	 */
	public Jugada destruir() {
		ArrayList<Jugada> moves = board.gapssw(hercolor);
		int max = 0;
		
//		La jugada más dañina para el oponente.
		Jugada hmove = null;
		
		for (Jugada jugada : moves) {
			
//			Tablero temporal para ensayar todas las jugadas
			Board tempboard = board.clone();
			tempboard.aplicarJugada(jugada, mycolor_);
			int mycost = tempboard.costsw(mycolor);
			int hercost = tempboard.costsw(hercolor);
			if (max < hercost/mycost){
				max = hercost/mycost;
				hmove = jugada;
			}
		}
		return hmove;
	}
}
