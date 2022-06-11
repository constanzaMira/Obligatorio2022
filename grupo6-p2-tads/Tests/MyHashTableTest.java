import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.tad.hash.HashTable;
import uy.edu.um.prog2.tad.hash.MyHashTableImp;
import uy.edu.um.prog2.tad.hash.NoExiste;


public class MyHashTableTest {
    @Test
    void testPut(){
        HashTable<Integer,Integer> hash = new MyHashTableImp<>();
        try {
            hash.put(3,4);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(5,6);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(9,8);
        } catch (IllegalAccessException e) {
        }
        try {
            Assertions.assertEquals(8,hash.get(9));
        } catch (IllegalAccessException e) {

        }
        Assertions.assertEquals(false, hash.contains(7));
        try {
            hash.put(null,null);
        } catch (IllegalAccessException e) {
        }
    }

    @Test
    void testContains(){
        HashTable<Integer,Integer> hash = new MyHashTableImp<>();
        try {
            hash.put(3,4);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(5,6);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(9,8);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(30,26);
        } catch (IllegalAccessException e) {
        }
        Assertions.assertEquals(true,hash.contains(30));
        Assertions.assertEquals(false,hash.contains(7));
    }

    @Test
    void testSize(){
        HashTable<Integer,Integer> hash = new MyHashTableImp<>();
        try {
            hash.put(3,4);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(5,6);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(9,8);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(30,26);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(6,14);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(90,65);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(34,7);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(22,1);
        } catch (IllegalAccessException e) {
        }
        Assertions.assertEquals(8,hash.size());
    }

    @Test
    void testRemove(){
        HashTable<Integer,Integer> hash = new MyHashTableImp<>();
        try {
            hash.put(3,4);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(5,6);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(9,8);
        } catch (IllegalAccessException e) {
        }
        try {
            hash.put(30,26);
        } catch (IllegalAccessException e) {
        }

        try {
            hash.remove(9);
        } catch (NoExiste e) {
        }
        try {
            hash.remove(30);
        } catch (NoExiste e) {
        }
        Assertions.assertEquals(false,hash.contains(30));
        Assertions.assertEquals(false,hash.contains(9));
    }
}
