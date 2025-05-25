package smartHome;

public class Thermostat implements Device{

    @Override
    public void update(String event) {
        String timeOfDay = CentralController.getInstance().getSystemState().getTimeOfDay();

        if ("temperature drop".equals(event)) {
            System.out.println("Heater On. Temperature is dropping");
        }

        if ("time change".equals(event)) {
            if ("night".equalsIgnoreCase(timeOfDay)) {
                System.out.println("Night mode — reducing heating slightly to save energy.");
            } else if ("morning".equalsIgnoreCase(timeOfDay)) {
                System.out.println("Morning mode — raising heating for comfort.");
            }
        }

    }
}
