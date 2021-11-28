package com.sp.book_manager;

class Borrow extends DomainObject
    {
    public int daysBorrowed() {
    	return _daysBorrowed;
    }
    public Copy copy() {
    	return _copy;
    }
    private Copy _copy;
    public Borrow(Copy copy, int daysBorrowed) {
    	_copy = copy;
    	_daysBorrowed = daysBorrowed;
    }
    private int _daysBorrowed;
    }
