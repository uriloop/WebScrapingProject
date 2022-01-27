public class InfoPebrot {

    private String nombre, descripcion,familia;

    private String[] origen;

    FormatingPebrots format= new FormatingPebrots();
    public InfoPebrot(String nombre, String description, String origen, String familia) {

        this.nombre= nombre;
        this.descripcion=description;
        this.familia=format.familyFilter(familia);
        this.origen= format.getValuesFromOrigen(origen);   /// En aquest cas guardaré com array per a probar. Després hauré de fer getters més concrets

        // constructor revisat

    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFamilia() {
        return familia;
    }

    public String getOrigen() {
        String data= origen[0];
        if (origen.length==2) data+=", "+origen[1];
        return data;
    }



}
