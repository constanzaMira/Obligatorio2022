import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.linkedlist.LinkedList;
import uy.edu.um.prog2.tad.queue.EmptyQueueException;
import uy.edu.um.prog2.tad.queue.MyDoubleQueue;
import static org.junit.jupiter.api.Assertions.*;

public class MyDoubleQueueTest {

    MyDoubleQueue<Integer> colaDoble;

    @BeforeEach
    public void setUp() {
        colaDoble = new LinkedList<>();
        colaDoble.enqueueRight(34);
        colaDoble.enqueueRight(5);
        colaDoble.enqueueRight(9);
        colaDoble.enqueueRight(0);
        colaDoble.enqueueRight(2);
        colaDoble.enqueueRight(24);
    }

    @Test
    public void enqueueRight_dequeueLeft_Test() throws EmptyQueueException {
        int[] expected = {34, 5, 9, 0, 2, 24};
        int[] actual = new int[6];

        for (int i = 0; i < 6; i++) {
            actual[i] = colaDoble.dequeueLeft();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void enqueueLeft_dequeueRight_Test() throws EmptyQueueException {
        colaDoble.enqueueLeft(42);
        colaDoble.enqueueLeft(78);

        int[] expected = {24, 2, 0, 9, 5, 34, 42, 78};
        int[] actual = new int[8];

        for (int i = 0; i < 8; i++) {
            actual[i] = colaDoble.dequeueRight();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void peekLeft_Test() throws EmptyQueueException {
        assertEquals(34, colaDoble.peekLeft());
    }

    @Test
    public void peekRight_Test() throws EmptyQueueException {
        assertEquals(24, colaDoble.peekRight());
    }

    @Test
    public void size_Test() {
        colaDoble.enqueueRight(23);
        colaDoble.enqueueLeft(80);

        assertEquals(8, colaDoble.size());
    }

    @Test
    public void contains_Test() {
        boolean[] actual = {colaDoble.contains(9), colaDoble.contains(300), colaDoble.contains(24)};
        boolean[] expected = {true, false, true};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void isEmpty_Test() {
        assertFalse(colaDoble.isEmpty());
    }
}
