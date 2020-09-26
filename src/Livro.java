public class Livro extends Produto{

    private final String titulo;
    private final String autor;
    private final int anoDePublicacao;
    private final int numeroDePaginas;



    public Livro(int pesoEmGramas, float precoEmReais, String categoria, int quantidadeEmEstoque, String titulo, String autor, int anoDePublicacao, int numeroDePaginas){
        super(pesoEmGramas, precoEmReais, categoria, quantidadeEmEstoque);
        this.categoria = "Publicacoes";
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getAnoDePublicacao() {
        return this.anoDePublicacao;
    }

    public int getNumeroDePaginas() {
        return this.numeroDePaginas;
    }

    @Override
    public String toString() {
        return super.toString() +  ", Titulo: " + this.titulo + ", Autor: " + this.autor + ", Ano de publicacao: " + this.anoDePublicacao + ", Numero de paginas: " + this.numeroDePaginas + "]";
    }
}
