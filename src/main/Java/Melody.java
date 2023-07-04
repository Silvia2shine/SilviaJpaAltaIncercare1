import jakarta.persistence.*;
import lombok.ToString;


@ToString
@Entity
@Table(name = "audioTable")
public class Melody {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String audioLink;


    public Melody(int id, String name, String audioLink) {
        this.id = id;
        this.name = name;
        this.audioLink = audioLink;
    }

    public Melody() {
    }

    public Melody(String name, String audioLink) {
        this.name = name;
        this.audioLink = audioLink;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAudioLink(String audioLink) {
        this.audioLink = audioLink;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAudioLink() {
        return audioLink;
    }
}
