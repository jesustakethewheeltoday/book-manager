package com.sp.book_manager;

import java.util.Enumeration;
import java.util.Vector;

class Reader extends DomainObject {
    public Reader(String name) {
        _name = name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentBorrowerPoints = 0;
        Enumeration<Borrow> borrows = _borrows.elements();
        String result = "Borrow Record for " + name() + "\n";
        while (borrows.hasMoreElements()) {
            double thisAmount = 0;
            Borrow each = (Borrow) borrows.nextElement();

            //determine amounts for each line
            switch (each.copy().book().priceCode()) {
                case Book.REGULAR:
                    thisAmount += 2;
                    if (each.daysBorrowed() > 2)
                        thisAmount += (each.daysBorrowed() - 2) * 1.5;
                    break;
                case Book.NEW_RELEASE:
                    thisAmount += each.daysBorrowed() * 3;
                    break;
                case Book.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.daysBorrowed() > 3)
                        thisAmount += (each.daysBorrowed() - 3) * 1.5;
                    break;

            }
            totalAmount += thisAmount;

            // add frequent borrower points
            frequentBorrowerPoints ++;
            // add bonus for a two day new release borrow
            if ((each.copy().book().priceCode() == Book.NEW_RELEASE) 
                 && each.daysBorrowed() > 1) frequentBorrowerPoints ++;

            //show figures for this borrow
            result += "\t" + each.copy().book().name()
                   + "\t" + String.valueOf(thisAmount) + "\n";

        }
        //add footer lines
        result +=  "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentBorrowerPoints) 
               + " frequent borrower points";
        return result;

    }

    public void addBorrow(Borrow arg) {
    	_borrows.addElement(arg);
    }

    public void persist() {
    	Registrar.add("Readers", this);
    }
    
    private Vector<Borrow> _borrows = new Vector<Borrow>();
    }

