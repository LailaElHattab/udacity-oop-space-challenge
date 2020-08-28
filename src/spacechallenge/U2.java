package spacechallenge;

public class U2 extends Rocket {

    U2() {
        super(29000, 120);
    }

    @Override
    public boolean launch() {
        double randNumber = (int) Math.floor(Math.random() * 101);
        if ((4 * (1.0 * currentWeight / maxWeight)) < randNumber) {
            return true;
        }
        return false;
    }

    @Override
    public boolean land() {
        double randNumber = (int) Math.floor(Math.random() * 101);
        if ((8 * (1.0 * currentWeight / maxWeight)) < randNumber) {
            return true;
        }
        return false;
    }
}
