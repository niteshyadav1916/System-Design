
// Proxy Pattern
interface Document{
     void viewDocument();
}

class RealDocument implements Document{
    private String content;

    public RealDocument(String content) {
        this.content = content;
    }
    
    public void viewDocument(){
         System.out.println("real document is getting viewed" + content);
    }
}

class DocumentProxy implements Document{
    private RealDocument realDocument;
    private String userRole;
    
    DocumentProxy(String userRole){
            this.userRole = userRole;
    }
    
    public void viewDocument(){
         if(userRole == "ADMIN"){
             if(realDocument == null){
                  realDocument = new RealDocument("Sensitive Document Content");
             }
             
             realDocument.viewDocument();
         }else{
             System.out.println("access denied");
         }
    }
}


public class Main
{
	public static void main(String[] args) {
	    
      DocumentProxy userDocumentProxy = new DocumentProxy("USER");
      
      userDocumentProxy.viewDocument();
      
      DocumentProxy adminDocumentProxy = new DocumentProxy("ADMIN");
      
      adminDocumentProxy.viewDocument();
	}
}

// more examples like access restriction, 
// pre/post-processing (logging, publish events), caching, etc
