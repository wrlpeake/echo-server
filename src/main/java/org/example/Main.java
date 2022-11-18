package org.example;

public class Main {
    public String helloWorld() {
        return ("Hello world!");
    }

    public String fizzbuzz(int number) {
        if (((number % 5) == 0) && ((number % 3) == 0)) {
            return ("fizzbuzz");
        }
            else if ((number % 5) == 0) {
                return ("buzz");
        }   else if ((number % 3) == 0) {
                return ("fizz");
        }
        return String.valueOf(number);
    }
}