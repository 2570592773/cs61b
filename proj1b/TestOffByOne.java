import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('c', 'd'));
        assertFalse(offByOne.equalChars('c', 'c'));
    }

    @Test
    public void testIsPalindrome() {
        OffByOne offByOne1=new OffByOne();
        assertFalse(offByOne1.isPalindrome("persiflage"));
        assertTrue(offByOne1.isPalindrome(""));
        assertTrue(offByOne1.isPalindrome("A"));
        assertTrue(offByOne1.isPalindrome("AB"));
        assertFalse(offByOne1.isPalindrome("abcba"));
        assertTrue(offByOne1.isPalindrome("flake"));
    }
}
