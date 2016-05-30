import java.util.List;
import java.util.Optional;
import java.util.Arrays;

public class StringCalculator {

	public int add(String numbers){
//		if(numbers.length()==1) return Integer.parseInt(numbers.substring(0, 1));
//		if(numbers.length()>0){
//			return add(numbers.substring(0,numbers.length()/2))+add(numbers.substring(numbers.length()/2,numbers.length()));
//		}
		Optional<String> delimiter = Optional.empty();
		if(numbers.startsWith("//")){
			String[] splittedNumbers = numbers.split("\n",2);
			numbers = splittedNumbers[1];
			delimiter = Optional.of(splittedNumbers[0].substring(splittedNumbers[0].length()-1));
		}
		if(numbers.length()>0){
			List<String> nmbs = Arrays.asList(numbers.split(",|\n|"+delimiter.orElse(null)));
			
			return nmbs.stream().map((number)-> 
				Integer.parseInt(number)
			).mapToInt(i -> i.intValue()).sum();
		}
		return 0;
	}
	
	
}
