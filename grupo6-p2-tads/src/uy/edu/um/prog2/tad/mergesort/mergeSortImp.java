package uy.edu.um.prog2.tad.mergesort;

public class mergeSortImp {
    public int[] mergesort( int [] lista, int length){
        if(length<2){// si el tamanio de la lista es menor a 2 no voy a tener que hacer nada entonces retorno la lista
            return lista;
        }
        int pivot=length/2;// ubico el centro de mi lista como pivot
        int[] der=new int [length-pivot];// creo lista del tamanio de el largo de lsita menos pivot
        // en el caso que el length sea un numeor no dividible entre dos me va a quedar mas grande
        int[] izq= new int [pivot];

        for (int i=0;i<pivot; i ++){// paso todos valores a la lista izquierda hasta el pivot
            izq[i]=lista[i];
        }
        for(int j=pivot;j<length;j++){// paso todos los valores desde el pivot hasta el final
            der[j-pivot]=lista[j];
        }
        mergesort(izq,pivot);// aplico recursividad en la lista izquierda
        mergesort(der,length-pivot);//aplico recursividad en la lista drecha para que se sigan separando
        merge(lista,izq,der,pivot,length-pivot);

        return lista ;
    }
    public void merge(int [] list, int[] izq, int[] der, int pivot,int pivot1){
        int a=0;//indice de izquierda
        int b=0;//indice de derecha
        int c=0;//indice de list
        while (a<pivot && b< pivot1){
            if(izq[a]<=der[b]){
                list[c++]=izq[a++];
            }else {
                list[c++]=der[b++];
            }
        }
        while(a<pivot){
            list[c++]=izq[a++];

        }
        while(b<pivot1){
            list[c++]=der[b++];
        }
    }

}
