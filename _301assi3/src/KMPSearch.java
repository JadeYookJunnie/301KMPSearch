import java.util.ArrayList;
import java.util.List;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.*;

class KMPSearch {

    static List<Character> charList = new ArrayList<>();

    static String passedString = ""; // target string
    static String[][] skipArray;

    public static void main(String[] args) {
        String tableFile = "";
        String textFile = "";
        // get table file
        tableFile = args[0];
        readTable(tableFile);
        // get text file
        textFile = args[1];
        SearchText(textFile);

    }

    public static void readTable(String filename) {
        // //read first line as string to be compared
        // //put characters into a row
        // //use index of character in searchstring
        // //if not, index = list.length

        BufferedReader reader;
        String pattern;

        try {
            List<String[]> rows = new ArrayList<String[]>();
            reader = new BufferedReader(new FileReader(filename));
            passedString = reader.readLine();
            for (int i = 0; i < passedString.length(); i++) {
                if (!(charList.contains(passedString.charAt(i)))) {
                    charList.add(passedString.charAt(i));
                }
            }

            skipArray = new String[charList.size() + 1][passedString.length()];

            int x = 0;
            String line = "";
            while ((line = reader.readLine()) != null) {
                // //break line into 2d array
                String[] row = line.split(",");

                for (int i = 0; i < row.length; i++) {
                    skipArray[x][i] = row[i];

                }
                x++;

            }
            // System.out.println(skipArray[0][0]);
            // System.out.println(skipArray[1][1]);
            // System.out.println(skipArray[2][2]);
            // System.out.println(skipArray[3][3]);
            // read rest of file
            // String[][] skipArray = new String[rows.size()][0];
            // rows.toArray(skipArray);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // SearchedText = the text we are searching for
    public static void SearchText(String textFile) {

        // start = index position
        int start = 0;
        // column
        int offset = 0;
        int lineNumber = 0;
        int index = 0;
        int lenghpassedString = passedString.length();
        boolean isSet = false;
        ////////////////////////////////////////////////////

        List<Character> row = new ArrayList<>();
        // passed string row
        boolean doeshave = false;
        System.out.println(passedString);
        for (int y = 0; y < lenghpassedString; y++) {
            for (char ch : row) {
                if (ch == passedString.charAt(y))
                    doeshave = true;
            }
            if (doeshave == false) {
                row.add(passedString.charAt(y));
                doeshave = false;
            }
            doeshave = false;
        }

        // loop through text file
        try {
            File text = new File(textFile);
            Scanner myReader = new Scanner(text);
            while (myReader.hasNextLine()) {
                String textline = myReader.nextLine();
                for (int i = 0; i < textline.length(); i++) {

                    if (textline.charAt(i) == passedString.charAt(start)) {
                        // so that we dont reset the index every time there is a match
                        if (isSet == false) {
                            index = i;
                            isSet = true;
                        }
                        start++;
                        System.out.println("hellow");
                        // if we make it to end off passed string
                        if (start == (lenghpassedString - 1)) {
                            System.out.println("we found a match");
                            // output line
                            System.out.println("This is the line number: " + (lineNumber + 1));
                            // ouput index mihgt need another vaiable for this
                            System.out.println("this is the index: " + (index + 1));
                            // reset
                            offset = 0;
                            start = 0;
                            index = 0;
                            isSet = false;
                            // move on to next line
                            i = textline.length();
                        }

                    } else {

                        // find offset
                        for (int x = index; x < i; i++) {
                            if (textline.charAt(x) != row.get(start)) {

                            }

                            // if(textline.charAt(x)!= passedString.charAt(x)){

                            // }
                        }

                        // look at skip array
                        // skipArray[][start];

                        // reset
                        offset = 0;
                        start = 0;
                        index = 0;
                        isSet = false;
                    }
                }
                // System.out.print(textline);
                lineNumber++;

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error spawned");
            e.printStackTrace();
        }
    }
}