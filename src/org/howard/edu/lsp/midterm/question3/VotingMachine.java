package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a simple electronic voting machine.
 * It allows candidates to be added, votes to be cast, and results to be displayed.
 */
public class VotingMachine {
    private Map<String, Integer> votes; // Stores candidate names and their vote count

    /**
     * Constructor initializes the voting machine with an empty candidate list.
     */
    public VotingMachine() {
        votes = new HashMap<>();
    }

    /**
     * Adds a candidate to the election.
     * @param candidate The name of the candidate to be added.
     */
    public void addCandidate(String candidate) {
        if (!votes.containsKey(candidate)) { // Ensure no duplicate candidates
            votes.put(candidate, 0);
        }
    }

    /**
     * Casts a vote for a given candidate.
     * @param candidate The candidate receiving the vote.
     * @return true if the vote was successfully cast, false if the candidate does not exist.
     */
    public boolean castVote(String candidate) {
        if (votes.containsKey(candidate)) {
            votes.put(candidate, votes.get(candidate) + 1); // Increment vote count
            return true;
        } 
        return false; // Candidate does not exist
    }

    /**
     * Determines the winner of the election.
     * @return The name of the candidate with the most votes.
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = 0;
        
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner + " WINS with " + maxVotes + " votes!!";
    }
}
