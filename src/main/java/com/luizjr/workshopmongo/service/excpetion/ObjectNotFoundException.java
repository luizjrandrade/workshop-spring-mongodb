package com.luizjr.workshopmongo.service.excpetion;

public class ObjectNotFoundException extends RuntimeException {
	//com runtime não precisa tratar a exceção
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
