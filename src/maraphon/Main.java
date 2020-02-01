package maraphon;

import maraphon.competitors.Cat;
import maraphon.competitors.Competitor;
import maraphon.competitors.Human;
import maraphon.competitors.Robot;
import maraphon.obstacle.Cross;
import maraphon.obstacle.Obstacle;
import maraphon.obstacle.Wall;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors ={
                new Human("Vasia", 1200, 5),
                new Human("Petia", 600, 3),
                new Cat("Murzik", 800, 6),
                new Cat("Barsik", 900, 7),
                new Robot("BostonDynamics", 3000, 12),
                new Robot("Android-C137", 500, 6)
        };
        Obstacle[] obstacles ={
                new Wall(5),
                new Cross(750)
        };
        for (Competitor c:competitors) {
            for (Obstacle o:obstacles) {
                o.doIt(c);
                if(!c.isDistance()){
                    break;
                }
            }
        }

        for (Competitor c:competitors) {
            c.info();
        }
    }
}
