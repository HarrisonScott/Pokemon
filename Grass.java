public class Grass extends Pokemon {
    public Grass(String name, String type, Double health, Double speed){
        super(name, type, health, speed);
    }
    public Grass(){
        super();
    }

    public double DoDamage(Pokemon opponent, double power) {
        boolean superEffective = false;
        boolean notVeryEffective = false;
        if (opponent.type.equals("Water")){
            superEffective = true;
        } else if (opponent.type.equals("Fire")){
            notVeryEffective = true;
        }

        if (superEffective) {
            power *= 1.5;
            System.out.println("That was super effective!");
        } else if (notVeryEffective) {
            power *= .5;
            System.out.println("That was not very effective.");
        }
        return power;
    }

    //moves

    public void RazorLeaf(Pokemon opponent){
        double power = 35;
        power = DoDamage(opponent, power);
        System.out.println("Razor Leaf does " + power + " damage to " + opponent.pokeName + "\n");
        opponent.DecreaseHealth(power);
    }
    public void LeechSeed(Pokemon opponent, Pokemon self){
        double power = 20;
        power = DoDamage(opponent, power);
        System.out.println("Leech Seed does " + power + " damage to " + opponent.pokeName + ", and heals "
                + self.pokeName + " by " + power + " points!\n");
        opponent.DecreaseHealth(power);
        self.IncreaseHealth(power);
    }
    public void SleepPowder(Pokemon opponent) {
        double power = 30;
        power = DoDamage(opponent,power);
        System.out.println("Sleep Powder decreases " + opponent.pokeName + "'s speed by " + power + "!\n");
        opponent.DecreaseSpeed(power);
    }
}
