package com.tirali.eventart.view;
  
import java.io.Serializable;  
import java.util.ArrayList;  
import java.util.List;  
import java.util.UUID;  
//import org.primefaces.event.ToggleEvent;  
  
public class TableBean implements Serializable {  
  /*
    static {  
        colors = new String[10];  
        colors[0] = "Black";  
        colors[1] = "White";  
        colors[2] = "Green";  
        colors[3] = "Red";  
        colors[4] = "Blue";  
        colors[5] = "Orange";  
        colors[6] = "Silver";  
        colors[7] = "Yellow";  
        colors[8] = "Brown";  
        colors[9] = "Maroon";  
  
        manufacturers = new String[10];  
        manufacturers[0] = "Mercedes";  
        manufacturers[1] = "BMW";  
        manufacturers[2] = "Volvo";  
        manufacturers[3] = "Audi";  
        manufacturers[4] = "Renault";  
        manufacturers[5] = "Opel";  
        manufacturers[6] = "Volkswagen";  
        manufacturers[7] = "Chrysler";  
        manufacturers[8] = "Ferrari";  
        manufacturers[9] = "Ford";  
    }  
  */
   // private final static String[] colors;  
  
   // private final static String[] manufacturers;  
  
    private List<String> carsSmall;  
  
    public TableBean() {  
        carsSmall = new ArrayList<String>();  
  
        populateRandomCars(carsSmall, 9);  
    }  
  
    private void populateRandomCars(List<String> list, int size) {  
        for(int i = 0 ; i < size ; i++)  
            list.add("Lili"+i);  
    }  
  
    public List<String> getCarsSmall() {  
        return carsSmall;  
    }  
  
    private int getRandomYear() {  
        return (int) (Math.random() * 50 + 1960);  
    }  
  
    private String getRandomColor() {  
        return "orc";  
    }  
  
    private String getRandomManufacturer() {  
        return "orc";  
    }  
  
    private String getRandomModel() {  
        return UUID.randomUUID().toString().substring(0, 8);  
    }  
  /*
    public void onRowToggle(ToggleEvent event) {  
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,  
                                            "Row State " + event.getVisibility(),  
                                            "Model:");
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  */
}  