package Exceptions;

public class TamMaxTuiteUltrapassadoException extends Exception{
    public String getMessage() {
        return "Tamanho máximo de caracteres ultrapassado!";
    }
}
