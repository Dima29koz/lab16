package tasks;

import javax.swing.*;
import java.util.HashMap;

public class OrderManager {
    private final HashMap<Integer, Order> restaurantOrders;
    private final HashMap<String, Order> intetnetOrders;

    public OrderManager() {
        restaurantOrders = new HashMap<>();
        intetnetOrders = new HashMap<>();
    }

    public void add(int tableNum, RestaurantOrder restaurantOrder) throws OrderAlreadyAddedExeption{
        if (restaurantOrders.containsKey(tableNum)){
            throw new OrderAlreadyAddedExeption("Очередь для столика с этим номером уже существует");
        }
        else {
            restaurantOrders.put(tableNum, restaurantOrder);
        }
    }

    public void add(String adress, InternetOrder internetOrder) throws OrderAlreadyAddedExeption{
        if (intetnetOrders.containsKey(adress)){
            throw new OrderAlreadyAddedExeption("Очередь для данного адреса уже существует");
        }
        else {
            intetnetOrders.put(adress, internetOrder);
        }
    }

    public Order getOrder(int tableNum) throws IllegalTableNumber {
        if(!restaurantOrders.containsKey(tableNum))
            throw new IllegalTableNumber("Указанного столика не существует");
        return restaurantOrders.get(tableNum);
    }

    public Order getOrder(String adress)
    {
        return intetnetOrders.get(adress);
    }

    public void removeOrder(int tableNum) throws IllegalTableNumber {
        if(!restaurantOrders.containsKey(tableNum))
            throw new IllegalTableNumber("Указанного столика не существует");
        restaurantOrders.remove(tableNum);
    }

    public void removeOrder(String adress){
        intetnetOrders.remove(adress);
    }

    public void addItem(int tableNum, Item item) throws IllegalTableNumber {
        if(!restaurantOrders.containsKey(tableNum))
            throw new IllegalTableNumber("Указанного столика не существует");
        restaurantOrders.get(tableNum).add(item);
    }

    public void addItem(String adress, Item item){
        intetnetOrders.get(adress).add(item);
    }

    public Order[] getRestaurantOrders(){
        return restaurantOrders.values().toArray(new Order[0]);
    }

    public Order[] getInternetOrders(){
        return intetnetOrders.values().toArray(new Order[0]);
    }

    public double restaurantOredersCostSummary(){
        Order[] orders = getRestaurantOrders();
        double result = 0;
        for (Order order : orders){
            result += order.costTotal();
        }
        return result;
    }
    public double internetOredersCostSummary(){
        Order[] orders = getInternetOrders();
        double result = 0;
        for (Order order : orders){
            result += order.costTotal();
        }
        return result;
    }

    public int getItemRestaurantQuantity(String name){
        int result = 0;
        Order[] orders = getRestaurantOrders();
        for (Order order : orders){
            result += order.getQuantity(name);
        }
        return result;
    }

    public int getItemInternetQuantity(String name){
        int result = 0;
        Order[] orders = getInternetOrders();
        for (Order order : orders){
            result += order.getQuantity(name);
        }
        return result;
    }
}
