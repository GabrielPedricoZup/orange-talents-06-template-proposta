package com.gabrielpedrico.proposta.proposta.configs.integrations;

import com.gabrielpedrico.proposta.proposta.dtos.carteirapaypal.NovaCarteiraResponse;

import java.util.Map;

public class CriaCarteiraService implements CriaCarteira {

    @Override
    public NovaCarteiraResponse paypal(String id, Map<String, Object> request) {
        return null;
    }
}
