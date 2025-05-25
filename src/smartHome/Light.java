package smartHome;

import smartHome.CentralController;
import smartHome.Device;

public class Light implements Device {
    private boolean isOn = false;

    @Override
    public void update(String event) {
        String timeOfDay = CentralController.getInstance().getSystemState().getTimeOfDay();

        if ("motion".equals(event)) {
            if (!isOn) {
                isOn = true;
                System.out.println("Light turning on.");
            } else {
                System.out.println("Motion detected  light already on.");
            }
        }

        if ("time change".equals(event)) {
            if ("night".equalsIgnoreCase(timeOfDay)) {
                if (!isOn) {
                    isOn = true;
                    System.out.println("Light turning on.");
                }
            } else {
                if (isOn) {
                    isOn = false;
                    System.out.println("Light turning off.");
                }
            }
        }
    }
}
