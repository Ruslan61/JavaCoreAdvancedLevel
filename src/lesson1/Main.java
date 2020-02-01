package lesson1;

import lesson1.competitors.Cat;
import lesson1.competitors.Competitor;
import lesson1.competitors.Human;
import lesson1.competitors.Robot;
import lesson1.obstacle.Cross;
import lesson1.obstacle.Obstacle;
import lesson1.obstacle.Wall;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors ={
                new Human("Vasia", 1200, 5),
                new Human("Petia", 600, 3),
                new Cat("Murzik", 800, 6),
                new Cat("Barsik", 1100, 3),
                new Robot("BostonDynamics", 3000, 12),
                new Robot("Android-C137", 500, 6)
        };
        Obstacle[] obstacles ={
                new Wall(4),
                new Cross(1000)
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
