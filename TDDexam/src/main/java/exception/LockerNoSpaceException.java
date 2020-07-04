package exception;

public class LockerNoSpaceException extends Exception {
    public LockerNoSpaceException() {
        super("fail to save the bag, no space");
    }
}
