package data;


import java.time.ZonedDateTime;


public interface Person {
    String getFirst_name();
    String getLast_name();
    String getPreferred_name();
    ZonedDateTime getDate_of_birth();
    String sayHello();


}
