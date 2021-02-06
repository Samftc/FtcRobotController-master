package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

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
    double pos;
    boolean go = false;
    @Override
    public void init() {

        //starts telemetry in the phones
        telemetry.addData("Mode:", "done initializing");
        telemetry.update();

//crossroads is password to control hub
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
        FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

      /*  pos = 1;
        HS.setPosition(pos);
        HSL.setPosition(0.9);
        HSR.setPosition(0.1);

*/
        pos = 0;

    }

    @Override
    public void loop() {

        HS.setPosition(pos);





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




        up = gamepad2.right_trigger;
        down = gamepad2.left_trigger;

        A.setPower(up - down);

        //open claw
        if(gamepad2.x){
            HSL.setPosition(0.8); //sets the servo to open
            HSR.setPosition(0.2);

        }
        //close claw
        if(gamepad2.b){
            HSL.setPosition(0.0); //sets the servo to closed
            HSR.setPosition(1);
        }

        //swivels claw
        if(gamepad2.y && go){
            pos = pos + 0.2;
            go = false;
        }

        if(gamepad2.a && go){
            pos = pos - 0.2;
            go = false;
        }
        if (!gamepad2.a && !gamepad1.y){

            if (pos > 1){
                pos = 1;
            }
            else if(pos < 0){
                pos = 0;
            }

            go = true;
            //ends claw swivel
        }










        telemetry.addData("Back Left", LPower +(2 * Left) );//displays info in phones
        telemetry.addData("Front Left",LPower -(2 * Left) );
        telemetry.addData("Back Right", LPower -(2 * Left));
        telemetry.addData("Front Right", LPower +(2 * Left));
        telemetry.addData("pos", pos);

        //cool equation for mapping numbers just in case Y = (X-A)/(B-A) * (D-C) + C


    }
}
