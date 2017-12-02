package ch14_Serialization;

import java.io.FileWriter;
import java.io.IOException;

public class WriteAFile {
	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("Foo.txt");
			writer.write("hello! my dog is so beautiful");
			writer.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
