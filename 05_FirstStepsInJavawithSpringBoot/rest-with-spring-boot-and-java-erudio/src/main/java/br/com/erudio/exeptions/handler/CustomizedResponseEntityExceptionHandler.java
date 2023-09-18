package br.com.erudio.exeptions.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.erudio.exeptions.ExceptionResponse;

@RestController
@ControllerAdvice

public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public final ResponseEntity<ExceptionResponse> handleAllExceptions(
			Exception ex ,WebRequest request) {
ExceptionResponse exceptionResponse = new ExceptionResponse(
		null, PAGE_NOT_FOUND_LOG_CATEGORY, )
	}

}
