public class Main {
    public static void main(String[] args) {
        WeatherData wd = new WeatherData();
        CurrentConditionDisplay ccd = new CurrentConditionDisplay(wd);
        WeatherForecast wf = new WeatherForecast(wd);
        WeatherStatistics ws = new WeatherStatistics(wd);

        wd.setMeasurements(30,1000,57);
        // 1. Wyświetlacz który będzie powiadamiał o ciśnienia
        wd.setMeasurements(31,1007,45);
        wf.display();
        wd.setMeasurements(29,999,30);
        wf.display();
        wd.setMeasurements(31,999,30);

        // 2. Wyświetlacz ktory będzie powiadamiał o średniej temparaturze
        ws.display();
    }
}