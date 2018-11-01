public class FireType extends Pokemon {


    public FireType(String name, String type, Double health, Double speed){
        super(name, type, health, speed);
    }

    public FireType(){
        super();
    }

    //moves
    public double DoDamage(Pokemon opponent, double power) {
        boolean superEffective = false;
        boolean notVeryEffective = false;
        if (opponent.type.equals("Grass")){
            superEffective = true;
        } else if (opponent.type.equals("Water")){
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

    public void Ember(Pokemon opponent) {
        double power = 40;
        power = DoDamage(opponent, power);
        System.out.println("Ember does " + power + " damage to " + opponent.pokeName + "!\n");
        opponent.DecreaseHealth(power);
    }
    public void FireSpin(Pokemon opponent){
        double power = 35;
        power = DoDamage(opponent, power);
        System.out.println("Fire Spin does " + power + " damage to " + opponent.pokeName + "\n");
        opponent.DecreaseSpeed(power);
    }
    public void CoalWalk(Pokemon self){
        System.out.println("Coal Walk increases " + self.pokeName + "'s speed by 35!\n");
        self.IncreaseSpeed(35);
    }
}
