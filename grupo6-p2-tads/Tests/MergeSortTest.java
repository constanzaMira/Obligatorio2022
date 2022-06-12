import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.mergesort.mergeSortImp;

import java.util.Arrays;

public class MergeSortTest {
    @Test
    public void mergeSort(){
        mergeSortImp merge= new mergeSortImp();
        int[] pr={90,60,43,2,4};
        Assertions.assertEquals(Arrays.toString(new int[]{2, 4, 43, 60, 90}) ,Arrays.toString(merge.mergesort(pr, pr.length)) );
        int [] ue={};
        Assertions.assertEquals(Arrays.toString(new int[]{}) ,Arrays.toString(merge.mergesort(ue, ue.length)) );
        int[] ba={90,6,43,78,1,90,7,88,-1,-50};
        Assertions.assertEquals(Arrays.toString(new int[]{-50,-1,1,6,7,43,78,88,90,90}) ,Arrays.toString(merge.mergesort(ba, ba.length)) );
    }

}
