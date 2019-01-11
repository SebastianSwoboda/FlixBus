package flixBus;

import java.util.List;
import java.util.Scanner;

public class Process {

    protected Boolean flixBusProcess(BusTerminal busTerminalZuerich, List<Travel> listOfJourneys, List<Bus> listOfAvailableBuses) {
        Boolean continueBooking = false;
        String departureTime = null;
        String destination = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Flix-Bus, what would you like to do?\n" +
                "1. Search for a journey\n2. See all available buses");

        if (scanner.next().equals("1")) {
            System.out.println("Where would you like to go? ");
            destination = scanner.next().toLowerCase();

            System.out.println("At what time would you like to leave?(day.month.year-hour:minute) ");
            departureTime = scanner.next();


        } else {


        }


        Travel journey = new Travel();
        journey = journey.checkIfDestinationIsAvailable(destination, listOfJourneys);
        journey.generateErrorMessageIfDepartureIsNotAvailableAtRequiredTime(departureTime, journey);




        Platform platform = new Platform();
        boolean isJourneyInternational = journey.getInternational();

        Bus yourBus = busTerminalZuerich.findBusForRequiredJourney(isJourneyInternational, listOfAvailableBuses);


        platform = platform.findPlatformForJourney(busTerminalZuerich, yourBus);
        System.out.println("We found a journey departing to " + journey.getDestination() + " from platform " + platform.getPlatformNumber() + " at " +
                journey.getDepartureTime() + " and it will be arriving at your destination at " +
                journey.getArrivalTime());
        System.out.println("Would you like to book this journey? ");
        bookJourney(scanner.next());
        continueBooking = bookAnotherJourney(scanner.next(), continueBooking);


        return continueBooking;
    }


    private void bookJourney(String bookJourneyAnswer) {

        if (bookJourneyAnswer.equals("yes")) {
            System.out.println("Thank you for traveling with flix-bus-switzerland");
        } else {
            System.out.println("Maybe nex time!");


        }

        System.out.println("Would you like to book another journey? ");


    }

    private Boolean bookAnotherJourney(String bookAnotherJourneyAnswer, Boolean continueBooking) {

        if (bookAnotherJourneyAnswer.equals("yes")) {
            continueBooking = true;
        } else {
            System.exit(0);

        }
        return continueBooking;

    }


}
