import java.util.*;

public class StatisticsDisplay implements Observer, DisplayElement {
	private ArrayList temperatures;
	private ArrayList humidities;
	private ArrayList pressures;
	private Subject weatherData;

	public StatisticsDisplay(Subject weatherData) {
		temperatures = new ArrayList();
		humidities = new ArrayList();
		pressures = new ArrayList();
		weatherData.registerObserver(this);
	}

	public void display() {
		float sumTemperature = 0;
		float sumHumidity = 0;
		float sumPressure = 0;
		Iterator itT = temperatures.iterator();
		Iterator itH = humidities.iterator();
		Iterator itP = pressures.iterator();
		int count = 0;
		while(itT.hasNext()){
			sumTemperature += (float)itT.next();
			sumHumidity += (float)itH.next();
			sumPressure += (float)itP.next();
			count++;
		}
		float avgTemperature = sumTemperature / count;
		float avgHumidity = sumHumidity / count;
		float avgPressure = sumPressure / count;

		System.out.println("Average conditions: " + avgTemperature
				+ "F degrees and " + avgHumidity + "% humidity");
	}

	public void update(float temp, float humidity, float pressure) {
		temperatures.add(temp);
		humidities.add(humidity);
		pressures.add(pressure);
		display();
	}

}
