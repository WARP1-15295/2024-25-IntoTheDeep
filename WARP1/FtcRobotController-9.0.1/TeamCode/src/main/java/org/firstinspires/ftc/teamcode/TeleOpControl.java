package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(name="TeleOp Control")
//@Disabled
public class TeleOpControl extends OpMode {
    // Declare OpMode members here
    private ElapsedTime elapsedTime = new ElapsedTime();
    RobotMap robotMap = new RobotMap();

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        robotMap.init(hardwareMap);
    }

    @Override
    public void init_loop() {
    }

    public
    @Override
    void start() {
        elapsedTime.reset();
    }

    @Override
    public void loop() {
        //GAME-PAD 1
        //GAMEPAD 1
        double degreesToRads45 = -Math.PI/4;
        double leftStickDeadzone = 0.1;
        double rightStickDeadzone = 0.1;

        double x = gamepad1.left_stick_x * Math.cos(degreesToRads45) + gamepad1.left_stick_y * Math.sin(degreesToRads45);
        double y = -gamepad1.left_stick_y * Math.cos(degreesToRads45) + gamepad1.left_stick_x * Math.sin(degreesToRads45);
        double rotate = gamepad1.right_stick_x;

        if (Math.abs(rotate) > rightStickDeadzone) {
            robotMap.frontLeft.setPower(rotate);
            robotMap.backLeft.setPower(rotate);
            robotMap.backRight.setPower(-rotate);
            robotMap.frontRight.setPower(-rotate);
        } else if(Math.abs(x) > leftStickDeadzone || Math.abs(y) > leftStickDeadzone){
            robotMap.frontLeft.setPower(x);
            robotMap.backLeft.setPower(y);
            robotMap.frontRight.setPower(y);
            robotMap.backRight.setPower(x);
        } else {
            robotMap.frontLeft.setPower(0.0);
            robotMap.backLeft.setPower(0.0);
            robotMap.frontRight.setPower(0.0);
            robotMap.backRight.setPower(0.0);
        }




        //thaeden made this part of if code.
        if (Math.abs(gamepad2.left_stick_y) > 0.1) {
            robotMap.liftMotor.setPower(gamepad2.left_stick_y);
        } else {
            robotMap.liftMotor.setPower(0.0);
        }

        if (gamepad1.left_trigger > 0.3) {
            robotMap.intakeMotor.setPower(robotMap.INTAKE_OUT);
        } else if (gamepad1.right_trigger > 0.3) {
            robotMap.intakeMotor.setPower(robotMap.INTAKE_IN);
        } else {
            robotMap.intakeMotor.setPower(0.0);
        }

        if (Math.abs(gamepad2.right_stick_y) > 0.1) {
            robotMap.piviotMotor.setPower(gamepad2.right_stick_y);
        } else {
            robotMap.piviotMotor.setPower(gamepad2.right_stick_y);
        }
    }
}