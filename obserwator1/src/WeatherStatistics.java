import java.util.ArrayList;

public class WeatherStatistics implements Observer, DisplayElement{
    private double averageTemp =0;
    private double minTemp;
    private double maxTemp;

    private ArrayList<Double> listOfTemperatures;

    Subject weatherData;

    public WeatherStatistics(Subject aWeatherData) {
        weatherData = aWeatherData;
        weatherData.registerObserver(this);
        listOfTemperatures = new ArrayList<>();
    }

    @Override
    public void display() {
        System.out.println("MaxTemp: " + maxTemp);
        System.out.println("MinTemp: " + minTemp);
        System.out.println("Average: " + averageTemp);
    }

    @Override
    public void update(double temp, double pressure, double humidity) {
        if(listOfTemperatures.isEmpty()){
            minTemp = temp;
        }
        if(minTemp > temp){
            minTemp = temp;
        }
        if(maxTemp < temp){
            maxTemp = temp;
        }
        listOfTemperatures.add(temp);
        averageTemp = listOfTemperatures.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}
