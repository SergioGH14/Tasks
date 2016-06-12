package bussines;

import java.util.ArrayList;
import java.util.List;

public class Estrategia_Ordenacion_Prioridad implements Estrategia_Ordenacion_Actividades{
	private List<Actividad> listaActividades;
	
	public Estrategia_Ordenacion_Prioridad(Asignatura asignatura) {
		listaActividades = Unidad_Logica.getInstance().listaDeAsignatura(asignatura);
		ordenar();
	}

	@Override
	public List<Actividad> ordenar() {
		 if(listaActividades!=null && !listaActividades.isEmpty()){
		 System.out.println(prioridades());
	     quicksort(listaActividades,0,listaActividades.size()-1);
	     System.out.println(prioridades());
		 return listaActividades;
		 }else return listaActividades;
	}

public void  quicksort(List<Actividad> listaActividades,int izq , int der ){
		
		int i = izq;
		int j = der;
		Actividad pivote = listaActividades.get(izq);
		Actividad aux;
		
		while (i < j){
			while(listaActividades.get(i).getPrioridadTotal()<= pivote.getPrioridadTotal() && i < j){i++;}
			while(listaActividades.get(j).getPrioridadTotal() > pivote.getPrioridadTotal()){j --;}
			if(i<j){
				aux = listaActividades.get(i);
				listaActividades.set(i, listaActividades.get(j));
				listaActividades.set(j, aux);
				
			}
			
		}	
		listaActividades.set(izq, listaActividades.get(j));
		listaActividades.set(j, pivote);
		 if(izq<j-1)
		      quicksort(listaActividades,izq,j-1); 
		   if(j+1 <der)
		      quicksort(listaActividades,j+1,der);		
		
		
	}
public String prioridades(){
	int i = 0;
	String res = "";
	while (i<listaActividades.size()) {
		res = res + listaActividades.get(i).getPrioridadTotal()+"\n"; 
		i++;
	}
	return res;
	
}
}
