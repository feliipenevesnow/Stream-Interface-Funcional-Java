package functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//Consome, não retorna resultado
public class ConsumerExample {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        // 1° Maneira definindo consumer com lambida antes do stream
        Consumer<Integer> imprimirNumeroPar = numero -> {
            if (numero % 2 == 0) {
                System.out.println(numero);
            }
        };

        numeros.stream().forEach(imprimirNumeroPar);
        
        //2° Maneira implementando
        numeros.stream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer numero) {
                if (numero % 2 == 0) {
                    System.out.println(numero);
                }
            }
        });
        
        //3° Maneira Lambida
        numeros.stream().forEach(numero -> {
            if (numero % 2 == 0) {
                System.out.println(numero);
            }
        });
        
        // 4° Maneira Filter
        numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}
