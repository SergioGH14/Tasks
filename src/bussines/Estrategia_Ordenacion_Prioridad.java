package bussines;

import java.util.ArrayList;
import java.util.List;

public class Estrategia_Ordenacion_Prioridad implements Estrategia_Ordenacion_Actividades{
	private List<Actividad> listaActividades;
	
	public Estrategia_Ordenacion_Prioridad(Asignatura asignatura) {
		listaActividades = Unidad_Logica.getInstance().listaDeAsignatura(asignatura);
		
	}

	@Override
	public List<Actividad> ordenar() {
		
		 quicksort(listaActividades,0,listaActividades.lastIndexOf(listaActividades)+1);
		 return listaActividades;
	}

	public void  quicksort(List<Actividad> listaActividades,int x , int y){
		
		int posizq = x;
		int posder = y;
		Actividad pivote = listaActividades.get(x);
		Actividad aux;
	
		
		while (posizq < posder){
			while(listaActividades.get(posizq).getPrioridadTotal()<= pivote.getPrioridadTotal() && posizq < posder){posizq++;}
			while(listaActividades.get(posder).getPrioridadTotal() > pivote.getPrioridadTotal()){posder --;}
			if(posizq<posder){
				aux = listaActividades.get(posizq);
				listaActividades.set(posizq, listaActividades.get(posder));
				listaActividades.set(posder, aux);
				
			}
			
		}	
		listaActividades.set(x, listaActividades.get(posder));
		listaActividades.set(posder, pivote);
		
		 if(x<posder-1)
		      quicksort(listaActividades,posizq,posder-1); 
		   if(posizq+1 <y)
		      quicksort(listaActividades,posizq+1,posder);		
		
		
	}
	
}
