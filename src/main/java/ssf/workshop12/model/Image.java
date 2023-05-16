package ssf.workshop12.model;

public class Image {
    
    private String name;
    private String path;

    
    //to populate the image data POJO class
    public Image() {
    }



    public Image(String name, String path) {
        this.name = name;
        this.path = path;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public void setPath(String path) {
        this.path = path;
    }



    public String getPath() {
        return path;
    }



    @Override
    public String toString() {
        return "Image [name=" + name + ", path=" + path + "]";
    }

    

    
}
