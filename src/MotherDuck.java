import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

/**
 * 
 * @author Alexander Halbarth
 *
 * Dies ist das Programm für den Front Roboter, er fährt im Kreis herum und sollte von den anderen Robotern
 * erkannt werden.
 */
public class MotherDuck {
	public static void main(String[] args) {
	LightSensor leftS=new LightSensor(SensorPort.S1);
	LightSensor rightS=new LightSensor(SensorPort.S4);
	leftS.setFloodlight(true);
	rightS.setFloodlight(true);
		while(true) {
			 if(leftS.getLightValue()-rightS.getLightValue()>3) {
				Motor.A.setSpeed(125);
				Motor.A.backward();
				Motor.C.setSpeed(250);
				Motor.C.forward();
			} else if(rightS.getLightValue()-leftS.getLightValue()>3) {
				Motor.C.setSpeed(250);
				Motor.A.forward();
				Motor.C.setSpeed(125);
				Motor.C.backward();
			} else if(rightS.getLightValue()<45&&leftS.getLightValue()<45) {
				Motor.C.setSpeed(250);
				Motor.A.forward();
				Motor.C.setSpeed(125);
				Motor.C.backward();
			} else{
				Motor.A.setSpeed(250);
				Motor.A.forward();
				Motor.C.setSpeed(250);
				Motor.C.forward();
			} 
		}
	}
}
