package LiveObjects;

public class AnimalConstants {
    public enum AnimalParameters {
        WOLF(50,30,3,8,images[7]),
        SNAKE(15,30,1,3,images[8]),
        FOX(8,30,2,2,images[9]),
        BEAR(500,5,2,80,images[1]),
        EAGLE(6,20,3,1,images[10]),
        HORSE(400,20,4,60,images[2]),
        DEER(300,20,4,50,images[3]),
        RABBIT(2,150,2,0.45,images[11]),
        MOUSE(0.05,500,1,0.01,images[14]),
        GOAT(60,140,3,10,images[6]),
        SHEEP(70,140,3,15,images[5]),
        HOG(400,50,2,50,images[4]),
        BULL(700,10,3,100,images[0]),
        DUCK(1,200,4,0.15,images[12]),
        WORM(0.01,1000,0,0,images[14]),
        PLANT(1,200,0,0,images[15]);

        private double weight;
        private int movementSpeed;
        private int maxRepresentatives;
        private double minFood;
        private String icon;

        AnimalParameters(double weight, int maxRepresentatives, int movementSpeed, double minFood, String icon) {
            this.weight=weight;
            this.maxRepresentatives=maxRepresentatives;
            this.movementSpeed=movementSpeed;
            this.minFood=minFood;
            this.icon=icon;
        }

        public double getWeight() {
            return weight;
        }

        public int getMovementSpeed() {
            return movementSpeed;
        }

        public int getMaxRepresentatives() {
            return maxRepresentatives;
        }

        public double getMinFood() {
            return minFood;
        }

        public String getIcon(){
            return icon;
        }
    }

    public static final String [] images= {"\uD83D\uDC03","\uD83D\uDC3B","\uD83D\uDC0E","\uD83E\uDD8C","\uD83D\uDC17","\uD83D\uDC11","\uD83D\uDC10","\uD83D\uDC3A","\uD83D\uDC0D","\uD83E\uDD8A","\uD83E\uDD85","\uD83D\uDC07","\uD83E\uDD86","\uD83D\uDC01","\uD83D\uDC1B","\uD83C\uDF31"};

}
