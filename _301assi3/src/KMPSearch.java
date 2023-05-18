import java.util.ArrayList;
import java.util.List;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

class KMPSearch {

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
            Scanner myReader = new Scanner(table);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
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
        // loop through text file
        try {
            File text = new File(textFile);
            Scanner myReader = new Scanner(text);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.print(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error spawned");
            e.printStackTrace();
        }
    }
}