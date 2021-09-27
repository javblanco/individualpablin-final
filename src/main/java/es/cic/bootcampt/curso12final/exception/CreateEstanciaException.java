package es.cic.bootcampt.curso12final.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreateEstanciaException extends RuntimeException{
	
	public CreateEstanciaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateEstanciaException(String message) {
		super(message);
	}

}
