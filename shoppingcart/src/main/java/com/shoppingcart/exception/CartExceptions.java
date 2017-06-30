package com.shoppingcart.exception;

/**
 * Created by Gyan on 6/30/2017.
 */
public class CartExceptions  extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String exceptionName;

    public CartExceptions(String message, String exceptionName) {
        super(message);
        this.exceptionName = exceptionName;
    }

    @Override
    public String toString() {
        return exceptionName+" "+super.toString();
    }
}
