import java.util.List;

public class BibliotecaPebrots {

    public BibliotecaPebrots(List<Pebrot> pebrotsList){
        this.pebrotsList = pebrotsList;
    }

    public List<Pebrot> getPebrotsList() {
        return pebrotsList;
    }

    private List<Pebrot> pebrotsList;


    @Override
    public String toString() {
        return "BibliotecaPebrots{" +
                "pebrotsList=" + pebrotsList +
                '}';
    }




}
