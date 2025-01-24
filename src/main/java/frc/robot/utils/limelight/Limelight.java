package frc.robot.utils.limelight;
import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.utils.commandUtils.Periodical;
import frc.robot.utils.commandUtils.PeriodicalUtil;
import frc.robot.utils.logging.Loggable;

public class Limelight implements Periodical, Loggable {
    @AutoLog
    public static class LimelightInputs {
        boolean tV;
        Pose2d robotPose;
    }

    LimelightInputsAutoLogged inputs = new LimelightInputsAutoLogged();

    private String tableName;
    
    public Limelight(String tableName) {
        this.tableName = tableName;

        configure(new Pose3d());

        inputs.tV = false;
        inputs.robotPose = new Pose2d();

        PeriodicalUtil.registerPeriodic(this);
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
    
    public Pose2d getBotPose() {
        return LimelightHelpers.getBotPose2d_wpiBlue(tableName);
    }

    public LimelightHelpers.PoseEstimate getBotPoseEstimate() {
        return LimelightHelpers.getBotPoseEstimate_wpiBlue_MegaTag2(tableName); //TODO: Check Which one may work
    }

    @Override
    public void periodic() {
        LimelightHelpers.PoseEstimate poseEstimate = getBotPoseEstimate();
        if(poseEstimate == null) {
            inputs.robotPose = new Pose2d(0, 0, new Rotation2d(0));
        } else {
            inputs.robotPose = poseEstimate.pose;
        }
        inputs.tV = LimelightHelpers.getTV(tableName);

        log("Limelights", tableName);
    }

    @Override
    public void log(String subdirectory, String humanReadableName) {
        Logger.processInputs(subdirectory + "/" + humanReadableName, inputs);
    }
}
