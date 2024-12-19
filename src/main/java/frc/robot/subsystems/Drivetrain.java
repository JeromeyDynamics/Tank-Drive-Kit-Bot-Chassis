package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.units.measure.Velocity;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    private final SparkMax leftFront, rightFront, leftBack, rightBack;

    private final DifferentialDrive drive;
    public Drivetrain() {
        leftFront = new SparkMax(Constants.kLeftFrontMotorID, MotorType.kBrushless);
        rightFront = new SparkMax(Constants.kRightFrontMotorID, MotorType.kBrushless);
        leftBack = new SparkMax(Constants.kLeftBackMotorID, MotorType.kBrushless);
        rightBack = new SparkMax(Constants.kRightBackMotorID, MotorType.kBrushless);
        
        MotorControllerGroup leftMotors = new MotorControllerGroup(leftFront, leftBack);
        MotorControllerGroup rightMotors = new MotorControllerGroup(rightFront, rightBack);

        leftFront.setInverted(true);
        leftBack.setInverted(true);

        drive = new DifferentialDrive(leftMotors, rightMotors);
    }

    public void drive(double velocity, double rotation) {
        drive.arcadeDrive(velocity, rotation);
     
    }

    public void stop() {
        drive.arcadeDrive(0, 0);
    }
}

