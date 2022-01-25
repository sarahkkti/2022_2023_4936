package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMap.HardwareMap_DuckMotor;

// name this opMode and determine a group
@TeleOp(name="DuckWheelTest", group="Test?")
public class DuckWheelTest extends OpMode{

    /* Declare OpMode members. */
    HardwareMap_DuckMotor robot       = new HardwareMap_DuckMotor();

    @Override
    public void init() {

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello SPARKS Driver!!");    //

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

        boolean isButtonB = gamepad1.b;
        boolean isButtonA = gamepad1.a;
        boolean isButtonX = gamepad1.x;
        boolean isButtonY = gamepad1.y;

        double speed = 0.5;

        if (isButtonA) {

            robot.duckMotor.setPower(speed);
            robot.duckMotor.setPower(speed);
            telemetry.addData("Button","A");

            //A is retract
        } else if (isButtonB) {

            robot.duckMotor.setPower(-speed);
            robot.duckMotor.setPower(-speed);
            telemetry.addData("Button","B");
            //B is extend

        } else if (isButtonX) {

            robot.duckMotor.setPower(1);
            robot.duckMotor.setPower(1);
            telemetry.addData("Button","X");
            //X is retract, but with full power

        }  else if (isButtonY) {

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