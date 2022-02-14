package modelo;

public class Tabla {
	
	private char[][] tabla;
	private int fila;
	private int columna;
	
	
	public Tabla(int fila, int columna) {
		super();

		this.tabla = new char[fila][columna];
		this.columna = columna;
		this.fila = fila;
		
	}


	public int getFila() {
		return fila;
	}


	public void setFila(int fila) {
		this.fila = fila;
	}


	public int getColumna() {
		return columna;
	}


	public void setColumna(int columna) {
		this.columna = columna;
	}


	public char[][] getTabla() {
		return tabla;
	}


	public void setTabla(char tabla, int fila, int columna) {
		this.tabla [fila][columna] = tabla;
	}
	
	
	
	

}
