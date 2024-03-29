package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(5);
        arb.enqueue(3);
        arb.enqueue(7);
        arb.enqueue(10);
        System.out.println(arb.dequeue());
        System.out.println(arb.peek());
        System.out.println(arb.dequeue());
        System.out.println(arb.dequeue());
        System.out.println(arb.peek());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
