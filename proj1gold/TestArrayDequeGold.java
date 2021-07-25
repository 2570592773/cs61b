import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayDeque;

public class TestArrayDequeGold {
    @Test
    public void textStudentArrayDeque(){
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<Integer>();
        String message = "";
        while (true) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            Integer j = StdRandom.uniform(100);
            Integer k = StdRandom.uniform(100);
            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(j);
                sad2.addLast(j);
                sad1.addLast(k);
                sad2.addLast(k);
                message = "addLast("+j+")\naddLast("+k+")\nremoveFirst()\n";
            } else {
                sad1.addFirst(j);
                sad2.addFirst(j);
                sad1.addFirst(k);
                sad2.addFirst(k);
                message = "addFirst("+j+")\naddFirst("+k+")\nremoveFirst()\n";
            }
            Integer expected = sad2.removeFirst();
            Integer actual = sad1.removeFirst();
            sad2.addFirst(expected);
            sad1.addFirst(actual);
            assertEquals(message, expected, actual);
        }
    }
}
