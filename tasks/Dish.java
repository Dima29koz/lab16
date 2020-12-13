package tasks;

public final class Dish implements  Item, Comparable<Dish>{
    private final double price;
    private final String name;
    private final String description;

    public Dish(double price, String name, String description) throws IllegalArgumentException{
        if (price < 0 || name == null || description == null)
            throw new IllegalArgumentException("Невозможно создать блюдо с такими параметрами");
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public Dish(String name, String description) throws IllegalArgumentException{
        if (name == null || description == null)
            throw new IllegalArgumentException("Невозможно создать блюдо с такими параметрами");
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
    public int compareTo(Dish dish) {
        if (this.price == dish.price) {
            return 0;
        } else if (this.price < dish.price) {
            return -1;
        } else {
            return 1;
        }
    }
}
