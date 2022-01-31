package org.firstinspires.ftc.teamcode.HardwareMap;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class HardwareMap_Servo {

    public Servo intakeServo;
    public static final double START_INTAKE = 0;
    //public static final double END_INTAKE   = 0.40;

    public void init (HardwareMap hardwaremap)
    {

        intakeServo = hardwaremap.servo.get("intakeServo");
        intakeServo.setDirection(Servo.Direction.FORWARD);
        intakeServo.setPosition(0);
    }

}