import java.io.*;
import java.util.Random;

public class ImmutableMatrix {
    /*
     *  This class generates a square matrix of random numbers between
     *  1 and 10. The number of rows/columns of the matrix can be
     *  modified by changing the public static member size. 
     *
     *  To test immutability, I created a random matrix, and kept a 
     *  copy of it to compare it to. I call each of the member 
     *  functions of Matrix2D on the base matrix, and compare it to 
     *  the copy to see if there's any mutation.
     *
     *  I was going to try to test accessing the private final members
     *  of the object, but I couldn't find an exception that would
     *  let me do that and continue the tests. 
     */

    public static int size = 5;
    public static void main(String[] args) {
        Random rand = new Random();

        double[][] matrix = new double[size][size];
        for( int i = 0; i < size; i++ ) {
            for( int j = 0; j < size; j++ ) {
                matrix[i][j] = rand.nextInt(10) + 1;
            }
        }
        
        double[][] onesMatrix = new double[size][size];
        for( int i = 0; i < size; i++ ) {
            for( int j = 0; j < size; j++ ) {
                onesMatrix[i][j] = 1;
            }
        }
        Matrix2D base = new Matrix2D(size,size,matrix);
        Matrix2D ones = new Matrix2D(size,size,onesMatrix);
        Matrix2D copy = new Matrix2D(base);
        if( base.equals(copy) ) {
            System.out.println("The Matrix was copied successfully.");
            System.out.println("Base: \n" + base.toString());
            System.out.println("Copy: \n" + copy.toString());
        } else {
            System.out.println("The copy constructor"
                   + " mutated the matrix!");
        }
        Matrix2D addResult = base.add(copy);
        
        if( base.equals(copy) ) {
            System.out.println("The Matrix was unchanged after a"
                    + " call to add().");
            System.out.println("Result of base + base:\n" 
                    + addResult.toString());
        } else {
            System.out.println("The Matrix has been mutated!");
        }
        
        Matrix2D subResult = base.subtract(ones);
        
        if( base.equals(copy) ) {
            System.out.println("The Matrix was unchanged after a"
                    + " call to subtract().");
            System.out.println("Result of (base - " 
                    + " a square matrix of 1's):\n" 
                    + subResult.toString());
        } else {
            System.out.println("The Matrix has been mutated!");
        }
        
        if( base.getNumberOfRows() == size ) {
            System.out.println("Matrix contains right # of rows.");
        }

        if( base.getNumberOfColumns() == size ) {
            System.out.println("Matrix contains right # of columns.");
        }
        
        if( base.equals(copy) ) {
            System.out.println("Calls to getters didn't"
                + " mutate the Matrix");
        } else {
            System.out.println("The Matrix has been mutated!");
        }
    }
}
