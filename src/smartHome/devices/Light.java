package smartHome.devices;

public class Light implements Device {
    private boolean vacationMode = false;

    public void enableVacationMode() {
        vacationMode = true;
        System.out.println("Light: Vacation mode enabled.");
    }

    public void disableVacationMode() {
        vacationMode = false;
        System.out.println("Light: Vacation mode disabled.");
    }

    public void turnOn() {
        System.out.println("Light: Turned on.");
    }

    public void turnOff() {
        System.out.println("Light: Turned off.");
    }

    @Override
    public void update(String event) {
        if ("motion".equalsIgnoreCase(event)) {
            turnOn();
        }
    }
}
