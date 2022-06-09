import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.linkedlist.LinkedList;
import uy.edu.um.prog2.tad.queue.EmptyQueueException;
import uy.edu.um.prog2.tad.queue.MyQueue;

public class MyQueueTest {

    MyQueue<Integer> cola;

    @BeforeEach
    public void setUp() {
        cola = new LinkedList<>();
        cola.enqueue(2);
        cola.enqueue(6);
        cola.enqueue(-1);
        cola.enqueue(11);
        cola.enqueue(-67);
        cola.enqueue(14);
    }

    @Test
    public void enqueue_dequeue_Test() throws EmptyQueueException {
        int[] actual = new int[6];
        int[] expected = {2,6,-1,11,-67,14};

        for (int i = 0; i < 6; i++) {
            actual[i] = cola.dequeue();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void size_Test() {
        assertEquals(6, cola.size());
    }

    @Test
    public void peek_Test() throws EmptyQueueException {
        assertEquals(2, cola.peek());
    }

    @Test
    public void isEmpty_Test() {
        MyQueue<Integer> cola2 = new LinkedList<>();

        boolean[] actual = {cola.isEmpty(), cola2.isEmpty()};
        boolean[] expected = {false, true};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void contains_Test() {
        boolean[] actual = {cola.contains(-1), cola.contains(300), cola.contains(14)};
        boolean[] expected = {true, false, true};

        assertArrayEquals(expected, actual);
    }
}
