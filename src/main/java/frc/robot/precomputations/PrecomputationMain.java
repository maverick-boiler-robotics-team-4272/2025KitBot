package frc.robot.precomputations;

import java.io.BufferedReader;
import java.io.FileReader;

public class PrecomputationMain {
    public static void main(String[] args) {
        System.out.println("Testing pre-computations");


        try(BufferedReader reader = new BufferedReader(new FileReader("./src/main/deploy/pathplanner/paths/Finding.path"))) {
        } catch(Exception e) {
            System.out.println("An error occurred reading the file... Be sure to make a path file named Finding!");
            throw new RuntimeException(e);
        } 

        // JSONParser parser = new JSONParser();
        // // JSONObject obj = (JSONObject)parser.parse(reader);
    }   
}