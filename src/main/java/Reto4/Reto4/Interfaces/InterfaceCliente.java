package Reto4.Reto4.Interfaces;

import Reto4.Reto4.Entidades.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceCliente extends CrudRepository<Cliente,Integer> {

}
