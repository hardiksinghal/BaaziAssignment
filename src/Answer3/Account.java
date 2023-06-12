package Answer3;

public class Account implements OnlineAccount, Comparable<Account>{

    private final Integer noOfRegularMovies;
    private final Integer noOfExclusiveMovies;
    private final String ownerName;

    public Account(Integer noOfRegularMovies, Integer noOfExclusiveMovies, String ownerName) {
        this.noOfRegularMovies = noOfRegularMovies;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
        this.ownerName = ownerName;
    }

    @Override
    public int compareTo(Account o) {
        return this.monthlyCost().compareTo(o.monthlyCost());
    }

    public Integer monthlyCost(){
        return basePrice + (noOfRegularMovies * regularMoviePrice) + (noOfExclusiveMovies * exclusiveMoviePrice);
    }

    @Override
    public String toString() {
        return "Owner is "+ownerName+" and monthly cost is "+monthlyCost()+" USD.";
    }
}
