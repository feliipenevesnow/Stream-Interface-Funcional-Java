package functional_interface;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Pode aumentar os elementos
public class SupplierExample {

    public static void main(String[] args) {

        Supplier<String> saudacao = () -> "Olá, seja bem-vindo(a)!";

        List<String> listaSaudacoes = Stream.generate(saudacao)
                .limit(5)
                .collect(Collectors.toList());

        List<String> listaSaudacoes2 = Stream.generate(
                new Supplier<String>() {

            @Override
            public String get() {
                return "Olá, seja bem-vindo(a)!";

            }
        })
                .limit(5)
                .collect(Collectors.toList());

        List<String> listaSaudacoes3 = Stream.generate(() -> "Olá, seja bem-vindo(a)!")
                .limit(5)
                .collect(Collectors.toList());

        listaSaudacoes.forEach(System.out::println);
    }
}
