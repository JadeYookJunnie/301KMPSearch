import java.util.ArrayList;
import java.util.List;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.*;

class KMPSearch {

    static List<Character> charList = new ArrayList<>();

    static String passedString = ""; //target string
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
        // System.out.println(textFile);

    }

    public static void readTable(String filename) {
//            //read first line as string to be compared
//            //put characters into a row
//            //use index of character in searchstring
//            //if not, index = list.length

        BufferedReader reader;
        String pattern;

        try {
            List<String[]> rows = new ArrayList<String[]>();
            reader = new BufferedReader(new FileReader(filename));
            passedString = reader.readLine();
            for(int i = 0; i< passedString.length(); i++) {
                if(!(charList.contains(passedString.charAt(i)))) {
                    charList.add(passedString.charAt(i));
                }
            }
            //System.out.println(passedString.length());
            skipArray = new String[charList.size()+1][passedString.length()];

            int x = 0;
            String line = "";
            while ((line = reader.readLine()) != null) {
                // //break line into 2d array
                String[] row = line.split(",");
                // //row = String[]{0,1,0,3,2} x4
                // rows.add(row); //add to list
                // //pattern = reader.readLine();
                // System.out.println(line);
                // //break;

                for (int i = 0; i < row.length; i++) {
                    skipArray[x][i] = row[i];
                    //System.out.println(row[i]);

                    //System.out.print(skipArray[x][i]);
                    //System.out.printf("%n");

                }
                x++;

            }
            // read rest of file
            //String[][] skipArray = new String[rows.size()][0];
            //rows.toArray(skipArray);


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
        // loop through text file
        try {
            File text = new File(textFile);
            Scanner myReader = new Scanner(text);
            while (myReader.hasNextLine()) {
                String textline = myReader.nextLine();
                if (textline.charAt(offset) == passedString.charAt(offset)) {
                    // look at table and increment passedString

                    //if we make it to end off passed string
                    //output line
                    //ouput index
                } else {
                    // look at table skip desired characters  on line
                }

                System.out.print(textline);
                lineNumber++;

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error spawned");
            e.printStackTrace();
        }
    }
}