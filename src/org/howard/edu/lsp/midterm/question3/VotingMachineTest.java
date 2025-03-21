package org.howard.edu.lsp.midterm.question3;

/**
 * This class tests the functionality of the VotingMachine.
 */
public class VotingMachineTest {
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();

        // Adding candidates to the election
        vm.addCandidate("Alice");
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");

        // Casting votes for candidates
        vm.castVote("Alice");
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");

        // Attempting to vote for a non-existent candidate
        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success); // Should print: false

        // Displaying election winner
        System.out.println("Winner: " + vm.getWinner()); // Expected output: Charlie WINS with 3 votes!!
    }
}
