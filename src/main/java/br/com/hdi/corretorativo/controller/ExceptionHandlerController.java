package br.com.hdi.corretorativo.controller;

import br.com.hdi.corretorativo.exception.ErrorResponseException;
import br.com.hdi.corretorativo.exception.Response;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ErrorResponseException.class)
	public ResponseEntity<Response> errorResponseExceptionHandler(ErrorResponseException ex) {
		return new ResponseEntity<>(ex.getResponse(), ex.getStatus());
	}

	@ExceptionHandler(FeignException.class)
	public Response handleFeignStatusException(FeignException e, HttpServletResponse response) {
		response.setStatus(e.status());
		return Response
				.builder()
				.code(e.status())
				.message("Integration error")
				.description("Integration error")
				.build();
	}
	
}
