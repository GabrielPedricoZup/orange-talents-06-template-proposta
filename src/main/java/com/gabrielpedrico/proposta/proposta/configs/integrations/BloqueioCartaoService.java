package com.gabrielpedrico.proposta.proposta.configs.integrations;

import com.gabrielpedrico.proposta.proposta.dtos.cartao.CartaoResponse;

public class BloqueioCartaoService implements BloqueioCartao{
    @Override
    public CartaoResponse getCartao(String id) {
        return null;
    }

    @Override
    public void bloquearCartao(String id, Object sistemaResponsavel) {

    }
}
