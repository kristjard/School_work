package data;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class PersonImpl implements Person {
    private String first_name;
    private String last_name;
    private String preferred_name;
    private ZonedDateTime date_of_birth;

    public PersonImpl(String first_name, String last_name, String preferred_name, ZonedDateTime date_of_birth) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.preferred_name = preferred_name;
        this.date_of_birth = date_of_birth;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPreferred_name() {
        return preferred_name;
    }

    public void setPreferred_name(String preferred_name) {
        this.preferred_name = preferred_name;
    }

    public ZonedDateTime getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(ZonedDateTime date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(this.date_of_birth, ZonedDateTime.now());
    }

    public void sayHello() {

    }
}
