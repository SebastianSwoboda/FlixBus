package flixBus;

import java.util.List;

public abstract class Bus {


    private String busType;
    private int passengerCapacity;
    private String comfort;
    protected Boolean international;




    public Bus() {
    }


    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getComfort() {
        return comfort;
    }

    public void setComfort(String comfort) {
        this.comfort = comfort;
    }

    public Boolean getInternational() {
        return international;
    }

    public abstract void setInternational();


}
