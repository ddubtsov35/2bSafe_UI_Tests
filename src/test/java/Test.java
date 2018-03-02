import File.FileNameClass;
import java.io.File;

/**
 * Created by user on 02.03.18.
 */
public class Test {

    @org.junit.Test
    public void test(){
        FileNameClass fileNameClass = new FileNameClass();
        File f = fileNameClass.getFile();
        System.out.println("File " + f.getName() + " exist?  " + f.exists());

    }

}
