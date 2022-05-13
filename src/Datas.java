import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Datas {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//LocalDate, sintaxe mais simples
		LocalDate hoje = LocalDate.now();
        System.out.println(hoje);
        
        LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
        
        int anos = olimpiadasRio.getYear() - hoje.getYear();
        System.out.println(anos);
        
        //Period
        Period periodo = Period.between(hoje, olimpiadasRio);
        System.out.println(periodo);
        
        System.out.println(periodo.getYears());
        System.out.println(periodo.getMonths());
        System.out.println(periodo.getDays());
        
        //incremento de data
        System.out.println(hoje.minusYears(1));
        System.out.println(hoje.minusMonths(4));
        System.out.println(hoje.minusDays(2));

        System.out.println(hoje.plusYears(1));
        System.out.println(hoje.plusMonths(4));
        System.out.println(hoje.plusDays(2));
        
        //Period é imutável, para manipular o resultado de incremento deve-se retorná-lo para um LocalDate
        LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
        System.out.println(proximasOlimpiadas);

        
        //Formatação de datas
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        String valorFormatado = proximasOlimpiadas.format(formatador);
        System.out.println(valorFormatado);
        
        //Medida de tempo com LocalDateTime
        LocalDateTime agora = LocalDateTime.now();
        
        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        System.out.println(agora.format(formatadorComHoras));
        
        //Modelos de data específicos
        YearMonth anoEMes = YearMonth.of(2015, Month.JANUARY);
        //12 representa hora e 30 minutos
        LocalTime intervalo = LocalTime.of(12, 30);
        System.out.println(intervalo);
        
	}

}
