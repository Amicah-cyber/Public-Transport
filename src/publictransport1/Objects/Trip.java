/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publictransport1.Objects;

//import java.sql.Date;

import java.sql.Time;
import java.time.LocalDate;



/**
 *
 * @author Amix
 */
public class Trip{
    
     private int id;
    private String type;
    private String coach;
    private String origin;
    private String destination;
    private LocalDate date;
    private int mobile;
    private Time tm;
    private String time;
    
    private static Trip trip;
    private Trip() {
    }
    private static class singletonhelper
    {
        private static final Trip trip = new Trip();
    }
    private Trip(int id, String type, String coach, String origin, String destination, LocalDate date, int mobile) {
        this.id = id;
        this.type = type;
        this.coach = coach;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.mobile = mobile;
    }
    public static Trip getTrip()
    {
        return singletonhelper.trip;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    public void setTime(String time)
    {
        this.time=time;
    }
    public String gettime()
    {
      return time;
    }
    
    public static void main (String [] args)
    {
    Driver d1 = Driver.getDriver();
    }

  
}
