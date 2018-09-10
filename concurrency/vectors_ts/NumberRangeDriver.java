/*
    Class for exercising the NumberRange class.
    @author Ryan Lindsey

   */
public class NumberRangeDriver {
    final static String PASS = "PASS";
    final static String FAIL = "FAIL";

    public static void main(String[] args) {
        System.out.println("Testing if 3 is in range[2,4]: "
                + testIfNumberInRange(2,4,3));
        System.out.println("Testing if 1 is in range[0,1]: "
                + testIfNumberInRange(0,1,1));
        System.out.println("Testing if 0 is in range[0,0]: "
                + testIfNumberInRange(0,0,0));
        System.out.println("Testing if 0 is not in range[1,2]: "
                + testIfNumberOutOfRange(1,2,0));
        System.out.println("Testing if 3 is not in range[0,0]: "
                + testIfNumberOutOfRange(0,0,3));
        System.out.println("Testing if 99 is not in range[0,1]: "
                + testIfNumberOutOfRange(0,0,99));
        
        /*
            The class should throw exceptions if the 
            upper > lower invariant is violated.
           */
        try {
            NumberRange test = new NumberRange();
            test.setLower(10);
            System.out.println("Raise exception for bad range "
                + "(setting lower > upper): "
                + FAIL);
        } catch ( IllegalArgumentException name) {
            System.out.println("Raise exception for bad range: "
                + "(setting lower > upper): "
                + PASS);
        }
        
        try {
            NumberRange test = new NumberRange();
            test.setUpper(10);
            test.setLower(5);
            test.setUpper(4);
            System.out.println("Raise exception for bad range "
                + "(setting upper < lower): "
                + FAIL);
        } catch ( IllegalArgumentException name) {
            System.out.println("Raise exception for bad range: "
                + "(setting upper < lower): "
                + PASS);
        }

    }

    /*
     *  Test if the integer x is in the range [m,n],
     *  return "PASS" if true.
     */
    static String testIfNumberInRange(int m, int n, int x) {
        NumberRange r = new NumberRange();
        r.setUpper(n);
        r.setLower(m);
        if( r.isInRange(x) ) {
            return PASS;
        } else {
            return FAIL;
        }
    }
    /*
     *  Test if the integer x is NOT in the range [m,n],
     *  return "PASS" if true.
     */
    static String testIfNumberOutOfRange(int m, int n, int x) {
        NumberRange r = new NumberRange();
        r.setUpper(n);
        r.setLower(m);
        if( !r.isInRange(x) ) {
            return PASS;
        } else {
            return FAIL;
        }
    }
}
