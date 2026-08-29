import java.util.Random;

public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        
        int wins = 0, losses = 0, draws = 0;
        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("----------------------------------------------");
        
        for (int i = 0; i < 5; i++) {
            String player = playerMoves[i];
            String computer = moves[random.nextInt(3)];
            String result = playRound(player, computer);
            
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
            
            System.out.printf("%-6d | %-11s | %-13s | %s\n", (i + 1), player, computer, result);
        }
        
        double winPct = (wins / 5.0) * 100;
        System.out.printf("\nFinal Summary\nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPct);
    }
}
