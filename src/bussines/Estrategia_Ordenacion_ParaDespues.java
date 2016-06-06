package bussines;

import java.util.ArrayList;
import java.util.List;


public class Estrategia_Ordenacion_ParaDespues implements Estrategia_Ordenacion_Actividades{

	private List<Actividad> listaActividades;
	@Override
	public List<Actividad> ordenar() {
		
		 listaActividades = Unidad_Logica.getInstance().listaDeParaDespues();
		 if(listaActividades.isEmpty()==false){
		 burbuja();
		 return listaActividades;
		 }else return listaActividades;
	}
	
	
	public void burbuja(){ 
		
	int	n=listaActividades.size()-1; 
	for	(int i=0; i<n; i++){
		for(int j=n; j>i; j--){ 
		 Actividad elementoX = listaActividades.get(j-1);
		 Actividad elementoY = listaActividades.get(j);
		
		 if(elementoX.getFechaFinalizacion().isAfter(elementoY.getFechaFinalizacion())){
		  listaActividades.set(j-1 ,elementoY);
		  listaActividades.set(j,elementoX);
		}
	   }
      }
	}
}
