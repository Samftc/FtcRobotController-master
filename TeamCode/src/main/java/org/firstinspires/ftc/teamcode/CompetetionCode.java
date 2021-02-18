package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
//Disabled
public class CompetetionCode extends LinearOpMode {


    double time;//declares variables
    double position;

    double TurnPosition;


    HardwareOmni rob = new HardwareOmni();//uses setup from Hardware Omni
    @Override
    public void runOpMode(){

        waitForStart();//wait for the start

        rob.init(hardwareMap);// starts using hardware omni
        RESET();




        position = -1 *(rob.FL.getCurrentPosition() + rob.FR.getCurrentPosition() //position is equal to the position of all of the motors combined
                //Position is gotten from the encoder positions of the motors
                + rob.BR.getCurrentPosition() + rob.BL.getCurrentPosition());

        TurnPosition =   -1*(rob.FL.getCurrentPosition() + rob.BR.getCurrentPosition()) + rob.BL.getCurrentPosition() + rob.FR.getCurrentPosition();
        // is basically the exact same as position, but it is Just the Front Left and Back Left motors
            //If it was using position code while turning, the motors that would turn the other way would interfere with each other

        time = getRuntime();// gets the runtime





        while (time < 10 && position <= 10000 && opModeIsActive()){//while time is less and position is less than assigned number, the code runs
            DriveForward(); //function that runs code which makes the robot go forward
        }

        ALL();//runs both BREAK sleep and RESET functions and code

        while (time < 10 && position >= -500 && opModeIsActive()){
            Backwards();//the robot goes backwards
        }

        ALL();


        while (time < 10 && TurnPosition >= -5000 && opModeIsActive()){

            LeftTurn();//the robot turns left


        }

       ALL();


        while (time < 10 && position <= 10000 && opModeIsActive()){
            DriveForward();//the robot goes forward
        }


       ALL();


        //robot should be near the wall in this part, now there should be code to score a few points and then back up

        while (time < 10 && position >= -10000 && opModeIsActive()){
            Backwards();//robot goes backwards
        }

        ALL();


    }

    private void ALL() { //contains BREAK sleep and RESET code
        BREAK(); //stops movement

        sleep(2000); //stops code for certain time

        RESET(); //resets encoders and runtime to zero

    }

    private void RESET() {//sets encoders and runtime to zero
        rob.FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);//resets encoders so they say zero
        rob.FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rob.BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rob.BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        rob.BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);//motors don't run with encoders, but it is still possible to read the encoders
        rob.FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rob.A.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rob.FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rob.BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        rob.BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);// when the motor is not moving it automatically breaks
        rob.FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rob.FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rob.BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rob.A.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        resetStartTime();//resets runtime
        time = getRuntime();// now equal to zero


    }

    private void LeftTurn() {//the robot moves left
        rob.FL.setPower(-0.5);//sets power of the motors
        rob.FR.setPower(0.5);//motors must turn in a specific way to make the robot go directly left
        rob.BR.setPower(-0.5);
        rob.BL.setPower(0.5);


        TurnPosition =   -1*(rob.FL.getCurrentPosition() + rob.BR.getCurrentPosition()) + rob.BL.getCurrentPosition() + rob.FR.getCurrentPosition();



        time = getRuntime();


        telemetry.addData("TurnPosition", TurnPosition);
        telemetry.addData("FL",rob.FL.getCurrentPosition());
        telemetry.addData("FR",rob.FR.getCurrentPosition());
        telemetry.addData("BR",rob.BR.getCurrentPosition());
        telemetry.addData("BL",rob.BL.getCurrentPosition());
        telemetry.update();
    }

    private void RightTurn() {
        rob.FL.setPower(0.5);
        rob.FR.setPower(-0.5);
        rob.BR.setPower(0.5);
        rob.BL.setPower(-0.5);


        TurnPosition =   -1*(rob.FL.getCurrentPosition() + rob.BR.getCurrentPosition()) + rob.BL.getCurrentPosition() + rob.FR.getCurrentPosition();



        time = getRuntime();


        telemetry.addData("TurnPosition", TurnPosition);
        telemetry.addData("FL",rob.FL.getCurrentPosition());
        telemetry.addData("FR",rob.FR.getCurrentPosition());
        telemetry.addData("BR",rob.BR.getCurrentPosition());
        telemetry.addData("BL",rob.BL.getCurrentPosition());
        telemetry.update();
    }

    private void Backwards() {
        rob.FL.setPower(-0.5);
        rob.FR.setPower(-0.5);
        rob.BR.setPower(-0.5);
        rob.BL.setPower(-0.5);


        time = getRuntime();

        position = -1 *(rob.FL.getCurrentPosition() + rob.FR.getCurrentPosition()
                + rob.BR.getCurrentPosition() + rob.BL.getCurrentPosition());



        telemetry.addData("Position", position);
        telemetry.addData("FL",rob.FL.getCurrentPosition());
        telemetry.addData("FR",rob.FR.getCurrentPosition());
        telemetry.addData("BR",rob.BR.getCurrentPosition());
        telemetry.addData("BL",rob.BL.getCurrentPosition());
        telemetry.update();

    }

    private void RunForward() {
        rob.FL.setPower(1);
        rob.FR.setPower(1);
        rob.BR.setPower(1);
        rob.BL.setPower(1);

        time = getRuntime();

        position = -1 *(rob.FL.getCurrentPosition() + rob.FR.getCurrentPosition()
                + rob.BR.getCurrentPosition() + rob.BL.getCurrentPosition());



        telemetry.addData("Position", position);
        telemetry.addData("FL",rob.FL.getCurrentPosition());
        telemetry.addData("FR",rob.FR.getCurrentPosition());
        telemetry.addData("BR",rob.BR.getCurrentPosition());
        telemetry.addData("BL",rob.BL.getCurrentPosition());
        telemetry.update();
    }

    private void BREAK() {
        rob.FL.setPower(0);
        rob.FR.setPower(0);
        rob.BR.setPower(0);
        rob.BL.setPower(0);

    }

    private void DriveForward() {
        rob.FL.setPower(0.5);
        rob.FR.setPower(0.5);
        rob.BR.setPower(0.5);
        rob.BL.setPower(0.5);




        time = getRuntime();

        position = -1 *(rob.FL.getCurrentPosition() + rob.FR.getCurrentPosition()
                + rob.BR.getCurrentPosition() + rob.BL.getCurrentPosition());



        telemetry.addData("Position", position);
        telemetry.addData("FL",rob.FL.getCurrentPosition());
        telemetry.addData("FR",rob.FR.getCurrentPosition());
        telemetry.addData("BR",rob.BR.getCurrentPosition());
        telemetry.addData("BL",rob.BL.getCurrentPosition());
        telemetry.update();

    }
}
