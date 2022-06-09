import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.heap.MyHeap;
import uy.edu.um.prog2.tad.queue.EmptyQueueException;
import uy.edu.um.prog2.tad.heap.Heap;
import static org.junit.jupiter.api.Assertions.*;

public class MyHeapTest {

    MyHeap<Integer,Integer> heapMax;
    MyHeap<Integer,Integer> heapMin;

    @BeforeEach
    public void setUp() {
        heapMax = new Heap<>(1);
        heapMax.insert(10,10);
        heapMax.insert(16,16);
        heapMax.insert(8,8);
        heapMax.insert(7,7);
        heapMax.insert(64,64);
        heapMax.insert(4,4);
        heapMax.insert(32,32);
        heapMax.insert(5,5);
        heapMax.insert(9,9);
        heapMax.insert(6,6);

        heapMin = new Heap<>(-1);
        heapMin.insert(10,10);
        heapMin.insert(16,16);
        heapMin.insert(8,8);
        heapMin.insert(7,7);
        heapMin.insert(64,64);
        heapMin.insert(4,4);
        heapMin.insert(32,32);
        heapMin.insert(5,5);
        heapMin.insert(9,9);
        heapMin.insert(6,6);
    }

    @Test
    public void heapMax_insert_toArray_Test() {
        int[] expected = {64,16,32,9,10,4,8,5,7,6};
        int[] actual = new int[10];

        for (int i = 0; i < 10; i++) {
            actual[i] = heapMax.getContenido().get(i).getData();
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    public void heapMin_insert_Test() {
        int[] expected = {4,5,7,8,6,10,32,16,9,64};
        int[] actual = new int[10];

        for (int i = 0; i < 10; i++) {
            actual[i] = heapMin.getContenido().get(i).getData();
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    public void contains_Test() {
        boolean[] actual = {heapMax.contains(9), heapMax.contains(300), heapMin.contains(32)};
        boolean[] expected = {true, false, true};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void size_Test() {
        assertEquals(10, heapMax.size());
    }

    @Test
    public void find_Test() {
        assertEquals(8, heapMin.find(8));
    }

    @Test
    public void remove_Test() {
        int num = heapMax.remove(6);

        assertTrue(num == 6 && !heapMax.contains(6));
    }

    @Test
    public void delete_Test() {
        heapMax.delete(64);

        assertFalse(heapMax.contains(64));
    }

    @Test
    public void print_Test() {
        System.out.println("Prueba de Mostrar Heap:");
        System.out.print("HeapMax = ");
        heapMax.print();
        System.out.println();
        System.out.print("HeapMin = ");
        heapMin.print();
    }
}
