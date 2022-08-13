package br.com.avocat.agenda.exception;

public class AgendaException extends RuntimeException {

    private String descricao;

    public AgendaException(String descricao) {
        super(descricao);
        this.descricao = descricao;
    }

    public AgendaException(String descricao, Throwable e) {
        super(descricao, e);
        this.descricao = descricao;
    }
}
