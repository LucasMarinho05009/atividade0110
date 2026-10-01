package br.com.starlog.exception;

/** Excecao verificada: a chamada deve tratar ou declarar a falta de espaco. */
public class CapacidadeExcedidaException extends Exception {
    private static final long serialVersionUID = 1L;

    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem);
    }
}
