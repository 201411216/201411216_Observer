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
		System.out.print("( Temperature : ");
		if(lastTemperature < currentTemperature){
			System.out.print(" up ");
		}
		else if(lastTemperature == currentTemperature){
			System.out.print("same");
		}
		else if(lastTemperature > currentTemperature){
			System.out.print("down");
		}
		System.out.print(" | Humidity : ");
		if(lastHumidity < currentHumidity){
			System.out.print(" up ");
		}
		else if(lastHumidity == currentHumidity){
			System.out.print("same");
		}
		else if(lastHumidity > currentHumidity){
			System.out.print("down");
		}
		System.out.print(" | Pressure : ");
		if(lastPressure < currentPressure){
			System.out.print(" up ");
		}
		else if(lastPressure == currentPressure){
			System.out.print("same");
		}
		else if(lastPressure > currentPressure){
			System.out.print("down");
		}
		System.out.println(" )");
	}
}
