import Exceptions.ArquivoCorrompidoException;

import java.io.*;
import java.util.*;

public class Principal {

    public static void calcularMedia (File aqv) throws IOException, ArquivoCorrompidoException {
        HashSet<Float> lista = new HashSet<>();
        Float soma = 0f;
        float numero = 0f;
        int contadorLinhas = 0;
        int contadorLinhasInvalidas = 0;

        BufferedReader in = new BufferedReader(new FileReader(aqv));
        String linha;
        while ((linha = in.readLine()) != null) {
            try {
                numero = Float.parseFloat(linha);
                soma += Float.parseFloat(linha);
                lista.add(numero);
                contadorLinhas++;
            } catch (NumberFormatException e1) {
                contadorLinhasInvalidas++;
            }
        }
        if (contadorLinhas < contadorLinhasInvalidas) throw new ArquivoCorrompidoException();
        float media = soma / lista.size();
        System.out.println("Notas (Sem ordenacao):");
        System.out.println(lista);
        System.out.println("Media:");
        System.out.println(media);
    }

    private static File setArquivo() {
        System.out.println("Informe o nome do arquivo: ");
        Scanner sc = new Scanner(System.in);
        File aqv = new File(sc.nextLine());

        try {
            calcularMedia(aqv);
        } catch (IOException e) {
            System.out.println("---Arquivo nao encontrado!---");
            setArquivo();
        } catch (ArquivoCorrompidoException e) {
            System.out.println("---Arquivo corrompido!---");
            setArquivo();
        }

        return aqv;
    }

    public static void main(String[] args) {

        /* ATENÇÃO:  Este main() serve apenas para ilustrar o uso do Scanner apontando para
                     um arquivo de entrada. Ele não é o main() que vc precisa escrever
                     para resolver o exercíciodo LAB 8 descrito em LAB8.txt */


        setArquivo();
    }
}
