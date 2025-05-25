package smartHome.devices;

public class Thermostat implements Device {
    private String mode = "comfort";

    public void setEcoMode() {
        mode = "eco";
        System.out.println("Thermostat: Switched to Eco Mode.");
    }

    public void setComfortMode() {
        mode = "comfort";
        System.out.println("Thermostat: Switched to Comfort Mode.");
    }

    @Override
    public void update(String event) {
        if ("temperature drop".equalsIgnoreCase(event) && "comfort".equals(mode)) {
            System.out.println("Thermostat: Temperature dropped — increasing heating.");
        }
    }
}
