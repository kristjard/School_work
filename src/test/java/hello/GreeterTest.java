package hello;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class GreeterTest
{
    @Mock
    private CounterLogic counter;

    @InjectMocks
    Greeter greeter = new Greeter();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void no_input_case(){
        //Given
        when(counter.charCounter(" ")).thenReturn(0);

        //When
        String result=greeter.sayHello(" ");

        //then
        assertEquals("You didn't input anything. You alright, mate?", result);


    }
    @Test
    public void has_only_letters_in_name(){
        //Given
        when(counter.charCounter("Kristjan")).thenReturn(8);
        when(counter.charDetector("Kristjan")).thenReturn("only letters");

        //When
        String result=greeter.sayHello("Kristjan");

        //then
        assertEquals("Hello, Kristjan. Your name is 8 digits long and contains only letters.", result);


    }
    @Test
    public void contains_numbers(){
        //Given
        when(counter.charCounter("Kr1stjan")).thenReturn(8);
        when(counter.charDetector("Kr1stjan")).thenReturn("numbers");

        //When
        String result=greeter.sayHello("Kr1stjan");

        //then
        assertEquals("Hello, Kr1stjan. Your name is 8 digits long and contains numbers.", result);


    }
    @Test
    public void contains_special_bois(){
        //Given
        when(counter.charCounter("Kr!stjan")).thenReturn(8);
        when(counter.charDetector("Kr!stjan")).thenReturn("special characters");

        //When
        String result=greeter.sayHello("Kr!stjan");

        //then
        assertEquals("Hello, Kr!stjan. Your name is 8 digits long and contains special characters.", result);


    }

    @Test
    public void contains_numbers_and_special_bois(){
        //Given
        when(counter.charCounter("Kr1stjan!")).thenReturn(8);
        when(counter.charDetector("Kr1stjan!")).thenReturn("special characters and numbers");

        //When
        String result=greeter.sayHello("Kr1stjan!");

        //then
        assertEquals("Hello, Kr1stjan!. Your name is 8 digits long and contains special characters and" +
                " numbers.", result);


    }
    @Test
    public void has_more_than_one_word_in_it(){
        //Given
        when(counter.charCounter("Kr1 stjan!")).thenReturn(8);
        when(counter.charDetector("Kr1 stjan!")).thenReturn("No empty spaces allowed," +
                " try and use only one name. Or if you insist on using more than one" +
                                ", try using an underscore, maybe??");

        //When
        String result=greeter.sayHello("Kr1 stjan!");

        //then
        assertEquals("No empty spaces allowed, try and use only one name. Or if you insist on using more" +
                " than one, try using an underscore, maybe??", result);


    }








}