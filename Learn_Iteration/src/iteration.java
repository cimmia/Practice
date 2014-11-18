import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//This program is to test the new iteration in java8
//You need to create "data.txt" by yourself
public class iteration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner in = new Scanner(new File("data.txt"));
			ArrayList<String> arr = new ArrayList<>();
			// Read the file,store it in the arr,then output
			// before Java 5
			read_and_write1(in, arr);
			// in Java 5
			read_and_write2(in, arr);
			// in Java 8
			read_and_write3(in, arr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Read and wirte object into arraylist in and before Java 5
	public static void read_and_write1(Scanner in, ArrayList<String> arr) {
		System.out.println("before Java 5");
		while (in.hasNext()) {
			String weather_day = in.nextLine();
			arr.add(weather_day);
		}
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

	// Read and wirte object into arraylist in Java 5
	public static void read_and_write2(Scanner in, ArrayList<String> arr) {
		System.out.println("in Java 5");
		while (in.hasNext()) {
			String weather_day = in.nextLine();
			arr.add(weather_day);
		}
		for (String s : arr) {
			System.out.println(s);
		}
	}

	// Read and wirte object into arraylist in Java 8
	public static void read_and_write3(Scanner in, ArrayList<String> arr) {
		System.out.println("in Java 8");
		in.forEachRemaining(line -> arr.add(line));
		arr.forEach(name -> System.out.println(name));
	}
}
