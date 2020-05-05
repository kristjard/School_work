package data;

import java.time.ZonedDateTime;

public class Teatcher extends PersonImpl {
    public Teatcher(String first_name, String last_name, String preferred_name, ZonedDateTime date_of_birth) {
        super(first_name, last_name, preferred_name, date_of_birth);
    }

    @Override
    public String sayHello() {

        return "Hello teacher " + getFirst_name() + " " + getLast_name();
    }


}
