package org.firstinspires.ftc.teamcode.gen1;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

import java.util.Locale;


@TeleOp(name="oldSwerve")
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

    public int MTCoffset = 0;

    public boolean[] timerArray = new boolean[20];

    double[] timeArray = new double[20];

    double time = 0;

    @Override
    public void runOpMode() throws InterruptedException {

        robotHardware robot = new robotHardware(hardwareMap);

        while (!isStarted() && !isStopRequested()) {
        }

        while (opModeIsActive()) {

            robot.swerveDrive(gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x, robot.moveSpeed); //normal people
            //robot.mecanumDrive(gamepad1.right_stick_y, -gamepad1.right_stick_x, -gamepad1.left_stick_x, .75); //nolan

            telemetry.addData("turnPowerRight", robot.turnPowerRight);
            telemetry.addData("aTan degrees", robot.aTan);
            telemetry.addData("newAngle", robot.newAngle);
            telemetry.addData("oppo angle ", robot.oppositeAngle);
            telemetry.addData("rotations ", robot.rotations);
            telemetry.addData("robot power", robot.power);

            //one +     two -
            telemetry.addData("motorRB", robot.motorRB.getCurrentPosition());
            telemetry.addData("motorRF", robot.motorRF.getCurrentPosition());
            telemetry.addData("motorLB",robot.motorLB.getCurrentPosition());
            telemetry.addData("motorLF",robot.motorLF.getCurrentPosition());

            telemetry.addData("right pod pos", robot.rightPodPosition);
            telemetry.addData("left pod pos", robot.leftPodPosition);
            telemetry.addData("current angle right",robot.currentAngle);
            telemetry.addData("final angle",robot.finalAngle);
            telemetry.addData("wheel Direction",robot.wheelDirection);
            telemetry.addData("distance",robot.distance);
            telemetry.addData("oppo-distance",robot.oppositeDistance);
            telemetry.addData("testing",robot.testing);
            telemetry.update();

        }
    }

}
