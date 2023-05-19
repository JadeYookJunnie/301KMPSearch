import java.util.ArrayList;
import java.util.List;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class KMPSearch {

    public List<Character> charList = new ArrayList<>();

    public String passedString = ""; //target string
    String[][] skipArray;
    public static void main(String[] args) {
        String tableFile = "";
        String textFile = "";
        // get table file
        tableFile = args[0];
        readTable(tableFile);
        // get text file
        textFile = args[1];
        SearchText(textFile);
        // System.out.println(textFile);

    }

    public static void readTable(String filename) {
        try {
            File table = new File(filename);
            //read first line as string to be compared
            Scanner myReader = new Scanner(table);
            //put characters into a row
            //use index of character in searchstring
            //if not, index = list.length
            passedString = myReader.nextLine();

            for(int i = 0; i< passedString.length(); i++) {
                if(!(charList.contains(passedString.charAt(i)))) {
                    charList.add(subString.charAt(i));
                }
            }
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //pass to array
                System.out.print(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error spawned");
            e.printStackTrace();
        }
    }

    // SearchedText = the text we are searching for
    public static void SearchText(String textFile) {
        //start = index position
        int start = 0;
        int offset = 0;
        int lineNumber = 0;
        // loop through text file
        try {
            File text = new File(textFile);
            Scanner myReader = new Scanner(text);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.contains(passedString)) {


                }
                System.out.print(data);
                lineNumber++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error spawned");
            e.printStackTrace();
        }
    }
}