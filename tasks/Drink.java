package tasks;

public final class Drink implements Item, Comparable<Drink>{
    private final double price;
    private final String name;
    private final String description;

    public Drink(double price, String name, String description) throws IllegalArgumentException{
        if (price < 0 || name == null || description == null)
            throw new IllegalArgumentException("Невозможно создать напиток с такими параметрами");
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public Drink(String name, String description) throws IllegalArgumentException{
        if (name == null || description == null)
            throw new IllegalArgumentException("Невозможно создать напиток с такими параметрами");
        this.name = name;
        this.description = description;
        this.price = 0;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Drink drink) {
        if (this.price == drink.price) {
            return 0;
        } else if (this.price < drink.price) {
            return -1;
        } else {
            return 1;
        }
    }
}
