package ec.edu.uce.pa.grupo.u2;

import java.time.LocalDateTime;

import ec.edu.uce.pa.grupo.u2.pedidos.aplication.PedidoService;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain 
public class Main implements QuarkusApplication{

    @Inject 
    private PedidoService pedidoService;    


    public static void main(String[] args){
        Quarkus.run(Main.class,args);
    }


    @Override
    public int run(String... args) throws Exception {

        System.out.println("Hello Quarkus! ");

        //create (insert)
        
        Pedido p1 = new Pedido();
        p1.setProducto("Producto de prueba 2");
        p1.setPrecio(1.1);
        p1.setFecha(LocalDateTime.now());

        this.pedidoService.guaradar(p1);
        

        //read (buscar pedido por id)
        Pedido pedido1 = this.pedidoService.buscarPorId(2);
        System.out.println("Pedido encontrado: " + pedido1);

        //update (actulizar)
        pedido1.setPrecio(200.0);
        this.pedidoService.actualizar(pedido1);

        Pedido pedido2 = this.pedidoService.buscarPorId(2);
        System.out.println("Pedido actualizado: " + pedido2);

        //deleted (eliminar)
        this.pedidoService.eliminar(2);





       return 0;
    }

}
