package ec.edu.uce.pa.grupo.u2.pedidos.domain.repository;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;

public interface PedidoRepository {
    
    //cread
    public void crear(Pedido pedido);

    //read por id
    public Pedido read(Integer id);

    //update
    public void update(Pedido pedido);

    //delete
    public void delete(Integer id);


}
