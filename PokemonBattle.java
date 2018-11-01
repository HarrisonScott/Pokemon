import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

/*
Fixme ; TO DO LIST

Subclasses (which requires a parent class)  1/2 or 2/2 ??
Additional member variables in subclasses   0/2                 -toughness?
Additional methods in subclasses            2/2
Overriding                                  1/2 kind of
Overloading                                 2/2
Polymorphic instantiations                  2/2

 */

public class PokemonBattle {
    public static FireType genericFire = new FireType();
    public static Pokemon charmander = new FireType("Charmander", "Fire", 130.0, 110.0);
    public static Pokemon vulpix = new FireType("Vulpix", "Fire", 110.0, 130.0);
    public static Pokemon growlithe = new FireType("Growlithe", "Fire", 120.0, 120.0);
    public static Pokemon ponyta = new FireType("Ponyta", "Fire", 100.0, 140.0);

    public static Water genericWater = new Water();
    public static Pokemon squirtle = new Water("Squirtle", "Water", 100.0, 140.0);
    public static Pokemon krabby = new Water("Krabby", "Water", 110.0, 130.0);
    public static Pokemon seel = new Water("Seel", "Water", 120.0, 120.0);
    public static Pokemon staryu = new Water("Staryu", "Water", 130.0, 110.0);

    public static Grass genericGrass = new Grass();
    public static Pokemon bulbasaur = new Grass("Bulbasaur", "Grass", 100.0, 140.0);
    public static Pokemon oddish = new Grass("Oddish", "Grass", 110.0, 130.0);
    public static Pokemon bellsprout = new Grass("Bellsprout", "Grass", 120.0, 120.0);
    public static Pokemon paras = new Grass("Paras", "Grass", 130.0, 110.0);

    public static ArrayList<Pokemon> PokeOptions = new ArrayList<>(Arrays.asList(charmander, vulpix, growlithe, ponyta,
            squirtle, krabby, seel, staryu, bulbasaur, oddish, bellsprout, paras));

    public static Player player1 = new Player();
    public static Player player2 = new Player();


    public static void main(String[] args) {
        System.out.println("Welcome to Harrison's Pokemon World! \n");

        /////// Set up

        Scanner name = new Scanner(System.in);
        String playerName;

        // Set names for players
        System.out.println("Player 1: what is your name?");
        playerName = name.nextLine();
        player1.playerName = playerName;
        System.out.println("Player 2: what is your name?");
        playerName = name.nextLine();
        player2.playerName = playerName;

        // Set teams for players
        System.out.println("\nAvailable Pokemon:" + PokeOptions);
        for (int draftRound = 1; draftRound <= 3; draftRound++) {
            while (player1.team.size() < draftRound) { setTeams(player1); }
                System.out.println(player1.team.get(draftRound - 1).pokeName + " has been added to your team!");
            while (player2.team.size() < draftRound) { setTeams(player2); }
                System.out.println(player2.team.get(draftRound - 1).pokeName + " has been added to your team!");
        }
        System.out.println("\n" + player1.playerName + "'s team :" + player1.team);
        System.out.println(player2.playerName + "'s team :" + player2.team + "\n");

        /////// Battle!

        player1.hasOut = player1.team.get(0);
        player2.hasOut = player2.team.get(0);

        while (!player1.hasLost && !player2.hasLost) {
            resolveTurn(player1, player2);
        }
    }

    public static void setTeams(Player player) {
        Boolean memberAdded = false;
        Scanner draft = new Scanner(System.in);

        System.out.println(player.playerName + ": enter a pokemon!");
        String playerInput = draft.nextLine();

        if (playerInput.equals("")) {
            System.out.println("I mean, you have to enter something, dude.");
            return;
        } else {
            playerInput = playerInput.substring(0, 1).toUpperCase() + playerInput.substring(1);
        }


        for (int counter = 0; counter < PokeOptions.size(); counter++) {
            if (player == player1) {
                // add to team 1
                if (playerInput.equals(PokeOptions.get(counter).pokeName)) {
                    if (PokeOptions.get(counter).type.equals("Fire")) {
                        if (player.team.size() == 0) {
                            Pokemon p1fireType1 = new FireType(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p1fireType1);
                            return;
                        } else if (player.team.size() == 1) {
                            Pokemon p1fireType2 = new FireType(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p1fireType2);
                            return;
                        } else if (player.team.size() == 2) {
                            Pokemon p1fireType3 = new FireType(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p1fireType3);
                            return;
                        }
                    } else if (PokeOptions.get(counter).type.equals("Grass")) {
                        if (player.team.size() == 0) {
                            Pokemon p1grassType1 = new Grass(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p1grassType1);
                            return;
                        } else if (player.team.size() == 1) {
                            Pokemon p1grassType2 = new Grass(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p1grassType2);
                            return;
                        } else if (player.team.size() == 2) {
                            Pokemon p1grassType3 = new Grass(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p1grassType3);
                            return;
                        }
                    } else if (PokeOptions.get(counter).type.equals("Water")) {
                        if (player.team.size() == 0) {
                            Pokemon p1waterType1 = new Water(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p1waterType1);
                            return;
                        } else if (player.team.size() == 1) {
                            Pokemon p1waterType2 = new Water(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p1waterType2);
                            return;
                        } else if (player.team.size() == 2) {
                            Pokemon p1waterType3 = new Water(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p1waterType3);
                            return;
                        }
                    }
                }
            } else if (player == player2) {
                //add to team 2
                if (playerInput.equals(PokeOptions.get(counter).pokeName)) {
                    if (PokeOptions.get(counter).type.equals("Fire")) {
                        if (player.team.size() == 0) {
                            Pokemon p2fireType1 = new FireType(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p2fireType1);
                            return;
                        } else if (player.team.size() == 1) {
                            Pokemon p2fireType2 = new FireType(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p2fireType2);
                            return;
                        } else if (player.team.size() == 2) {
                            Pokemon p2fireType3 = new FireType(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p2fireType3);
                            return;
                        }
                    } else if (PokeOptions.get(counter).type.equals("Grass")) {
                        if (player.team.size() == 0) {
                            Pokemon p2grassType1 = new Grass(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p2grassType1);
                            return;
                        } else if (player.team.size() == 1) {
                            Pokemon p2grassType2 = new Grass(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p2grassType2);
                            return;
                        } else if (player.team.size() == 2) {
                            Pokemon p2grassType3 = new Grass(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p2grassType3);
                            return;
                        }
                    } else if (PokeOptions.get(counter).type.equals("Water")) {
                        if (player.team.size() == 0) {
                            Pokemon p2waterType1 = new Water(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p2waterType1);
                            return;
                        } else if (player.team.size() == 1) {
                            Pokemon p2waterType2 = new Water(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p2waterType2);
                            return;
                        } else if (player.team.size() == 2) {
                            Pokemon p2waterType3 = new Water(
                                    PokeOptions.get(counter).pokeName,
                                    PokeOptions.get(counter).type,
                                    PokeOptions.get(counter).health,
                                    PokeOptions.get(counter).speed);
                            player.team.add(p2waterType3);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Whoops! Doesn't look like we have that pokemon!");
    }

    public static int takeTurn(Player takingTurn, Player opponent) {
        Scanner turnInput = new Scanner(System.in);
        String choice;
        boolean validInput = false;

        System.out.println("[" + opponent.playerName + "'s " + opponent.hasOut.pokeName +
                ": " + opponent.hasOut.health + " hp, " + opponent.hasOut.speed + " speed ]");
        System.out.println("[Your " + takingTurn.hasOut.pokeName +
                ": " + takingTurn.hasOut.health + " hp, " + takingTurn.hasOut.speed + " speed ]");
        System.out.println("-Enter (1) to attack opponent's pokemon");
        System.out.println("-Enter (2) to switch pokemon");

        while (!validInput) {
            choice = turnInput.nextLine();
            if (choice.equals("1")) {
                return chooseAttack(takingTurn);
            } else if (choice.equals("2")) {
                switchPokemon(takingTurn);
                return 0;
            }
            System.out.println("Pick 1 or 2, not " + choice);
        }
        return 0;
    }

    public static int chooseAttack(Player takingTurn) {
        Scanner moveInput = new Scanner(System.in);

        int atkChoice = 0;

        if (takingTurn.hasOut.type.equals("Fire")) {
            // choose between attacks and set atkChoice
            System.out.println("\nChoose a move!\n" +
                    "Enter (1) to use Ember\n" +
                    "       -Powerful fire attack\n" +
                    "Enter (2) to use Fire Spin\n" +
                    "       -Decrease opponent's speed\n" +
                    "Enter (3) to use Coal Walk\n" +
                    "       -Increase your speed");
            atkChoice = Integer.valueOf(moveInput.nextLine());
        } else if (takingTurn.hasOut.type.equals("Grass")) {
            System.out.println("\nChoose a move!\n" +
                    "Enter (1) to use Razor Leaf\n" +
                    "       -Powerful grass attack\n" +
                    "Enter (2) to use Leech Seed\n" +
                    "       -Drain your opponent's health and heal yourself\n" +
                    "Enter (3) to use Sleep Powder\n" +
                    "       -Decrease opponent's speed");
            atkChoice = Integer.valueOf(moveInput.nextLine());
        } else if (takingTurn.hasOut.type.equals("Water")) {
            System.out.println("\nChoose a move!\n" +
                    "Enter (1) to use Surf\n" +
                    "       -Increase your speed and decrease your opponent's\n" +
                    "Enter (2) to use Bubble Beam\n" +
                    "       -Powerful water attack\n" +
                    "Enter (3) to use Hydrate\n" +
                    "       -Heal yourself");
            atkChoice = Integer.valueOf(moveInput.nextLine());
        }
        // will return number of choice // Fixme ; scanner is overridden by player2's input
        return atkChoice;
    }

    public static void switchPokemon(Player takingTurn) {
        Scanner turnInput = new Scanner(System.in);
        int choice;

        System.out.println("\n" + takingTurn.playerName + ", which pokemon would you like to use?");
        System.out.println("(1)" + takingTurn.team.get(0) +
                ", (2)" + takingTurn.team.get(1) +
                ", (3)" + takingTurn.team.get(2));
        choice = Integer.valueOf(turnInput.nextLine()) - 1;
        if (takingTurn.team.get(choice).alive) {
            takingTurn.hasOut = takingTurn.team.get(choice);
            System.out.println(takingTurn.playerName + ": 'Go " + takingTurn.hasOut + "!'\n");
        } else {
            System.out.println(takingTurn.team.get(choice).pokeName + " has fainted! Choose a different pokemon!");
            switchPokemon(takingTurn);
        }
    }

    public static void resolveTurn(Player player1, Player player2) {

        // set move choices
        System.out.println("\n    " + player1.playerName + ", what will you do?");
        int p1Move = takeTurn(player1, player2);
        System.out.println("\n    " + player2.playerName + ", what will you do?");
        int p2Move = takeTurn(player2, player1);

        System.out.println("--------------------------\n");

        // execute stack. switching pokemon takes priority
        // Fixme ; if the first player in the stack KOs the second player, it still resolves their turn after they choose a new pokemon
        if (p1Move == 0 && p2Move == 0) {
            //Fixme ; next turn... return?
        } else if (p1Move == 0) {
            player2.resolve(player1, p2Move);
        } else if (p2Move == 0) {
            player1.resolve(player2, p1Move);
        } else if (player1.hasOut.speed >= player2.hasOut.speed) {
            if (player1.resolve(player2, p1Move)) {
                player2.resolve(player1, p2Move);
            }
        } else if (player2.hasOut.speed >= player1.hasOut.speed) {
            if (player2.resolve(player1, p2Move)) {
                player1.resolve(player2, p1Move);
            }
        }
    }
}






