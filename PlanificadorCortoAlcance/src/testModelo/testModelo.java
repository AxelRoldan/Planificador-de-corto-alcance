package testModelo;

import modelo.Duracion;
import modelo.Sistema;
import modelo.Tabla;

public class testModelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sistema nuevoSistema = new Sistema (new Tabla(4, 40));
		
		
		nuevoSistema.agregarProceso("Proceso 1", new Duracion(1, 3, 2, 4));
		nuevoSistema.agregarProceso("Proceso 2", new Duracion(2, 2, 3, 2));
		nuevoSistema.agregarProceso("Proceso 3", new Duracion(4, 4, 2, 1));
		nuevoSistema.agregarProceso("Proceso 4", new Duracion(6, 1, 1, 1));
		
		
		nuevoSistema.admProcesos();
		nuevoSistema.mostrarProcesosListos();
		
		

	}

}
