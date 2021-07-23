package com.gabrielpedrico.proposta.proposta.configs.integrations;

import com.gabrielpedrico.proposta.proposta.dtos.avisoviagem.NovoAvisoViagemRequest;
import com.gabrielpedrico.proposta.proposta.dtos.cartao.CartaoResponse;
import org.springframework.web.bind.annotation.RequestParam;

public class AssociaCartaoService implements  AssociaCartao{
    @Override
    public CartaoResponse buscaCartao(@RequestParam(required = true, name = "idProposta") String id) {
        return null;
    }

    @Override
    public CartaoResponse buscaCartaoById(String id) {
        return null;
    }

    @Override
    public void enviaAvisoViagem(String id, NovoAvisoViagemRequest request) {
    }
}
