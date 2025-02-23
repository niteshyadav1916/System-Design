
// Singleton Pattern
class DatabaseConnection {
    
   private static DatabaseConnection dbConnection;
   private DatabaseConnection(){};
   
   // double locking
   public static DatabaseConnection getInstance(){
       if(dbConnection==null){
           synchronized (DatabaseConnection.class){
                  if(dbConnection==null){
                         System.out.println("object being created once");
                         dbConnection = new DatabaseConnection();
                   }
           }
       }
       
       return dbConnection;
   }
   
}


public class Main
{
	public static void main(String[] args) {
	    
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        
        
        DatabaseConnection dbConnectionSecondUsage = DatabaseConnection.getInstance();
         
        
	}
}

// more examples like db connection, config manager
