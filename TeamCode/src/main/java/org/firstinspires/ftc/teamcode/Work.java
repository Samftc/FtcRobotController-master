package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
@Disabled
public class Work extends LinearOpMode {
    HardwareOmni  rob = new HardwareOmni();

    @Override
    public void runOpMode() throws InterruptedException {
        rob.init(hardwareMap);


        rob.FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rob.FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rob.FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rob.FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();

        ForwardDrive(10, 10, 10);
    }

    private void ForwardDrive(int i, int i1, int i2) {
        rob.FR.setTargetPosition(1000);
        rob.FL.setTargetPosition(1000);

        rob.FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rob.FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rob.FL.setPower(0.005);
        rob.FR.setPower(0.005);
        while(rob.FL.isBusy() && rob.FR.isBusy()){

        }

        rob.FL.setPower(0);
        rob.FR.setPower(0);

    }
}
