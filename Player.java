import java.util.ArrayList;

public class Player {
    String playerName;
    ArrayList<Pokemon> team = new ArrayList();
    Boolean hasLost = false;
    Pokemon hasOut;

    public Player () {
        this.playerName = "";
    }

    public boolean resolve(Player opponent, int attackChoice){
        boolean resolveNextMove = true;
        // execute move
        if (this.hasOut.type.equals("Fire")){
            if (attackChoice == 1){
                PokemonBattle.genericFire.Ember(opponent.hasOut);
            } else if (attackChoice == 2){
                PokemonBattle.genericFire.FireSpin(opponent.hasOut);
            } else if (attackChoice == 3){
                PokemonBattle.genericFire.CoalWalk(this.hasOut);
            }
        } else if (this.hasOut.type.equals("Grass")){
            if (attackChoice == 1){
                PokemonBattle.genericGrass.RazorLeaf(opponent.hasOut);
            } else if (attackChoice == 2){
                PokemonBattle.genericGrass.LeechSeed(opponent.hasOut, this.hasOut);
            } else if (attackChoice == 3){
                PokemonBattle.genericGrass.SleepPowder(opponent.hasOut);
            }
        } else if (this.hasOut.type.equals("Water")) {
            if (attackChoice == 1) {
                PokemonBattle.genericWater.Surf(opponent.hasOut, this.hasOut);
            } else if (attackChoice == 2) {
                PokemonBattle.genericWater.BubbleBeam(opponent.hasOut);
            } else if (attackChoice == 3) {
                PokemonBattle.genericWater.Hydrate(this.hasOut);
            }
        }
        // Check for death
        if (opponent.hasOut.health <= 0){
            System.out.println(opponent.hasOut.pokeName + " has fainted!");
            opponent.hasOut.alive = false;
            if (!opponent.team.get(0).alive && !opponent.team.get(1).alive && !opponent.team.get(2).alive){
                System.out.println("\n" + opponent.playerName + ", all your pokemon have fainted! You pass out and lose " +
                        "$200.\n" + this.playerName + ", you win! You find $200.");
                this.hasLost = true;
                System.exit(0);
            }
            PokemonBattle.switchPokemon(opponent);
            resolveNextMove = false;
        }
        return resolveNextMove;
    }
}


