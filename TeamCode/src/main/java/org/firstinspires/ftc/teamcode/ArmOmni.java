package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
// Sam B created this code January 3rd 2021

@TeleOp(name = "ARMNI")
@Disabled
public class ArmOmni extends OpMode {


    DcMotor A;
    DcMotor FL;
    DcMotor BL;
    DcMotor BR;
    DcMotor FR;
    com.qualcomm.robotcore.hardware.Servo HSL;
    com.qualcomm.robotcore.hardware.Servo HSR;
    com.qualcomm.robotcore.hardware.Servo HS;

    double Power;
    double RunTime;
    double Turn;
    double Servo;
    double Arm;


    @Override
    public void init() {
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

        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        FR.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        Power = gamepad1.left_stick_y; //variable for controller power on motors
        Turn = 1.5*gamepad1.left_stick_x; //variable is used for turning



        HSL.setPosition(Servo);  // sets the position of the servo
        HSR.setPosition(Servo);
        A.setPower(Arm);    //controls the arm motor

        Arm = -gamepad1.right_stick_y;

        BR.setPower(Power +Turn);  //controls movement... forward, backward, left, right
        FR.setPower(Power +Turn);
        FL.setPower(Power -Turn);
        BL.setPower(Power -Turn);
        if(gamepad1.x){
            Servo = 0; //sets the servo to closed

        }
        else if(gamepad1.b){
            Servo =  180; //sets the servo to open
        }
    }
}

