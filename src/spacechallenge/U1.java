package spacechallenge;

public class U1 extends Rocket {
    U1() {
        super(18000, 100);
    }

    @Override
    public boolean launch() {
        double randNumber = (int) Math.floor(Math.random() * 101);
        if ((5 * (1.0 * currentWeight / maxWeight)) < randNumber) {
            return true;
        }
        return false;
    }

    @Override
    public boolean land() {
        double randNumber = (int) Math.floor(Math.random() * 101);
        if ((1 * (1.0 * currentWeight / maxWeight)) < randNumber) {
            return true;
        }
        return false;
    }

}
