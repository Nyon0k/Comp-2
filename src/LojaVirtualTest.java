import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class LojaVirtualTest {

    //private Livro livroBlau = new Livro(500, 20, "Publicacoes", 20, "livroBlau", "laura", 2010, 50);
    //private Livro livroClau = new Livro(500, 20, "Publicacoes", 30, "livroClau", "laura", 2015, 50);
    //private Roupa roupaBlau = new Roupa(3, 200, 40, "Vestuario", 50, 'm', "preta");
    private LojaVirtual lojinha = new LojaVirtual();


    @Before
    public void setup(){
        // Professor, eu tentei utilizar o setup mas quando eu colocava os testes pra rodar com os produtos sendo instanciados aqui dentro ele dava nullPointerException, entao acabei optando por nao respeitar o DRY.
    }

    @Test
    void getValorTotalRecebido() {
        Livro livroClau = new Livro(500, 20, "Publicacoes", 30, "livroClau", "laura", 2015, 50);
        Roupa roupaBlau = new Roupa(200, 40, "qualquer coisa", 50, 'm', "preta");
        lojinha.efetuarVenda(livroClau, 20);
        assertEquals(400, lojinha.getValorTotalRecebido(), 0);
    }

    @Test
    public void testGetTamanhoEstoque() {
        Livro livroClau = new Livro(500, 20, "Publicacoes", 30, "livroClau", "laura", 2015, 50);
        Roupa roupaBlau = new Roupa(200, 40, "qualquer coisa", 50, 'm', "preta");
        lojinha.incluirProdutoNoEstoque(roupaBlau, 30);
        assertEquals(30, lojinha.getTamanhoEstoque());
        assertEquals(50, lojinha.getTamanhoEstoque(roupaBlau));
        lojinha.incluirProdutoNoEstoque(livroClau, 70);
        assertEquals(100, lojinha.getTamanhoEstoque());
        assertEquals(30, lojinha.getTamanhoEstoque(livroClau));
    }

    @Test
    void testIncluirProdutoNoEstoque() {
        Roupa roupaBlau = new Roupa(200, 40, "qualquer coisa", 50, 'm', "preta");
        lojinha.incluirProdutoNoEstoque(roupaBlau, 20);
        assertEquals(50, lojinha.getTamanhoEstoque(roupaBlau));
    }

    @Test
    void testEfetuarVenda() {
        Livro livroClau = new Livro(500, 20, "Publicacoes", 50, "livroClau", "laura", 2015, 50);
        lojinha.efetuarVenda(livroClau, 30);
        assertEquals(20, lojinha.getTamanhoEstoque(livroClau));
    }
}