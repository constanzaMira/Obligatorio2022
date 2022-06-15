import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.arraylist.ArrayList;
import uy.edu.um.prog2.tad.arraylist.IndexOutOfBounds;
import uy.edu.um.prog2.tad.arraylist.MyArrayList;

public class MyArrayListTest {

    MyArrayList<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new ArrayList<>();
        lista.add(5);
        lista.add(3);
        lista.add(8);
        lista.add(-9);
        lista.add(10);
        lista.add(64);
    }

    @Test
    public void add_get_Test() {
        int[] actual = new int[6];
        int[] expected = {5,3,8,-9,10,64};

        for (int i = 0; i < 6; i++) {
            actual[i] = lista.get(i);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void size_Test() {
        lista.add(23);
        lista.add(80);

        assertEquals(8, lista.size());
    }

    @Test
    public void remove_Test() throws IndexOutOfBounds {
        lista.remove(4);
        lista.remove(2);

        int[] actual = new int[lista.size()];
        int[] expected = {5,3,64,-9};

        for (int i = 0; i < lista.size(); i++) {
            actual[i] = lista.get(i);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void set_Test() throws IndexOutOfBounds {
        lista.set(0, 45);
        lista.set(5, 100);
        lista.set(3, -7);

        int[] actual = new int[6];
        int[] expected = {45,3,8,-7,10,100};

        for (int i = 0; i < 6; i++) {
            actual[i] = lista.get(i);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void contains_Test() {
        boolean[] expected = {true, false};
        boolean[] actual = {lista.contains(5), lista.contains(100)};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void makeLarger_Test() {

        for (int i = 0; i < 20; i++) {
            lista.add(i);
        }

        int[] actual = new int[26];
        int[] expected = {5,3,8,-9,10,64,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};

        for (int i = 0; i < lista.size(); i++) {
            actual[i] = lista.get(i);
        }

        assertArrayEquals(expected, actual);
    }


}
