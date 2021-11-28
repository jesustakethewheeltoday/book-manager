package com.sp.book_manager;

class Lending extends DomainObject {
    private Copy _copy;
    private int _daysLent;

    public int daysLent() {
    	return _daysLent;
    }

    public Copy copy() {
    	return _copy;
    }

    public Lending(Copy copy, int daysLent) {
    	_copy = copy;
    	_daysLent = daysLent;
    }
}
