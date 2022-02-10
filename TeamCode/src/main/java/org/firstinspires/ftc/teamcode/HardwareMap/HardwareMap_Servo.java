package org.firstinspires.ftc.teamcode.HardwareMap;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class HardwareMap_Servo {

    public CRServo intakeServo;
    public static final double START_INTAKE = 0;
    //public static final double END_INTAKE   = 0.40;

    public void init (HardwareMap hardwaremap)
    {

        intakeServo = hardwaremap.crservo.get("intakeServo");
        intakeServo.setDirection(CRServo.Direction.FORWARD);
        intakeServo.setPower(0);

        //intakeServo.setPosition(0);
    }

}