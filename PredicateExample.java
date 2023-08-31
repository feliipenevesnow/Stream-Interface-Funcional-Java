package functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Usado com filter para filtrar por alguma condição (Predicate)
public class PredicateExample {

    public static void main(String[] args) {

        List<String> palavras = Arrays.asList("java", "kotlin", "python", "javascript", "c", "go", "ruby");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        Predicate<String> maisDeCincoCaracteres = palavra -> palavra.length() > 5;

        Predicate<String> maisDeTresCaracteres = palavra -> palavra.length() > 3;

        List<String> maisDeTres = palavras.stream().filter(maisDeTresCaracteres).collect(Collectors.toList());

        maisDeTres.forEach(System.out::println);

        palavras.stream()
                .filter(maisDeCincoCaracteres)
                .forEach(System.out::println);

        Predicate<Integer> numerosParesPredicate = numero -> {
            return numero % 2 == 0;
        };

        List<Integer> numerosPares = nums.stream().filter(numerosParesPredicate).collect(Collectors.toList());

        numerosPares.forEach(System.out::println);

        //Impares
        nums.stream().filter(
                new Predicate<Integer>() {
            @Override
            public boolean test(Integer numero) {
                return numero % 2 != 0;
            }
        })
                .forEach(System.out::println);

    }
}
