package exception;

public class InvalidTicketException extends Exception{
    public InvalidTicketException() {
        super("fail to save the bag, invaild ticket");
    }

}
