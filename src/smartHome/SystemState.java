package smartHome;

public class SystemState {
    private String timeOfDay;
    private double temperature;
    private boolean motionDetected;

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    public void setMotionDetected(boolean motionDetected) {
        this.motionDetected = motionDetected;
    }

    @Override
    public String toString() {
        return "SystemState{" +
                "timeOfDay='" + timeOfDay + '\'' +
                ", temperature=" + temperature +
                ", motionDetected=" + motionDetected +
                '}';
    }
}
