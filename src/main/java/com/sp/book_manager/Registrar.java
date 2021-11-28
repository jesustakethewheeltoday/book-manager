package com.sp.book_manager;

import java.util.Vector;

public class Registrar {
    static Vector<Book> _books;
    static Vector<Reader> _readers;

    public static void add(String type, Object wv) {
        if(type == "books") {
            _books.add((Book)wv);
        }
        else {
            _readers.add((Reader)wv);
        }
    }
}

