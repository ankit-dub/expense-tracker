import java.util.TreeSet;

class Sorted{
    public static void main(String[] args) {
        TreeSet<Loan> loans= new TreeSet<Loan>();
        loans.add(new Loan(5000.0,5,"Ankit"));
        loans.add(new Loan(16000.0,4,"Sandesh"));
        loans.add(new Loan(10000.0,8,"Monish"));
        loans.add(new Loan(10000.0,6,"Sajal"));
       //Collections.sort(loans);
       for(Loan l:loans){
           System.out.println(l.loanAmount+" "+l.tenure+" "+l.loanApplicantName);}
    //    loanAmountSort amountSort=new loanAmountSort();
    //    Collections.sort(loans,amountSort);
    //    for(Loan n:loans){
    //        System.out.println(n.loanAmount+" "+n.tenure+" "+n.loanApplicantName);
    //        if(n.loanApplicantName.startsWith("A"))
    //        System.out.println("Get loan with : "+n.loanApplicantName);
    //    }
       
   }
}