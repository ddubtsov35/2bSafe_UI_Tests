package File;

import java.io.File;

/**
 * Created by user on 02.03.18.
 */
public class FileNameClass {

        public File getFile(){
            //src/main/resources/photo.jpg
            //src/main/resources/target/2bSafe_TargetProject-1.0-SNAPSHOT.jar
            File f = new File("src/main/resources/target/2bSafe_TargetProject-1.0-SNAPSHOT.jar");
            return f;
        }

}
