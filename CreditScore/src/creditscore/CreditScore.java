package creditscore;

import javax.ejb.Remote;

@Remote
public interface CreditScore {    
    int getCreditScore(String empID);
}