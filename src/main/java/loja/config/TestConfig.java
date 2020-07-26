package loja.config;

import loja.api.dto.Item;
import loja.api.model.entity.*;
import loja.api.model.enums.StatusCompra;
import loja.api.model.enums.TipoCategoria;
import loja.api.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {



    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemCompraRepository itemCompraRepository;


    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Electronics" , TipoCategoria.PERIFERICO);
        Categoria cat2 = new Categoria(null, "Electronics" , TipoCategoria.PERIFERICO);
        Categoria cat3 = new Categoria(null, "Electronics" , TipoCategoria.PERIFERICO);


        Produto p1 = new Produto(null, "The Lords of the Rings", "Lorem ispsum doar amet, consectetur.", 4,90.5);
        Produto p2 = new Produto(null, "The Lords of the Rings", "Lorem ispsum doar amet, consectetur.", 4,90.5);
        Produto p3 = new Produto(null, "The Lords of the Rings", "Lorem ispsum doar amet, consectetur.", 4,90.5);
        Produto p4 = new Produto(null, "The Lords of the Rings", "Lorem ispsum doar amet, consectetur.", 4,90.5);
        Produto p5 = new Produto(null, "The Lords of the Rings", "Lorem ispsum doar amet, consectetur.", 4,90.5);

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.setCategoria(cat2);
        p2.setCategoria(cat1);
        p2.setCategoria(cat3);
        p3.setCategoria(cat3);
        p4.setCategoria(cat3);
        p5.setCategoria(cat2);

        produtoRepository.saveAll((Arrays.asList(p1, p2, p3, p4, p5)));
/*
        Cliente u1 = new Cliente(null, "Maria Brown","rua a", "maria@gmail.com", "123456","F", "22.554.784.24","www",true);
       // Entregador u2 = new Entregador(null, "Maria Brown","rua a", "maria@gmail.com", "123456","F",true);
        Administrador u3 = new Administrador(null, "Maria Brown","rua a", "maria@gmail.com", "123456","F", "");




        clienteRepository.saveAll(Arrays.asList(u1));
        entregadorRepository.saveAll(Arrays.asList(u2));
        administradorRepository.saveAll(Arrays.asList(u3));

        Item item1 = new Item();
        item1.setPreco(145.0);
        item1.setQuantidade(3);
        item1.setIdProduto(p1.getIdProduto());

        Item item2 = new Item();
        item2.setPreco(145.0);
        item2.setQuantidade(3);
        item2.setIdProduto(p1.getIdProduto());

        Item item3 = new Item();
        item3.setPreco(145.0);
        item3.setQuantidade(3);
        item3.setIdProduto(p1.getIdProduto());

        List<Item> itens1 = new ArrayList<Item>();
        itens1.addAll(Arrays.asList(item1, item2, item3));

        List<Item> itens2 = new ArrayList<Item>();
        itens1.addAll(Arrays.asList(item3));

        List<Item> itens3 = new ArrayList<Item>();
        itens1.addAll(Arrays.asList(item1, item3));

        //Compra o1 = new Compra(null, StatusCompra.ESPERANDO,itens1 );
        //Compra o2 = new Compra(null, StatusCompra.ESPERANDO,itens2 );
        //Compra o3 = new Compra(null, StatusCompra.ESPERANDO,itens3 );
/*
        compraRepository.saveAll(Arrays.asList(o1, o2, o3));


        ItemCompra oi1 = new ItemCompra(o1, p1, 2, p1.getPreco());
        ItemCompra oi2 = new ItemCompra(o1, p3, 1, p3.getPreco());
        ItemCompra oi3 = new ItemCompra(o2, p3, 2, p3.getPreco());
        ItemCompra oi4 = new ItemCompra(o3, p5, 2, p5.getPreco());

        itemCompraRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

        Pagamento pagamento = new Pagamento(null, o1);
        o1.setPagamento(pagamento);
        compraRepository.save(o1);
  */
    }

}