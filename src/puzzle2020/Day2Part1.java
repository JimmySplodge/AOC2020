/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Day2Part1 {

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
            
            int letterCount = 0;

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

            for (char c : word) {
                if (c == numLets[1].charAt(0)) {
                    letterCount++;
                }
            }

            if (letterCount >= Integer.parseInt(nums[0]) && letterCount <= Integer.parseInt(nums[1])) {
                generalCount++;
                System.out.println("true");
            }
        }
        
        //output
        System.out.println(generalCount);

    }

}
