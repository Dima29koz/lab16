package tasks;

import java.util.Arrays;

public class InternetOrder implements Order{
    private int size;
    private ListNode head;

    public InternetOrder(){
        size = 0;
        head = null;
    }

    public InternetOrder(RestaurantOrder restaurantOrder){
        Item[] items = restaurantOrder.getItems();
        for (Item item : items) {
            add(item);
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public boolean add(Item item){
        if (isEmpty())
            head = new ListNode(item);
        else{
            ListNode tmp = head;
            head = new ListNode(item, tmp, null);
            head.next.previous = head;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(String name){
        if (isEmpty()) return false;

        //если элемент вначале списка
        if (head.item.getName().equals(name)){
            head = head.next;
            head.previous = null;
            return true;
        }

        ListNode cur = head.next;
        while (cur != null){
            if (cur.item.getName().equals(name)){
                cur.previous.next = cur.next;
                if (cur.next != null)
                    cur.next.previous = cur.previous;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int removeAll(String name){
        int counter = 0;
        while (remove(name))
            counter++;
        return counter;
    }

    @Override
    public int getQuantity() {
        return size;
    }

    @Override
    public int getQuantity(String name){
        int counter = 0;
        ListNode cur = head;
        while(cur != null){
            if (cur.item.getName().equals(name))
                counter++;
            cur = cur.next;
        }
        return counter;
    }

    @Override
    public double costTotal(){
        double total = 0;
        ListNode cur = head;
        while(cur != null){
            total+=cur.item.getPrice();
            cur = cur.next;
        }
        return total;
    }

    @Override
    public Item[] getItems(){
        Item[] items = new Item[size];
        ListNode cur = head;
        int i=0;
        while(cur != null){
            items[i] = cur.item;
            cur = cur.next;
            i++;
        }
        return items;
    }

    @Override
    public String[] getNames() {
        String[] out = new String[size];
        ListNode cur = head;
        int i=0;
        while(cur != null){
            out[i] = cur.item.getName();
            cur = cur.next;
            i++;
        }
        return out;
    }

    @Override
    public Item[] getSorted() {
        return (Item[]) Arrays.stream(getItems()).sorted().toArray();
    }

}
