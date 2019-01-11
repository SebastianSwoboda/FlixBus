package flixBus;

public class Platform {

    private int platformNumber;
    private String platformSize;
    private String busService;
    private String busType;


    private Boolean isOccupied;

    public Platform(int platformNumber,
                    String platformSize,
                    String busService,
                    String busType, Boolean isOccupied) {
        this.platformNumber = platformNumber;
        this.platformSize = platformSize;
        this.busService = busService;
        this.busType = busType;
        this.isOccupied = isOccupied;
    }

    public Platform() {
    }

    public int getPlatformNumber() {
        return platformNumber;
    }

    public void setPlatformNumber(int platformNumber) {
        this.platformNumber = platformNumber;
    }

    public String getPlatformSize() {
        return platformSize;
    }

    public void setPlatformSize(String platformSize) {
        this.platformSize = platformSize;
    }

    public String getBusService() {
        return busService;
    }

    public void setBusService(String busService) {
        this.busService = busService;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }


    public Boolean getCorrectPlatformForBus(Platform platform, Bus bus) {
        Boolean correctPlatformForBus = true;
        if (bus.getInternational().equals(true)) {
            if (!platform.getBusService().equals("international")) {
                correctPlatformForBus = false;
            }


        }
        return correctPlatformForBus;
    }

    public Platform findPlatformForJourney(BusTerminal busTerminalZuerich, Bus bus) {

        Platform choosenPlatform = null;
        for (Platform platform :
                busTerminalZuerich.getPlatforms()
        ) {
            if (bus.getInternational() && platform.getBusService().equals("international") && !platform.getOccupied()) {
                choosenPlatform = platform;

                platform.setOccupied(true);
            }
            if (platform.getBusService().equals("international")) {
                if (!platform.getOccupied()) {
                    choosenPlatform = platform;

                    platform.setOccupied(true);


                }

            }


        }
        return choosenPlatform;
    }







}