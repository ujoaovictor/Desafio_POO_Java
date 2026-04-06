//OBS: Código feito no site onlineGDB


public class Main {
    public static void main(String[] args) {

        
        Cliente cliente = new Cliente("Joao Victor", 01);
        
        Pedido p1 = new Pedido("Pizza Grande", 40.00, 1);
        Pedido p2 = new Pedido("Refrigerante 2L ", 10.00, 2);
        Pedido p3 = new Pedido("Sobremesa", 18.00, 1);

        
        ContaRestaurante conta = new ContaRestaurante(cliente, p1, p2, p3);

        
        conta.mostrarConta();
    }
}