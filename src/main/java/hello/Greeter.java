package hello;





public class Greeter extends CounterLogic {
    CounterLogic counter = new CounterLogic();
    public String sayHello(String name) {

        if (counter.charCounter(name)==0)
        {
            return "You didn't input anything. You alright, mate?";
        }
        if (counter.charDetector(name).length() > 50){
            return counter.charDetector(name);
        }
        else{
            return String.format("Hello, %s. Your name is %s digits long and contains %s.", name, counter.charCounter(name), counter.charDetector(name));
        }

        
    }
}
