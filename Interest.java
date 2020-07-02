import java.io.InputStream;
import java.util.Scanner;

interface InterestCalculator{
    void calculateInterest(int tenure,float princinpal,float rateOfInterest);
}
class SimpleInterestCalculator implements InterestCalculator{
    
    public void calculateInterest(int tenure,float princinpal,float rateOfInterest) {
        Double interest;
        interest=(double)princinpal*rateOfInterest*tenure/100;
        System.out.println("Simple Interest : "+interest);
    }
}
class CompoundInterestCalculator implements InterestCalculator{
    
    public void calculateInterest(int tenure,float princinpal,float rateOfInterest) {
        Double interest;
        interest=(double)princinpal*(Math.pow((1+rateOfInterest/100),tenure));
        System.out.println("Compound Interest : "+interest);
    }
}
class Interest{
    public static void main(String[] args) {
        SimpleInterestCalculator s=new SimpleInterestCalculator();
        CompoundInterestCalculator c=new CompoundInterestCalculator();
        Scanner sc=new Scanner(System.in);
        int tenure=sc.nextInt();
        float princinpal=sc.nextFloat();
        float rateOfInterest=sc.nextFloat();
        s.calculateInterest(tenure,princinpal,rateOfInterest);
        c.calculateInterest(tenure,princinpal,rateOfInterest);
    }
}