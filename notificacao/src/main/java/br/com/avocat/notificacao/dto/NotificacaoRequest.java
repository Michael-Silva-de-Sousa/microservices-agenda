package br.com.avocat.notificacao.dto;

public record NotificacaoRequest (
        Integer toCustomerId,
        Integer toCustomerName,
        String message
) {}
