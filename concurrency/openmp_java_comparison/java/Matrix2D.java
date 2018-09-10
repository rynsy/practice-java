import java.io.*;
import java.util.*;
import java.lang.String;

//This is immutable

public class Matrix2D   {
   
   private final int rows;
   private final int cols; 
   private final double[][] matrix;


   /** Creates a new Matrix2D object specified by the number of rows and    
      columns for a 2-dimensional double array.
      @param rows    Number of rows in 2D array.
      @param cols    Number of columns in 2D array.
      @param array   A 2D array of values for populating the Matrix2D object.
      */
   public Matrix2D( int rows, int cols, double[][] array ){
      this.rows = rows;
      this.cols = cols;
      // matrix = new double[this.rows][this.cols];
      matrix = arrayCopy( array ); // makes mutable
      
      // copy row by row

   }
   
   /** Creates a new Matrix2D object so that is represents the same 
      Matrix2D object as the argument.
      @param original   A Matrix2D object 
      */
   public Matrix2D( Matrix2D original ){
      this( original.rows, original.cols, original.matrix );
   }

   /** Returns the number of rows in this Matrix2D object. 
      @return Number of rows
      */
      public int getNumberOfRows()    { return rows; }

   /** Returns the number of columns in this Matrix2D object. 
      @return Number of columns
      */
      public int getNumberOfColumns() { return cols; }
      
   /** Multiplies this Matrix2D object by rightOperand Matrix2D object.   
      @param rightOperand Right operand
      @return  Product of this and rightOperand
      */
   public Matrix2D multiply( Matrix2D rightOperand ){
      
      if ( this.cols != rightOperand.rows ) {
         System.err.println("Can't multiply matrices with these dimensions.");
         System.exit(1);
      }

      double[][] result = new double[rows][rightOperand.cols];
      
      for (int i = 0; i < rows; i++){
         for (int j = 0; j < rightOperand.cols; j++){
            for (int k = 0; k < cols; k++){
               result[i][j] += this.matrix[i][k] * rightOperand.matrix[k][j];
            }
         }
      }      
      return new Matrix2D( rows, rightOperand.cols, result );
   }

   /** Adds rightOperand Matrix2D object to this Matrix2D object.    
      @param rightOperand Right operand
      @return  Sum of this and rightOperand
      */
   public Matrix2D add( Matrix2D rightOperand ){
      
      if ( this.cols != rightOperand.cols || this.rows != rightOperand.rows ) {
         System.err.println( "Can't add matrices with different dimensions." );
         System.exit( 1 );
      }
      
      double[][] result = new double[this.rows][this.cols];
      
      for (int i = 0; i < this.rows; i++){
         for (int j = 0; j < this.cols; j++){
            result[i][j] = this.matrix[i][j] + rightOperand.matrix[i][j];
         }
      }
      
      return new Matrix2D( this.rows, this.cols, result);
   }
   
   
   /** Subtracts rightOperand from this object.    
      @param rightOperand Right operand
      @return  Difference of this and rightOperand
      */
   public Matrix2D subtract( Matrix2D rightOperand ){
      
      if ( this.cols != rightOperand.cols || this.rows != rightOperand.rows ) {
         System.err.println( "Can't add matrices with different dimensions." );
         System.exit( 1 );
      }
      
      double[][] result = new double[this.rows][this.cols];
      
      for (int i = 0; i < this.rows; i++){
         for (int j = 0; j < this.cols; j++){
            result[i][j] = this.matrix[i][j] - rightOperand.matrix[i][j];
         }
      }
      
      return new Matrix2D( this.rows, this.cols, result);
   }
   
   
   /** Inverts the matrix represented by the Matrix2D object. 
      Rows of the original Matrix2D object become columns.
      @return transpose of the Matrix2D object.
      */
   public Matrix2D transpose(){
      
      double[][] array = new double[this.cols][this.rows];
      
      for ( int i = 0; i < this.rows; i++ ){
         for ( int j = 0; j < this.cols; j++ ){
            array[j][i] = this.matrix[i][j];
         }
      }
      return new Matrix2D( this.cols, this.rows, array );
   }
   
   /**Indicates whether the dimensions and contents of some other Matrix2D
      object is "equal to" this one. 
      @param obj Some other Matrix2D object.
      @return true if the Matrix2D objects have same dimensions and contents; 
      false otherwise.
      */
   @Override 
   public boolean equals( Object obj ){
      
      if ( this == obj ){
         return true;
      }
      
      boolean same = (obj.getClass() != this.getClass());
      Matrix2D otherMatrix = (Matrix2D) obj;
      
      int otherRows = otherMatrix.rows;
      int otherCols = otherMatrix.cols;
       
      same = ( this.rows == otherRows ) & ( this.cols == otherCols );
      
      if ( !same ) {
         return false;
      }
      
      if ( same ){
         for( int i = 0; i < rows; i++ ){
            for( int j = 0; j < cols; j++ ){
               same &= ( this.matrix[i][j] == otherMatrix.matrix[i][j] );
            }
         }
      }
      return same;
   }
   
   /**Returns a string representation of the Matrix2D object. */
   @Override 
   public String toString(){
      int rowNum = 0;
      StringBuilder sb = new StringBuilder("[");
      for( double[] row: matrix){
         
         if ( rowNum != 0 ) sb.append(" ");
         sb.append( " " + Arrays.toString(row ) );
         rowNum++;
         if ( rowNum < rows ) sb.append("\n");
      }
      sb.append(" ]");
      return sb.toString();
   }     
   
   public static double[][] arrayCopy( double[][] array ){
      int rows = array.length;
      int cols = array[0].length;
      
      double[][] copy = new double[rows][cols];
      
      for (int i = 0; i < rows; i++){
         copy[i] = array[i].clone();
      }
      return copy;
      
   }
   
}