package spacechallenge;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Simulation {

    public ArrayList loadItems(String phase) throws Exception {
        File file = new File(phase);
        Scanner scan = new Scanner(file);
        ArrayList<Item> item = new ArrayList<Item>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split("=");
            Item tools = new Item(parts[0], Integer.parseInt(parts[1]));
            item.add(tools);
        }

        return item;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> toolList) {
        ArrayList<U1> rocketU1 = new ArrayList();
        U1 rocket = new U1();
        rocketU1.add(rocket);
        for (Item tools : toolList) {

            if (rocket.canCarry(tools)) {
                rocket.carry(tools);
            } else {
                rocket = new U1();
                rocketU1.add(rocket);
                rocket.carry(tools);
            }
        }
        return rocketU1;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> toolList) {
        ArrayList<U2> rocketU2 = new ArrayList();
        U2 rocket = new U2();
        rocketU2.add(rocket);
        for (Item tools : toolList) {
            if (rocket.canCarry(tools)) {
                rocket.carry(tools);
            } else {
                rocket = new U2();
                rocketU2.add(rocket);
                rocket.carry(tools);
            }

        }
        return rocketU2;
    }

    public int runSimulation(ArrayList<? extends Rocket> rocket) {
        int cost = 0;
        for (int i = 0; i < rocket.size(); i++) {
            boolean fail = true;
            while (fail) {
                fail = !rocket.get(i).launch() || !rocket.get(i).land();
                cost += rocket.get(i).getCost();
            }

        }
        return cost;
    }

    public static void main(String[] args) throws Exception {
        Simulation trial1 = new Simulation();
        ArrayList<Item> items1 = trial1.loadItems("phase1.txt");
        ArrayList<Item> items2 = trial1.loadItems("phase2.txt");
        ArrayList<Item> allItems = new ArrayList<>();
        allItems.addAll(items1);
        allItems.addAll(items2);
        ArrayList<U1> u1s = trial1.loadU1(allItems);
        ArrayList<U2> u2s = trial1.loadU2(allItems);
        System.out.println(trial1.runSimulation(u1s));
        System.out.println(trial1.runSimulation(u2s));


    }
}
