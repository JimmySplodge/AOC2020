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
public class Day1Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        try {
            // get file input
            fr = new FileReader("AOC1P1.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day1Part1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BufferedReader br = new BufferedReader(fr);
        
        //add inputs to array
        int[] inputs = new int[200];
        
        String line = br.readLine();
        int count = 0;
        while (line != null) {
            inputs[count] = Integer.parseInt(line);
            line = br.readLine();
            count++;
        }
        
        /*
        for (int i : inputs) {
            System.out.println(i);
        }*/
        
        //find 2020 sum
        for (int i = 0; i < 200; i++) {
            for (int j = i+1; j < 200; j++) {
                if (inputs[i] + inputs[j] == 2020) {
                    System.out.println(inputs[i] * inputs[j]);
                }
            }
        }
    }
    
}
