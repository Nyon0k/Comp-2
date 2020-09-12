public class Fracao {

    private int numerador;
    private int denominador;
    private boolean sinalPositivo;
    private boolean nula;

    /**
     * Construtor.
     * O sinal da fração é passado no parâmetro específico.
     *
     * @param numerador O numerador (inteiro não-negativo)
     * @param denominador O denominador (inteiro positivo)
     * @param sinalPositivo se true, a fração será positiva; caso contrário, será negativa
     */
    public Fracao(int numerador, int denominador, boolean sinalPositivo) {
        this.numerador = numerador;
        this.denominador = denominador;
        if (numerador==0){
            this.nula = true;
            this.sinalPositivo = false;
        }else{
            this.nula = false;
            this.sinalPositivo = sinalPositivo;
        }
    }

    /**
     * @return um double com o valor numérico desta fração
     */
    public double getValorNumerico() {
        if(sinalPositivo==true){
            return (double)this.numerador/(double)this.denominador;
        }else{
            return (double)-this.numerador/(double)this.denominador;
        }
    }

    /**
     * Retorna uma fração que é equivalente a esta fração (this),
     * e que é irredutível (numerador e denominador primos entre si).
     * Em outras palavras, retorna a fração geratriz desta fração.
     *
     * @return uma fração irredutível equivalente a esta;
     *         no caso desta fração JÁ SER ela própria irredutível, retorna this
     */
    public Fracao getFracaoGeratriz() {
        int mdc = mdc(this.numerador, this.denominador);
        if(mdc==1){
            return this;
        }else {
            int numerador = this.numerador / mdc;
            int denominador = this.denominador / mdc;
            Fracao fracao = new Fracao(numerador, denominador, this.sinalPositivo);
            return fracao;
        }
    }

    public int mdc(int numerador, int denominador){
        if (denominador%numerador==0){
            return numerador;
        }else{
            int resto = denominador%numerador;
            return mdc(numerador, resto);
        }
    }

    public int getNumerador() {
        return this.numerador;
    }

    public int getDenominador() {
        return this.denominador;
    }

    public boolean isPositiva() {
        if(sinalPositivo==true){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fracao fracao = (Fracao) o;
        if(this.nula && fracao.nula) {
            return true;
        }
        return this.getFracaoGeratriz().getNumerador() == fracao.getFracaoGeratriz().getNumerador() &&
                this.getFracaoGeratriz().getDenominador() == fracao.getFracaoGeratriz().getDenominador() &&
                this.getFracaoGeratriz().sinalPositivo == fracao.getFracaoGeratriz().sinalPositivo;
    }
}
