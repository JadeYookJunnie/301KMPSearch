import java.util.ArrayList;
import java.util.List;

class KMPSearch {

    public static void main(String[] args) {
        // string where searching for
        String subString = args[0];
        // text file
        String InputString = "The cat said dasdjaljsdlj xxy xyz xyz xyxyz zyxyzyxy";


        List<Character> charList = new ArrayList<>();
        //build list of characters to check for (going down)

        // table array
        String[][] inputTable = new String[charList.size()][subString.length()];


        for(int i = 0; i< subString.length(); i++) {
            if(!(charList.contains(subString.charAt(i)))) {
                charList.add(subString.charAt(i));
            }
        }
        //add other characters
        charList.add("*".charAt(0));



        //for each character in string
        for(char compChar: charList) {
            //String out = String.valueOf(compChar) + ":";
            String out = "";

            //string for pattern
            String pattern = "";
            //string for copy of pattern to compoare against
            String compareString = "";

            for(char subChar: subString.toCharArray()) {
                int count = 0;
                //add seeked character to prefix
                String prefix = pattern + compChar;
                //System.out.println(prefix);



                compareString += subChar;
                //alwatys 0 when equal
                if(subChar == compChar) {
                    count = 0;

                }
                else { //NOTE: need a better way of comparing strings to adhere to pattern
                    while(!(compareString.contains(prefix))) {
                        //increment count (no. skips)
                        count += 1;
                        //System.out.println(prefix);
                        //System.out.println(compareString);


                        //drop off first character and repeat
                        prefix = prefix.substring(1);
//                        if(prefix.length() == 1) {
//                            if(prefix.charAt(0) != "x".charAt(0)) {
//                                count += 1;
//                            }
//                        }
                        //matcher("xyxyz", prefix);

                    }
                    if(compareString.contains(prefix)) {
                        if(prefix.length() == 1) {
                            if(prefix.charAt(0) != subString.charAt(0)) {
                                count += 1;
                            }
                        }
                    }

                }

                //add to array 'row'
                out += " " + String.valueOf(count);
                //add current char to pattern
                pattern += subChar;
                //add current pattern to comparestring

                //pattern and comparestring the same at this stage

            }
            System.out.println(out);
        }

    }



}