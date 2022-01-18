public class Pebrot {


    private String nombre,img;
    private String id;

    private CultiuPebrot cultiuPebrot;
    private CaracteristiquesPebrot caracteristiquesPebrot;
    private InfoPebrot infoPebrot;

    public Pebrot(String nombre, String description, String origen, String distanciaEntrePlantas, String distanciaEntreSemillas, String scoville, String anchoPlanta, String familia, String colorFlor, String tempCrecimiento, String luz, String alturaPlanta, String rendimiento, String tiempoMinimoCosecha, String profSemilla, String tempGerminacion, String img) {

        this.img = img;
        cultiuPebrot=new CultiuPebrot(profSemilla,distanciaEntrePlantas,distanciaEntreSemillas,tempCrecimiento,luz,tempGerminacion);
        caracteristiquesPebrot= new CaracteristiquesPebrot(scoville,anchoPlanta,colorFlor,alturaPlanta,rendimiento,tiempoMinimoCosecha);
        infoPebrot= new InfoPebrot(nombre,description,origen,familia);

    }

}
