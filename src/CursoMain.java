import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CursoMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		//comparação por quantidade de alunos
		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		//Streams
		//Stream<Curso> streamDeCurso = cursos.stream();
		
		//Stream de cursos para encontrar cursos com mais de 100 alunos 
		// usando um predicado de comparação com Lambda
		Stream<Curso> streamDeCurso = cursos.stream().filter(c -> c.getAlunos() > 100);
		streamDeCurso.forEach(c -> System.out.println(c.getNome()));

		//poderia ser mais simples
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .forEach(c -> System.out.println(c.getNome()));
		
		// Map para capturar um novo Stream de cursos com quantidade acima de 100 alunos
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .map(Curso::getAlunos)
		   .forEach(System.out::println);
		
		
		/*
		 * Quando fizemos o map(Curso::getAlunos), recebemos de volta um Stream<Integer>,
		 *  que acaba fazendo o autoboxing dos ints. Isto é, utilizará mais recursos da JVM.
		 *  Claro que, se sua coleção é pequena, o impacto será irrisório. 
		 *  Mas é possível trabalhar só com ints, invocando o método mapToInt*/
		IntStream stream = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso::getAlunos);
		
		int soma = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso::getAlunos)
				   .sum();
	}

}
