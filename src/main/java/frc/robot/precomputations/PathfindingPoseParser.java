package frc.robot.precomputations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PathfindingPoseParser {
    public static void editPathfindingPoses() {
        String fieldLengthConstantName = "FIELD_LENGTH_METERS";
        String fieldWidthConstantName = "FIELD_WIDTH_METERS";

        String generatedCode = "";

        Map<String, String> rotationMap = new HashMap<>();
        rotationMap.put("Coral_AB", "red ? Rotation2d.fromDegrees(180) : Rotation2d.fromDegrees(0)");
        rotationMap.put("Coral_CD", "red ? Rotation2d.fromDegrees(-120) : Rotation2d.fromDegrees(60)");
        rotationMap.put("Coral_EF", "red ? Rotation2d.fromDegrees(-60) : Rotation2d.fromDegrees(120)");
        rotationMap.put("Coral_GH", "red ? Rotation2d.fromDegrees(0) : Rotation2d.fromDegrees(180)");
        rotationMap.put("Coral_IJ", "red ? Rotation2d.fromDegrees(60) : Rotation2d.fromDegrees(-120)");
        rotationMap.put("Coral_KL", "red ? Rotation2d.fromDegrees(120) : Rotation2d.fromDegrees(-60)");
        rotationMap.put("Coral_Station_Right", "red ? Rotation2d.fromDegrees(126) : Rotation2d.fromDegrees(-55)");
        rotationMap.put("Coral_Station_Left", "red ? Rotation2d.fromDegrees(-126) : Rotation2d.fromDegrees(55)");

        try(BufferedReader reader = new BufferedReader(new FileReader("./src/main/deploy/pathplanner/paths/Finding.path"))) {
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject)parser.parse(reader);
            
            JSONArray waypoints = (JSONArray) obj.get("waypoints");
            for(int i = 0; i < waypoints.size(); i++) {
                JSONObject waypoint = (JSONObject) waypoints.get(i);
                JSONObject anchor = (JSONObject) waypoint.get("anchor");
                double x = (Double) anchor.get("x");
                double y = (Double) anchor.get("y");

                String linkedName = (String) waypoint.get("linkedName");

                String rotationCode = rotationMap.get(linkedName);

                generatedCode += "\t\t%s = new Pose2d(red ? %.4f : %s - %.4f, red ? %.4f : %s - %.4f, %s);"
                    .formatted(
                        linkedName.toUpperCase().replace(' ', '_'), 
                        x, 
                        fieldLengthConstantName, 
                        x, 
                        y, 
                        fieldWidthConstantName, 
                        y, 
                        rotationCode
                    );
                
                generatedCode += '\n';
            }

            editJavaFile(
                "src\\main\\java\\frc\\robot\\constants\\PositionContainer.java",
                "//Insert Precomputed positions here", 
                "//Stop Precomputed positions here", 
                generatedCode
            );
        } catch(Exception e) {
            System.out.println("An error occurred reading the file...");
            throw new RuntimeException(e);
        }
    }

    public static void editJavaFile(String filePath, String startMarker, String endMarker, String newCode) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            List<String> modifiedLines = new ArrayList<>();

            boolean insideBlock = false;

            for (String line : lines) {
                if (line.contains(startMarker)) {
                    insideBlock = true;
                    modifiedLines.add(line); // Keep the START marker
                    modifiedLines.add(newCode); // Add the generated code
                    continue; // Skip to next iteration to prevent adding old code
                }
                if (line.contains(endMarker)) {
                    insideBlock = false;
                    modifiedLines.add(line); // Keep the END marker
                    continue;
                }

                if (!insideBlock) {
                    modifiedLines.add(line); // Keep everything outside the block
                }
            }

            Files.write(Paths.get(filePath), modifiedLines);
            System.out.println("File updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
