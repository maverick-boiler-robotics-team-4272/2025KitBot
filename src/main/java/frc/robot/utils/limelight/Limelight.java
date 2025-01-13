package frc.robot.utils.limelight;
import frc.robot.utils.limelight.LimelightHelpers;
import frc.robot.utils.limelight.*;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;



public class Limelight {
    private String tableName;
    
    public Limelight(String tableName) {
        this.tableName = tableName;

        configure(new Pose3d());
    }

    public void configure(Pose3d cameraoffset) {
        LimelightHelpers.setCameraPose_RobotSpace(
            tableName,
            cameraoffset.getX(),
            cameraoffset.getY(),
            cameraoffset.getZ(),
            cameraoffset.getRotation().getX(),
            cameraoffset.getRotation().getY(),
            cameraoffset.getRotation().getZ()
        );

        LimelightHelpers.setPipelineIndex(tableName, 0);
        LimelightHelpers.setLEDMode_PipelineControl(tableName);
        LimelightHelpers.setLEDMode_ForceOff(tableName);
    }
    public void turnOnLeds() {
        LimelightHelpers.setLEDMode_ForceOn(tableName);
    }

    public void setRobotOrientation(double yaw) {
        LimelightHelpers.SetRobotOrientation(tableName, yaw, 0.0, 0.0, 0.0, 0.0, 0.0);
    }
    

}
