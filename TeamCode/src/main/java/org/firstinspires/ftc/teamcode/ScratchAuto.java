package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Scratch Auto")


public class ScratchAuto extends LinearOpMode {


    HardwareOmni    robot   = new HardwareOmni();   //Uses the motors and stuff in the class HardwareOmni
    private ElapsedTime runtime = new ElapsedTime();

    static final double DriveSpeed = 0;

    double FRpos = 0;
    double FLpos = 0;
    double BLpos = 0;
    double BRpos = 0;



    @Override
    public void runOpMode() {
        robot.init(hardwareMap);    //actually sets up the motors from HardwareOmni



        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Resetting Encoders");    //
        telemetry.update();

        robot.FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.A.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData("Position", "%7d :%7d", FRpos, FLpos, BRpos, BLpos);
        telemetry.update();





        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        ForwardDrive(DriveSpeed, 48 , 48, 48, 48, 5);
    }

    private void ForwardDrive(double speed, double FR, double FL, double BR, double BL, double StopTime) {
        if (opModeIsActive()){
            int FRTarget;
            int FLTarget;
            int BRTarget;
            int BLTarget;

            FRTarget = robot.FR.getCurrentPosition() + (int) (FR)*1000;
            FLTarget = robot.FL.getCurrentPosition() + (int) (FL)*1000;
            BRTarget = robot.BR.getCurrentPosition() + (int) (BR)*1000;
            BLTarget = robot.BL.getCurrentPosition() + (int) (BL)*1000;
            robot.FR.setTargetPosition(FRTarget);
            robot.BR.setTargetPosition(BRTarget);
            robot.FL.setTargetPosition(FLTarget);
            robot.BL.setTargetPosition(BLTarget);

            robot.FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            robot.FR.setPower(Math.abs(speed));
            robot.FL.setPower(Math.abs(speed));
            robot.BR.setPower(Math.abs(speed));
            robot.BL.setPower(Math.abs(speed));
            while (opModeIsActive() &&
                    (runtime.seconds() < StopTime) &&
                    (robot.FR.isBusy() && robot.FL.isBusy() && robot.BR.isBusy() && robot.BL.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Path1",  "Running to %7d :%7d", FRTarget,  FLTarget, BRTarget, BLTarget);
                telemetry.addData("Path2",  "Running at %7d :%7d",
                        robot.FR.getCurrentPosition(),
                        robot.FL.getCurrentPosition(),
                        robot.BL.getCurrentPosition(),
                        robot.BR.getCurrentPosition());
                telemetry.update();
            }

            // Stop all motion;
            robot.FR.setPower(0);
            robot.FL.setPower(0);
            robot.BL.setPower(0);
            robot.BR.setPower(0);

            // Turn off RUN_TO_POSITION
            robot.FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            sleep(250);   // optional pause after each move
        }


    }

}
