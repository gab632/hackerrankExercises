package solved.javaReflectionAPI;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignatureCreator {

    public static List<String> createMethodSignatures(File textFile) throws IOException {
        List<String> methodSignatures = new ArrayList<>();

        Path path = Paths.get("src/solved.javaReflectionAPI/inputNames.txt");
        try(BufferedReader reader = Files.newBufferedReader(path)){
            String methodName;

            while((methodName = reader.readLine()) != null){
                String signature = String.format("public void %s(){\n}\n", methodName);
                methodSignatures.add(signature);
            }

        } catch (IOException e){
            System.out.println(e.getStackTrace());
        }
        return methodSignatures;
    }

    public static void storeMethodSignatures(List<String> signatures) throws IOException {

//        File outputFile = new File("src/solved.javaReflectionAPI/output.txt");
        Files.write(Path.of("src/solved.javaReflectionAPI/output.txt"), signatures);

    }
}
