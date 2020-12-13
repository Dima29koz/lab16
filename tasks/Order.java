package tasks;

public interface Order {
    boolean add(Item item);
    boolean remove(String name);
    int removeAll(String name);
    int getQuantity();
    int getQuantity(String name);
    double costTotal();
    Item[] getItems();
    String[] getNames();
    Item[] getSorted();
}
