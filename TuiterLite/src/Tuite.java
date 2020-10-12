import java.util.ArrayList;
import java.util.HashSet;

public class Tuite<T> {

    private final Usuario autor;
    private final String texto;

    private HashSet<String> hashtags;

    private T anexo;

    public Tuite(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
        this.hashtags = new HashSet<String>();
        extrairHashtags();
    }

    public void anexarAlgo(T anexo) {
        this.anexo = anexo;
    }

    public Object getAnexo() {
        return anexo;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public String getTexto() {
        return this.texto;
    }

    public HashSet<String> getHashtags() {
        return hashtags;
    }

    private void extrairHashtags() {
        String[] hash = this.texto.split("[\\s,]");
        for (String h : hash) {
            if (h.startsWith("#")) {
                this.hashtags.add(h);
            }
        }
    }
}
