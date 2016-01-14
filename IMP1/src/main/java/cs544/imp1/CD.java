
package cs544.imp1;

import javax.persistence.Entity;

@Entity
public class CD extends Product{
    private String artist;

    public CD(String name, String description,String artist) {        
        super(name, description);
        this.artist=artist;
    }

    public CD() {
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    
}
