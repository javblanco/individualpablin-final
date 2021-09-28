package es.cic.bootcamp.curso12final.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreateTipoEstanciaException extends RuntimeException{

	public CreateTipoEstanciaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateTipoEstanciaException(String message) {
		super(message);
	}
}
