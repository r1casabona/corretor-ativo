package br.com.hdi.corretorativo.insurance.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrokerStatusResponse {

    private String code;
    private Boolean active;
    private BigDecimal commissionRate;

}
