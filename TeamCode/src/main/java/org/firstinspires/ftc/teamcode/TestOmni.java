//Erin Kelley and Sam Bigham 1/9/2021

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "ArmOmni")
class TestOmni extends OpMode {
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
        HS = hardwareMap.servo.get("hand_servo"); //swivel
        HSL = hardwareMap.servo.get("hand_servo_left"); //claw left
        HSR = hardwareMap.servo.get("hand_servo_right"); // claw right

        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        FR.setDirection(DcMotorSimple.Direction.REVERSE);

        //nulls
        HSL.setPosition(0);
        HSR.setPosition(180);

    }

    @Override
    public void loop() {
        Power = gamepad1.left_stick_y; //variable for controller power on motors
        Turn = 1.5*gamepad1.left_stick_x; //variable is used for turning

        if(gamepad1.x){
            Left = 0; //sets the servo to closed
            Right = 180; //sets the servo to open
        }
        else if(gamepad1.b){
            Left =  180; //sets the servo to open
            Right = 0; //sets the servo to closed
        }

        if(gamepad1.y){
            Swivel = 0; //sets servo to closed
        }
        else if(gamepad1.a){
            Swivel = 180; //sets servo to open
        }

        HS.setPosition(Swivel); // sets the position of the servo
        HSL.setPosition(Left);
        HSR.setPosition(Right);

        A.setPower(Arm);    //controls the arm motor

        Arm = -gamepad1.right_stick_y;

        BR.setPower(Power +Turn);  //controls movement... forward, backward, left, right
        FR.setPower(Power +Turn);
        FL.setPower(Power -Turn);
        BL.setPower(Power -Turn);

    }
}

