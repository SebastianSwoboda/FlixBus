package flixBus.flixBusTest;

import flixBus.Bus;
import flixBus.DoubleDeckerBus;
import flixBus.SingleFlooredBus;
import flixBus.Travel;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class flixBusTest {


    @Test
    public void doubleDeckerShouldBeInternational(){
        Bus doubleDeckerBus = new DoubleDeckerBus();
        Bus singleFloor = new SingleFlooredBus();
        doubleDeckerBus.setInternational();
        singleFloor.setInternational();
        assertEquals(true, doubleDeckerBus.getInternational());
        assertEquals(false, singleFloor.getInternational());


    }

    @Test
    public void shouldReturnTravelIfDestinationAvailable(){
        Travel travel = new Travel();

        Travel journeyLondon = new Travel("london", "11.12.2018-10:00", "12.12.2018-13:00", true);
        Travel journeyAmsterdam = new Travel("amsterdam", "22.12.2018-11:00", "22.12.2018-23:00", true);
        Travel journeyBern = new Travel("bern", "08.12.2018-08:00", "08.12.2018-10:00", false);


        List<Travel> listOfAvialableJourneys= new ArrayList<>();
        listOfAvialableJourneys.add(journeyAmsterdam);
        listOfAvialableJourneys.add(journeyLondon);
        listOfAvialableJourneys.add(journeyBern);

        //travel=travel.checkIfDestinationIsAvailable("london", listOfAvialableJourneys);
        assertEquals(journeyLondon, travel.checkIfDestinationIsAvailable("london", listOfAvialableJourneys));

    }

}


