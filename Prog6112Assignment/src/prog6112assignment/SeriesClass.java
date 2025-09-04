/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog6112assignment;

/**
 *
 * @author lab_services_student
 */
public class SeriesClass  {
    
    // Data Memebers
    public String seriesId;
    public String seriesName;
    public String seriesNumberOfEpisodes;
    public String seriesAge;
    

    public SeriesClass(String id, String name, String age, String episodes) {
        this.seriesId = id;
        this.seriesName = name;
        this.seriesAge = age;
        this.seriesNumberOfEpisodes = episodes;
        
        
    }
    
    // setters
    public void setSeriesId(String seriesId){
        this.seriesId =seriesId;
        
    }
    public void setSeriesName(String seriesName){
        this.seriesName =seriesName;
        
    }
    public void setSeriesAge(String seriesAge){
        this.seriesAge = seriesAge;
        
    }
    public void setSeriesNumberofEpisodes(String seriesNumberofEpisodes){
        this.seriesNumberOfEpisodes =seriesNumberofEpisodes;
        
    }
    
    // Getters
    public String getseriesID(){
        return seriesId;
        
        
    }
    public String getseriesName(){
        return seriesName;
        
    }
    public String getseriesNumberofEpisodes(){
        return seriesNumberOfEpisodes;
        
    }
    public String getseriesAge(){
        return seriesAge;
    }
    
    
    
    
}
