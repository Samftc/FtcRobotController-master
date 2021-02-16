package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.lang.annotation.Documented;

@Autonomous
@Disabled
public class RunAuto extends LinearOpMode {




    DcMotor A;
    DcMotor FL;
    DcMotor BL;
    DcMotor BR;
    DcMotor FR;
    com.qualcomm.robotcore.hardware.Servo HS;
    com.qualcomm.robotcore.hardware.Servo HSL;
    com.qualcomm.robotcore.hardware.Servo HSR;

    double position;
    double target;
    double time;
    double power;
    @Override
    public void runOpMode() {


        BR = hardwareMap.dcMotor.get("back_right_motor");
        FR = hardwareMap.dcMotor.get("front_right_motor");
        A = hardwareMap.dcMotor.get("arm_motor");
        FL = hardwareMap.dcMotor.get("front_left_motor");
        BL = hardwareMap.dcMotor.get("back_left_motor");
        HSL = hardwareMap.servo.get("hand_servo_left");
        HSR = hardwareMap.servo.get("hand_servo_right");
        HS = hardwareMap.servo.get("hand_servo");


        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);



        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        FR.setDirection(DcMotorSimple.Direction.REVERSE);




        // Wait for the game to start (driver presses PLAY)
        waitForStart();

      FL.setTargetPosition(1000);
      FR.setTargetPosition(1000);
      BR.setTargetPosition(1000);
      BL.setTargetPosition(1000);

        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        FL.setPower(0.1);
        FR.setPower(0.1);
        BR.setPower(0.1);
        BL.setPower(0.1);




        while(opModeIsActive() && BL.isBusy() && BR.isBusy() && FL.isBusy() & FR.isBusy()){

           position = BL.getCurrentPosition();
           target = BL.getTargetPosition();
           power = BL.getPower();
           telemetry.addData("target", target);
            telemetry.addData("power", power);
        telemetry.addData("position", position);
           telemetry.update();
        }

        FL.setPower(0);
        FR.setPower(0);
        BR.setPower(0);
        BL.setPower(0);


    }
}
