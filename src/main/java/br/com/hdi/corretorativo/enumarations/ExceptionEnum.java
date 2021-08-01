package br.com.hdi.corretorativo.enumarations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {

	NO_CONTENT(1, "No Content"),
	RULE_BUSINESS(1, "Deactivated broker");

	Integer id;
	String description;

}
