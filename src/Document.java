public abstract class Document {

    public Document(String documentType, String id){
        this.documentType = documentType;
        this.id = id;
    }
    
private String documentType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

public String getDocumentType() {
    return documentType;
}




}
