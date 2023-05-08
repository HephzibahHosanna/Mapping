package com.example.Mapping.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class NoRecordFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

		public NoRecordFoundException(String message) {
	        super(message);
	    }
		
		public NoRecordFoundException(String message, Throwable throwable) {
			super(message, throwable);
		}
	}


