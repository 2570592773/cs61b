import javax.swing.text.html.StyleSheet;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        if (word == null){
            return null;
        }
        Deque<Character> deque=new LinkedListDeque<Character>();
        for(int i=0;i<word.length();i++){
            deque.addLast(word.charAt(i));
        }
        return deque;
    }
    private boolean isPalindromeHelp(Deque<Character> deque){
        if(deque.size()<2) {
            return true;
        }
        char i=deque.removeFirst();
        char j=deque.removeLast();
        if(i==j) {
            return isPalindromeHelp(deque);
        }
        else {
            return false;
        }
    }
    public boolean isPalindrome(String word){
        if(word.length()<2) {
            return true;
        }
        Deque<Character> deque=wordToDeque(word);
        return isPalindromeHelp(deque);
    }
}
