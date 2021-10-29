package Reto4.Reto4.Servicios;

import Reto4.Reto4.Entidades.Cliente;
import Reto4.Reto4.Repositorios.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosCliente {
    @Autowired
    private RepositorioCliente metodosCrud;

    public List<Cliente> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Cliente> getClient(int clientId) {
        return metodosCrud.getCliente(clientId);
    }

    public Cliente save(Cliente client) {
        if (client.getIdClient() == null) {
            return metodosCrud.save(client);
        } else {
            Optional<Cliente> sercli = metodosCrud.getCliente(client.getIdClient());
            if (sercli.isEmpty()) {
                return metodosCrud.save(client);
            } else {
                return client;
            }
        }
    }

    public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> sercli= metodosCrud.getCliente(client.getIdClient());
            if(!sercli.isEmpty()){
                if(client.getName()!=null){
                    sercli.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    sercli.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    sercli.get().setPassword(client.getPassword());
                }
                metodosCrud.save(sercli.get());
                return sercli.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
