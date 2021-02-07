package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
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

    public static final double MID_SERVO = 0.5;
    public static final double ARM_UP_POWER = 0.45;
    public static final double ARM_DOWN_POWER = -0.45;

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


       /* BR = hardwareMap.dcMotor.get("back_right_motor");
        FR = hardwareMap.dcMotor.get("front_right_motor");
        A = hardwareMap.dcMotor.get("arm_motor");
        FL = hardwareMap.dcMotor.get("front_left_motor");
        BL = hardwareMap.dcMotor.get("back_left_motor");
        HSL = hardwareMap.servo.get("hand_servo_left");
        HSR = hardwareMap.servo.get("hand_servo_right");
        HS = hardwareMap.servo.get("hand_servo"); */
    }
}
