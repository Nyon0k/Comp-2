public class Produto {

    protected final long id;
    protected static long nextSeqNum = 1;
    protected int pesoEmGramas;
    protected float precoEmReais;
    protected String categoria;
    protected int quantidadeEmEstoque;



    public Produto(int pesoEmGramas, float precoEmReais, String categoria, int quantidadeEmEstoque){
        this.id = nextSeqNum++;
        this.pesoEmGramas = pesoEmGramas;
        this.precoEmReais = precoEmReais;
        this.categoria = categoria;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public long getId() {
        return id;
    }

    public static long getNextSeqNum() {
        return nextSeqNum;
    }

    public int getPesoEmGramas() {
        return pesoEmGramas;
    }

    public void setPesoEmGramas(int pesoEmGramas) {
        this.pesoEmGramas = pesoEmGramas;
    }

    public float getPrecoEmReais() {
        return precoEmReais;
    }

    public void setPrecoEmReais(float precoEmReais) {
        this.precoEmReais = precoEmReais;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return "[" + "Id: " + this.id + ", Peso em gramas: " + this.pesoEmGramas + ", Categoria: " + this.categoria + ", Quantidade em Estoque: " + this.quantidadeEmEstoque;
    }
}
