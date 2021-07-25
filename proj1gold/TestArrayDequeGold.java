import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayDeque;

public class TestArrayDequeGold {
    @Test
    public void textStudentArrayDeque(){
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<Integer>();
        String message = "";
        int i = 0;
        while (i < 10) {
            Integer j = StdRandom.uniform(100);
            if (i % 2 == 0) {
                sad1.addLast(j);
                sad2.addLast(j);
                message += "addLast(" + j + ")\n";
                assertEquals(message, j, sad1.get(sad1.size()-1));
            } else {
                sad1.addFirst(j);
                sad2.addFirst(j);
                message += "addFirst(" + j + ")\n";
                assertEquals(message, j, sad1.get(0));
            }
            i++;
        }
        while (i > 0) {
            if (i % 2 == 0) {
                Integer actual = sad1.removeFirst();
                Integer expect = sad2.removeFirst();
                message += "removeFirst()\n";
                assertEquals(message, expect, actual);
            } else {
                Integer actual = sad1.removeLast();
                Integer expect = sad2.removeLast();
                message += "removeLast()\n";
                assertEquals(message, expect, actual);
            }
            i--;
        }
    }
}
