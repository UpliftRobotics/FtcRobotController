package org.firstinspires.ftc.teamcode.opmodes.RedSideAutos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.UpliftRobot;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.toolkit.background.Odometry;
import org.firstinspires.ftc.teamcode.toolkit.core.UpliftAuto;

@Autonomous(name = "Park Auto", group = "opModes")
public class ParkAuto extends UpliftAuto {

    UpliftRobot robot;
    Odometry odom;

    @Override
    public void initHardware() {
        robot = new UpliftRobot(this);
        odom = robot.odometry;
    }

    @Override
    public void initAction() {
        robot.wobbleSub.dropWobble();
    }

    @Override
    public void body() {
        // create empty path list
        odom.setOdometryPosition(105.25, 8.5, 0);
        robot.driveSub.driveToPosition(105.25, 78, 0.7, 0);

    }

    @Override
    public void exit() {
        // last thing to do is write the current robot position to file
        robot.stopThreads();
        robot.writePositionToFiles();
    }
}
