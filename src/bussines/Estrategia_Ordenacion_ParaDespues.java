package bussines;


import java.util.List;


public class Estrategia_Ordenacion_ParaDespues implements Estrategia_Ordenacion_Actividades{

	private List<Actividad> listaActividades;
	@Override
	public List<Actividad> ordenar() {
		
		 listaActividades = Unidad_Logica.getInstance().listaDeParaDespues();
		 if(listaActividades.isEmpty()==false){
		 System.out.println(prioridades());
	     burbuja();
		 System.out.println(prioridades());
		 return listaActividades;
		 }else return listaActividades;
	}
	public String prioridades(){
		int i = 0;
		String res = "";
		while (i<listaActividades.size()) {
			res = res + listaActividades.get(i).getFechafinalizacion()+"\n"; 
			i++;
		}
		return res;
		
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
