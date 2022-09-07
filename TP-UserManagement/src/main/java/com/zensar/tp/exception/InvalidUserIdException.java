package com.zensar.tp.exception;


public class InvalidUserIdException extends RuntimeException{
	private String message;
	public InvalidUserIdException(){
		this.message="";
	}
	public InvalidUserIdException(String message)
	{
		this.message=message;
	}
	public String toString()
	{
		return "Invalid Stock Id "+this.message;
	}
	

}
