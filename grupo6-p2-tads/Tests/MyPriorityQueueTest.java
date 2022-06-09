import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.linkedlist.LinkedList;
import uy.edu.um.prog2.tad.queue.EmptyQueueException;
import uy.edu.um.prog2.tad.queue.MyPriorityQueue;

public class MyPriorityQueueTest {

    @Test
    public void enqueueWithPriority_Test() throws EmptyQueueException {
        MyPriorityQueue<String> colaPrioridad = new LinkedList<>();
        colaPrioridad.enqueue("Primer Cero");
        colaPrioridad.enqueueWithPriority("Primer Tres", 3);
        colaPrioridad.enqueueWithPriority("Primer Uno", 1);
        colaPrioridad.enqueueWithPriority("Segundo Tres", 3);
        colaPrioridad.enqueueWithPriority("Primer Cuatro", 4);
        colaPrioridad.enqueue("Segundo Cero");
        colaPrioridad.enqueueWithPriority("Segundo Cuatro", 4);

        String[] expected = {"Primer Cuatro", "Segundo Cuatro", "Primer Tres", "Segundo Tres", "Primer Uno", "Primer Cero", "Segundo Cero"};
        String[] actual = new String[7];

        for (int i = 0; i < 7; i++) {
            actual[i] = colaPrioridad.dequeue();
        }
        assertArrayEquals(expected, actual);
    }
}
