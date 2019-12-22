public class TestBody {
    public static void main(String[] args) {
        checkTestBody();
    }

    private static void checkEquals(double expected, double actual, String label, double eps) {
        if (Double.isNaN(actual) || Double.isInfinite(actual)) {
            System.out.println("FAIL: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        } else if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label
                    + ": Expected " + expected + " and you gave " + actual);
        }
    }


    /**
     *  Checks the Body class to make sure update works.
     */
    private static void checkTestBody() {
        System.out.println("Checking TestBody...");

        Body b1 = new Body(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Body b2 = new Body(2.0, 2.0, 3.0, 4.0, 5.0, "mars.gif");

        double val = b1.calcForceExertedBy(b2);
        checkEquals(8.3375e-10, val, "pairwise force", 0.01);
    }
}