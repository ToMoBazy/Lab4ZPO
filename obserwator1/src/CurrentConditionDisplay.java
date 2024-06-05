public class CurrentConditionDisplay implements Observer, DisplayElement{
    private double temp;
    private double humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(double temp, double pressure, double humidity) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Temperature: " + temp);
        System.out.println("Humidity: " + humidity);
    }

}
