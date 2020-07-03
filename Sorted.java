import java.util.TreeSet;

class Sorted{
    public static void main(String[] args) {
        TreeSet<Loan> loans= new TreeSet<Loan>();
        loans.add(new Loan(5000.0,5,"Ankit"));
        loans.add(new Loan(16000.0,4,"Sandesh"));
        loans.add(new Loan(10000.0,8,"Monish"));
        loans.add(new Loan(10000.0,6,"Sajal"));
      
       for(Loan l_set:loans){
           System.out.println(l_set.loanAmount+" "+l_set.tenure+" "+l_set.loanApplicantName);}

        
   }
}