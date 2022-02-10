package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMap.HardwareMap_competition;

// name this opMode and determine a group
@TeleOp (name="Competition Teleop", group="Which group")
public class TeleOp_HolonomicDucklComp extends OpMode {

    /* Declare OpMode members. */
    HardwareMap_competition robot       = new HardwareMap_competition();

    @Override
    public void init() {

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Sparks Driver!!");    //

    }
    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {

    }

    @Override
    public void loop() {


        double rStickX;
        double rStickY;
        double lStickX;
        double targetAngle;
        double mag1;
        double mag2;
        double rotationPower;
        double maxPower;
        double scaleDown;

        rStickX = gamepad1.right_stick_x;
        rStickY = -gamepad1.right_stick_y;
        lStickX = gamepad1.left_stick_x;

        boolean isButton2B = gamepad2.b;
        boolean isButton2A = gamepad2.a;
        boolean isButton2X = gamepad2.x;
        boolean isButton2Y = gamepad2.y;

        /// DRIVING PLAYER 1
        targetAngle = (Math.atan2(rStickY,rStickX));

        rotationPower = -lStickX;
        mag1 = Math.sqrt(Math.pow(rStickX,2) + Math.pow(rStickY,2)) * (Math.sin(targetAngle + Math.PI / 4));
        mag2 = Math.sqrt(Math.pow(rStickX,2) + Math.pow(rStickY,2)) * (Math.sin(targetAngle - Math.PI / 4));

        maxPower = Math.max(Math.abs(mag1) +  Math.abs(rotationPower) , Math.abs(mag2) +  Math.abs(rotationPower)) + 0.15;
        scaleDown = 1.0;

        if (maxPower > 1)
            scaleDown = 1.0 / maxPower;


        robot.leftFront.setPower((mag2 - rotationPower) * scaleDown);
        robot.rightFront.setPower((mag1 + rotationPower) * scaleDown);
        robot.leftBack.setPower((mag1 - rotationPower) * scaleDown);
        robot.rightBack.setPower((mag2 + rotationPower) * scaleDown);

        // PLAYER 2

        double speedDuck = 0.5;

        if (isButton2A) {

            robot.duckMotor.setPower(speedDuck);
            robot.duckMotor.setPower(speedDuck);
            telemetry.addData("Button","A");

            //A is retract
        } else if (isButton2B) {

            robot.duckMotor.setPower(-speedDuck);
            robot.duckMotor.setPower(-speedDuck);
            telemetry.addData("Button","B");
            //B is extend

        } else if (isButton2X) {

            robot.duckMotor.setPower(1);
            robot.duckMotor.setPower(1);
            telemetry.addData("Button","X");
            //X is retract, but with full power

        }  else if (isButton2Y) {

            robot.duckMotor.setPower(-1);
            robot.duckMotor.setPower(-1);
            telemetry.addData("Button","X");
            //X is retract, but with full power

        }else {

            telemetry.addData("Button","None");
            robot.duckMotor.setPower(0);
            robot.duckMotor.setPower(0);

        }


    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        telemetry.addData("Say", "Good Job Team! We have STOPPED!!");

    }


}
