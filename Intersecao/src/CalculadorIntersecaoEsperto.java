import java.util.*;

public class CalculadorIntersecaoEsperto extends CalculadorIntersecao<Integer> {

    @Override
    public int getQuantidadeElementosEmComum(List<Integer> lista1, List<Integer> lista2) {

        HashMap<Integer, Integer> l12 = new HashMap<>();
        HashSet<Integer> l1 = new HashSet<>(lista1);
        HashSet<Integer> inter = new HashSet<>();

        for (int numero : lista2){
            if(l1.contains(numero)) {
                inter.add(numero);
            }
        }

        return inter.size();
    }
}
