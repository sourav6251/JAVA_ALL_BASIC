import java.util.ArrayList;
import java.util.*;
public class Array {
    public static void main(String[] args) {
        ArrayList<String> cars=new ArrayList<>();
        System.out.println("How many cars name you want to add: ");
        Scanner scan =new Scanner(System.in);
        int No= scan.nextInt();
        scan.nextLine();
        System.out.println("Enter car name one by one: ");
        for (int i=0;i<No;i++){
            cars.add(scan.nextLine());
        }
        System.out.println("yours car name are: ");
        for (int i=0;i<No;i++){
            System.out.print(cars.get(i)+" ");
        }
        scan.close();
    }
}
