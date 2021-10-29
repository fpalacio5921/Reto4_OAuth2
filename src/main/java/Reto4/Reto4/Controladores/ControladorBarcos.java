package Reto4.Reto4.Controladores;

import Reto4.Reto4.Entidades.Barcos;
import Reto4.Reto4.Servicios.ServiciosBarcos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorBarcos {
    @Autowired
    private ServiciosBarcos servicio;

    @GetMapping("/all")
    public List<Barcos> getBarcos() {
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Barcos> getBarcos(@PathVariable("id") int boadId) {
        return servicio.getBarcos(boadId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Barcos save(@RequestBody Barcos boat) {
        return servicio.save(boat);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Barcos update(@RequestBody Barcos boat) {
        return servicio.update(boat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int boatId) {
        return servicio.deleteBarcos(boatId);
    }
}
