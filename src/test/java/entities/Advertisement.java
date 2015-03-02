package entities;

import utils.PropertyLoader;

import java.io.File;

/**
 * Created by c2614 on 02.03.2015.
 */
public class Advertisement {
    public String title;
    public String rubric;
    public String desrcr;
    public String photoUrl = new File(PropertyLoader.loadProperty("project.path")+"src/test/resourses/testData.file").getAbsolutePath();

    public Advertisement(boolean correct){

    }


}

