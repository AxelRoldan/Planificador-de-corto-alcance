package modelo;

import java.util.ArrayList;
import java.util.List;

public class Procesos {
	
	private int id;
	private String nombreProceso;
	private int prioridad;
	private Duracion duracionProceso;
	private boolean bloqueado;
	private int contadorBloqueo;
	private int contadorProceso;
	private boolean primeraParte;
	private boolean segundaParte;
	
	public Procesos(int id, String nombreProceso, int proridad, Duracion duracionProceso, boolean bloqueado, int contadorBloqueo, int contadorProceso, boolean primeraParte, boolean segundaParte) {
		
		super();
		this.id = id;
		this.nombreProceso = nombreProceso;
		this.prioridad = proridad;
		this.duracionProceso = duracionProceso;
		this.bloqueado = bloqueado;
		this.contadorBloqueo = contadorBloqueo;
		this.contadorProceso = contadorProceso;
		this.primeraParte = primeraParte;
		this.segundaParte = segundaParte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreProceso() {
		return nombreProceso;
	}

	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}

	public int getProridad() {
		return prioridad;
	}

	public void setProridad(int proridad) {
		this.prioridad = proridad;
	}

	public Duracion getDuracionProceso() {
		return duracionProceso;
	}

	public void setDuracionProceso(Duracion duracionProceso) {
		this.duracionProceso = duracionProceso;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public int getContadorBloqueo() {
		return contadorBloqueo;
	}

	public void setContadorBloqueo(int contadorBloqueo) {
		this.contadorBloqueo = contadorBloqueo;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int getContadorProceso() {
		return contadorProceso;
	}

	public void setContadorProceso(int contadorProceso) {
		this.contadorProceso = contadorProceso;
	}

	public boolean isPrimeraParte() {
		return primeraParte;
	}

	public void setPrimeraParte(boolean primeraParte) {
		this.primeraParte = primeraParte;
	}

	public boolean isSegundaParte() {
		return segundaParte;
	}

	public void setSegundaParte(boolean segundaParte) {
		this.segundaParte = segundaParte;
	}

	@Override
	public String toString() {
		return "Procesos [id=" + id + ", nombreProceso=" + nombreProceso + ", prioridad=" + prioridad
				+ ", duracionProceso=" + duracionProceso + ", bloqueado=" + bloqueado + ", contadorBloqueo="
				+ contadorBloqueo + ", contadorProceso=" + contadorProceso + ", primeraParte=" + primeraParte
				+ ", segundaParte=" + segundaParte + "]";
	}

	
	
	
	
	
	
}
