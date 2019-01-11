package flixBus;

import java.util.ArrayList;
import java.util.List;

public class Control {

    public static void main(String[] args) {


        Platform platform1 = new Platform(1, "large", "international", "large", false);
        Platform platform2 = new Platform(2, "small", "national", "small", false);
        Platform platform3 = new Platform(3, "large", "international", "large", false);
        Platform platform4 = new Platform(4, "small", "national", "small", false);

        List<Platform> listOfPlatforms = new ArrayList<>();

        listOfPlatforms.add(platform1);
        listOfPlatforms.add(platform2);
        listOfPlatforms.add(platform3);
        listOfPlatforms.add(platform4);

        BusTerminal busTerminalZuerich = new BusTerminal("zuerich", listOfPlatforms);

        Bus doubleDecker1 = new DoubleDeckerBus();
        doubleDecker1.setBusType("doubleDecker");
        doubleDecker1.setPassengerCapacity(40);
        doubleDecker1.setComfort("basic");
        doubleDecker1.setInternational();

        Bus doubleDecker2 = new DoubleDeckerBus();
        doubleDecker2.setBusType("doubleDecker");
        doubleDecker2.setPassengerCapacity(40);
        doubleDecker2.setComfort("first");
        doubleDecker2.setInternational();

        Bus singleFlooredBus1 = new SingleFlooredBus();
        singleFlooredBus1.setBusType("singleFlooredBus");
        singleFlooredBus1.setPassengerCapacity(20);
        singleFlooredBus1.setComfort("basic");
        singleFlooredBus1.setInternational();



        List<Bus> listOfAvailableBuses = new ArrayList<>();

        listOfAvailableBuses.add(doubleDecker2);
        listOfAvailableBuses.add(doubleDecker1);
        listOfAvailableBuses.add(singleFlooredBus1);


        Travel journeyLondon = new Travel("london", "11.12.2018-10:00", "12.12.2018-13:00", true);
        Travel journeyAmsterdam = new Travel("amsterdam", "22.12.2018-11:00", "22.12.2018-23:00", true);
        Travel journeyBern = new Travel("bern", "08.12.2018-08:00", "08.12.2018-10:00", false);

        List<Travel> listOfJourneys = new ArrayList<>();

        listOfJourneys.add(journeyLondon);
        listOfJourneys.add(journeyAmsterdam);
        listOfJourneys.add(journeyBern);
        Boolean continueBooking = true;

        Process process = new Process();

        while (continueBooking) {
            continueBooking = process.flixBusProcess(busTerminalZuerich, listOfJourneys, listOfAvailableBuses);


        }
    }
}



















