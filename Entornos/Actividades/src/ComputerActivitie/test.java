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
public class test {
    public static void main(String[] args) {
        Computer c1 = new Computer("Paco",4,100);
        OperatingSystem os1 = new OperatingSystem("Linux","1.0","Pacos",true,20,2);
        Software s1= new Software("Word","1.0",1,1);
        Software s2= new Software("Drive","1.0",1,1);
        c1.installingOS(os1);
        if (c1.getHardDisk()>s1.getSoftwareSpaceRequirement()&&c1.getRamMemory()>s1.getSoftwareRamMemortyRquierement()){
            c1.getOs().installSoftware(s1);
            c1.setHardDisk(c1.getHardDisk()-s1.getSoftwareSpaceRequirement());
            c1.setRamMemory(c1.getRamMemory()-s1.getSoftwareRamMemortyRquierement());
        }else {
            System.out.println("No hay espacio");
        }
        if (c1.getHardDisk()>=s2.getSoftwareSpaceRequirement()&&c1.getRamMemory()>=s2.getSoftwareRamMemortyRquierement()){
            c1.getOs().installSoftware(s2);
            c1.setHardDisk(c1.getHardDisk()-s2.getSoftwareSpaceRequirement());
            c1.setRamMemory(c1.getRamMemory()-s2.getSoftwareRamMemortyRquierement());
        }else {
            System.out.println("No hay espacio");
        }
        System.out.println("Queda "+c1.getHardDisk()+" GB de disco duro y queda "+c1.getRamMemory()+" GB de memoria RAM");
        for (int i = 0; i < os1.getOsSoftware().size(); i++) {
            System.out.println("Programas instalados "+os1.getOsSoftware().get(i).getSoftwareName());
        }
        c1.getOs().uninstallSoftware(s1);
        c1.getOs().uninstallSoftware(s2);
        c1.setHardDisk(c1.getHardDisk()+s2.getSoftwareSpaceRequirement());
        c1.setRamMemory(c1.getRamMemory()+s2.getSoftwareRamMemortyRquierement());
        c1.setHardDisk(c1.getHardDisk()+s1.getSoftwareSpaceRequirement());
        c1.setRamMemory(c1.getRamMemory()+s1.getSoftwareRamMemortyRquierement());
        c1.format();
        System.out.println("Queda "+c1.getHardDisk()+" GB de disco duro y queda "+c1.getRamMemory()+" GB de memoria RAM");
    }
}
