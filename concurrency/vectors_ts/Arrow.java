/* Euclidean vector implementation in 3-space.
* @Immutable
*/
public class Arrow implements Cloneable {
   static final int DIMENSION = 3;
   public static final Arrow ORIGIN = new Arrow(new long[] {0L, 0L, 0L});
   private static final int HASHSTART = 37;
   private final long coordinates[];

   public Arrow(long[] coords) {
      this.coordinates = new long[DIMENSION];
      for (int i=0; i<DIMENSION; i+=1)
         this.coordinates[i] = coords[i];
   }

   public Arrow(long x, long y, long z) {
      this.coordinates = new long[DIMENSION];
      this.coordinates[0] = x;
      this.coordinates[1] = y;
      this.coordinates[2] = z;
   }

   @Override
   public final Arrow clone() {
      Arrow a = null;
      try {
         a = (Arrow) super.clone(); // shallow copy
      } catch (CloneNotSupportedException thisCantHappen) {
      } finally {
         return a;
      }
   }

   @Override
   public final boolean equals(Object o) {
      if (o instanceof Arrow) {
         Arrow a = (Arrow) o; // safe
         boolean retVal = true;
         for (int i=0; i<DIMENSION; i+=1)
            retVal = retVal && (this.coordinates[i] == a.coordinates[i]);
         return retVal;
      }
      return false;
   }

   @Override
   public final int hashCode() {
      int retVal = HASHSTART;
      for (int i=0; i<DIMENSION; i+=1) {
         retVal *= coordinates[i];
         retVal = (retVal << 8) + (((int)coordinates[i]) & 0xff);
      }
      return retVal & 0x7fffffff; // ensure positive
   }

   public final Arrow plus(Arrow a) {
      long coords[] = new long[DIMENSION];
      for (int i=0; i<DIMENSION; i+=1)
         coords[i] = this.coordinates[i] + a.coordinates[i];
      return new Arrow(coords);
   }

   public final Arrow minus(Arrow a) {
      long coords[] = new long[DIMENSION];
      for (int i=0; i<DIMENSION; i+=1)
         coords[i] = this.coordinates[i] - a.coordinates[i];
      return new Arrow(coords);
   }

   public final Arrow scaledBy(int factor) {
      long coords[] = new long[DIMENSION]; // There's GOT to be a better way! >:/
      for (int i=0; i<DIMENSION; i+=1)
         coords[i] = this.coordinates[i]*factor;
      return new Arrow(coords);
   }

   public final Arrow dividedBy(int divisor) {
      long coords[] = new long[DIMENSION]; // There's GOT to be a better way! >:/
      for (int i=0; i<DIMENSION; i+=1)
         coords[i] = this.coordinates[i]/divisor; // integer division
      return new Arrow(coords);
   }
    
   @Override
   public final String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append('(');
      for (int i=0; i<DIMENSION; i+=1) {
         sb.append(this.coordinates[i]);
         sb.append(',');
      }
      sb.replace(sb.length()-1,sb.length(),")");
      return sb.toString();
   }
   /* Static method to measure distance between arrows.  Not very accurate
      * because of integer arithmetic
      */
   public static long distance(Arrow a, Arrow b) {
      double sum = 0.0;
      for (int i=0; i<DIMENSION; i+=1) {
         double diff = a.coordinates[i] - b.coordinates[i];
         sum += diff * diff;
      }
      return (long) Math.sqrt(sum);
   }
}
