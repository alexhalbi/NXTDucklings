import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class TestSensor {
	public static void main(String[] args) {
		LightSensor leftS = new LightSensor(SensorPort.S1);
		LightSensor rightS = new LightSensor(SensorPort.S4);
		leftS.setFloodlight(true);
		rightS.setFloodlight(true);
		while (true) {
			LCD.drawInt(leftS.getLightValue(), 0, 0);
			LCD.drawInt(rightS.getLightValue(), 0, 100);
		}
	}
}
