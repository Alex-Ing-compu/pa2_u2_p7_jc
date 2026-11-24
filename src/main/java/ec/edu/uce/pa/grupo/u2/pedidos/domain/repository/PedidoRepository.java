package ec.edu.uce.pa.grupo.u2.pedidos.domain.repository;

import java.util.List;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;

public interface PedidoRepository {
    
    //cread
    public void crear(Pedido pedido);

    //read por id
    public Optional<Pedido> read(Integer id);

    public Optional<Pedido> readByNumber(String numero);

    public List<Pedido> readAll();


    //update
    public void update(Pedido pedido);

    //delete
    public void delete(Integer id);


}
