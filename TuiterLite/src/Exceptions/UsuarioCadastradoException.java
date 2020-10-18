package Exceptions;

public class UsuarioCadastradoException extends Exception{
    public String getMessage() {
        return "Usuário não cadastrado!";
    }
}
