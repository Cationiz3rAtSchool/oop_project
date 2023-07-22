package GUI;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import GUI.Characters;
import history.entity.Character;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.Field;

public class Readjson {
	static String src="src/main/java/oop.json";
    static Path path= Paths.get(src);
    static String x = path.toString();
	private static Characters[] customers;
	public static void main(String[] args) throws IOException {
          loadDatajson(x);

	}
	public static Characters[] loadDatajson(String filename) {
	    try (FileReader reader = new FileReader(filename)) {
	        Gson gson = new GsonBuilder().create();
	        
	        Characters[] customers = gson.fromJson(reader, Characters[].class);
	        
	    } catch (NullPointerException | IOException | JsonIOException | JsonSyntaxException e) {
	        ((Throwable) e).printStackTrace();
	        // handle exception
	    }
	    return customers;
	}


}
