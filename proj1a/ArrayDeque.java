import java.util.Objects;

public class ArrayDeque<T> {
    private int size;
    private int nextFirst=4;
    private int nextLast=5;
    private T[] items;
    private int refactor=3;
    public ArrayDeque(){
        items= (T[]) new Object[8];
        size=0;
    }
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if(nextFirst==size)
        {
            System.arraycopy(items, 0, a, nextFirst+1, size);
            nextLast=nextFirst+size+1;
        }
        else{
            System.arraycopy(items, nextFirst+1, a, nextFirst+1, items.length-nextFirst-1);
            System.arraycopy(items, 0, a, items.length, nextLast);
            nextLast=size+nextFirst+1;
        }
        items = a;
    }

    public void addFirst(T item){
        if(nextFirst==nextLast){
            resize(size*refactor);
        }
        items[nextFirst]=item;
        if(nextFirst==0){
            nextFirst=nextFirst+items.length-1;
        }
        else nextFirst-=1;
        size+=1;
    }
    public void addLast(T item){
        if(nextFirst==nextLast){
            resize(size*refactor);
        }
        items[nextLast]=item;
        if(nextLast==items.length-1){
            nextLast=nextLast-items.length+1;
        }
        else nextLast+=1;
        size+=1;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        if(nextFirst<nextLast && size!=items.length){
            for(int i=nextFirst+1;i<nextLast;i++){
                System.out.print(items[i]);
            }
        }
        else{
            if(nextFirst==items.length){
                for(int i=0;i<nextLast;i++){
                    System.out.print(items[i]);
                }
            }
            else{
                for(int i=nextFirst+1;i<items.length;i++){
                    System.out.print(items[i]);
                }
                for(int i=0;i<nextLast;i++){
                    System.out.print(items[i]);
                }
            }
        }
        System.out.println();
    }

    public T removeFirst(){
        if(size==0){
            return null;
        }
        T i;
        if(nextFirst==items.length-1){
            i=items[0];
            items[0]=null;
            nextFirst=0;
        }
        else {
            i=items[nextFirst+1];
            items[nextFirst+1]=null;
            nextFirst=nextFirst+1;
        }
        size--;
        return i;
    }
    public T removeLast(){
        if(size==0){
            return null;
        }
        T i;
        if(nextLast==0){
            i=items[items.length-1];
            items[items.length-1]=null;
            nextLast=items.length-1;
        }
        else {
            i=items[nextLast-1];
            items[nextLast-1]=null;
            nextLast=nextLast-1;
        }
        size--;
        return i;
    }
    public T get(int index){
        if(index<0 || index>=size){
            return null;
        }
        if(nextFirst+index+1>items.length-1){
            return items[nextFirst+index+1-items.length];
        }
        return items[nextFirst+index+1];
    }
    /*public static void main(String [] args){
        ArrayDeque l=new ArrayDeque();
        l.addFirst(3);
        l.addFirst(2);
        l.addLast(4);
        l.addLast(5);
        l.addLast(6);
        l.addLast(7);
        l.addLast(8);
        l.addLast(9);
        l.addLast(10);
        l.addFirst(1);
        System.out.println(l.size());
        l.printDeque();
        int j= (int) l.removeFirst();
        System.out.println(j);
        l.printDeque();
        int i= (int) l.removeLast();
        l.printDeque();
        System.out.println(l.size());
        System.out.println(l.get(8));
    }*/
}
