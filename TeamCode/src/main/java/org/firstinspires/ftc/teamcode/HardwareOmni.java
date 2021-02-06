package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareOmni
{
    /* Public OpMode members. */

   public DcMotor A;
   public DcMotor FL;
   public DcMotor BL;
   public DcMotor BR;
   public DcMotor FR;
   Servo HS;
   Servo HSL;
   Servo HSR;
    public static final double MID_SERVO       =  0.5 ;
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;

    HardwareMap hwMap;

    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwareOmni(){

    }
    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;



    }
}
