package smartHome;

import java.util.ArrayList;
import java.util.List;

public class EventDispatcher {
    private List<Device> devices = new ArrayList<>();

    public void registerDevice(Device device){
        devices.add(device);
    }

    public void notifyDevice(String event){
        System.out.println("Notifying devices the event: "+event);
        for(Device device : devices){
            device.update(event);
        }
    }
}
