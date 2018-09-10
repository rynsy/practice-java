/* trajectory and status information for an object.
*/

public class Trajectory implements Cloneable {
   public static final int MAXDELTAT = (int) Math.sqrt(Integer.MAX_VALUE);
   private static final int HASHSTART = 937;
   // Note: because Arrows are immutable, a shallow copy is fine
   private Arrow position;
   private Arrow velocity;
   private Arrow acceleration;

   public Trajectory(Arrow pos, Arrow vel, Arrow acc) {
      this.position = pos;
      this.velocity = vel;
      this.acceleration = acc;
   }

   @Override
   public synchronized Trajectory clone() {
      Trajectory t = null;
      try {
         // Note: because Arrows are immutable, a shallow copy is fine
         t = (Trajectory) super.clone();
      } catch (CloneNotSupportedException thisCantHappen) {
      } finally {
         return t;
      }
   } 

   @Override
   public final boolean equals(Object o) {
      if (o instanceof Trajectory) {
         Trajectory t = (Trajectory) o; // safe
         return this.position.equals(t.position) &&
            this.velocity.equals(t.velocity) &&
               this.acceleration.equals(t.acceleration);
      }
      return false;
   }

   @Override
   public final int hashCode() {
      int retVal = HASHSTART*HASHSTART*acceleration.hashCode() +
         HASHSTART*velocity.hashCode()+acceleration.hashCode();
      return retVal & 0x7fffffff;
   }

   /* adjust position and velocity for passage of time
      */
   public synchronized void update(int deltat) {
      if (deltat < 0 || deltat > MAXDELTAT)
         throw new RuntimeException("illegal time increment");
      // next line is safe if we got this far...
      position = position.plus(velocity.scaledBy(deltat).plus(
         acceleration.scaledBy(deltat*deltat).dividedBy(2)));
      velocity = velocity.plus(acceleration.scaledBy(deltat));
   }

   public synchronized void accelerate(Arrow delta) {
      acceleration = acceleration.plus(delta);
   }

   public synchronized Arrow getPosition() { // synchronized for visibility
      return position;  // immutable, so OK to return the original
   }

   public synchronized Arrow getVelocity() { // synchronized for visibility
      return velocity;  // immutable, so OK to return the original
   }

   public synchronized String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("<pos=");
      sb.append(this.position.toString());
      sb.append(",vel=");
      sb.append(this.velocity.toString());
      sb.append(",acc=");
      sb.append(this.acceleration.toString());
      sb.append(">");
      return sb.toString();
   }

}
