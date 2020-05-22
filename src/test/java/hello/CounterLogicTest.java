package hello;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CounterLogicTest {
    CounterLogic logic = new CounterLogic();

    @Test
    public void counter_works(){
        int expectedResult = 8;
        assertEquals(logic.charCounter("Kristjan"), expectedResult);
    }
    @Test
    public void no_input(){
        int expectedResult = 0;
        assertEquals(expectedResult, logic.charCounter(""));
    }
    @Test
    public void ridiculously_large_input(){
        int expectedResult = 100000;
        String string = "";
        for(int i=0; i<100000; i++){
            string = string.concat("a");
        }
        assertEquals(expectedResult, logic.charCounter(string));
    }
    @Test
    public void only_letters(){
        String expectedResult = "only letters";
        assertEquals(expectedResult, logic.charDetector("Kristjan"));
    }
    @Test
    public void contains_nrs(){
        String expectedResult = "numbers";
        assertEquals(expectedResult, logic.charDetector("Kristjan123"));
    }
    @Test
    public void contains_specials(){
        String expectedResult = "special characters";
        assertEquals(expectedResult, logic.charDetector("Kristjan!"));
    }
    @Test
    public void contains_specials_and_numbers(){
        String expectedResult = "special characters and numbers";
        assertEquals(expectedResult, logic.charDetector("Kristjan1!"));
    }
    @Test
    public void contains_a_space_character(){
        String expectedResult = "No empty spaces allowed, try and use only one name. Or if you insist on using more" +
                " than one, try using an underscore, maybe??";
        assertEquals(expectedResult, logic.charDetector("Kristj an1!"));
    }

}
