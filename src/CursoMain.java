import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CursoMain {

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		//retorna qualquer curso com mais de 100 alunos para um Optional, pois talvez o retorno seja nulo
		Optional<Curso> optional = cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .findAny();
		
		//retorna o objeto encontrado
		Curso curso1 = optional.get();
		
		//retorna o objeto se existir ou outro retorno
		Curso curso2 = optional.orElse(null);
		
		//chama o lambda se o objeto curso estiver presente
		optional.ifPresent(c -> System.out.println(c.getNome()));
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .findAny()
		   .ifPresent(c -> System.out.println(c.getNome()));
		
		
		//Gerando uma coleção a partir de um Stream
		
		List<Curso> resultados = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .collect(Collectors.toList());
		
		/**
		 * Queremos um mapa que, dado o nome do curso, o valor atrelado é a quantidade alunos.
		 * Um Map<String, Integer>. Utilizamos o Collectors.toMap. Ele recebe duas Functions. 
		 * A primeira indica o que vai ser a chave, e a segunda o que será o valor
		 */
		Map mapa = cursos 
				.stream() 
				.filter(c -> c.getAlunos() > 100) 
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
	}

}
