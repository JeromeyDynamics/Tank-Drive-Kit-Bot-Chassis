package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class TestDrive extends Command {
    private Drivetrain drivetrain;
    private Timer timer;

    public TestDrive(Drivetrain drivetrain) {
        addRequirements(drivetrain);
        this.drivetrain = drivetrain;
        execute();
    }

    @Override public void initialize() { 
        timer.reset(); 
        timer.start();
    }

    @Override
    public void execute() {
        if (timer.get() < 2.0) {
            drivetrain.drive(0.2, 0);
        } else {
            if (timer.get() < 4.0) {
                drivetrain.drive(-0.2, 0);
            } else {
                timer.reset();
                timer.start();
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.drive(RobotContainer.m_driverController.getLeftY(), RobotContainer.m_driverController.getRightX());
    }
}
