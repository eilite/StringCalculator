import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Arrays;

public class StringCalculator {

	public int add(String numbers){
//		if(numbers.length()==1) return Integer.parseInt(numbers.substring(0, 1));
//		if(numbers.length()>0){
//			return add(numbers.substring(0,numbers.length()/2))+add(numbers.substring(numbers.length()/2,numbers.length()));
//		}
		
		if(numbers.length()>0){
			Optional<String> delimiter = Optional.empty();
			if(numbers.startsWith("//")){
				String[] splittedNumbers = numbers.split("\n",2);
				numbers = splittedNumbers[1];
				delimiter = Optional.of(splittedNumbers[0].substring(splittedNumbers[0].length()-1));
			}
			List<String> nmbs = Arrays.asList(numbers.split(",|\n|"+delimiter.orElse(null)));
			List<Integer> negativeNumbers = new ArrayList<>();
			List<Integer> parsedNumbers = nmbs.stream().map( number -> {
				Integer res = Integer.parseInt(number);
				if(res<0){
					negativeNumbers.add(res);
					return 0;
				}
				return res;
			}).collect(Collectors.toList());
			if(! negativeNumbers.isEmpty()) throw new IllegalArgumentException(negativeNumbers.toString());
			return parsedNumbers.stream().mapToInt(i-> i.intValue()).sum();
		}
		return 0;
	}
	
	
}
