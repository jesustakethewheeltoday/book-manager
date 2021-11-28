package com.sp.book_manager;

class Copy extends DomainObject {
    private String _serialNumber;
    private Book _book;

    public Book book() {
    	return _book;
    }
    public String get_serialNumber() {
        return _serialNumber;
    }

    public void set_serialNumber(String _serialNumber) {
        this._serialNumber = _serialNumber;
    }

    public Copy(String serialNumber, Book book) {
    	set_serialNumber(serialNumber);
    	_book = book;
    }
}