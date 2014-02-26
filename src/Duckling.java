import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;


public class Duckling {
	
	public static void main(String[] args) {
		UltrasonicSensor leftS = new UltrasonicSensor(SensorPort.S2);
		UltrasonicSensor rightS = new UltrasonicSensor(SensorPort.S3);
		while(true) {
			if(leftS.getDistance()>30&&rightS.getDistance()>30) {
				Motor.A.setSpeed(250);
				Motor.A.forward();
				Motor.C.setSpeed(250);
				Motor.C.forward();
			} else if (leftS.getDistance()<8||rightS.getDistance()<8) {
				Motor.A.stop();
				Motor.C.stop();
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
