public class InfoPebrot {

    private String nombre, descripcion,familia;

    private String[] origen;

    Formating format= new Formating();
    public InfoPebrot(String nombre, String description, String origen, String familia) {

        this.nombre= nombre;
        this.descripcion=description;
        this.familia=format.familyFilter(familia);
        this.origen= format.getValuesFromOrigen(origen);

        // constructor revisat

    }
}
