package com.sp.book_manager;

public class Book extends DomainObject {
    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;


	private int _priceCode;

	public Book(String name, int priceCode) {
		_name = name;
		_priceCode = priceCode;
	}

	public int priceCode() {
		return _priceCode;
	}

	public void persist() {
		Registrar.add ("Books", this);
	}
}
