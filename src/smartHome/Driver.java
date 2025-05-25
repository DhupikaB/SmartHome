package smartHome;

import smartHome.devices.Device;
import smartHome.factories.AppleAlarmFactory;
import smartHome.factories.BrandDeviceFactory;
import smartHome.factories.KelvinThermostatFactory;
import smartHome.factories.OrangeLightFactory;
import smartHome.utilities.ModeFactory;

public class Driver {
    public static void main(String[] args) {

        CentralController controller = CentralController.getInstance();


        SystemState state = controller.getSystemState();
        state.setTimeOfDay("night");
        state.setTemperature(15.0);
        state.setMotionDetected(false);


        BrandDeviceFactory deviceFactory = new BrandDeviceFactory(
                new OrangeLightFactory(),
                new AppleAlarmFactory(),
                new KelvinThermostatFactory()

        );


        Device light = deviceFactory.createLight();
        if (light != null) controller.getDispatcher().registerDevice(light);

        Device alarm = deviceFactory.createAlarm();
        if (alarm != null) controller.getDispatcher().registerDevice(alarm);

        Device thermostat = deviceFactory.createThermostat();
        if (thermostat != null) controller.getDispatcher().registerDevice(thermostat);



        String[] modes = {"default", "vacation", "energy", "security"};

        for (String modeName : modes) {
            System.out.println("\n-- Switching to " + modeName + " Mode --");
            controller.setMode(ModeFactory.createMode(modeName));
            controller.runMode(state);
        }


        String[] events = {"time change", "motion", "temperature drop"};

        for (String event : events) {
            if ("motion".equals(event)) {
                System.out.println("\n-- Simulating motion detection --");
                state.setMotionDetected(true);
                controller.getDispatcher().notifyDevice(event);
                state.setMotionDetected(false);  // reset after handling
            } else {
                System.out.println("\n-- Simulating event: " + event + " --");
                controller.getDispatcher().notifyDevice(event);
            }
        }


        System.out.println("\n-- Changing time of day to morning --");
        state.setTimeOfDay("morning");


        for (String event : events) {
            if ("motion".equals(event)) {
                System.out.println("\n-- Simulating motion detection (morning) --");
                state.setMotionDetected(true);
                controller.getDispatcher().notifyDevice(event);
                state.setMotionDetected(false);
            } else {
                System.out.println("\n-- Simulating event: " + event + " --");
                controller.getDispatcher().notifyDevice(event);
            }
        }
    }
}
