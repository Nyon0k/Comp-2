import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Usuario {

    public static final int MIN_TUITES_SENIOR = 200;
    public static final int MIN_TUITES_NINJA = 1000;

    private ArrayList<Tuite> tuitesUsuario = new ArrayList();
    private int quantTuites;

    private final String email;
    private String nome;
    private Image foto;

    // Pode ser INICIANTE, SENIOR ou NINJA
    private NivelUsuario nivel;

    public Usuario(String nome, String email) {
        this.email = email;
        this.nome = nome;
        this.nivel = NivelUsuario.INICIANTE;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getFoto() {
        return this.foto;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return this.nome;
    }

    public NivelUsuario getNivel() {
        return nivel;
    }

    public Tuite tuitesUsuario(Tuite tuite){
        this.quantTuites += 1;
        trocarNivelUsuario();
        tuitesUsuario.add(tuite);
        return tuite;
    }

    public void trocarNivelUsuario(){
        if(quantTuites>=MIN_TUITES_SENIOR && quantTuites<MIN_TUITES_NINJA){
            this.nivel = NivelUsuario.SENIOR;
        }
        if(quantTuites>=MIN_TUITES_NINJA){
            this.nivel = NivelUsuario.NINJA;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email);
    }
}
