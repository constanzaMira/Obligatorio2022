import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.linkedlist.LinkedList;
import uy.edu.um.prog2.tad.linkedlist.MyList;

public class MyLinkedListTest {
    MyList<Integer> lista;

    @BeforeEach
    public void setUp() {
        lista = new LinkedList<>();
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
    public void remove_Test() {
        lista.remove(4);
        lista.remove(2);

        int[] actual = new int[lista.size()];
        int[] expected = {5,3,-9,64};

        for (int i = 0; i < lista.size(); i++) {
            actual[i] = lista.get(i);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeObj_Test() {
        lista.removeObj(64);
        lista.removeObj(5);
        lista.removeObj(8);

        int[] actual = new int[lista.size()];
        int[] expected = {3,-9,10};

        for (int i = 0; i < lista.size(); i++) {
            actual[i] = lista.get(i);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void set_Test() {
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
    public void append_Test() {
        MyList<Integer> lista2 = new LinkedList<>();
        lista2.add(24);
        lista2.add(-24);
        lista2.add(16);
        lista2.add(73);
        lista2.add(47);

        MyList<Integer> lista3 = lista.append(lista2);

        int[] expected = {5,3,8,-9,10,64,24,-24,16,73,47};
        int[] actual = new int[lista3.size()];

        for (int i = 0; i < lista3.size(); i++) {
            actual[i] = lista3.get(i);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void intercambiar_Test() {
        lista.intercambiar(5, -1);
        lista.intercambiar(64, 1);
        lista.intercambiar(-9, 1);

        int[] actual = new int[lista.size()];
        int[] expected = {3,64,8,10,-9,5};

        for (int i = 0; i < lista.size(); i++) {
            actual[i] = lista.get(i);
        }
        assertArrayEquals(expected, actual);
    }
}
