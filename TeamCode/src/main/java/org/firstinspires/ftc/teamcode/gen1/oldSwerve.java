package org.firstinspires.ftc.teamcode.gen1;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.bylazar.configurables.PanelsConfigurables;
import com.bylazar.field.PanelsField;
import com.bylazar.telemetry.PanelsTelemetry;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

import java.util.Locale;


@TeleOp(name="turtle")
//@Disabled

public class oldSwerve extends LinearOpMode
{
    public boolean buttonY = true;
    public boolean buttonX = true;
    public boolean buttonA = true;
    public boolean buttonB = true;
    public boolean buttonLB = true;
    public boolean buttonLT = true;
    public boolean buttonRB = true;
    public boolean buttonRT = true;
    public boolean buttonDR = true;
    public boolean buttonDL = true;
    public boolean buttonDU = true;
    public boolean buttonDD = true;


    public boolean button2Y = true;
    public boolean button2X = true;
    public boolean button2A = true;
    public boolean button2B = true;
    public boolean button2LB = true;
    public boolean button2LT = true;
    public boolean button2RB = true;
    public boolean button2RT = true;
    public boolean button2DR = true;
    public boolean button2DL = true;
    public boolean button2DU = true;
    public boolean button2DD = true;

    public boolean rtOneButtonPress = true;

    public boolean lbOneButtonPress = true;

    public boolean twoltOneButtonPress = true;

    public int MTCoffset = 0;



    double targetVoltage = 1.34; //minimum voltage for slide flips
    double currentVoltage;

    public boolean[] timerArray = new boolean[20];

    double[] timeArray = new double[20];

    double time = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        robotHardware robot = new robotHardware(hardwareMap);

        while (!isStarted() && !isStopRequested()) {

            robot.leftSlideFlip.setTargetPosition(0);
            robot.leftSlideFlip.setPower(0.05);
            robot.leftSlideFlip.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.rightSlideFlip.setTargetPosition(0);
            robot.rightSlideFlip.setPower(0.05);
            robot.rightSlideFlip.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.slidesR.setTargetPosition(0);
            robot.slidesR.setPower(0.05);
            robot.slidesR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.slidesL.setTargetPosition(0);
            robot.slidesL.setPower(0.05);
            robot.slidesL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.rightFinger.setPosition(.5);
            robot.leftFinger.setPosition(.5);

            robot.upWrist.setPosition(.5);
            robot.sideWrist.setPosition(robot.SIDE_WRIST_STRAIGHT);
        }

        while (opModeIsActive()) {

            robot.mecanumDrive(gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x, robot.moveSpeed); //normal people
            //robot.mecanumDrive(gamepad1.right_stick_y, -gamepad1.right_stick_x, -gamepad1.left_stick_x, robot.moveSpeed); //nolan

            robot.slidesR.setTargetPosition((int)(gamepad1.right_trigger * 1300));
            robot.slidesR.setPower(.5);
            robot.slidesR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.slidesL.setTargetPosition((int)(gamepad1.right_trigger * 1300));
            robot.slidesL.setPower(.5);
            robot.slidesL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            if(gamepad1.b && buttonB){

                robot.leftSlideFlip.setTargetPosition(robot.leftSlideFlip.getCurrentPosition() + 10);
                robot.leftSlideFlip.setPower(0.5);
                robot.leftSlideFlip.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                robot.rightSlideFlip.setTargetPosition(robot.rightSlideFlip.getCurrentPosition() + 10);
                robot.rightSlideFlip.setPower(0.5);
                robot.rightSlideFlip.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                buttonB = false;
            }
            if(!gamepad1.b && !buttonB){

                buttonB = true;
            }
            if(gamepad1.a && buttonA){

                robot.leftSlideFlip.setTargetPosition(robot.leftSlideFlip.getCurrentPosition() - 10);
                robot.leftSlideFlip.setPower(0.5);
                robot.leftSlideFlip.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                robot.rightSlideFlip.setTargetPosition(robot.rightSlideFlip.getCurrentPosition() - 10);
                robot.rightSlideFlip.setPower(0.5);
                robot.rightSlideFlip.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                buttonA = false;
            }
            if(!gamepad1.a && !buttonA){

                buttonA = true;
            }



            if(gamepad1.dpad_up && buttonDU){
                //robot.DriveD = robot.DriveD + 0.00005;
                robot.slidesR.setTargetPosition(1220);
                robot.slidesR.setPower(1);
                robot.slidesR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                robot.slidesL.setTargetPosition(1220);
                robot.slidesL.setPower(1);
                robot.slidesL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                buttonDU = false;
            }
            if(!gamepad1.dpad_up && !buttonDU){

                buttonDU = true;
            }


            if(gamepad1.dpad_down && buttonDD){

                robot.slidesR.setTargetPosition(0);
                robot.slidesR.setPower(1);
                robot.slidesR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                robot.slidesL.setTargetPosition(0);
                robot.slidesL.setPower(1);
                robot.slidesL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                buttonDD = false;
            }
            if(!gamepad1.dpad_down && !buttonDD){
                buttonDD = true;
            }



            if(gamepad1.leftBumperWasPressed() && buttonLB){

                if(lbOneButtonPress){
                    robot.sideWrist.setPosition(robot.SIDE_WRIST_STRAIGHT);
                    lbOneButtonPress = false;
                }else{
                    robot.sideWrist.setPosition(robot.SIDE_WRIST_UPSIDE);
                    lbOneButtonPress = true;
                }

                buttonLB = false;
            }
            if(!gamepad1.left_bumper && !buttonLB){

                buttonLB = true;
            }


            if(gamepad1.rightBumperWasPressed() && buttonRB){

                if(rtOneButtonPress){
                    robot.rightFinger.setPosition(.8);
                    robot.leftFinger.setPosition(.2);
                    rtOneButtonPress = false;
                }else{
                    robot.rightFinger.setPosition(.5);
                    robot.leftFinger.setPosition(.5);
                    rtOneButtonPress = true;
                }

                buttonRB = false;
            }
            if(!gamepad1.right_bumper && !buttonRB){

                buttonRB = true;
            }


            /*
            if(Math.abs(currentVoltage - targetVoltage) < 0.05){
                robot.rightSlideFlip.setPower(0);
                robot.leftSlideFlip.setPower(0);
            }
            else if(Math.abs(currentVoltage - targetVoltage) < 0.5){
                robot.rightSlideFlip.setPower(0.25);
                robot.leftSlideFlip.setPower(0.25);
            }
            else if(Math.abs(currentVoltage - targetVoltage) < 0.75){
                robot.rightSlideFlip.setPower(0.5);
                robot.leftSlideFlip.setPower(0.5);
            }
            else{
                robot.rightSlideFlip.setPower(.5);
                robot.leftSlideFlip.setPower(.5);
            }

            if(currentVoltage > targetVoltage){
                robot.rightSlideFlip.setPower(-robot.rightSlideFlip.getPower());
                robot.leftSlideFlip.setPower(-robot.leftSlideFlip.getPower());
            }

             */



            //telemetry.addData("turnPowerRight", robot.turnPowerRight);
            //telemetry.addData("aTan degrees", robot.aTan);
            //telemetry.addData("newAngle", robot.newAngle);
            //telemetry.addData("oppo angle ", robot.oppositeAngle);
            //telemetry.addData("rotations ", robot.rotations);
            //telemetry.addData("robot power", robot.power);

            //one +     two -
            //telemetry.addData("motorRB", robot.motorRB.getCurrentPosition());
            //telemetry.addData("motorRF", robot.motorRF.getCurrentPosition());
            //telemetry.addData("motorLB",robot.motorLB.getCurrentPosition());
            //telemetry.addData("motorLF",robot.motorLF.getCurrentPosition());

            telemetry.addData("right pod pos", robot.rightPodPosition);
            telemetry.addData("left pod pos", robot.leftPodPosition);
            telemetry.addData("current angle right",robot.currentAngle);
            telemetry.addData("final angle",robot.finalAngle);
            telemetry.addData("wheel Direction",robot.wheelDirection);
            telemetry.addData("distance",robot.distance);
            telemetry.addData("oppo-distance",robot.oppositeDistance);
            telemetry.addData("testing",robot.testing);

            telemetry.addData("right finger position", robot.rightFinger.getPosition());
            telemetry.addData("left finger position", robot.leftFinger.getPosition());
            telemetry.addData("up wrist position", robot.upWrist.getPosition());
            telemetry.addData("side wrist position", robot.sideWrist.getPosition());

            telemetry.addData("right Flip", robot.rightSlideFlip.getCurrentPosition());

            telemetry.addData("right slides", robot.slidesR.getCurrentPosition());
            telemetry.addData("left slides", robot.slidesL.getCurrentPosition());

            telemetry.addData("Potentiometer voltage", currentVoltage);

            //telemetry.addData("General F", robot.GeneralF);
            //telemetry.addData("General P", robot.GeneralP);
            //telemetry.addData("General D", robot.GeneralD);
            //telemetry.addData("General I", robot.GeneralI);

            //telemetry.addData("Drive F", robot.DriveF);
            //telemetry.addData("Drive P", robot.DriveP);
            //telemetry.addData("Drive D", robot.DriveD);
            //telemetry.addData("Drive I", robot.DriveI);

            //telemetry.addData("Turn F", robot.TurnF);
            //telemetry.addData("Turn P", robot.TurnP);
            //telemetry.addData("Turn D", robot.TurnD);
            //telemetry.addData("Turn I", robot.TurnI);

            telemetry.update();

        }
    }
}
