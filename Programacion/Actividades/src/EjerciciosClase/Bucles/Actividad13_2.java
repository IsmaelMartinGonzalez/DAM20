package EjerciciosClase.Bucles;

/*
 * Project name: Actividades
 * Filename: Actividad 13
 * Description: En esta actividad ya tenemos lo parametros establecidos y contamos cunatos numero negativos o positivos
 *              tenemso. En caso de error el proghramas de para.
 * Created:  13/11/20 / 17:11
 * Revision:
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version: 1.1
 */
public class Actividad13_2 {
    public static void start(String[] args) {
        int[] nums=new int[10];
        int positivos = 0;
        int negativos = 0;

        try {
            for (int i = 0; i < nums.length; i++) {
                nums[i]=Integer.parseInt(args[i]);
                if (nums[i]<=0){
                    negativos++;
                }else if (nums[i]>=0){
                    positivos++;
                }
            }
        }catch (Exception e){
            System.out.println("Comeme los huevos");
            System.exit(0);
        }
        System.out.println("El recuento de positivos es: "+positivos);
        System.out.println("El recuento de negativos es: "+negativos);
    }
}
