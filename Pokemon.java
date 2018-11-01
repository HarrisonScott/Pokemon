public class Pokemon {
    @Override
    public String toString() {
        return pokeName;
    }

    String pokeName;
    String type;
    double health;
    double speed;
    boolean alive = true;

    public Pokemon () {
        this.pokeName = "";
        this.type = "";
        this.health = -1;
        this.speed = -1;


    }
    public Pokemon (String newName, String newType, double newHealth, double newSpeed){
        this.pokeName = newName;
        this.type = newType;
        this.health = newHealth;
        this.speed = newSpeed;
    }

    public void DecreaseHealth(double atk) {
        this.health -= atk;
    }
    public void IncreaseHealth(double heal) {
        this.health += heal;
    }
    public void IncreaseSpeed(double speedUp) {
        this.speed += speedUp;
    }
    public void DecreaseSpeed(double speedDown){
        this.speed -= speedDown;
    }
}
