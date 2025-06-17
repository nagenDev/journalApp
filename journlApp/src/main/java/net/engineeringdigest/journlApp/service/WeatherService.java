package net.engineeringdigest.journlApp.service;

import net.engineeringdigest.journlApp.api.responce.WeatherResponce;
import net.engineeringdigest.journlApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;

    @Value("${weather.api.key}")
    private  String weather;
    @Autowired
    private RestTemplate restTemplate;

 //   private static final String API = "https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    public WeatherResponce getWeather(String city) {
        WeatherResponce weatherResponce = redisService.get("weather_of_" +city, WeatherResponce.class);
        if (weatherResponce != null) {
            return weatherResponce;
        } else {
            String finalApi = appCache.APP_CACHE.get("weather_api").replace("<city>", city).replace("<apiKey>", weather);
            ResponseEntity<WeatherResponce> response = restTemplate.exchange(finalApi, HttpMethod.POST, null, WeatherResponce.class);
            WeatherResponce body = response.getBody();
            if (body != null) {
                redisService.set("weather_of_" + city, body,300l);
            }
            return body;
        }
    }

}
//e611b0564ec10fbf1d078106d8e511f8