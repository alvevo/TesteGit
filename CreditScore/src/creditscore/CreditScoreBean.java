package creditscore;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name="CreditScore",
    mappedName = "CreditScoreApp-CreditScore-CreditScore")
@Remote
@Local
public class CreditScoreBean implements CreditScore, CreditScoreLocal {
    
    public CreditScoreBean() {
    }
    
    public int getCreditScore(String empID) {
        int score = 400; // initialize to extremely poor credit
        
        switch (empID.charAt(empID.length() - 1)) {
        case '1':
        case '2':
        case '3':
            score = 500; // poor credit score
            break;
        case '4':
        case '5':
        case '6':
            score = 600; // average credit score
            break;
        case '7':
        case '8':
        case '9':
            score = 700; // good credit score
        }
        return score;
    }
    
}
