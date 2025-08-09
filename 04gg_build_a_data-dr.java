import java.util.*;

public class GamePrototypeSimulator {
    public static void main(String[] args) {
        // Define game data
        Map<String, Integer> playerData = new HashMap<>();
        playerData.put("health", 100);
        playerData.put("level", 1);
        playerData.put("experience", 0);

        Map<String, Integer> enemyData = new HashMap<>();
        enemyData.put("health", 50);
        enemyData.put("attack", 20);
        enemyData.put("defense", 10);

        Map<String, String> gameConfig = new HashMap<>();
        gameConfig.put("gameMode", "easy");
        gameConfig.put("gameLevel", "forest");

        // Define game logic
        int playerHealth = playerData.get("health");
        int enemyAttack = enemyData.get("attack");
        int enemyDefense = enemyData.get("defense");

        // Simulate game loop
        while (playerHealth > 0) {
            System.out.println("Player Health: " + playerHealth);
            System.out.println("Enemy Attack: " + enemyAttack);
            System.out.println("Enemy Defense: " + enemyDefense);

            // Player's turn
            int playerDamage = calculateDamage(playerData, enemyData, gameConfig);
            enemyDefense -= playerDamage;
            System.out.println("Player deals " + playerDamage + " damage to enemy!");
            System.out.println("Enemy Defense: " + enemyDefense);

            // Enemy's turn
            int enemyDamage = calculateDamage(enemyData, playerData, gameConfig);
            playerHealth -= enemyDamage;
            System.out.println("Enemy deals " + enemyDamage + " damage to player!");
            System.out.println("Player Health: " + playerHealth);

            System.out.println();
        }

        if (playerHealth <= 0) {
            System.out.println("Game Over! Enemy wins!");
        } else {
            System.out.println("Game Over! Player wins!");
        }
    }

    private static int calculateDamage(Map<String, Integer> attackerData, Map<String, Integer> defenderData, Map<String, String> gameConfig) {
        int attackerAttack = attackerData.get("attack");
        int defenderDefense = defenderData.get("defense");

        // Apply game config modifiers
        if (gameConfig.get("gameMode").equals("hard")) {
            attackerAttack *= 2;
        }

        if (gameConfig.get("gameLevel").equals("desert")) {
            defenderDefense /= 2;
        }

        return attackerAttack - defenderDefense;
    }
}