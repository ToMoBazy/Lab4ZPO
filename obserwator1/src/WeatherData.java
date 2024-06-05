import java.util.ArrayList;

public class WeatherData implements Subject{
    private double temp;
    private double pressure;
    private double humidity;

    ArrayList<Observer> observers;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    public void setMeasurements(double temp, double pressure, double humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temp, pressure, humidity);
        }
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
}
