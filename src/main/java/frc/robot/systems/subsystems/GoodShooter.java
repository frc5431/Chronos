package frc.robot.systems.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;


public class GoodShooter {

    private final WPI_TalonSRX rightShooter, leftShooter;

    private WPI_TalonSRX motor;

    public GoodShooter(WPI_TalonSRX left, WPI_TalonSRX right){
        leftShooter = left;
        rightShooter = right;
    }




}