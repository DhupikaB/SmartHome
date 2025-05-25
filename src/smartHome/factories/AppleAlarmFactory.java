package smartHome.factories;

import smartHome.devices.Alarm;

public class AppleAlarmFactory implements AlarmFactory {
    public Alarm createAlarm() {
        System.out.println("AppleAlarmFactory: Creating Alarm Alarm.");
        return new Alarm();
    }
}

