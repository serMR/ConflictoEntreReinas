package base;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoReinas {

	
	public static Escenario read(String path) throws FileNotFoundException{
		
		Scanner sc = new Scanner(new File(path));
		
		int dimensionTablero = sc.nextInt();
		int cantReinas = sc.nextInt();
		
		List<Reina> reinas = new ArrayList<>();
		int[][] matTablero = new int[dimensionTablero][dimensionTablero];
		int fila, col;
		
		for(int i = 0 ; i<cantReinas; i++){
			fila = sc.nextInt();
			col = sc.nextInt();
			reinas.add(new Reina(fila,col,i+1));
			matTablero[fila-1][col-1] = i+1;
		}
		sc.close();
		return new Escenario(reinas, dimensionTablero, matTablero);
	}
	
	public static void write(String path, Escenario esc) throws FileNotFoundException {
		
		PrintWriter salida = new PrintWriter(new File(path));
		int size;
		
		for(int i=0; i<esc.getReinas().size(); i++) {
			size = esc.getReinas().get(i).getConflictos().size();
			salida.print(size);					
			if(size!=0){
				for(int j=0; j<size;j++)
					salida.print(" " + esc.getReinas().get(i).getConflictos().get(j));
		
			}
			salida.println();
		}
	
		salida.close();
	}
	
}
