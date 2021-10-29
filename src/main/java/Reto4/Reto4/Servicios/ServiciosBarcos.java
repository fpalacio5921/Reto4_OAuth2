package Reto4.Reto4.Servicios;

import Reto4.Reto4.Entidades.Barcos;
import Reto4.Reto4.Repositorios.RepositorioBarcos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosBarcos {
    @Autowired
    private RepositorioBarcos metodosCrud;

    public List<Barcos> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Barcos> getBarcos(int boatId) {

        return metodosCrud.getBarcos(boatId);
    }

    public Barcos save(Barcos boat) {
        if (boat.getId() == null) {
            return metodosCrud.save(boat);
        } else {
            Optional<Barcos> serbar = metodosCrud.getBarcos(boat.getId());
            if (serbar.isEmpty()) {
                return metodosCrud.save(boat);
            } else {
                return boat;
            }
        }
    }

    public Barcos update(Barcos boat){
        if(boat.getId()!=null){
            Optional<Barcos> serbar=metodosCrud.getBarcos(boat.getId());
            if(!serbar.isEmpty()){
                if(boat.getName()!=null){
                    serbar.get().setName(boat.getName());
                }
                if(boat.getBrand()!=null){
                    serbar.get().setBrand(boat.getBrand());
                }
                if(boat.getYear()!=null){
                    serbar.get().setYear(boat.getYear());
                }
                if(boat.getDescription()!=null){
                    serbar.get().setDescription(boat.getDescription());
                }
                if(boat.getCategory()!=null){
                    serbar.get().setCategory(boat.getCategory());
                }
                metodosCrud.save(serbar.get());
                return serbar.get();
            }else{
                return boat;
            }
        }else{
            return boat;
        }
    }


    public boolean deleteBarcos(int boatId) {
        Boolean aBoolean = getBarcos(boatId).map(boat -> {
            metodosCrud.delete(boat);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
