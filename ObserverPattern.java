*******************************************************************************/
import java.util.List;
import java.util.ArrayList;

// Observer Pattern
interface Observer{
     void update(String weatherData);
}

class MobileAppDisplay implements Observer{
    public void update(String weatherData){
         System.out.println("MobileApp updated with: " + weatherData);
    }
}

class WindowsDisplay implements Observer{
    public void update(String weatherData){
         System.out.println("WindowsDisplay updated with: " + weatherData);
    }
}

interface Observable{
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class WeatherObservable implements Observable{
    private List<Observer> observers= new ArrayList<>();
    private String weatherData;
    
    public void registerObserver(Observer observer){
            observers.add(observer);
    }
        
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    
    public void setWeatherData(String weatherData){
        this.weatherData = weatherData;
        notifyObservers();
    }
    
    public void notifyObservers(){
        for(Observer observer: observers){
            observer.update(weatherData);
        }
    }
}

public class Main
{
	public static void main(String[] args) {
	    
       WeatherObservable weatherObservable = new WeatherObservable();
       
       WindowsDisplay windowsDisplay = new WindowsDisplay();
       MobileAppDisplay mobileAppDisplay= new MobileAppDisplay();
       
       weatherObservable.registerObserver(windowsDisplay);
       weatherObservable.registerObserver(mobileAppDisplay);
       
       weatherObservable.setWeatherData("100");
       
       weatherObservable.removeObserver(mobileAppDisplay);
       
       weatherObservable.setWeatherData("200");
	}
}

// more examples like notify me, 
