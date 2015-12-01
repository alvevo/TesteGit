package creditscore;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CreditScoreClient {
    public static void main(String [] args) {
        try {
            final Context context = getInitialContext();
            CreditScore creditScore = (CreditScore)context.lookup("CreditScoreApp-CreditScore-CreditScore#creditscore.CreditScore");
            
            for (int empID = 100; empID < 110; empID++) {
                int empCreditScore = creditScore.getCreditScore(Integer.toString(empID));
                System.out.println("Credit Score for Employee ID" + empID + "from the CreditScore Stateless EJB is: " + empCreditScore);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }   
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://localhost:7101");
        return new InitialContext( env );
    }
}
