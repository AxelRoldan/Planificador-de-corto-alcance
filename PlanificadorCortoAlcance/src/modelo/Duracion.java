package modelo;

public class Duracion {
	
	private int comienzaTiempo;
	private int cpuInicio;
	private int bloqueado;
	private int cpuFinal;
	
	public Duracion(int comienzaTiempo, int cpuInicio, int bloqueado, int cpuFinal) {
		super();
		this.comienzaTiempo = comienzaTiempo;
		this.cpuInicio = cpuInicio;
		this.bloqueado = bloqueado;
		this.cpuFinal = cpuFinal;
	}
	

	@Override
	public String toString() {
		return "Duracion [comienzaTiempo=" + comienzaTiempo + ", cpuInicio=" + cpuInicio + ", bloqueado=" + bloqueado
				+ ", cpuFinal=" + cpuFinal + "]";
	}


	public int getCpuInicio() {
		return cpuInicio;
	}

	public void setCpuInicio(int cpuInicio) {
		this.cpuInicio = cpuInicio;
	}

	public int getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(int bloqueado) {
		this.bloqueado = bloqueado;
	}

	public int getCpuFinal() {
		return cpuFinal;
	}

	public void setCpuFinal(int cpuFinal) {
		this.cpuFinal = cpuFinal;
	}

	public int getComienzaTiempo() {
		return comienzaTiempo;
	}

	public void setComienzaTiempo(int comienzaTiempo) {
		this.comienzaTiempo = comienzaTiempo;
	}
	
	
	

}
