import java.lang.reflect.Array;
import java.util.ArrayList;

public class LojaVirtual {

    private int tamanhoEstoque;
    private float valorTotalRecebido;
    private String nome;

    private ArrayList<Produto> produtos;


    public LojaVirtual(){
        this.tamanhoEstoque = 0;
        this.valorTotalRecebido = 0;
        this.produtos = new ArrayList<Produto>();
    }

    public void setTamanhoEstoque(int tamanhoEstoque) {
        this.tamanhoEstoque = tamanhoEstoque;
    }

    public float getValorTotalRecebido() {
        return valorTotalRecebido;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getTamanhoEstoque(){
        return tamanhoEstoque;
    }

    public int getTamanhoEstoque(Produto produto){
        return produto.getQuantidadeEmEstoque();
    }

    public void incluirProdutoNoEstoque(Produto produto, int quantidade){
        produtos.add(produto);
        this.tamanhoEstoque += quantidade;
    }

    public String efetuarVenda(Produto produto, int quantidade){
        if(produto.quantidadeEmEstoque != 0) {
            if (quantidade <= getTamanhoEstoque(produto)) {
                float valor = produto.precoEmReais * quantidade;
                if(receberPagamento(valor) == true){
                    produto.quantidadeEmEstoque -= quantidade;
                    return "Recibo: Valor total: " + valor;
                }
            }
        }
        return "Nao foi possivel efetuar a venda!";
    }

    public float getTotalValorVendas(){
        return this.valorTotalRecebido;
    }

    private boolean receberPagamento(float valor){
        this.valorTotalRecebido += valor;
        return true;
    }
}
