import java.util.List;

public class BibliotecaPebrots {

    public List<Pebrot> getPebrotsList() {
        return pebrotsList;
    }

    private List<Pebrot> pebrotsList;

    public BibliotecaPebrots(List<Pebrot> pebrotsList) {
        this.pebrotsList = pebrotsList;
    }

    @Override
    public String toString() {
        return "BibliotecaPebrots{" +
                "pebrotsList=" + pebrotsList +
                '}';
    }


}
