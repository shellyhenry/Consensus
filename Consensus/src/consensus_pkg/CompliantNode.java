package consensus_pkg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node{
	
	HashSet<Transaction> nodePendingTransactions;
	ArrayList<Boolean> nodeFollowees;
	
	
    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
        // IMPLEMENT THIS
    	nodePendingTransactions = new HashSet<Transaction>();
    	nodeFollowees =  new ArrayList<Boolean>();
    }

    public void setFollowees(boolean[] followees) {
        // IMPLEMENT THIS
    	for(int i = 0; i < followees.length; i++)
    	{
    		nodeFollowees.add(followees[i]);
    	}
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        // IMPLEMENT THIS
       	for (Transaction Tx:pendingTransactions ) {
       		nodePendingTransactions.add(Tx);
       	}
    }

    public Set<Transaction> sendToFollowers() {
        // IMPLEMENT THIS
    	return nodePendingTransactions;
    }

    public void receiveFromFollowees(Set<Candidate> candidates) {
        // IMPLEMENT THIS
       	for (Candidate Cd:candidates ) {
       		if (nodeFollowees.get(Cd.sender) == true) {
       			nodePendingTransactions.add(Cd.tx);
       		}
       	}
    }

}
