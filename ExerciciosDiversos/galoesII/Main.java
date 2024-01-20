class Main {
    public static void main (String args[]) {
        double metro, polegadas ;
        int counter; counter = 0;
        for (polegadas = 1; polegadas <=144; polegadas++){
            metro = polegadas / 39.37;
            System.out.println(polegadas + " polegadas são" + metro + " metros"); counter++;
            if (counter == 12 ) {
                System.out.println(); counter = 0;
            }
        }
    }
}