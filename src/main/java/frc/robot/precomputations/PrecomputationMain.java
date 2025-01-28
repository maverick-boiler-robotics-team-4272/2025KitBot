package frc.robot.precomputations;

import java.nio.file.Files;
import java.nio.file.Path;

public class PrecomputationMain {
    public static void main(String[] args) {
        System.out.println("Testing pre-computations");

        String content;

        try {
            content = Files.readString(Path.of("./src/main/deploy/pathplanner/paths/Finding.path"));
        } catch(Exception e) {
            System.out.println("An error occurred reading the file... Be sure to make a path file named Finding!");
            throw new RuntimeException(e);
        }

        System.out.println(content);
    }   
}
