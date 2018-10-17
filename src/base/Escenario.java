package base;

import java.util.Collections;
import java.util.List;

public class Escenario {

	private List<Reina> reinas;
	private int dimTablero;
	private int[][] mat;
	
	public Escenario(List<Reina> reinas, int dimensionTablero, int[][] matTablero) {
		this.reinas = reinas;
		this.dimTablero = dimensionTablero;		
		this.mat = matTablero;
	}
	
	public Escenario solucion(){
		
		int fila, col;
		
		for(int i=0; i<reinas.size(); i++) {
				
			fila= reinas.get(i).getFila();
			col= reinas.get(i).getColumna();
			
			//derecha
			for(int j=col; j<this.dimTablero; j++) {
				if(mat[fila-1][j]!=0) {
					reinas.get(i).add(mat[fila-1][j]);
					break;
				}
			}
			
			//izquierda
			for(int j=col-2; j>=0; j--) {
				if(mat[fila-1][j]!=0) {
					reinas.get(i).add(mat[fila-1][j]);
					break;
				}
			}
			
			//abajo
			for(int j=fila; j<this.dimTablero; j++) {
				if(mat[j][col-1]!=0) {
					reinas.get(i).add(mat[j][col-1]);
					break;
				}
				
			}
			
			//arriba
			for(int j=fila-2; j>=0; j--) {
				if(mat[j][col-1]!=0) {
					reinas.get(i).add(mat[j][col-1]);
					break;
				}	
			}
			
			//diagonalPriAbajo
			for(int j=0;j<this.dimTablero;j++) {
				if((fila+j)<this.dimTablero && (col+j)<this.dimTablero && mat[fila+j][col+j]!=0) {
					reinas.get(i).add(mat[fila+j][col+j]);
					break;
				}
			}
			
			//diagonalPriArriba
			for(int j=1; j<this.dimTablero; j++) {
				if((fila-1-j)>=0 && (col-1-j)>=0 && mat[fila-1-j][col-1-j]!=0) {
					reinas.get(i).add(mat[fila-1-j][col-1-j]);
					break;
				}
			}
			
			//diagonalSecArriba
			for(int j=1; j<this.dimTablero; j++) {
				if( (fila-1-j)>=0 && (col-1+j)<this.dimTablero && mat[(fila-1)-j][(col-1)+j]!=0) {
					reinas.get(i).add(mat[(fila-1)-j][(col-1)+j]);
					break;
				}
			}
			
			//diagonalSecAbajo
			for(int j=1; j<this.dimTablero; j++) {
				if((fila-1+j)<this.dimTablero && (col-1-j)>=0 && mat[(fila-1)+j][(col-1)-j]!=0) {
					reinas.get(i).add(mat[(fila-1)+j][(col-1)-j]);
					break;
				}
			}
			
			Collections.sort(reinas.get(i).getConflictos());
		}
		
		return this;
	}


	public List<Reina> getReinas() {
		return reinas;
	}
	
}
