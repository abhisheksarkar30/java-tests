package org.abhi.tools.overlapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class JavaObjectOverlapperApplication {

	public static void main(String[] args) throws IOException, IllegalAccessException {
		ObjectMapper mapper = new ObjectMapper();
		Class<UserDefinedBaseClass> classType = UserDefinedBaseClass.class;
//        System.out.println(mapper.writeValueAsString(new UserDefinedBaseClass("h1", 1, 2, true, false, new String[]{"h12", "h13"}, new UserDefinedChildClass(3.0, 4.0, 5.0f, 6.0f),null)));
		UserDefinedBaseClass h1 = mapper.readValue(classType.getResourceAsStream("/h1.json"), classType),
				h2 = mapper.readValue(classType.getResourceAsStream("/h2.json"), classType);
//        UserDefinedBaseClass h3 =
//        mapper.readerForUpdating(h1).readValue(classType.getResourceAsStream("/h2.json"), classType);
//        mapper.updateValue(h1, h2);

		JavaObjectOverlapper.overlap(h1, h2, 0);
		System.out.println(mapper.writeValueAsString(h2));
	}

}
