package Exceptions;

public class EmailInvalidoException extends Exception{
    public String getMessage() {
        return "Email inválido! Formato esperado: nome@email.com";
    }
}
