public class Pebrot {


    private String nombre,
            description, origen, distanciaEntrePlantas, distanciaEntreSemillas, scoville, anchoPlanta, familia, colorFlor,
            tempCrecimiento, luz, alturaPlanta, rendimiento, tiempoMinimoCosecha, profSemilla, tempGerminacion,img;

    private CultiuPebrot cultiuPebrot;
    private CaracteristiquesPebrot caracteristiquesPebrot;
    private InfoPebrot infoPebrot;

    public Pebrot(String nombre, String description, String origen, String distanciaEntrePlantas, String distanciaEntreSemillas, String scoville, String anchoPlanta, String familia, String colorFlor, String tempCrecimiento, String luz, String alturaPlanta, String rendimiento, String tiempoMinimoCosecha, String profSemilla, String tempGerminacion, String img) {
        this.nombre = nombre;
        this.description = description;
        this.origen = origen;
        this.distanciaEntrePlantas = distanciaEntrePlantas;
        this.distanciaEntreSemillas = distanciaEntreSemillas;
        this.scoville = scoville;
        this.anchoPlanta = anchoPlanta;
        this.familia = familia;
        this.colorFlor = colorFlor;
        this.tempCrecimiento = tempCrecimiento;
        this.luz = luz;
        this.alturaPlanta = alturaPlanta;
        this.rendimiento = rendimiento;
        this.tiempoMinimoCosecha = tiempoMinimoCosecha;
        this.profSemilla = profSemilla;
        this.tempGerminacion = tempGerminacion;
        this.img = img;
        cultiuPebrot=new CultiuPebrot(distanciaEntrePlantas,distanciaEntreSemillas,tempCrecimiento,luz,profSemilla,tempGerminacion);
        caracteristiquesPebrot= new CaracteristiquesPebrot(scoville,anchoPlanta,colorFlor,alturaPlanta,rendimiento,tiempoMinimoCosecha);
        infoPebrot= new InfoPebrot(nombre,description,origen,familia);

    }

}
