public class AckermannFunction {

    public static void main(String[] args) {
        int result = ackermann(3, 4);
        System.out.println("A(3, 4) = " + result);
    }

    public static int ackermann(int x, int y) {
        if (x == 0) {
            return y + 1;
        } else if (y == 0) {
            return ackermann(x - 1, 1);
        } else {
            return ackermann(x - 1, ackermann(x, y - 1));
        }
    }
}
