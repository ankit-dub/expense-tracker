import java.util.*;
class Array{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Vector foo = new Vector();
        for (int i = 1; i <= 5; i++) 
            foo.add(sc.nextInt());
        System.out.println(foo);
        foo.remove(3); 
  
        // Displaying the List 
        // after deletion 
        System.out.println(foo); 
  
        // Printing elements one by one 
        for (int i = 0; i < foo.size(); i++) 
            System.out.print(foo.get(i) + " ");
    }
        
    
}