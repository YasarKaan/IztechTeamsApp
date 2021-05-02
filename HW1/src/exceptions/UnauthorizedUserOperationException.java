package exceptions;

public class UnauthorizedUserOperationException extends Exception{

    private String message="Unauthorized User!";
    public UnauthorizedUserOperationException(){}
    public String getMessage() {
        return message;
    }

}