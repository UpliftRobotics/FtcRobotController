package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.UpliftRobot;
import org.firstinspires.ftc.teamcode.toolkit.core.Command;
import org.firstinspires.ftc.teamcode.subsystems.FlickerSubsystem;
import org.firstinspires.ftc.teamcode.toolkit.core.UpliftTele;
import org.firstinspires.ftc.teamcode.toolkit.misc.Utils;

public class FlickerCommands extends Command {

    public FlickerSubsystem flicker;
    public UpliftTele opMode;
    UpliftRobot robot;

    public FlickerCommands(UpliftTele opMode, UpliftRobot robot, FlickerSubsystem flickerSubsystem) {
        super(opMode, flickerSubsystem);
        this.flicker = flickerSubsystem;
        this.opMode = opMode;
        this.robot = robot;
    }

    @Override
    public void init() {
        // set flicker to start position (back)
    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        if(opMode.gamepad1.right_bumper) {
            flicker.flickRing();
        }

        // Method for shooting (only flicks 3 rings, then tells transfer to drop and shooter to slow)
        if(opMode.gamepad1.y) {
            for(int i = 0; i < 2; i++) {
                flicker.flickRing();
                robot.safeSleep(100);
            }
            flicker.flickRing();
            robot.setShootingState(UpliftRobot.ShootingState.DONE_SHOOTING);
        }

        if(robot.shootingState == UpliftRobot.ShootingState.SHOOTING_PS1) {
            flicker.flickRing();
            robot.setShootingState(UpliftRobot.ShootingState.DONE_PS1);
        }

        if(robot.shootingState == UpliftRobot.ShootingState.SHOOTING_PS2) {
            flicker.flickRing();
            robot.setShootingState(UpliftRobot.ShootingState.DONE_PS2);
        }

        if(robot.shootingState == UpliftRobot.ShootingState.SHOOTING_PS3) {
            flicker.flickRing();
            robot.setShootingState(UpliftRobot.ShootingState.DONE_PS3);
        }

    }

    @Override
    public void stop() {

    }
}
