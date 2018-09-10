import java.lang.Exception;

public final class Matrix2D {
   /* 
    *   I've declared the class and it's members final to make them
    *   immutable. All methods in the class don't modify the current
    *   instance of the object (or objects passed in as parameters).
    *   
    *   No method modifies either the current instance of Matrix2D
    *   or Matrix2D's passed in as parameters. Write operations are
    *   avoided by creating new double[][] to write the results of 
    *   each method to, and these variables are used to instantiate
    *   new Matrix2D's whose references are returned from the method.
    *
    *   I had to use goofy formatting for some of the dimension 
    *   checking I do at the beginning of some methods (to keep 
    *   all my lines within 80 characters). 
    *
    *   I also chose not to use the @immutable decorator from the 
    *   text, since that's more of a promise to other developers 
    *   instead of verification that the class is immutable. I also
    *   chose not to use packages I found on Github for verifying 
    *   immutability since it defeats the purpose of writing my own
    *   tests. 
    */

    private final int rows;
    private final int cols;
    private final double[][] matrix;

    public Matrix2D (int rows, int cols, double[][] matrix) {
 
            this.rows = rows;
            this.cols = cols;
            this.matrix = matrix;
    }
    
    public Matrix2D ( Matrix2D original ) {
  
        this(original.rows, original.cols, original.matrix);
    } // copy constructor
    
    public int getNumberOfRows() {
   
        return this.rows;
    }

    public int getNumberOfColumns() {
    
        return this.cols;
    }
    
    public Matrix2D add( Matrix2D rightOperand ) {
        /*
         * I use members resultRows, resultCols, and resultMatrix in
         * each method to try to maintain consistency. I believe it 
         * makes the code more readable (though I can see the 
         * argument that it's unnecessary). 
         */
        
        if ( this.rows != rightOperand.rows 
                ||
             this.cols != rightOperand.cols ) 
        {
            throw new IllegalArgumentException(
                    "Matrix2D.add expects Matrix2D of equal dimension"
            );
        } //goofy formatting to meet 80 character line limit 

        int resultRows = this.rows;
        int resultCols = this.cols;
        double[][] resultMatrix = new double[resultRows][resultCols];

        for( int i = 0; i < resultRows; i++ ) {
            for( int j = 0; j < resultCols; j++ ) {
                resultMatrix[i][j] = this.matrix[i][j]
                    + rightOperand.matrix[i][j];
            }
        }
        return new Matrix2D(resultRows, resultCols, resultMatrix);
    }

    public Matrix2D subtract( Matrix2D rightOperand ) {
        
        if ( this.rows != rightOperand.rows 
                ||
             this.cols != rightOperand.cols ) 
        {
            throw new IllegalArgumentException(
               "Matrix2D.subtract expects Matrix2D of equal dimension"
            );
        } //goofy formatting to meet 80 character line limit

        int resultRows = this.rows;
        int resultCols = this.cols;
        double[][] resultMatrix = new double[resultRows][resultCols];
        
        for( int i = 0; i < resultRows; i++ ) {
            for( int j = 0; j < resultCols; j++ ) {
                resultMatrix[i][j] = this.matrix[i][j]
                    - rightOperand.matrix[i][j];
            }
        }
        return new Matrix2D(resultRows, resultCols, resultMatrix);
    }

    public Matrix2D multiply( Matrix2D rightOperand ) { 
        
        if ( this.cols != rightOperand.rows )
        {
            throw new IllegalArgumentException(
            "Matrix2D.multiply expects arg where this.cols = arg.rows"
            );
        }
        
        int resultRows = this.rows;
        int resultCols = rightOperand.cols;
        double[][] resultMatrix = new double[resultRows][resultCols];
        double sum;
        
        for( int i = 0; i < this.rows; i++ ) {
            for( int j = 0; j < this.cols; j++ ) {
                sum = 0.0;
                for( int k = 0; k < rightOperand.rows; k++ ) {
                    sum = sum + this.matrix[i][k] 
                        * rightOperand.matrix[k][j];
                } 
                resultMatrix[i][j] = sum;
            }
        }
        return new Matrix2D(resultRows, resultCols, resultMatrix);
    }

    public Matrix2D transpose() {
         
        int resultRows = this.cols;
        int resultCols = this.rows;
        double[][] resultMatrix = new double[resultRows][resultCols];

        for( int i = 0; i < resultRows; i++ ) {
            for( int j = 0; j < resultCols; j++ ) {
                resultMatrix[i][j] = this.matrix[j][i];
            }
        }

        return new Matrix2D(resultRows, resultCols, resultMatrix);
    }

    public boolean equals(Matrix2D rightOperand) {
        
        if ( this.rows != rightOperand.rows 
                ||
             this.cols != rightOperand.cols ) 
        {
            return false;
        }

        for( int i = 0; i < this.rows; i++ ) {
            for( int j = 0; j < this.cols; j++ ) {
                if( this.matrix[i][j]
                        !=
                    rightOperand.matrix[i][j] )
                {
                    return false;
                }
            }
        }

        return true;
    }
    
    public String toString() { 
        
        String matrix = "\n";
        for( int i = 0; i < this.rows; i++ ) {
            for( int j = 0; j < this.cols; j++ ) {
                matrix = matrix + this.matrix[i][j] + " ";
            }
            matrix = matrix + "\n";
        }
        return matrix;
    }
}
