import java.util.ArrayList;
import java.util.HashMap;

public class Tuite<T> {

    private final Usuario autor;
    private final String texto;

    private Object anexo;
    protected ArrayList<String> hashtags = new ArrayList<>();

    public Tuite(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
        String[] palavras = this.texto.split("[\\s,!]");
        for (String palavra : palavras) {
            if (palavra.startsWith("#")) {
                this.hashtags.add(palavra);
            }
        }
    }

    public void anexarAlgo(Object anexo) {
        this.anexo = anexo;
    }

    public Object getAnexo() {
        return this.anexo;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public String getTexto() {
        return this.texto;
    }

    public ArrayList<String> getHashtags() {
        return this.hashtags;
    }
}
