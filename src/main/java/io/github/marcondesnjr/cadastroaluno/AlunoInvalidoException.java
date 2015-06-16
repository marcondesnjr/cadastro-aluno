package io.github.marcondesnjr.cadastroaluno;

/**
 *
 * @author José Marcondes do Nascimento Junior
 */
public class AlunoInvalidoException extends Exception {

    public AlunoInvalidoException() {
    }

    public AlunoInvalidoException(String message) {
        super(message);
    }

    public AlunoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlunoInvalidoException(Throwable cause) {
        super(cause);
    }

    public AlunoInvalidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
