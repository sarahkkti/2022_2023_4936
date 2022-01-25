package org.firstinspires.ftc.teamcode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.HardwareMap.HardwareMap_Servo;

@TeleOp(name = "intakeServo Test", group = "Test")
//@Disabled
public class TeleOp_Lift extends OpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    HardwareMap_Servo robot       = new HardwareMap_Servo();

    @Override
    public void init() {
        robot.init(hardwareMap);

    }

    @Override
    public void loop() {

        final double INCREMENT = 0.01;
        boolean isButtonB= gamepad1.b;
        boolean isButtonA = gamepad1.a;

        double position = robot.intakeServo.getPosition();

        if (isButtonA) {

            position += INCREMENT;
            robot.intakeServo.setPosition(position);

        } else if (isButtonB) {

            position -= INCREMENT;
            robot.intakeServo.setPosition(position);

        }
        telemetry.addData("Box Servo Position",String.format("%.2f", robot.intakeServo.getPosition()));
    }

}