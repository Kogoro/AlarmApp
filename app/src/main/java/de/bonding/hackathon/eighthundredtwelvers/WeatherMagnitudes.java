package de.bonding.hackathon.eighthundredtwelvers;


public enum WeatherMagnitudes {

           WEATHER, TEMPERATURE, WINDSPEED, HUMIDITY, PRESSURE, LOCATION;
   private String value;

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }
}
