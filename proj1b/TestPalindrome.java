import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("persiflage"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("A"));
        assertFalse(palindrome.isPalindrome("AB"));
        assertFalse(palindrome.isPalindrome(null));
        assertTrue(palindrome.isPalindrome("abcba"));
        assertFalse(palindrome.isPalindrome("abCBa"));
    }
    @Test
    public void testOffByOneIsPalindrome() {
        CharacterComparator offByOne=new OffByOne();
        assertFalse(palindrome.isPalindrome("persiflage",offByOne));
        assertTrue(palindrome.isPalindrome("",offByOne));
        assertTrue(palindrome.isPalindrome("A",offByOne));
        assertTrue(palindrome.isPalindrome("AB",offByOne));
        assertFalse(palindrome.isPalindrome("abcba",offByOne));
        assertFalse(palindrome.isPalindrome("aa",offByOne));
        assertFalse(palindrome.isPalindrome(null,offByOne));
        assertTrue(palindrome.isPalindrome("flake",offByOne));
    }
}
