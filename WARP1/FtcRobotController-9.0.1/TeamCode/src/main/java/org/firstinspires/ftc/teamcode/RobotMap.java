package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class RobotMap {

    /* Public OpMode members. */
    public static DcMotor frontLeft = null;
    public static DcMotor frontRight = null;
    public static DcMotor backLeft = null;
    public static DcMotor backRight = null;

    public static final double INTAKE_IN = 1.0; //CHANGE
    public static final double INTAKE_OUT = -1.0; //CHANGE

    public static final double LIFTMOTOR_UP = 1.0; //for liftmotor to go up.
    public static final double LIFTMOTOR_DOWN = -1.0; //for liftmotor to go down.


    public static DcMotor liftMotor = null;

    public static DcMotor intakeMotor = null;

    public static DcMotor piviotMotor = null;

    public static final int WHEEL_DIAMETER = 101; //VEX 4 INCH
    public static final double MILLIMETER_TO_INCHES_CONSTANT = 25.4;

    public static final double WHEEL_CIRCUMFERENCE_INCHES = (Math.PI * WHEEL_DIAMETER) / MILLIMETER_TO_INCHES_CONSTANT; // ~ 11.13 in. IN 1120 ticks (1 Rev)

    /* local OpMode members. */
    HardwareMap hardwareMap = null;
    private ElapsedTime runtime = new ElapsedTime();

    /* Constructor */
    public RobotMap() {
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap hwMap) {
        // Save reference to Hardware map
        hardwareMap = hwMap;

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        liftMotor = hardwareMap.get(DcMotor.class, "liftMotor");
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");
        piviotMotor = hardwareMap.get(DcMotor.class, "piviotMotor");

        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        liftMotor.setDirection(DcMotor.Direction.REVERSE);
        intakeMotor.setDirection(DcMotor.Direction.REVERSE);
        piviotMotor.setDirection(DcMotor.Direction.REVERSE);

        // Reset motor encoders
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Set motor default run mode to use encoders
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

}