package hello;




public class CounterLogic{


    public String charDetector(String name)
    {
        String vastus1 = "only letters";
        String vastus2 = "numbers";
        String vastus3 = "special characters";
        String vastus4 = "No empty spaces allowed, try and use only one name. Or if you insist on using more than one" +
                ", try using an underscore, maybe??";
        String vastus = "";

        int i = 0;
        boolean only_ltrs = false;
        boolean also_nrs = false;
        boolean also_specials = false;
        boolean spacebar = false;
        for(i=0; i < name.length(); i++){

            if (name.charAt(i) >= 65 && name.charAt(i) <= 90
                    || name.charAt(i) >= 97 && name.charAt(i) <= 122) {
                only_ltrs = true;

            }
            else if (name.charAt(i)==32){
                spacebar = true;
            }
            else if (name.charAt(i) >= 48 && name.charAt(i) <= 57) {
                also_nrs = true;
                only_ltrs = false;
            }
            else {
                also_specials = true;
                only_ltrs = false;

            }


        }

        if(only_ltrs &&! spacebar &&! also_nrs &&! also_specials){
            vastus = vastus1;
        }
        else if(also_nrs &&! also_specials &&! spacebar){
            vastus = vastus2;
        }
        else if(also_nrs && also_specials &&! spacebar){
            vastus = vastus3 + " and " + vastus2;
        }
        else if(spacebar){
            vastus = vastus4;
        }
        else{
            vastus = vastus3;
        }
        return vastus;
    }
    public int charCounter(String name){
        int j;
        int count=0;
        for(j=0; j< name.length(); j++){
            if (name.charAt(j) != ' '){
                count++;
            }
        }return count;
    }




}
