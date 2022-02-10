package org.firstinspires.ftc.teamcode.HardwareMap;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;


public class HardwareMap_Lift {

    public CRServo liftServo;
    public static final double START_INTAKE = 0;
    //public static final double END_INTAKE   = 0.40;

    public void init (HardwareMap hardwaremap)
    {

        liftServo = hardwaremap.crservo.get("liftServo");
        liftServo.setDirection(CRServo.Direction.FORWARD);
        liftServo.setPower(0);

    }

}