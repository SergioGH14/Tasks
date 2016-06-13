package bussines;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;




public class Estrategia_Ordenacion_Hoy implements Estrategia_Ordenacion_Actividades {
	
	List<Actividad> listaActividades;
	private Actividad[] array;
	private int length;
	private Actividad[] tempMergArr;
	
public List<Actividad> ordenar(List<Actividad> listaPruebas) {
	listaActividades = listaPruebas;
	List<Actividad> B = new ArrayList<Actividad>();
	Actividad[] listaB = ListAArray(listaActividades);
	if(listaActividades.isEmpty()==false){
    sort(listaB);
	B = ArrayAList(listaB);
	return B;
	}else return B;
		
	}
	@Override
public List<Actividad> ordenar() {
		
		listaActividades = Unidad_Logica.getInstance().listaDeHoy();
		List<Actividad> B = new ArrayList<Actividad>();
		Actividad[] listaB = ListAArray(listaActividades);
		if(listaActividades.isEmpty()==false){
	    sort(listaB);
		B = ArrayAList(listaB);
		return B;
		}else return B;
	}	 
public void sort(Actividad inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new Actividad[length];
        doMergeSort(0, length - 1);
    } 
private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
        	
            if (tempMergArr[i].getPrioridadTotal() <= tempMergArr[j].getPrioridadTotal()) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
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
public Actividad[] ListAArray (List<Actividad> A){
		Actividad [] B = new Actividad [A.size()];
		for(int i = 0; i<A.size();i++){
			B[i]= A.get(i);
		}
		return B;
	}
public List<Actividad> ArrayAList(Actividad[] A){
		List <Actividad> B = new ArrayList<Actividad>();
		for(int i = 0; i < A.length;i++){
			
			B.add(A[i]);
		}
		return B;
	}

	}


