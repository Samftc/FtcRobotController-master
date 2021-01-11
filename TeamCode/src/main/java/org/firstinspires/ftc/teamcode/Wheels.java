package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

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
    double Power;
    double RunTime;
    double Turn;
    double Left;
    double Right;
    double Servo;
    double Swivel;
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

    }
}
