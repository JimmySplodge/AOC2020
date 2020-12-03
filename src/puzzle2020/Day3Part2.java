package puzzle2020;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James
 */
public class Day3Part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        try {
            // get file input
            fr = new FileReader("AOC3.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day1Part1.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedReader br = new BufferedReader(fr);

        //add inputs to array
        String[] inputs = new String[323];

        String line = br.readLine();
        int count = 0;
        while (line != null) {
            inputs[count] = line;
            line = br.readLine();
            count++;
        }

        //tree variables
        int[] trees = new int[5];
        int treeR1 = 0;
        int treeR3 = 0;
        int treeR5 = 0;
        int treeR7 = 0;
        int treeD2 = 0;

        //declare variables
        int widthPos;
        int treeCount;
        int rowLen = (inputs[0].length());
        int arrPos = 0;

        //each horizontal loop
        for (int i = 1; i < 8; i += 2) {
            //set variables
            widthPos = 0 - i;
            treeCount = 0;

            for (String row : inputs) {
                //change width pos
                widthPos += i;

                if (widthPos >= rowLen) {
                    widthPos = (widthPos - rowLen);
                }

                //System.out.println(widthPos);
                //check cell
                if (row.charAt(widthPos) == '#') {
                    treeCount++;
                    //System.out.println("Tree Hit");
                }

            }

            //set to array
            trees[arrPos] = treeCount;
            arrPos++;
        }

        //the downwards loop
        widthPos = -1;
        treeCount = 0;

        for (int i = 0; i < inputs.length; i += 2) {
            //change width pos
            widthPos += 1;

            if (widthPos >= rowLen) {
                widthPos = (widthPos - rowLen);
            }

                //System.out.println(widthPos);
            //check cell
            if (inputs[i].charAt(widthPos) == '#') {
                treeCount++;
                //System.out.println("Tree Hit");
            }
        }
        
        //set to array
        trees[arrPos] = treeCount;
        
        //calc total
        long total = 1;
        
        for (int i : trees) {
            total = total * i;
        }
        
        System.out.println(total);

        /*
         //declare variables
         int widthPos = -3;
         int treeCount = 0;
         int rowLen = (inputs[0].length());
        
         //testing only
         System.out.println("rowLen = " + rowLen);
        
         //iterate through array
         for (String row : inputs) {
         //change width pos
         widthPos += 3;
            
         if (widthPos >= rowLen) {
         widthPos = (widthPos - rowLen);
         }
            
         System.out.println(widthPos);
            
         //check cell
         if (row.charAt(widthPos) == '#') {
         treeCount++;
         System.out.println("Tree Hit");
         }
         }
        
         System.out.println(treeCount);*/
    }

}
