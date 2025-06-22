package javaReflectionAPI;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> signatureList = SignatureCreator.createMethodSignatures(new File("src/javaReflectionAPI/inputNames.txt"));

        for(String s : signatureList){
            System.out.println(s);
        }
        SignatureCreator.storeMethodSignatures(SignatureCreator.createMethodSignatures(new File("src/javaReflectionAPI/inputNames.txt")));

    }
}
