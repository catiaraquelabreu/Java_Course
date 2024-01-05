import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Character {
    void attack(Character target);

    void castSpell(Character target);

    int getHealth();

    void setHealth(int health);

    String getName();
}

abstract class BaseCharacter implements Character {
    protected String name;
    protected int health;

    public BaseCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Player extends BaseCharacter {
    private int attackPoints;
    private int spellCooldown;

    public Player(String name, int health, int attackPoints) {
        super(name, health);
        this.attackPoints = attackPoints;
        this.spellCooldown = 0;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getSpellCooldown() {
        return spellCooldown;
    }

    public void setSpellCooldown(int spellCooldown) {
        this.spellCooldown = spellCooldown;
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName() + "!");
        target.setHealth(target.getHealth() - attackPoints);
    }

    @Override
    public void castSpell(Character target) {
        if (spellCooldown == 0) {
            System.out.println(name + " casts a powerful spell on " + target.getName() + "!");
            target.setHealth(target.getHealth() - (attackPoints * 3));
            spellCooldown = 3;
        } else {
            System.out.println("Spell on cooldown. You can't cast the spell yet.");
        }
    }

    public void endTurn() {
        if (spellCooldown > 0) {
            spellCooldown--;
        }
    }
}

class Monster extends BaseCharacter {
    private int attackPoints;

    public Monster(String name, int health, int attackPoints) {
        super(name, health);
        this.attackPoints = attackPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName() + "!");
        target.setHealth(target.getHealth() - attackPoints);
    }

    @Override
    public void castSpell(Character target) {
        System.out.println("Monsters cannot cast spells!");
    }
}

class Level {
    private List<Monster> monsters;

    public Level() {
        monsters = new ArrayList<>();
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void removeMonster(Monster monster) {
        monsters.remove(monster);
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player = new Player("Hero", 100, 20);

        Level level = new Level();
        level.addMonster(new Monster("Chtullu", 50, 15));
        level.addMonster(new Monster("Berserk", 80, 25));

        boolean gameOver = false;

        while (!gameOver) {
            List<Monster> monsters = level.getMonsters();

            if (monsters.isEmpty()) {
                System.out.println("Congratulations! You have defeated all the monsters!");
                break;
            }

            System.out.println("LEVEL 1 - Hero choose a Monster (type 1 or 2)");
            for (int i = 0; i < monsters.size(); i++) {
                System.out.println((i + 1) + ". " + monsters.get(i).getName());
            }

            System.out.print("Choose a monster to attack (type 1 or 2): ");
            int monsterChoice = scanner.nextInt();
            scanner.nextLine();

            if (monsterChoice < 1 || monsterChoice > monsters.size()) {
                System.out.println("Invalid monster choice!");
                continue;
            }

            Monster selectedMonster = monsters.get(monsterChoice - 1);

            boolean playerTurn = true;
            while (player.getHealth() > 0 && selectedMonster.getHealth() > 0) {
                if (playerTurn) {
                    System.out.println("\nDefeat the Monster (type 1 or 2):");
                    System.out.println("1. Attack");
                    System.out.println("2. Spell");
                    System.out.print("Choose: ");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            player.attack(selectedMonster);
                            break;
                        case 2:
                            player.castSpell(selectedMonster);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            continue;
                    }
                } else {
                    selectedMonster.attack(player);
                }

                player.endTurn();
                playerTurn = !playerTurn;
            }

            if (player.getHealth() <= 0) {
                System.out.println("Monster killed the Hero. You died :(");
                gameOver = true;
            } else if (selectedMonster.getHealth() <= 0) {
                System.out.println("You defeated " + selectedMonster.getName() + ", you are a HERO!");
                level.removeMonster(selectedMonster);
            }
        }

        scanner.close();
    }
}