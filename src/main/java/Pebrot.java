public class Pebrot {


    private String nombre,img;
    private long id;

    private CultiuPebrot cultiuPebrot;
    private CaracteristiquesPebrot caracteristiquesPebrot;
    private InfoPebrot infoPebrot;

    public Pebrot(String nombre, String description, String origen, String distanciaEntrePlantas, String distanciaEntreSemillas, String scoville, String anchoPlanta, String familia, String colorFlor, String tempCrecimiento, String luz, String alturaPlanta, String rendimiento, String tiempoMinimoCosecha, String profSemilla, String tempGerminacion, String img) {

        this.img = img;
        cultiuPebrot=new CultiuPebrot(profSemilla,distanciaEntrePlantas,distanciaEntreSemillas,tempCrecimiento,luz,tempGerminacion);
        caracteristiquesPebrot= new CaracteristiquesPebrot(scoville,anchoPlanta,colorFlor,alturaPlanta,rendimiento,tiempoMinimoCosecha);
        infoPebrot= new InfoPebrot(nombre,description,origen,familia);

    }

    public Pebrot(String[] pebrot) {
        this.img = pebrot[pebrot.length-1];
        cultiuPebrot=new CultiuPebrot(pebrot[14],pebrot[3],pebrot[4],pebrot[9],pebrot[10],pebrot[pebrot.length-2]);
        caracteristiquesPebrot= new CaracteristiquesPebrot(pebrot[5],pebrot[6],pebrot[8],pebrot[11], pebrot[12],pebrot[13]);
        infoPebrot= new InfoPebrot(pebrot[0],pebrot[1],pebrot[2],pebrot[7]);
    }
}
