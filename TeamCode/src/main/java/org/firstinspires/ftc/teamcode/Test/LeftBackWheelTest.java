package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.HardwareMap.HardwareMap_example;


/**
 *  Test Program for Left Front Wheel - Drive Slow for a couple of inches.
 *  This test program is to verify encorders and motors are working without a hitch
 *  The motor is set to STOP_AND RESET_ENCODER, TARGET_POSITION and RUN_USING_ENCODER
 */

@Autonomous(name="LeftBack", group="Wheel")
//@Disabled
public class LeftBackWheelTest extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareMap_example robot   = new HardwareMap_example();   // Use a Pushbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();

    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.3; //drive slow
    static final double     TURN_SPEED              = 0.5;

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        int state = 0;
        if (state == 0){
            //init robot
            robot.init(hardwareMap);


            // Send telemetry message to signify robot waiting;
            telemetry.addData("Status", "Resetting Encoders");    //
            telemetry.update();

            robot.leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            robot.leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    
            waitForStart();
            state = 1;
        }

        //moving forward several inches
        if (state == 1){
            telemetry.addData("State","1");
            telemetry.update();
            encoderDriveRightFront(DRIVE_SPEED, 7, 4.0);
            //facing Forward strafe left one foot.
            state = 2;
        }

        sleep(1000);     // pause for servos to move

        telemetry.addData("Path", "Complete");
        telemetry.update();


    }

    public void encoderDriveRightFront(double speed,
                             double leftInches,
                             double timeoutS) {

        int newRightTarget;


        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newRightTarget = robot.leftBack.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
            robot.leftBack.setTargetPosition(newRightTarget);

            // Turn On RUN_TO_POSITION
            robot.leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            robot.leftBack.setPower(Math.abs(speed));

            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (robot.leftBack.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Path1",  "Running to %7d", newRightTarget);
                telemetry.addData("Path2",  "Running at %7d",
                        robot.leftBack.getCurrentPosition());
                telemetry.update();
            }

            // Stop all motion;
            robot.leftBack.setPower(0);

            // Turn off RUN_TO_POSITION
            robot.leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
        }
    }


}

