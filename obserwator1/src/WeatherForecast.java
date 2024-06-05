public class WeatherForecast implements Observer, DisplayElement{
    private double oldPressure;
    private double pressure;
    private Subject weatherData;

    public WeatherForecast(Subject aWeatherData) {
        weatherData = aWeatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        if(pressure > oldPressure){
            System.out.println("Ciśnienie rośnie.");
        } else {
            System.out.println("Ciśnienie spada.");
        }
    }

    @Override
    public void update(double temp, double pressure, double humidity) {
        this.oldPressure = this.pressure;
        this.pressure = pressure;
    }
}
