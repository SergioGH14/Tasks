package bussines;

import java.util.ArrayList;
import java.util.List;

public class Estrategia_Ordenacion_Hoy implements Estrategia_Ordenacion_Actividades {
	
	List<Actividad> listaActividades;
	@Override
	public List<Actividad> ordenar() {
		
		listaActividades = Unidad_Logica.getInstance().listaDeHoy();
		if(listaActividades.isEmpty()==false){
		mergesort(listaActividades,0,listaActividades.lastIndexOf(listaActividades)+1);
		return listaActividades;
		}else return listaActividades;
	}


	public  void mergesort(List<Actividad> listaActividades,int izq, int der){
	    if (izq<der){
	            int m=(izq+der)/2;
	            mergesort(listaActividades,izq, m);
	            mergesort(listaActividades,m+1, der);
	            merge(listaActividades,izq, m, der);
	    }
	}
	
	public static void merge(List<Actividad> A,int izq, int m, int der){
		   int i, j, k;
		   List<Actividad> B = new ArrayList<Actividad>(); //array auxiliar
		   for (i=izq; i<=der; i++) //copia ambas mitades en el array auxiliar
		             B.set(i,A.get(i));

		             i=izq; j=m+1; k=izq;
		             while (i<=m && j<=der) //copia el siguiente elemento más grande
		             if (B.get(i).getPrioridadTotal()<=B.get(j).getPrioridadTotal())
		                     A.set(k++,B.get(i++));
		             else
		                     A.set(k++, B.get(j++));
		             while (i<=m) //copia los elementos que quedan de la
		                           A.set(k++, B.get(i++)); //primera mitad (si los hay)
		 }
	
}
