package ClassLoaderTest.Hotdeploy;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by 殷鑫 on 2017/6/11.
 */
public class MyClassLoader extends ClassLoader {

    private static final String BASE_DIR = "E:/Git/JAVA/Java/out/production/Java/";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = name.replaceAll("\\.", "/");
        fileName = BASE_DIR + fileName + ".class";
        System.out.println(fileName);
        try {
            byte[] bytes = FileUtils.readFileToByteArray(new File(fileName));
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException ex) {
            throw new ClassNotFoundException("failed to load class " + name, ex);
        }
    }
}