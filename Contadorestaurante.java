class ContaRestaurante {

    Cliente cliente;
    Pedido pedido1;
    Pedido pedido2;
    Pedido pedido3;

       
    public ContaRestaurante(Cliente cliente, Pedido p1, Pedido p2, Pedido p3) {
        this.cliente = cliente;
        this.pedido1 = p1;
        this.pedido2 = p2;
        this.pedido3 = p3;
    }


    public double calcularSubtotal() {
        return pedido1.calcularTotalItem() +
               pedido2.calcularTotalItem() +
               pedido3.calcularTotalItem();
    }

  
    public double calcularTaxaServico() {
        double subtotal = calcularSubtotal();

        if (subtotal > 100) {
            return subtotal * 0.10;
        } else {
            return subtotal * 0.05;
        }
    }

  
    public double calcularDesconto() {

        String primeiroNome = cliente.getPrimeiroNome();

        char primeiraLetra = Character.toUpperCase(primeiroNome.charAt(0));

        if (primeiraLetra == 'J') {
            return 15;
        } else {
            return 0;
        }
    }

 
    public double calcularValorFinal() {
        return calcularSubtotal() +
               calcularTaxaServico() -
               calcularDesconto();
    }

    
    public void mostrarConta() {

        System.out.println("---------- CONTA DO RESTAURANTE ---------- \n");

        System.out.println("Cliente: " + cliente.nomeMaiusculo());
        System.out.println("Primeiro nome: " + cliente.getPrimeiroNome());
        System.out.println("Mesa: " + cliente.mesa);

        System.out.println("\nPedidos:");

        Pedido[] pedidos = {pedido1, pedido2, pedido3};

        for (int i = 0; i < pedidos.length; i++) {

            System.out.println(
                (i + 1) + " - " +
                pedidos[i].descricao +
                " | Qtd: " + pedidos[i].quantidade +
                " | Total: R$ " +
                String.format("%.2f", pedidos[i].calcularTotalItem())
            );
        }

        System.out.println("\nSubtotal: R$ " +
                String.format("%.2f", calcularSubtotal()));

        System.out.println("Taxa de serviÃ§o: R$ " +
                String.format("%.2f", calcularTaxaServico()));

        System.out.println("Desconto: R$ " +
                String.format("%.2f", calcularDesconto()));

        System.out.println("Valor final: R$ " +
                String.format("%.2f", calcularValorFinal()));
    }
}
