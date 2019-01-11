package flixBus;


import java.util.List;

public class Travel {
    private String destination;


    private String departureTime;
    private String arrivalTime;
    private Boolean international;

    public Travel(String destination,
                  String departureTime,
                  String arrivalTime,
                  Boolean international) {
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.international = international;
    }

    public Travel() {
    }


    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public Boolean getInternational() {
        return international;
    }


    public Travel checkIfDestinationIsAvailable(String destination, List<Travel> listOfAvailableDestinations) {
        Travel confirmedDestination = new Travel();

        for (Travel availableDestination : listOfAvailableDestinations
        ) {
            if (availableDestination.getDestination().equals(destination)) {
                confirmedDestination = availableDestination;

            }


        }
        if (!confirmedDestination.getDestination().equals(destination)) {
            generateFailedMessage(confirmedDestination, listOfAvailableDestinations);
        }
        return confirmedDestination;
    }

    public void generateErrorMessageIfDepartureIsNotAvailableAtRequiredTime(String departureTime, Travel journey) {
        if (!journey.getDepartureTime().equals(departureTime)) {


            System.out.println("We are sorry to inform you that there is no journey available at your desired time\n" +
                    "Available journey to " + journey.getDestination() + " leaving at " +
                    journey.getDepartureTime() + " arriving " + journey.getArrivalTime());
            System.exit(1);

        }


    }


    public void generateFailedMessage(Travel confirmedDestination, List<Travel> listOfAvailableJourneys) {
        if (confirmedDestination.equals(null)) {
            System.out.println("We are sorry to inform you that there is no journey available to your desired location");
            for (Travel availableJourney : listOfAvailableJourneys
            ) {
                System.out.println(
                        "Available journey: " + availableJourney.getDestination() + " leaving at " +
                                availableJourney.getDepartureTime() + " arriving " + availableJourney.getArrivalTime());

            }
            System.exit(1);
        }

    }

/*
        if (!destination.equals(journey.getDestination())) {
            System.out.println("We are sorry to inform you that there is no journey available to your desired" +
                    " location");
            for (Travel availableJourney : listOfJourneys
            ) {
                if(availableJourney.getDestination().equals(destination)){
                System.out.println("Available journey: " + availableJourney.getDestination() + " leaving at " +
                        availableJourney.getDepartureTime() + " arriving " + availableJourney.getArrivalTime());
                break;

            }}
            //findJourneyAtCorrectTime(departureTime, journey);

            System.exit(0);
        }*/




}
