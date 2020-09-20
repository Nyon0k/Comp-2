public class Album {

    public static final float PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR = 0.9f;  // 90%

    private int totalFigurinhas;
    private int quantFigurinhasPorPacotinho;
    private int figurinhasRepetidas;
    private int figurinhasColadas;
    private int quantPacotesRecebidos;
    private Figurinha figurinhas[] = new Figurinha[200];
    private boolean arrayFigRepetidas[] = new boolean[200];


    public Album(int totalFigurinhas, int quantFigurinhasPorPacotinho) {
        this.totalFigurinhas = totalFigurinhas;
        this.quantFigurinhasPorPacotinho = quantFigurinhasPorPacotinho;
    }

    public void receberNovoPacotinho(Figurinha[] pacotinho) {
        for (int i = 0; i < pacotinho.length; i++) {
            Figurinha figurinha = pacotinho[i];
            if (possuiFigurinhaColada(figurinha.getPosicao())) {
                this.figurinhasRepetidas += 1;
                arrayFigRepetidas[figurinha.getPosicao()-1] = true;
            } else {
                this.figurinhas[figurinha.getPosicao()-1] = figurinha;
                this.figurinhasColadas += 1;
            }
        }
        // equivalentemente, usar um "for each"
        this.quantPacotesRecebidos += 1;
    }

    public int getTotalPacotinhosRecebidos() {
        return this.quantPacotesRecebidos;
    }

    /**
     * Termina de preencher o álbum, desde que ele já esteja preenchido além de certa fração
     * mínima definida em Album.PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR.
     *
     * Se o álbum não estiver ainda completo o suficiente para isso, este método simplesmente
     * não faz nada.
     */
    public void encomendarFigurinhasRestantes() {
        if(this.figurinhasColadas >= PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR * this.totalFigurinhas){
            for (int i = 0; i<200; i++) {
                this.figurinhas[i] = new Figurinha(i, String.format("http://urlFakeDaFigurinha%d.jpg", i));
            }
            this.figurinhasColadas = 200;
        }
    }

    public boolean possuiFigurinhaColada(int posicao) {
        return this.figurinhas[posicao-1] != null;
    }

    public boolean possuiFigurinhaColada(Figurinha figurinha) {  // overload
        return possuiFigurinhaColada(figurinha.getPosicao());
    }

    public boolean possuiFigurinhaRepetida(int posicao) {
        return this.arrayFigRepetidas[posicao-1];
    }

    public boolean possuiFigurinhaRepetida(Figurinha figurinha) {
        // overload
        return possuiFigurinhaRepetida(figurinha.getPosicao());
    }

    public int getQuantFigurinhasColadas() {
        return this.figurinhasColadas;
    }

    public int getQuantFigurinhasRepetidas() {
        return this.figurinhasRepetidas;
    }

    public int getQuantFigurinhasFaltando() {
        int quantFigurinhasFaltando = 200 - getQuantFigurinhasColadas();
        return quantFigurinhasFaltando;
    }

}
