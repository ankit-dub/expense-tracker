import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Loan implements Comparable<Loan> {
    
    double loanAmount;
    int tenure;
    String loanApplicantName;

    public int compareTo(Loan m){
        return this.tenure-m.tenure;
    }
    Loan(double loanAmount,int tenure,String loanApplicantName)
    {this.loanAmount=loanAmount;
        this.tenure=tenure;
        this.loanApplicantName=loanApplicantName;

    }
}
class loanAmountSort implements Comparator<Loan>{
    public int compare(Loan l1,Loan l2){
        if(l1.loanAmount>l2.loanAmount)
        return 1;
        if(l1.loanAmount<l2.loanAmount)
        return -1;
        else 
        return 0;
    }
}
 class Sort{
     public static void main(String[] args) {
         ArrayList<Loan> loans= new ArrayList<Loan>();
         loans.add(new Loan(5000.0,5,"Ankit"));
         loans.add(new Loan(16000.0,4,"Sandesh"));
         loans.add(new Loan(10000.0,8,"Monish"));
         loans.add(new Loan(7000.0,5,"Sajal"));
        Collections.sort(loans);
        for(Loan l:loans){
            System.out.println(l.loanAmount+" "+l.tenure+" "+l.loanApplicantName);}
        loanAmountSort amountSort=new loanAmountSort();
        Collections.sort(loans,amountSort);
        for(Loan n:loans){
            System.out.println(n.loanAmount+" "+n.tenure+" "+n.loanApplicantName);
            if(n.loanApplicantName.startsWith("A"))
            System.out.println("Get loan with : "+n.loanApplicantName);
        }
        
    }
 }