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
    double LOmni;
    double ROmni;
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
        LPower = gamepad1.left_stick_y;
        RPower = gamepad1.right_stick_y;
        LOmni = gamepad1. left_stick_x;
        ROmni = gamepad1. right_stick_x;


        BL.setPower(LPower -LOmni);//controls driving motors
        FL.setPower(LPower -ROmni);
        BR.setPower(RPower -ROmni);
        FR.setPower(RPower -LOmni);



        telemetry.addData("Back Left", LPower - LOmni);//displays info in phones
        telemetry.addData("Back Right", LPower - LOmni);
        telemetry.addData("Front Right", RPower - LOmni);
        telemetry.addData("Front Left", RPower - LOmni);

        //cool equation for mapping numbers just in case Y = (X-A)/(B-A) * (D-C) + C

    }
}
