package br.com.hdi.corretorativo.controller;

import br.com.hdi.corretorativo.insurance.response.BrokerResponse;
import br.com.hdi.corretorativo.service.BrokerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/broker/v1")
@Api(tags = "Broker Controller")
public class BrokerController {

    private BrokerService brokerService;

    public BrokerController(BrokerService brokerService) {
        this.brokerService = brokerService;
    }

    @ApiOperation(value = "Find broker", notes = "Find broker", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Find broker request successfully executed", response = BrokerResponse.class),
            @ApiResponse(code = 404, message = "The request resource was not found") })
    @GetMapping("/broker/{document}")
    public ResponseEntity<BrokerResponse> find(@PathVariable final String document) {
        return ResponseEntity.ok(brokerService.find(document));
    }

}
