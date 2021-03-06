package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.Map;

//Created by SamB on Monday January 11th 2021
@TeleOp (name = "Wheels")
public class Wheels extends OpMode {

    DcMotor A;
    DcMotor FL;
    DcMotor BL;
    DcMotor BR;
    DcMotor FR;
    com.qualcomm.robotcore.hardware.Servo HS;
    com.qualcomm.robotcore.hardware.Servo HSL;
    com.qualcomm.robotcore.hardware.Servo HSR;
    double LPower;
    double RPower;
    double Left;
    double turn;
    double slowmode;



    @Override
    public void init() {

        //starts telemetry in the phones
        telemetry.addData("Mode:", "done initializing");
        telemetry.update();

//crossroads is password
          /* Motors:
  back_right_motor
  front_right_motor
  arm_motor
  front_left_motor
  back_left_motor
Servos:
  hand_servo*/
        BR = hardwareMap.dcMotor.get("back_right_motor");
        FR = hardwareMap.dcMotor.get("front_right_motor");
        A = hardwareMap.dcMotor.get("arm_motor");
        FL = hardwareMap.dcMotor.get("front_left_motor");
        BL = hardwareMap.dcMotor.get("back_left_motor");
        HSL = hardwareMap.servo.get("hand_servo_left");
        HSR = hardwareMap.servo.get("hand_servo_right");

        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);



    }

    @Override
    public void loop() {


        if (gamepad1.right_bumper){
            slowmode = 0.5; //slower
        }
        else if (gamepad1.left_bumper){
            slowmode = 1; //normal
        }


        LPower = gamepad1.left_stick_y;

        Left =  gamepad1.left_stick_x;


        RPower =  gamepad1.right_stick_y;

        turn =  gamepad1.right_stick_x;


        BL.setPower(LPower +(2 * Left) );//controls driving motors
        FL.setPower(LPower -(2 * Left) );//should control robot going forward, backward, left, and right
        BR.setPower(LPower -(2 * Left));
        FR.setPower(LPower +(2 * Left));





        if(RPower != 0 || turn != 0){
            BL.setPower(LPower -(2 * turn) );//controls driving motors if it works correctly, it should turn when moving the right joystick
            FL.setPower(LPower -(2 * turn) );
            BR.setPower(LPower +(2 * turn));
            FR.setPower(LPower +(2 * turn));
        }


        telemetry.addData("Back Left", LPower );//displays info in phones
        telemetry.addData("Back Right", LPower);
        telemetry.addData("Front Right", RPower);
        telemetry.addData("Front Left", RPower);

        //cool equation for mapping numbers just in case Y = (X-A)/(B-A) * (D-C) + C

    }
}
