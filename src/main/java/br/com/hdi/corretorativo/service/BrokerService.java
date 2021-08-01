package br.com.hdi.corretorativo.service;

import br.com.hdi.corretorativo.enumarations.ExceptionEnum;
import br.com.hdi.corretorativo.exception.ErrorResponseException;
import br.com.hdi.corretorativo.exception.Response;
import br.com.hdi.corretorativo.insurance.client.InsuranceClient;
import br.com.hdi.corretorativo.insurance.response.BrokerResponse;
import br.com.hdi.corretorativo.insurance.response.BrokerStatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BrokerService {

    private InsuranceClient insuranceClient;

    public BrokerService(InsuranceClient insuranceClient) {
        this.insuranceClient = insuranceClient;
    }

    public BrokerResponse find(String document) {
        BrokerResponse brokerResponse1 = insuranceClient.findByDocument(document)
                .orElseThrow(
                        () -> new ErrorResponseException(
                                Response.builder().code(ExceptionEnum.NO_CONTENT.getId())
                                        .description(ExceptionEnum.NO_CONTENT.getDescription())
                                        .message(ExceptionEnum.NO_CONTENT.getDescription()).build(),
                                HttpStatus.NOT_FOUND));

        BrokerStatusResponse brokerResponse = insuranceClient.find(brokerResponse1.getCode())
                .filter(broker -> broker.getActive())
                .orElseThrow(
                        () -> new ErrorResponseException(
                                Response.builder().code(ExceptionEnum.RULE_BUSINESS.getId())
                                        .description(ExceptionEnum.RULE_BUSINESS.getDescription())
                                        .message(ExceptionEnum.RULE_BUSINESS.getDescription()).build(),
                                HttpStatus.NOT_FOUND));

        brokerResponse1.setCommissionRate(brokerResponse.getCommissionRate());
        brokerResponse1.setActive(brokerResponse.getActive());

        return brokerResponse1;
    }

}
