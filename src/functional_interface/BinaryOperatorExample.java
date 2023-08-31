package functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

//pares de elementos, como somar números ou combinar objetos.
public class BinaryOperatorExample {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 1, 1);

        BinaryOperator<Integer> somar = Integer::sum;

        int resultado = numeros.stream()
                .reduce(0, Integer::sum);

        System.out.println("A soma dos números é: " + resultado);

        BinaryOperator<Integer> somar2 = (numero1, numero2) -> numero1 + numero2;

        int resultado1 = numeros.stream().reduce(0, somar2);

        int resultado2 = numeros.stream().reduce(1, (n1, n2) -> n1 * n2);

        int resultado3 = numeros.stream().reduce(1,
                new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer n1, Integer n2) {
                return n1 * n2;
            }
        });
        
        System.out.println("3: " + resultado3);

    }
}
