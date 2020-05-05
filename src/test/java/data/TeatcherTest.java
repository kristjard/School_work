package data;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.time.ZonedDateTime;

public class TeatcherTest {
    @Test
    public void sayHelloTest() {
        //given
        ZonedDateTime date_of_birth = ZonedDateTime.parse("1950-01-01T00:00:00.000+00:00[UTC]");
        Teatcher teatcher = new Teatcher("Uudo", "Uudishimulik", "Unts",
                date_of_birth);
        String expected_result = "Hello teacher Uudo Uudishimulik";
        //when
        String result = teatcher.sayHello();
        //then
        assertEquals(expected_result, result);
    }
}
