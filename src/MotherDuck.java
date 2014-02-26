import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;


public class MotherDuck {
	
	public static void main(String[] args) {
		UltrasonicSensor leftS = new UltrasonicSensor(SensorPort.S2);
		UltrasonicSensor rightS = new UltrasonicSensor(SensorPort.S3);
		while(true) {
			if(leftS.getDistance()>40&&rightS.getDistance()>40) {
				Motor.A.setSpeed(250);
				Motor.A.forward();
				Motor.C.setSpeed(250);
				Motor.C.forward();
			} else if(leftS.getDistance()<rightS.getDistance()) {
				Motor.A.setSpeed(125);
				Motor.A.backward();
				Motor.C.setSpeed(250);
				Motor.C.forward();
			} else if(rightS.getDistance()<leftS.getDistance()) {
				Motor.C.setSpeed(250);
				Motor.A.forward();
				Motor.C.setSpeed(125);
				Motor.C.backward();
			}
		}
	}
}
