package may17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class unique {
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> uniqueMap = new ConcurrentHashMap<>();
		return t -> uniqueMap.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// creating customer objects with repeated id's 100, 101
		Student1 customer1 = new Student1(100, "Jhon");
		Student1 customer2 = new Student1(101, "Peter");
		Student1 customer3 = new Student1(100, "Paul");
		Student1 customer4 = new Student1(102, "Noel");
		Student1 customer5 = new Student1(101, "Nup");
		Student1 customer6 = new Student1(101, "Nup");

		// created a list to store the customer objects
		List<Student1> customers = Arrays.asList(customer1, customer2, customer3, customer4, customer5, customer6);



		List<Student1> distinctElements = customers.stream().filter(distinctByKey(cust -> cust.getId()))
				.collect(Collectors.toList());
		System.out.println(distinctElements);

		
	}

}
