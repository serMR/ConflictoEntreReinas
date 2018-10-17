package base;

import java.util.ArrayList;

public class Reina{

	private int fila, columna;
	private int posicionEntrada;
	private ArrayList<Integer> conflictos = new ArrayList<>();
	
	public Reina(int fila, int col, int i) {
		this.fila = fila;
		this.columna = col;
		this.posicionEntrada = i;
	}
	
	public void add(int valor) {
		conflictos.add(valor);
	}
	
	public ArrayList<Integer> getConflictos() {
		return conflictos;
	}
	
	public int getFila(){
		return this.fila;
	}

	@Override
	public String toString() {
		return "Reina [fila=" + this.fila + ", columna=" + this.columna + ", posicionEntrada=" + this.posicionEntrada + "]";
	}


	public int getColumna() {
		// TODO Auto-generated method stub
		return this.columna;
	}

}
