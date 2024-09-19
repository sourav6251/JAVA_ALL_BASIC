import  java.util.*;
public class Hashmap {
    public static void main(String[] args) {
        HashMap<Integer,String> hash=new HashMap<>();
        Scanner scan=new Scanner(System.in);

        char Choice;
//        enum Choice{
//            Yes("Y"),
//            No("N");
//
//            public String value;
//            Choice(String value) {
//                this.value=value;
//            }
//        }

        do{
            System.out.print("Enter Rool No.: ");
            int Roll= scan.nextInt();
            scan.nextLine();
            System.out.print("Enter name: ");
            String Name=scan.nextLine();
            hash.put(Roll,Name);
            System.out.print("Want to add more(yes or no): ");
            Choice=Character.toUpperCase(scan.nextLine().charAt(0));
        }while (Choice=='Y');

        System.out.println("Roll\tName");
        for(Integer Roll:hash.keySet()){
            System.out.println(Roll+"\t\t"+hash.get(Roll));
        }
//        System.out.println(hash.size());
    }
}
