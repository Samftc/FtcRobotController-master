package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name =  "Pushbot: Teleop Tank", group ="Pushbot")
public class Omni extends OpMode {

    //@Disabled can be uncommented below to disable the OpMode
//@Disable
    //public variable definitions


        //hardware definitions
        public DcMotor LF = null;
        public DcMotor LB = null;
        public DcMotor RF = null;
        public DcMotor RB = null;

    /*
    //pairing DcMotor variables to configuration files
    LF = hardwareMap.get(DcMotor.class, "motor1");
    LB = hardwareMap.get(DcMotor.class, "motor2");
    RF = hardwareMap.get(DcMotor.class, "motor4");
    RB = hardwareMap.get(DcMotor.class, "motor3");

    //Seting hardware modes
    RF.Direction(DcMotor.Direction.REVERSE);
    RB.Direction(DcMotor.Direction.REVERSE);
    LF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    LB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    RF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    RB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    */

        @Override
    public void init() {
//would normally include preliminary calculations/initializations here
            telemetry.addData("Mode:", "done initializing");
            telemetry.update();
    }

    @Override
    public void loop() {
        //private variable definitions
        float LFpower = 0;    //resets motor calculations
        float LBpower = 0;
        float RFpower = 0;
        float RBpower = 0;

        //puts gamepad values in variables so they will be the same throughout the iteration
        float gamepadLX = gamepad1.left_stick_x;
        float gamepadLY = gamepad1.left_stick_y;
        float gamepadRX = gamepad1.right_stick_x;



        //converts stick inputs to motor powers
        if(gamepadLX != 0){
            LBpower += Math.cos(45*gamepadLX)-Math.sin(45*gamepadLY);
            RFpower += Math.cos(45*gamepadLX)-Math.sin(45*gamepadLY);
        }

        if(gamepadLY != 0){
            LBpower += Math.sin(45*gamepadLX)+Math.cos(45*gamepadLY);
            RFpower += Math.sin(45*gamepadLX)+Math.cos(45*gamepadLY);
        }

        if(gamepadRX != 0){
            LFpower += gamepadRX;
            LBpower += gamepadRX;
            RFpower -= gamepadRX;
            RBpower -= gamepadRX;
        }

        //makes variables compatible with motor powers
        if(LFpower > 1 || LBpower > 1 || RFpower > 1 || RBpower > 1){
            float max = Math.max(Math.max(LBpower, LFpower), Math.max(RBpower, RFpower));
            LFpower /= max;
            LBpower /= max;
            RFpower /= max;
            RBpower /= max;
        }

        //motor powers must be set to doubles
        double LFpowerDouble = LFpower;
        double LBpowerDouble = LBpower;
        double RFpowerDouble = RFpower;
        double RBpowerDouble = RBpower;


        //outputs calculated motor powers to motors
        LF.setPower(LFpowerDouble);
        RF.setPower(RFpowerDouble);
        LB.setPower(LBpowerDouble);
        RB.setPower(RBpowerDouble);

        // telemetry data dump and update
        telemetry.addData("LF power", LFpower);
        telemetry.addData("RF power", RFpower);
        telemetry.addData("LB power", LBpower);
        telemetry.addData("RB power", RBpower);

        telemetry.update();

    }
}
