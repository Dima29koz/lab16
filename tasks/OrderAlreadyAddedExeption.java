package tasks;

public class OrderAlreadyAddedExeption extends RuntimeException{
    public OrderAlreadyAddedExeption(String errorMessage){
        super (errorMessage);
    }

}
