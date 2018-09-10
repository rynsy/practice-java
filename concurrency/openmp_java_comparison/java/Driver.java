import java.io.*;

public class Driver {
    
    public static void main(String[] args) throws IOException, FileNotFoundException{
        if( args.length < 2 ) {
            System.out.println("Expected java Driver matrixOne.dat matrixTwo.dat");
            System.exit(-1);
        }
        
        BufferedReader fileOne = new BufferedReader(new FileReader(args[0]));
        BufferedReader fileTwo = new BufferedReader(new FileReader(args[1]));
        double[][] a1Array = new double[1000][1];   //Hard-coded sizes
        double[][] a2Array = new double[1][1000];
        String line = null;
        double temp = 0.0;
        int a1Cols, a1Rows, a2Cols, a2Rows;
        a1Cols = a1Rows = a2Cols = a2Rows = 0;
        
        while( (line = fileOne.readLine()) != null ) {
            a1Cols = 0;
            for( String retval : line.split(" ") ) {
                temp = Double.parseDouble(retval);
                a1Array[a1Rows][a1Cols] = temp;
                a1Cols++;
            }
            a1Rows++;
        }

        while( (line = fileTwo.readLine()) != null ) {
            a2Cols = 0;
            for( String retval : line.split(" ") ) {
                temp = Double.parseDouble(retval);
                a2Array[a2Rows][a2Cols] = temp;
                a2Cols++;
            }
            a2Rows++; 
        }
    
        Matrix2D a1 = new Matrix2D(a1Rows, a1Cols, a1Array);
        Matrix2D a2 = new Matrix2D(a2Rows, a2Cols, a2Array);
        
        Matrix2D a3 = a1.multiply(a2);
        Matrix2D a4 = a2.multiply(a1);
    }
}
