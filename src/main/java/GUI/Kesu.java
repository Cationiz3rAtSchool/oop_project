package GUI;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Kesu {
	public SimpleStringProperty  name, info, link;
	public SimpleIntegerProperty Id;
	 
    public int getId() {
        return Id.get();
    }
    public String getName() {
        return name.get();
    }

    public String getInfo() {
        return info.get();
    }

    public String getLink() {
        return link.get();
    }
    Kesu(int Id, String name, String info, String link) {
        this.Id   = new SimpleIntegerProperty(Id);
        this.name = new SimpleStringProperty(name);
        this.info = new SimpleStringProperty(info);
        this.link = new SimpleStringProperty(link);
    }
}
