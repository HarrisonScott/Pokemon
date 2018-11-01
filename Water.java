public class Water extends Pokemon {
    public Water(String name, String type, Double health, Double speed){
        super(name, type, health, speed);
    }

    public Water(){
        super();
    }

    public double DoDamage(Pokemon opponent, double power) {
        boolean superEffective = false;
        boolean notVeryEffective = false;
        if (opponent.type.equals("Fire")){
            superEffective = true;
        } else if (opponent.type.equals("Grass")){
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

    public void Surf(Pokemon opponent, Pokemon self){
        double power = 25;
        power = DoDamage(opponent, power);
        System.out.println("Surf increases your speed by "+ power + ", and decreases your opponent's " + opponent.pokeName
                + "'s by " + power + "!\n");
        opponent.DecreaseSpeed(power);
        self.IncreaseSpeed(power);
    }
    public void BubbleBeam(Pokemon opponent){
        double power = 40;
        power = DoDamage(opponent, power);
        System.out.println("Bubble Beam does " + power + " damage to " + opponent.pokeName + "\n");
        opponent.DecreaseHealth(power);
    }
    public void Hydrate(Pokemon self){
        System.out.println("Hydrate heals " + self.pokeName + " 15 points!\n");
        self.IncreaseHealth(15);
    }
}
