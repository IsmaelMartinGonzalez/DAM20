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
public class Computer {
    //Attributes
    private String name;
    private int ramMemory;
    private int hardDisk;
    private OperatingSystem os;

    //Builder
    public Computer(String name, int ramMemory, int hardDisk) {
        this.name = name;
        this.ramMemory = ramMemory;
        this.hardDisk = hardDisk;
        this.os = os;
    }

    //Getters/Setters

    public String getName() {
        return name;
    }
    public int getRamMemory() {
        return ramMemory;
    }
    public int getHardDisk() {
        return hardDisk;
    }
    public OperatingSystem getOs() {
        return os;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRamMemory(int ramMemory) {
        this.ramMemory = ramMemory;
    }
    public void setHardDisk(int hardDisk) {
        this.hardDisk = hardDisk;
    }
    public void setOs(OperatingSystem os) {
        this.os = os;
    }

    //Others Methods
    public void  installingOS(OperatingSystem os){
        if (os.getOsSpaceRequieremnt()<getHardDisk()&&os.getOsRamMemmoryRequirement()<getRamMemory()){
            this.os=os;
            this.hardDisk=hardDisk-os.getOsSpaceRequieremnt();
            this.ramMemory=ramMemory-os.getOsRamMemmoryRequirement();
        }else {
            System.out.println("No hay espacio sufiviente para el sistema");
        }
    }

    public void format(){
        for (int i = 0; i <os.getOsSoftware().size(); i++) {
            this.hardDisk+=os.getOsSoftware().get(i).getSoftwareRamMemortyRquierement();
            this.ramMemory+=os.getOsSoftware().get(i).getSoftwareSpaceRequirement();
        }
        this.hardDisk = hardDisk+os.getOsSpaceRequieremnt();
        this.ramMemory = ramMemory+os.getOsRamMemmoryRequirement();
        this.os=null;
    }
}
