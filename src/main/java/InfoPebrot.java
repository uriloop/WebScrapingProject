public class InfoPebrot {

    private String nombre, descripcion,origen,familia;

    Formating format= new Formating();
    public InfoPebrot(String nombre, String description, String origen, String familia) {

        this.nombre= nombre;
        this.descripcion=description;
        this.familia=format.familyFilter(familia);
        this.origen= origen;



    }
}
