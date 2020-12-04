package ComputerActivitie;

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
public class Software {
    //Attributes
   private String softwareName;
   private String softwareVersion;
   private int softwareSpaceRequirement;
   private int softwareRamMemortyRquierement;
    //Builder

    public Software(String softwareName, String softwareVersion, int softwareSpaceRequirement, int softwareRamMemortyRquierement) {
        this.softwareName = softwareName;
        this.softwareVersion = softwareVersion;
        this.softwareSpaceRequirement = softwareSpaceRequirement;
        this.softwareRamMemortyRquierement = softwareRamMemortyRquierement;
    }

    //Getters/Setters

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public int getSoftwareSpaceRequirement() {
        return softwareSpaceRequirement;
    }

    public void setSoftwareSpaceRequirement(int softwareSpaceRequirement) {
        this.softwareSpaceRequirement = softwareSpaceRequirement;
    }

    public int getSoftwareRamMemortyRquierement() {
        return softwareRamMemortyRquierement;
    }

    public void setSoftwareRamMemortyRquierement(int softwareRamMemortyRquierement) {
        this.softwareRamMemortyRquierement = softwareRamMemortyRquierement;
    }

    //Others Methods
}
