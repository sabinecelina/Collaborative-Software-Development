package de.hfu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    private Queue queue;
    @Before
    public void createQueue(){
        queue = new Queue(3);
    }
    @Test (expected = IllegalStateException.class, timeout = 1000)
    public void qeueTestEmpty(){
        queue.dequeue();
    }
    @Test
    public void queueTest(){
        for(int i = 1; i<= 3; i++){
            queue.enqueue(i);
        }
        for(int j = 1; j<=3; j++){
            assertEquals(j, queue.dequeue());
        }
        for(int k = 1; k<=4;k++){
            queue.enqueue(k);
        }
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(4, queue.dequeue());
    }
}
