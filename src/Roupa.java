public class Roupa extends Produto{

    public final char tamanho;
    public String cor;



    public Roupa(int pesoEmGramas, float precoEmReais, String categoria, int quantidadeEmEstoque, char tamanho, String cor){
        super(pesoEmGramas, precoEmReais, categoria, quantidadeEmEstoque);
        this.categoria = "Vestuario";
        this.tamanho = tamanho;
        this.cor = cor;
    }

    public char getTamanho() {
        return this.tamanho;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tamanho: " + this.tamanho + ", Cor: " + this.cor + "]";
    }
}
