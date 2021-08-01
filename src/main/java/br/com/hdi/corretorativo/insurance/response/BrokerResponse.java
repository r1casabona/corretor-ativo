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
public class BrokerResponse {

    private String name;
    private String document;
    private String code;
    private String createDate;
    private BigDecimal commissionRate;
    private Boolean active;

}
