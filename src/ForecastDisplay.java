public class ForecastDisplay implements Observer, DisplayElement {
	float lastTemperature;
	float lastHumidity;
	float lastPressure;
	float currentTemperature;
	float currentHumidity;
	float currentPressure;
	
	public ForecastDisplay(Subject weatherData){
		lastTemperature = 0;
		lastHumidity = 0;
		lastPressure = 0;
		currentTemperature = 0;
		currentHumidity = 0;
		currentPressure = 0;
		weatherData.registerObserver(this);
	}
	
	public void update(float temperature, float humidity, float pressure) {
		lastTemperature = currentTemperature;
		lastHumidity = currentHumidity;
		lastPressure = currentPressure;
		currentTemperature = temperature;
		currentHumidity = humidity;
		currentPressure = pressure;
		display();
	}
	
	public void display() {
		System.out.println("Last conditions: " + lastTemperature 
			+ "F degrees and " + lastHumidity + "% humidity");
		System.out.println("Current conditions: " + currentTemperature 
				+ "F degrees and " + currentHumidity + "% humidity");
	}
}
