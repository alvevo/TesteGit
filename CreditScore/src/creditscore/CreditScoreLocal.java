package creditscore;

import javax.ejb.Local;

@Local
public interface CreditScoreLocal {
    
    int getCreditScore(String empID);
    
}
