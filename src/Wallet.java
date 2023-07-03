import java.util.LinkedList;
import java.util.List;

public class Wallet {

    public Wallet(){

        this.documents = new LinkedList<Document>();

    }
    
private List<Document> documents;

public List<Document> getDocuments() {
    return documents;
}

public void AddDocumentToWallet(Document document) {
    documents.add(document);
}




}
