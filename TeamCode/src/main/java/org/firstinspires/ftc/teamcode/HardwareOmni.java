package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareOmni
{
    /* Public OpMode members. */
    DcMotor A = null;
    DcMotor FL = null;
    DcMotor BL = null;
    DcMotor BR = null;
    DcMotor FR = null;
    Servo HS = null;
    Servo HSL = null;
    Servo HSR = null;
/*
    public static final double MID_SERVO = 0.5;
    public static final double ARM_UP_POWER = 0.45;
    public static final double ARM_DOWN_POWER = -0.45;      */

    /* local OpMode members. */
    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    /* Constructor */
    public HardwareOmni() {
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        BR = hwMap.get(DcMotor.class, "back_right_motor");
        FR = hwMap.get(DcMotor.class, "front_right_motor");
        A = hwMap.get(DcMotor.class, "arm_motor");
        FL = hwMap.get(DcMotor.class, "front_left_motor");
        BL = hwMap.get(DcMotor.class, "back_left_motor");


        FR.setDirection(DcMotorSimple.Direction.REVERSE);
        BR.setDirection(DcMotorSimple.Direction.REVERSE);

        BR.setPower(0);
        FR.setPower(0);
        A.setPower(0);
        FL.setPower(0);
        BL.setPower(0);

        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        A.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize ALL installed servos.
        HSL = hwMap.get(Servo.class, "hand_servo_left");
        HSR = hwMap.get(Servo.class, "hand_servo_right");
        HS = hwMap.get(Servo.class, "hand_servo");
      /*  HSL.setPosition(MID_SERVO);
        HSR.setPosition(MID_SERVO);     */
    }
}
