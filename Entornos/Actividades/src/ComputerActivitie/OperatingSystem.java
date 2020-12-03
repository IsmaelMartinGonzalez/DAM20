package ComputerActivitie;

import java.util.ArrayList;

/**
 * Project name: DAM20/PACKAGE_NAME
 * Filename:
 * Created:  14/11/2020 / 13:47
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class OperatingSystem {
    //Attributes
    private String osName;
    private String osVersion;
    private String osArchitecture;
    private boolean osOnlyCommand;
    private int osSpaceRequieremnt;
    private int osRamMemmoryRequirement;
    private ArrayList<Software> osSoftware = new ArrayList<Software>();
    //Builder

    public OperatingSystem(String osName, String osVersion, String osArchitecture, boolean osOnlyCommand, int osSpaceRequieremnt, int osRamMemmoryRequirement) {
        this.osName = osName;
        this.osVersion = osVersion;
        this.osArchitecture = osArchitecture;
        this.osOnlyCommand = osOnlyCommand;
        this.osSpaceRequieremnt = osSpaceRequieremnt;
        this.osRamMemmoryRequirement = osRamMemmoryRequirement;
        this.osSoftware = osSoftware;
    }

    //Getters/Setters
    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsArchitecture() {
        return osArchitecture;
    }

    public void setOsArchitecture(String osArchitecture) {
        this.osArchitecture = osArchitecture;
    }

    public boolean isOsOnlyCommand() {
        return osOnlyCommand;
    }

    public void setOsOnlyCommand(boolean osOnlyCommand) {
        this.osOnlyCommand = osOnlyCommand;
    }

    public int getOsSpaceRequieremnt() {
        return osSpaceRequieremnt;
    }

    public void setOsSpaceRequieremnt(int osSpaceRequieremnt) {
        this.osSpaceRequieremnt = osSpaceRequieremnt;
    }

    public int getOsRamMemmoryRequirement() {
        return osRamMemmoryRequirement;
    }

    public void setOsRamMemmoryRequirement(int osRamMemmoryRequirement) {
        this.osRamMemmoryRequirement = osRamMemmoryRequirement;
    }

    public ArrayList<Software> getOsSoftware() {
        return osSoftware;
    }

    public void setOsSoftware(ArrayList<Software> osSoftware) {
        this.osSoftware = osSoftware;
    }

    //Others Methods
    public void installSoftware(Software osSoftware){
        this.osSoftware.add(osSoftware);
    }
    public void uninstallSoftware(Software osSoftware){
        this.osSoftware.remove(osSoftware);
    }
}
