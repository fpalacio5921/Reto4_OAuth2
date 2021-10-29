package Reto4.Reto4.Repositorios;

import Reto4.Reto4.Entidades.Barcos;
import Reto4.Reto4.Interfaces.InterfaceBarcos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioBarcos {

    @Autowired
    private InterfaceBarcos crud;

    public List<Barcos> getAll(){
        return (List<Barcos>) crud.findAll();
    }

    public Optional<Barcos> getBarcos(int id){
        return crud.findById(id);
    }

    public Barcos save(Barcos boat){
        return crud.save(boat);
    }
    public void delete(Barcos boat){
        crud.delete(boat);
    }

}
