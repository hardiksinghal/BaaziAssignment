package Answer3;

public class AccountSolution {
    public static void main(String[] args){
        Account account1 = new Account(2,4,"Hardik Singhal");
        Account account2 = new Account(3,3,"John Doe");

        System.out.println(account1.toString());
        System.out.println(account2.toString());

        if (account1.compareTo(account2) > 0){
            System.out.println("Account 1 is greater");
        } else if(account1.compareTo(account2) == 0){
            System.out.println("Accounts have equal monthly cost");
        } else {
            System.out.println("Account 2 is greater");
        }
    }
}
