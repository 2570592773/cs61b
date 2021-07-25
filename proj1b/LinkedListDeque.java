public class LinkedListDeque<Item> implements Deque<Item> {

    public class ItemNode<Item> {
        public Item item;
        public ItemNode next;
        public ItemNode pre;
        public ItemNode(Item i , ItemNode n, ItemNode p){
            item=i;
            next= n;
            pre=p;
        }
    }
    private int size;
    private ItemNode sentinel;
    public LinkedListDeque(){
        sentinel=new ItemNode(null,null,null);
        sentinel.next=sentinel;
        sentinel.pre=sentinel;
        size=0;
    }
    /*public LinkedListDeque(T item){
        sentinel=new ItemNode(null,null,null);
        sentinel.next=new ItemNode(item,sentinel,sentinel);
        sentinel.pre=sentinel.next;
        size=1;
    }*/
    @Override
    public void addFirst(Item item){
        sentinel.next.pre=new ItemNode(item,sentinel.next,sentinel);
        sentinel.next=sentinel.next.pre;
        size+=1;
    }
    @Override
    public void addLast(Item item){
        sentinel.pre.next=new ItemNode(item,sentinel,sentinel.pre);
        sentinel.pre=sentinel.pre.next;
        size+=1;
    }
    @Override
    public boolean isEmpty(){
        if(sentinel.next==sentinel){
            return true;
        }
        return false;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        ItemNode p=sentinel;
        while(p.next!=sentinel){
            System.out.print(p.next.item+" ");
            p=p.next;
        }
        System.out.println();
    }
    @Override
    public Item removeFirst(){
        if(sentinel==sentinel.next){
            return null;
        }
        Item t= (Item) sentinel.next.item;
        sentinel.next.next.pre=sentinel;
        sentinel.next=sentinel.next.next;
        size-=1;
        return t;
    }
    @Override
    public Item removeLast(){
        if(sentinel==sentinel.next){
            return null;
        }
        Item t= (Item) sentinel.pre.item;
        sentinel.pre.pre.next=sentinel;
        sentinel.pre=sentinel.pre.pre;
        size-=1;
        return t;
    }
    @Override
    public Item get(int index){
        if(index<0 || index>size-1){
            return null;
        }
        ItemNode p=sentinel;
        for(int i=0;i<=index;i++){
            p=p.next;
        }
        return (Item) p.item;
    }
    private Item getRecursiveHelp(ItemNode a,int i){
        if(i==0){
            return (Item) a.next.item;
        }
        else{
            a=a.next;
            i--;
        }
        return getRecursiveHelp(a,i);
    }
    public Item getRecursive(int index){
        if(index<0 || index>size-1){
            return null;
        }
        ItemNode p=sentinel;
        return getRecursiveHelp(p,index);
    }

    /*public static void main(String [] args){
        //LinkedListDeque<Integer> l=new LinkedListDeque<>(1);
        LinkedListDeque<Integer> l=new LinkedListDeque<>();
        l.addFirst(3);
        l.addFirst(2);
        l.addLast(4);
        System.out.println(l.size());
        System.out.println(l.isEmpty());
        l.printDeque();
        l.removeFirst();
        l.printDeque();
        int i= (int) l.removeLast();
        l.printDeque();
        System.out.println(i);
        System.out.println(l.get(2));
        System.out.println(l.getRecursive(0));
    }*/



}
