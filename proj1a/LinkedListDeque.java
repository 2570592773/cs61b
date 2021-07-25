//import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

public class LinkedListDeque<T> {

    public class ItemNode<T> {
        public T item;
        public ItemNode next;
        public ItemNode pre;
        public ItemNode(T i , ItemNode n, ItemNode p){
            item=i;
            next= n;
            pre=p;
        }
    }
    public int size;
    public ItemNode sentinel;
    public LinkedListDeque(){
        sentinel=new ItemNode(null,null,null);
        sentinel.next=sentinel;
        sentinel.pre=sentinel;
        size=0;
    }
    public LinkedListDeque(T item){
        sentinel=new ItemNode(null,null,null);
        sentinel.next=new ItemNode(item,sentinel,sentinel);
        sentinel.pre=sentinel.next;
        size=1;
    }
    public void addFirst(T item){
        sentinel.next.pre=new ItemNode(item,sentinel.next,sentinel);
        sentinel.next=sentinel.next.pre;
        size+=1;
    }
    public void addLast(T item){
        sentinel.pre.next=new ItemNode(item,sentinel,sentinel.pre);
        sentinel.pre=sentinel.pre.next;
        size+=1;
    }
    public boolean isEmpty(){
        if(sentinel.next==sentinel){
            return true;
        }
        return false;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        ItemNode p=sentinel;
        while(p.next!=sentinel){
            System.out.print(p.next.item+" ");
            p=p.next;
        }
        System.out.println();
    }
    public T removeFirst(){
        if(sentinel==sentinel.next){
            return null;
        }
        T t= (T) sentinel.next.item;
        sentinel.next.next.pre=sentinel;
        sentinel.next=sentinel.next.next;
        size-=1;
        return t;
    }
    public T removeLast(){
        if(sentinel==sentinel.next){
            return null;
        }
        T t= (T) sentinel.pre.item;
        sentinel.pre.pre.next=sentinel;
        sentinel.pre=sentinel.pre.pre;
        size-=1;
        return t;
    }
    public T get(int index){
        if(index<0 || index>size-1){
            return null;
        }
        ItemNode p=sentinel;
        for(int i=0;i<=index;i++){
            p=p.next;
        }
        return (T) p.item;
    }
    public T getRecursiveHelp(ItemNode a,int i){
        if(i==0){
            return (T) a.next.item;
        }
        else{
            a=a.next;
            i--;
        }
        return getRecursiveHelp(a,i);
    }
    public T getRecursive(int index){
        if(index<0 || index>size-1){
            return null;
        }
        ItemNode p=sentinel;
        return getRecursiveHelp(p,index);
    }

    /*public static void main(String [] args){
        LinkedListDeque<Integer> l=new LinkedListDeque<>(1);
        LinkedListDeque<Integer> r=new LinkedListDeque<>();
        l.addFirst(3);
        l.addFirst(2);
        l.addLast(4);
        System.out.println(l.size());
        System.out.println(r.isEmpty());
        l.printDeque();
        l.removeFirst();
        l.printDeque();
        int i= (int) l.removeLast();
        l.printDeque();
        System.out.println(i);
        System.out.println(l.get(2));
        System.out.println(l.getRecursive(1));
        System.out.println(-1%8);
    }*/



}
