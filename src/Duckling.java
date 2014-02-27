import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

/**
 * 
 * @author Alexander Halbarth
 * 
 * Dies ist der Code für die folgenden Roboter.
 */
public class Duckling {
	public static void main(String[] args) {
		UltrasonicSensor leftS = new UltrasonicSensor(SensorPort.S2);
		UltrasonicSensor rightS = new UltrasonicSensor(SensorPort.S3);
		LightSensor ls=new LightSensor(SensorPort.S4);
		ls.setFloodlight(true);
		while(true) {
			if(ls.getLightValue()<35) {
				Motor.A.setSpeed(250);
				Motor.A.forward();
				Motor.C.setSpeed(250);
				Motor.C.backward();
			} else if(leftS.getDistance()>10&&rightS.getDistance()>10) { //30
				Motor.A.setSpeed(250);
				Motor.A.forward();
				Motor.C.setSpeed(250);
				Motor.C.forward();
			} else if (leftS.getDistance()<4||rightS.getDistance()<4) {
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
