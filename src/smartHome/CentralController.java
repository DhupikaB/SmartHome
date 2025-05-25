package smartHome;


import smartHome.modes.DefaultMode;
import smartHome.modes.ModeStrategy;

public class CentralController {
    private static CentralController instance;

    private ModeStrategy mode;

    private EventDispatcher dispatcher;

    private SystemState systemState;

    private CentralController(){
        this.mode = new DefaultMode();
        this.dispatcher = new smartHome.EventDispatcher();
        this.systemState = new SystemState();

    }

    public static CentralController getInstance(){
        if(instance == null){
            instance= new CentralController();
        }
        return instance;
    }

    public EventDispatcher getDispatcher() {
        return dispatcher;
    }

    public SystemState getSystemState(){
        return systemState;
    }

    public void setMode(ModeStrategy mode){
        this.mode = mode;
        System.out.println("Mode switched to: " + mode.getClass().getSimpleName());
    }

    public void runMode(SystemState state){
        if(mode!= null){
            mode.execute(state,dispatcher);
        }else{
            System.out.println("Mode not set");
        }
    }
}
