package smartHome;

public class Alarm implements Device{
    @Override
    public void update(String event) {
        if("motion".equalsIgnoreCase(event)){
            System.out.println("Alert! motion detected");
        }
    }
}
