import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

class SymbolTable {
   private ArrayList<HashMap<String, Symb>> table;

   SymbolTable() {
       table = new ArrayList<HashMap<String, Symb>>();
       table.add(new HashMap<String, Symb>());
   }

   public void openScope() {
       table.add(new HashMap<String, Symb>());
   }

   public void closeScope() throws EmptySTException {
       if (table.isEmpty()) {
            throw new EmptySTException();
       } else {
           table.remove(table.size() - 1);
       }
   }

   public void insert(Symb s) throws EmptySTException, DuplicateException{
      if (table.isEmpty()) {
        throw new EmptySTException();
      }
      int last = table.size() - 1;
      if (this.table.get(last).containsKey(s.name().toLowerCase())) {
        throw new DuplicateException();
      } else {
        this.table.get(last).put(s.name().toLowerCase(), s);
      }
   }

   public Symb localLookup(String s) {
      if (table.isEmpty() ) {
        return null;
      } 
      HashMap<String, Symb> scope = table.get(table.size() - 1);
      if (!scope.containsKey(s.toLowerCase())) {
        return null;
      }
      return scope.get(s.toLowerCase());
   }

   public Symb globalLookup(String s) {
       HashMap<String, Symb> scope = null;
        for( int i = table.size() - 1; i >= 0; i--) {
            scope = table.get(i);
            if ( scope.containsKey(s.toLowerCase()) ) {
               return scope.get(s.toLowerCase()); 
            }
        }
        return null;
   }

   public String toString() {
      String tableStr = "";
      HashMap<String, Symb> scope = null;

      if (table.isEmpty()) {
        return "{}";
      }

      for( int i = 0; i < table.size(); i++ ) {
        scope = table.get(i);
        Iterator<Map.Entry<String, Symb>> it = scope.entrySet().iterator();
        tableStr += "{";
        while (it.hasNext()) {
            Map.Entry<String, Symb> pair = it.next();
            tableStr += pair.getKey() + " = " + pair.getValue().toString() + ",";
        }
        tableStr += "}";
      }
      return tableStr; // change this
   }

   void dump(PrintStream ps) {
      ps.print(this.toString() + "\n");
   }
}
