package smartHome.devices;

public class Alarm implements Device {
    private boolean armed = false;

    public void arm() {
        if (!armed) {
            armed = true;
            System.out.println("Alarm: Now armed.");
        }
    }

    public void disarm() {
        if (armed) {
            armed = false;
            System.out.println("Alarm: Now disarmed.");
        }
    }

    @Override
    public void update(String event) {
        if ("motion".equalsIgnoreCase(event) && armed) {
            System.out.println("Alarm: Motion detected! Triggering alarm!");
        }
    }
}

