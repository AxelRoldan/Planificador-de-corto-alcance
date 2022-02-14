package modelo;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	
	private List<Procesos> lstProcesos = new ArrayList<Procesos>();
	private List<Procesos> lstProcesosListos = new ArrayList<Procesos>();
	private Tabla nuevaTabla;

	public Sistema(Tabla nuevaTabla) {
		super();
		
		this.nuevaTabla = nuevaTabla;
	}

	public List<Procesos> getLstProcesos() {
		return lstProcesos;
	}

	public void setLstProcesos(List<Procesos> lstProcesos) {
		this.lstProcesos = lstProcesos;
	}
	
	public boolean agregarProceso(String nombreProceso, Duracion duracionProceso) {
		
		int id = 1;
		
		if(!lstProcesos.isEmpty()) {	
			id = lstProcesos.get(lstProcesos.size() - 1).getId() + 1;
			
		}
		return lstProcesos.add(new Procesos(id, nombreProceso, 0, duracionProceso, false, 0, 0, true, false));
	}
	
	public void admProcesos() {
		
		lstProcesosListos.clear(); // Se limpia cola de listos para mayor fiabilidad.
		prepararTabla(nuevaTabla); // Algoritmo que coloca un espacio en una matriz de char's ' ', Recibe la tabla que se va a usar como parametro.
		int i = 0;				   // Contador que va a mover manualmente el indice
		
		while(!terminoPlanificador()) {
			
			if(!traerListos(i).isEmpty()) { 			// Pregunto si hay procesos listos, y si devuelve al menos un proceso se cumplira la condicion
				agregarAColaListos(traerListos(i));		// Agrego los procesos listos que encontre
				if(lstProcesosListos.size()>= 3) {		// Si hay mas de dos procesos en la cola de listos excluyendo el que se esta ejecutando se cumple la condicion
					ordenoColaListos();					// ordeno por metodo de insercion
				}
			}
			
			ejecutoBloqueados(i);						// Ejecuto primero los bloqueados, ya que en el indice actual al setear bloqueado = true pisa el valor del ultimo "ejecutando" = 'E'
			ejecutoPrograma(i);							// Ejecuto el primer proceso de la cola de listos
			i++;
		}
		
	}
	
	public List<Procesos> traerListos(int columna){
		
		List<Procesos> lstAuxiliar = new ArrayList<Procesos>();
		
		for(int i =0; i<lstProcesos.size(); i++) {
			if(lstProcesos.get(i).getDuracionProceso().getComienzaTiempo() == columna+1 && !lstProcesos.get(i).isSegundaParte()) { // Pregunto: El tiempo de comienzo == Posicion de la columna
				lstAuxiliar.add(lstProcesos.get(i));									 										   // Añado el proceso si es que fue encontrado a una lista auxiliar
			}
		}	
		return lstAuxiliar; // Devuelvo la lista, si no encontro nada, estara vacia.
	}
	
	public Tabla prepararTabla(Tabla nuevaTabla) {
		
		for(int i=0; i<nuevaTabla.getFila(); i++) {
			for(int j=0; j<nuevaTabla.getColumna(); j++) {
				
				nuevaTabla.getTabla()[i][j] = ' ';
			}
		}
		return nuevaTabla;
	}
	
	public void agregarAColaListos(List<Procesos> lstListos) {
		
		for(int i=0; i<lstListos.size(); i++) {			// Recibe como parametro la lista de los procesos listos, al final del algoritmo limpia la lista.
			
			lstProcesosListos.add(lstListos.get(i));  	// Asigno a la cola los procesos que estan listos.
		}												// NO DEVUELVE NADA SOLO AGREGA A LA COLA LOS LISTOS
		lstListos.clear();
	}
	
	public void mostrarProcesosListos() {
		
		int contador = 1;
		
		for(int i=0; i<nuevaTabla.getFila(); i++) {
			for(int j=0; j<nuevaTabla.getColumna(); j++) {
				if(contador < 10) {
					System.out.print("| " +  contador + " |" );
				}
				else {
					System.out.print("| " +  contador + "|" );
				}
				contador++;
				
				if(contador > 40) {
					i = nuevaTabla.getFila();
				}
			}
		}
		
		System.out.println(" ");
		
		for(int i=0; i<nuevaTabla.getFila(); i++) {
			for(int j=0; j<nuevaTabla.getColumna(); j++) {
				System.out.print("| " + nuevaTabla.getTabla()[i][j] + " |");
			}
			System.out.println(" ");
		}
	}
	
	public void ejecutoPrograma(int columna) {
		
		int fila = lstProcesosListos.get(0).getId()-1;
		nuevaTabla.setTabla('E', fila, columna);
		
		lstProcesosListos.get(0).setContadorProceso(lstProcesosListos.get(0).getContadorProceso() + 1); // Subo contador de proceso ++
		lstProcesosListos.get(0).setPrioridad(lstProcesosListos.get(0).getPrioridad() + 1);				// Subo contador de prioridad ++
		
		
				
		if(lstProcesosListos.get(0).isPrimeraParte()) {		
			if(lstProcesosListos.get(0).getDuracionProceso().getCpuInicio() == lstProcesosListos.get(0).getContadorProceso()) {							// si aun esta en la primera fase de ejecucion se cumple la condicion
				lstProcesosListos.get(0).setBloqueado(true);																							// tal que isPrimeraParte = true
				lstProcesosListos.get(0).setContadorProceso(0);																							// si el proceso termino seteo bloqueado = true, contadorProceso = 0, 
				if(lstProcesosListos.get(0).getDuracionProceso().getBloqueado() == 1){																	// el tiempo de listo de proceso de setea comienzaTiempo = tiempoBloqueo + columna
					lstProcesosListos.get(0).getDuracionProceso().setComienzaTiempo(columna + lstProcesosListos.get(0).getDuracionProceso().getBloqueado() + 1);
				}
				else {
					lstProcesosListos.get(0).getDuracionProceso().setComienzaTiempo(columna + lstProcesosListos.get(0).getDuracionProceso().getBloqueado());
				}
				
				lstProcesosListos.get(0).setPrimeraParte(false);
				lstProcesosListos.remove(0);	
			}
		}
		else if (!lstProcesosListos.get(0).isPrimeraParte()){	
				if(lstProcesosListos.get(0).getDuracionProceso().getCpuFinal() == lstProcesosListos.get(0).getContadorProceso()) {		// Si es segunda parte y se cumple la condicion
					lstProcesosListos.get(0).setSegundaParte(true);																		// seteo segunda parte y retiro de la cola listos.
					lstProcesosListos.remove(0);																						// NO DEVUELVE NADA SOLO EJECUTA LA COLA DE LISTOS
					
				}
		}
		lstProcesosListos.forEach(System.out::println);
		System.out.println("------------------------------------------" + columna);
		
		
	}
	
	public void ejecutoBloqueados(int columna) {																			// Coloco un un char 'B' si el proceso isBLoqueado() = true
																															// Si el proceso termino su ciclo de bloqueado isBloqueado = false
		for(int i=0; i<lstProcesos.size(); i++) {																			// el tiempo de listo esta definido en el tiempo de ejecucion
			if(lstProcesos.get(i).isBloqueado()) {																			// SOLO EJECUTA BLOQUEADOS NO DEVUELVE NADA
				nuevaTabla.setTabla('B', i, columna);																		
				lstProcesos.get(i).setContadorBloqueo(lstProcesos.get(i).getContadorBloqueo() + 1);
				
				if(lstProcesos.get(i).getContadorBloqueo() == lstProcesos.get(i).getDuracionProceso().getBloqueado()) {
					lstProcesos.get(i).setBloqueado(false);
				}
			}
		}
	}
	
	public boolean terminoPlanificador() { 				// Si todos los procesos tiene su FLAG = true isSegundaParte() el while rompe el ciclo y se termina la ejecucion
														// DEVUELVE TRUE SI TODOS LOS PROCESOS TERMINARON
		boolean termino = true;
		
		for(int i=0 ; i<lstProcesos.size(); i++) {
			if(!lstProcesos.get(i).isSegundaParte()) {
				termino = false;
				i = lstProcesos.size();
			}
		}
		return termino;
	}
	
	public void ordenoColaListos () {																		// ordena los procesos listos excluyendo al primero por metodo de insercion directa
																											// SOLO ORDENA NO DEVUELVE NADA
		Procesos procesoAuxiliar = lstProcesosListos.get(1);
		int contador = 1;																					// Contador = 1 para no interferir en el proceso que se esta ejecutando
		
		while (contador < lstProcesosListos.size() ) {
			
			for(int i = contador; i<lstProcesosListos.size(); i++) {
				if(lstProcesosListos.get(contador).getPrioridad() >lstProcesosListos.get(i).getPrioridad()) {
					procesoAuxiliar = lstProcesosListos.get(contador);
					lstProcesosListos.set(contador, lstProcesosListos.get(i));
					lstProcesosListos.set(i, procesoAuxiliar);
				}
			}
			contador ++;
		}
		
	}

}
