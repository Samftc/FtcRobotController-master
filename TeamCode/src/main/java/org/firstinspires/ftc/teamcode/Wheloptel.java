package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Wheloptel")

public class Wheloptel extends OpMode {

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
    double slowmode = 1;
    double Turn;
    double Servo;
    double up;
    double down;
    double pos = 0;
    boolean go = false;
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
        HS = hardwareMap.servo.get("hand_servo");

        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);

        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        A.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }

    @Override
    public void loop() {




        if (gamepad1.right_bumper){
            slowmode = 0.2; //slower
        }
        else if (gamepad1.left_bumper){
            slowmode = 1; //normal
        }


        LPower = slowmode * gamepad1.left_stick_y;

        Left = slowmode * gamepad1.left_stick_x;


        RPower = slowmode * gamepad1.right_stick_y;

        turn = slowmode * gamepad1.right_stick_x;


        BL.setPower(LPower +(2 * Left) );//controls driving motors
        FL.setPower(LPower -(2 * Left) );
        BR.setPower(LPower -(2 * Left));
        FR.setPower(LPower +(2 * Left));


        if(RPower != 0 || turn != 0){
            BL.setPower(LPower -(2 * turn) );//controls driving motors
            FL.setPower(LPower -(2 * turn) );
            BR.setPower(LPower +(2 * turn));
            FR.setPower(LPower +(2 * turn));
        }




        up = gamepad1.right_trigger;
        down = gamepad1.left_trigger;

        A.setPower(up - down);

        if(gamepad1.x){
            HSL.setPosition(30); //sets the servo to closed
            HSR.setPosition(30);

        }
        else if(gamepad1.b){
            HSL.setPosition(180); //sets the servo to open
            HSR.setPosition(180);
        }


        HS.setPosition(pos);

        if (!gamepad1.a && go){
            pos = +1;
            go = false;
        }

        if (gamepad1.a){
            go =true;

        }
        else if(gamepad1.y){
            go = false;
        }

        else if (!gamepad1.y && !go){
            pos = -1;
            go = true;
        }






        telemetry.addData("Back Left", LPower );//displays info in phones
        telemetry.addData("Back Right", LPower);
        telemetry.addData("Front Right", RPower);
        telemetry.addData("Front Left", RPower);

        //cool equation for mapping numbers just in case Y = (X-A)/(B-A) * (D-C) + C


    }
}
