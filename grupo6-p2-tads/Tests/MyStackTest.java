import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.linkedlist.LinkedList;
import uy.edu.um.prog2.tad.stack.EmptyStackException;
import uy.edu.um.prog2.tad.stack.MyStack;

import java.security.PublicKey;
import java.sql.ClientInfoStatus;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {

    MyStack<Integer> pila;

    @BeforeEach
    public void setUp() {
        pila = new LinkedList<>();
        pila.push(6);
        pila.push(8);
        pila.push(2);
        pila.push(-3);
        pila.push(-8);
        pila.push(0);
        pila.push(-4);
    }

    @Test
    public void push_pop_Test() throws EmptyStackException {
        int[] actual = new int[7];
        int[] expected = {-4,0,-8,-3,2,8,6};

        for (int i = 0; i < 7; i++) {
            actual[i] = pila.pop();
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    public void size_Test () {
        assertEquals(7, pila.size());
    }

    @Test
    public void top_Test() throws EmptyStackException {
        assertEquals(-4, pila.top());
    }

    @Test
    public void isEmpty_Test() {
        MyStack<Integer> pila2 = new LinkedList<>();

        boolean[] actual = {pila.isEmpty(), pila2.isEmpty()};
        boolean[] expected = {false, true};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void makeEmpty() {
        pila.makeEmpty();

        assertTrue(pila.isEmpty());
    }

    @Test
    public void contains_Test() {
        boolean[] actual = {pila.contains(2), pila.contains(-8), pila.contains(100)};
        boolean[] expected = {true, true, false};

        assertArrayEquals(expected, actual);
    }
}
