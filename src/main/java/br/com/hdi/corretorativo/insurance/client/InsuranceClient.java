package br.com.hdi.corretorativo.insurance.client;

import br.com.hdi.corretorativo.insurance.response.BrokerResponse;
import br.com.hdi.corretorativo.insurance.response.BrokerStatusResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "${client.insurance.name}", url = "${client.insurance.url}")
public interface InsuranceClient {

    @GetMapping(value="/v1/brokerData")
    Optional<List<BrokerStatusResponse>> findAll();

    @GetMapping(value="/v1/brokerData/{brokerId}")
    Optional<BrokerStatusResponse> find(@PathVariable("brokerId") String brokerId);

    @GetMapping(value="/v1/broker/{document}")
    Optional<BrokerResponse> findByDocument(@PathVariable("document") String document);

}
