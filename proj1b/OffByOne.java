public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        try {
            int diff = x - y;
            return diff == 1 || diff == -1;
        } catch (NullPointerException e) {
            return false;
        }
    }
}
