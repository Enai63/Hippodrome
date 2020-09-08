package javarush.game.Hippodrome;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome( new ArrayList<>() );

        Horse light = new Horse( "light", 3.0, 0.0 );
        Horse Star = new Horse( "Star", 3.0, 0.0 );
        Horse Moon = new Horse( "Moon", 3.0, 0.0 );

        game.horses.add( light );
        game.horses.add( Star );
        game.horses.add( Moon );

        game.run();
        game.printWinner();

    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep( 200 );
        }
    }
    public void move() {
        for (Horse horse : horses)
            horse.move();

    }
    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse horse = horses.get( 0 );
        for (Horse horseI : horses) {
            if (horse.getDistance() < horseI.getDistance()) {
                horse = horseI;
            }
        }
        return horse;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
