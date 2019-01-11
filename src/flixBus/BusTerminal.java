package flixBus;

import java.util.List;

public class BusTerminal {
    private String terminal;
    private List<Platform> platforms;

  public BusTerminal(String terminal, List<Platform> platforms){
      this.terminal=terminal;
      this.platforms=platforms;

  }


    public String getTerminal() {
        return terminal;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }


    protected Bus findBusForRequiredJourney(boolean isJourneyInternational, List<Bus> listOfAvailableBuses) {

        Bus chosenBus = null;
        for (Bus bus : listOfAvailableBuses
        ) {

            if (isJourneyInternational) {
                if (bus.getInternational()) {
                    chosenBus = bus;

                }

            } else {
                if (bus.getBusType().equals("singleFlooredBus")) {
                    chosenBus = bus;
                    break;
                }
            }


        }

        return chosenBus;
    }



}
