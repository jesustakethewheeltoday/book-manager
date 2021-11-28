package com.sp.book_manager;

class Borrow extends DomainObject {
    private Copy _copy;
    private int _daysBorrowed;

    public int daysBorrowed() {
    	return _daysBorrowed;
    }

    public Copy copy() {
    	return _copy;
    }

    public Borrow(Copy copy, int daysBorrowed) {
    	_copy = copy;
    	_daysBorrowed = daysBorrowed;
    }
}
