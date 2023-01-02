package hagenmcgowan.coursework.studentmanagementservice.Logic.GUI;

public class GUICoordinator {
    private GUIForSMS guiForSMS;

    public GUICoordinator(){
        this.guiForSMS = new GUIForSMS();
    }

    private GUIForSMS getGUIForSMS(){
        return guiForSMS;
    }

    public GUIForSMS guiGateway(){
        return getGUIForSMS();
    }
}
