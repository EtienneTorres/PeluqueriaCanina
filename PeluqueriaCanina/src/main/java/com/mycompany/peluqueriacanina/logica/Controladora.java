package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia ControlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {

        //Creamos el dueño y asignamos valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);

        //Creamos Mascota y asignamos valores
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setAtencion_especial(atenEsp);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setColor(color);
        masco.setUnDuenio(duenio);

        ControlPersis.guardar(duenio, masco);

    }

    public List<Mascota> traerMascotas() {

        return ControlPersis.traerMascotas();

    }

    public void borrarMascota(int num_cliente) {

        ControlPersis.borrarMascota(num_cliente);

    }

    public Mascota traerMascotas(int numcliente) {

        return ControlPersis.traerMascotas(numcliente);

    }

    public void modificarMascota(Mascota masco, String nombreMasco, String Raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {

        masco.setNombre(nombreMasco);
        masco.setRaza(Raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAtencion_especial(atenEsp);
        masco.setAlergico(alergico);

        //modifico mascota
        ControlPersis.modificarMascota(masco);

        //seteo valores del duenio
        Duenio dueno = this.buscarduenio(masco.getUnDuenio().getId_duenio());
        dueno.setCelDuenio(celDuenio);
        dueno.setNombre(nombreDuenio);

       //llamar al modificar dueño
       this.modificarduenio(dueno);
    }

    private Duenio buscarduenio(int id_duenio) {

        return ControlPersis.traerduenio(id_duenio);

    }

    private void modificarduenio(Duenio dueno) {
         
        ControlPersis.modificarDuenio(dueno);
    }

}
