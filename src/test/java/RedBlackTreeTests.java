import org.junit.jupiter.api.*;

import java.util.Random;
import static org.junit.Assert.assertEquals;


public class RedBlackTreeTests {

    private static final Long SEED = 123123L;
    private static final Random RAND = new Random(SEED);

    private static int rand(){
        return RAND.nextInt();
    }

    private static RedBlackTree testing;

    private static final long I = 500;

    private void fill(int k) {
        for(int i = 0; i < k; i++){
            testing.insertNode(rand());
        }
    }

    private void prepare(String method, int k) {
        System.out.println("testing " + method + " " + k + " : ");
        fill(k);
    }


    @BeforeEach
    void beforeEach(){
        testing = new RedBlackTree();
    }


    @Test
    void insert10000() {
        int j = 10000;
        prepare("insert", j);
        for(int i = 0; i < I; i++){
            testing.insertNode(rand());
        }
        assertEquals(true, true);
    }

    @Test
    void insert20000() {
        int j = 20000;
        prepare("insert", j);
        for(int i = 0; i < I; i++){
            testing.insertNode(rand());
        }
        assertEquals(true, true);
    }

    @Test
    void insert30000(){
        int j = 30000;
        prepare("insert", j);
        for(int i = 0; i < I; i++){
            testing.insertNode(rand());
        }
        assertEquals(true, true);
    }

    @Test
    void insert40000() {
        int j = 40000;
        prepare("insert", j);
        for(int i = 0; i < I; i++){
            testing.insertNode(rand());
        }
        assertEquals(true, true);
    }

    @Test
    void search10000()  {
        int j = 10000;
        prepare("contains", j);
        for(int i = 0; i < I; i++){
            testing.searchNode(rand());
        }
        assertEquals(true, true);
    }

    @Test
    void search20000() {
        int j = 20000;
        prepare("contains", j);
        for(int i = 0; i < I; i++){
            testing.searchNode(rand());
        }
        assertEquals(true, true);
    }

    @Test
    void search30000() {
        int j = 30000;
        prepare("contains", j);
        for(int i = 0; i < I; i++){
            testing.searchNode(rand());
        }
        assertEquals(true, true);
    }

    @Test
    void search40000() {
        int j = 40000;
        prepare("contains", j);
        for(int i = 0; i < I; i++){
            testing.searchNode(rand());
        }
        assertEquals(true, true);
    }

    @Test
    void delete10000() {
        int j = 10000;
        prepare("remove", j);
        for(int i = 0; i < I; i++){
            testing.deleteNode(rand());
        }
        assertEquals(true, true);
    }

    @Test
    void delete20000() {
        int j = 20000;
        prepare("remove", j);
        for(int i = 0; i < I; i++){
            testing.deleteNode(rand());
        }
        assertEquals(true, true);
    }

    @Test
    void delete30000() {
        int j = 30000;
        prepare("remove", j);
        for(int i = 0; i < I; i++){
            testing.deleteNode(rand());
        }
        assertEquals(true, true);
    }

    @Test
    void delete40000() {
        int j = 40000;
        prepare("remove", j);
        for(int i = 0; i < I; i++){
            testing.deleteNode(rand());
        }
        assertEquals(true, true);
    }
}
