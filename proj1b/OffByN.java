public class OffByN implements CharacterComparator{
    int N;
    public OffByN(int N){
        this.N=N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        if(x-y==N || y-x==N) {
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isPalindromeHelp(Deque<Character> deque){
        if(deque.size() < 2) {
            return true;
        }
        char i=deque.removeFirst();
        char j=deque.removeLast();
        if(equalChars(i,j)) {
            return isPalindromeHelp(deque);
        }
        else {
            return false;
        }
    }

    public boolean isPalindrome(String word) {
        if(word.length()<2) {
            return true;
        }
        Palindrome palindrome=new Palindrome();
        Deque<Character> deque=palindrome.wordToDeque(word);
        return isPalindromeHelp(deque);
    }
}
