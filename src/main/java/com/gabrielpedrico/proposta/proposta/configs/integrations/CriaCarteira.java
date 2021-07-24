package com.gabrielpedrico.proposta.proposta.configs.integrations;

import com.gabrielpedrico.proposta.proposta.dtos.carteirapaypal.NovaCarteiraRequest;
import com.gabrielpedrico.proposta.proposta.dtos.carteirapaypal.NovaCarteiraResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;


@FeignClient(name = "paypal",
        url = "${cartoes.url}")
public interface CriaCarteira {

    @PostMapping("/{id}/carteiras")
    NovaCarteiraResponse paypal(@PathVariable String id, @RequestBody Map<String, Object> request);
}
