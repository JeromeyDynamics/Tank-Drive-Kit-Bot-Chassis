package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class DefaultDrive extends Command {
    private  Drivetrain drivetrain;
    public DefaultDrive(Drivetrain drivetrain) {
        addRequirements(drivetrain);
        this.drivetrain = drivetrain;
        execute();
    }

    @Override
    public void execute() {
        drivetrain.drive(RobotContainer.m_driverController.getLeftY(), RobotContainer.m_driverController.getRightX());
    }

    @Override
    public void end(boolean interrupted) {
       drivetrain.drive(0, 0);
    }
}
