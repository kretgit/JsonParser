package ru.sbrf.rocket;

import java.io.*;

public class JsonReader {

    String line2 = "";

    public String readJson (String jsonFile) throws FileNotFoundException, IOException {

        File file = new File(jsonFile);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis,"UTF8");
        BufferedReader br = new BufferedReader(isr);

        String line;
        while((line = br.readLine()) != null){
            //System.out.println(line);
            line2 +=line;
        }
        br.close();

        return line2;

    }

}
