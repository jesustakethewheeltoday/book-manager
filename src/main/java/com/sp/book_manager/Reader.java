package com.sp.book_manager;

import java.util.Enumeration;
import java.util.Vector;

class Reader extends DomainObject {
    public Reader(String name) {
        _name = name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentLendingerPoints = 0;
        Enumeration<Lending> lendings = _lendings.elements();
        String result = "Lending Record for " + name() + "\n";
        while (lendings.hasMoreElements()) {
            double thisAmount = 0;
            Lending each = (Lending) lendings.nextElement();

            //determine amounts for each line
            switch (each.copy().book().priceCode()) {
                case Book.REGULAR:
                    thisAmount += 2;
                    if (each.daysLent() > 2)
                        thisAmount += (each.daysLent() - 2) * 1.5;
                    break;
                case Book.NEW_RELEASE:
                    thisAmount += each.daysLent() * 3;
                    break;
                case Book.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.daysLent() > 3)
                        thisAmount += (each.daysLent() - 3) * 1.5;
                    break;

            }
            totalAmount += thisAmount;

            // add frequent lendinger points
            frequentLendingerPoints ++;
            // add bonus for a two day new release lending
            if ((each.copy().book().priceCode() == Book.NEW_RELEASE) 
                 && each.daysLent() > 1) frequentLendingerPoints ++;

            //show figures for this lending
            result += "\t" + each.copy().book().name()
                   + "\t" + String.valueOf(thisAmount) + "\n";

        }
        //add footer lines
        result +=  "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentLendingerPoints) 
               + " frequent lendinger points";
        return result;

    }

    public void addLending(Lending arg) {
    	_lendings.addElement(arg);
    }

    public void persist() {
    	Registrar.add("Readers", this);
    }
    
    private Vector<Lending> _lendings = new Vector<Lending>();
}

