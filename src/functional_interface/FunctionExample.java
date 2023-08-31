package functional_interface;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


//Pode transformar Elementos por uma função definida.
public class FunctionExample {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        Function<Integer, String> transformarEmString = numero -> "Número" + numero;

        List<String> numerosTexto = numeros.stream()
                .map(transformarEmString)
                .collect(Collectors.toList());

        List<String> numerosTexto2 = numeros.stream().map(
                new Function<Integer, String>() {
            @Override
            public String apply(Integer numero) {
                return "Número " + numero;
            }
        }
        ).collect(Collectors.toList());

        List<String> numerosTexto3 = numeros.stream().map(numero -> "Número " + numero).collect(Collectors.toList());

        numerosTexto.forEach(System.out::println);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        Function<Integer, Integer> quadradoLambida = numero -> {
            if(numero % 2 == 0){
                numero = numero * numero;
            }
            return numero;
        };
        
        List<Integer> numerosAoQuadrado = nums
                .stream()
                .map(quadradoLambida)
                .collect(Collectors
                        .toList()); 
        
        numerosAoQuadrado.forEach(System.out::println);
        
         List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 5);
         
         List<Integer> numerosAoQuadrado2 = nums.stream().map(n -> n * n).collect(Collectors.toList());
         
         numerosAoQuadrado2.forEach(System.out::println);
}
}
