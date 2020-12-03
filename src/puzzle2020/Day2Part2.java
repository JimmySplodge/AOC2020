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
public class Day2Part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        FileReader fr = null;
        try {
            // get file input
            fr = new FileReader("AOC2.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day1Part1.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedReader br = new BufferedReader(fr);

        //add inputs to array
        String[] inputs = new String[1000];

        String line = br.readLine();
        int count = 0;
        while (line != null) {
            inputs[count] = line;
            line = br.readLine();
            count++;
        }


        //count variable
        int generalCount = 0;

        for (String pass : inputs) {
            //pass = "3-4 j: jprp";

            String[] passReqSplit = pass.split(": ");
            
            //passReqSplit = ["3-4 j", "jprp"]

            String[] numLets = passReqSplit[0].split(" ");
            
            //passReqSplit = ["3-4 j", "jprp"]
            //numLets = ["3-4","j"]
            
            String[] nums = numLets[0].split("-");
            
            //passReqSplit = ["3-4 j", "jprp"]
            //numLets = ["3-4","j"]
            //nums = ["3","4"]

            char[] word = passReqSplit[1].toCharArray();
            
            //passReqSplit = ["3-4 j", "jprp"]
            //numLets = ["3-4","j"]
            //nums = ["3","4"]
            //word = ["j","p","r","p"]
            
            //check for greater pos than length
            if (word.length < Integer.parseInt(nums[1]) - 1) {
                System.out.println("Test");
            }
            
            if (word[Integer.parseInt(nums[0]) - 1] == numLets[1].charAt(0)) {
                if (word[Integer.parseInt(nums[1]) - 1] != numLets[1].charAt(0)) {
                    generalCount++;
                }
            } else if (word[Integer.parseInt(nums[1]) - 1] == numLets[1].charAt(0)) {
                generalCount++;
            }
            
        }
        
        //output
        System.out.println(generalCount);

    }

}
