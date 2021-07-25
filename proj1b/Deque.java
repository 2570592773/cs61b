public interface Deque<Item> {
    public abstract  void addFirst(Item item);
    public abstract  void addLast(Item item);
    public abstract boolean isEmpty();
    public abstract int size();
    public abstract void printDeque();
    public abstract Item removeFirst();
    public abstract Item removeLast();
    public abstract Item get(int index);
}
