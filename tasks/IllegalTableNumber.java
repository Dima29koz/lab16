package tasks;

public class IllegalTableNumber extends Exception{
    public IllegalTableNumber(String errorMessage){
        super(errorMessage);
    }
}
