package ec.edu.uce.pa.grupo.u2;

import java.time.LocalDateTime;
import java.util.Optional;

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

       Pedido p1 = new Pedido();
       p1.setFecha(LocalDateTime.now());
       p1.setNumero("10ab");
       p1.setPrecio(10.0);
       p1.setProducto("carro");

       //this.pedidoService.guaradar(p1);



        Optional<Pedido> pedido1 = this.pedidoService.buscarPorId(100);

        if (pedido1.isPresent()) {
            System.out.println("Pedido encontrado " + pedido1.getClass());
        }else{
            System.out.println("Pedido no encontrado");
        }

        //read by number 
        
        Optional<Pedido> pedidoByNumber = this.pedidoService.buscarPorNumero("10ab");
        if (pedidoByNumber.isPresent()) {
            System.out.println("Pedido encontrado por numero" + pedidoByNumber.get());
        }else{
            System.out.println("Pedido no encontrado");
        }
        

       return 0;
    }

}
