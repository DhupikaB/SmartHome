package smartHome.factories;

import smartHome.devices.Alarm;
import smartHome.devices.Light;
import smartHome.devices.Thermostat;

public class BrandDeviceFactory {
    private LightFactory lightFactory;
    private AlarmFactory alarmFactory;
    private ThermostatFactory thermostatFactory;


    public BrandDeviceFactory(LightFactory lightFactory, AlarmFactory alarmFactory,
                              ThermostatFactory thermostatFactory) {
        this.lightFactory = lightFactory;
        this.alarmFactory = alarmFactory;
        this.thermostatFactory = thermostatFactory;

    }

    public Light createLight() {
        if (lightFactory != null) {
            return lightFactory.createLight();
        } else {
            return null;
        }
    }

    public Alarm createAlarm() {
        if (alarmFactory != null) {
            return alarmFactory.createAlarm();
        } else {
            return null;
        }
    }

    public Thermostat createThermostat() {
        if (thermostatFactory != null) {
            return thermostatFactory.createThermostat();
        } else {
            return null;
        }
    }


}
