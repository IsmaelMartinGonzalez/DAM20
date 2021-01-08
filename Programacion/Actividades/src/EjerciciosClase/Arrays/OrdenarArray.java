package EjerciciosClase.Arrays;

/**
 * Project name: DAM20/EjerciciosClase.Arrays
 * Filename:
 * Created:  08/01/2021 / 17:47
 * Description:
 * Revision:
 *
 * @Author: Ismael - fmartin@nigul.cide.es
 * @Version:
 */
public class OrdenarArray {
    //Attriubutes
    //Builder
    //Getters/Setters
    //Other Methods
    /**Usamos el metodo Burbuja para ordenar los elemento de este array*/
    public void OrdenarArray( int[] nums){
        for (int i = nums.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j]>nums[j+1]){
                    ordenar(nums,j,j+1);
                }
            }
        }
    }
    private void print(int[] nums) {
        for (int i = 0; i <nums.length; i++) {
            System.out.printf("%d \t", nums[i]);
        }
        System.out.println();
    }

    private void ordenar(int[] array, int a, int b) {
        int valor=array[b];
        array[b]=array[a];
        array[a]=valor;
    }

    public static void main(String[] args) {
        OrdenarArray orAr=new OrdenarArray();
        int[] nums = {2,6,8,7,9,4,1,3,5};
        orAr.print(nums);
        orAr.OrdenarArray(nums);
        orAr.print(nums);
    }
}
