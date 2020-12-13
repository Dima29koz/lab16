package tasks;

import java.util.Arrays;

public class RestaurantOrder implements Order{
    private int size;
    private Item[] items;

    public RestaurantOrder() {
        size = 0;
        items = new Item[20];
    }

    @Override
    public boolean add(Item item){
        if (size + 2 > items.length){
            Item[] tmp_items = new Dish[items.length * 2];
            System.arraycopy(items, 0, tmp_items, 0, tmp_items.length);
            items = tmp_items;
        }
        try {
            items[size] = item;
            size++;
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean remove(String name){
        for (int i =0; i < items.length; i++){
            if (items[i].getName().equals(name)){
                if (i == size){
                    items[i] = null;
                }
                else{
                    if (size - 1 - i >= 0)
                        System.arraycopy(items, i + 1, items, i, size - 1 - i);
                    items[size] = null;
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeAll(String name){
        int counter = 0;
        while (remove(name)){
            counter++;
        }
        return counter;
    }

    @Override
    public int getQuantity(){
        return size;
    }

    @Override
    public int getQuantity(String name){
        int counter = 0;
        for (Item item : items) {
            if (item.getName().equals(name)) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public double costTotal(){
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public Item[] getItems() {
        return items;
    }

    @Override
    public String[] getNames(){
        String[] out = new String[size];
        for (int i=0; i< size; i++){
            out[i] = items[i].getName();
        }
        return out;
    }

    @Override
    public Item[] getSorted() {
        return (Item[]) Arrays.stream(items).sorted().toArray();
    }
}
