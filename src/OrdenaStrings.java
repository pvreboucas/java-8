import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.*;

public class OrdenaStrings {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		//lambdas sem method reference
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		Function<String, Integer> funcao1 = s -> s.length();
		
		palavras.forEach(s -> System.out.println(s));
		
		
		
		//lambdas com method reference
		palavras.sort(Comparator.comparing(String::length));
		
		//import static do Comparator permite chamar diretamente o método comparing
		palavras.sort(comparing(String::length));
		
		Function<String, Integer> funcao2 = String::length;
		
		palavras.forEach(System.out::println);
		
	}

}
