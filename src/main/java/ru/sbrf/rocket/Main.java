package ru.sbrf.rocket;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.sbrf.rocket.rest.CoreJson;
import ru.sbrf.rocket.rest.JsonDiff;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws IOException, ParseException {


        JsonReader jr = new JsonReader();
        //String jsonString = "{\"CoreJson\":" + jr.readJson(System.getProperty("user.home") + "//downloads//diff_response.json") + "}";
        String jsonString = jr.readJson(System.getProperty("user.home") + "//downloads//diff_response.json");

        System.out.println(jsonString);


        //List<String>jsonList = JsonPath.read(jsonString,"$..jsonDiffPath");
        List<String>jsonList = JsonPath.read(jsonString,"$..[?(@.op)].jsonDiffPath");


        for (String i : jsonList) {

            System.out.println(i);
        }

        //System.out.println(jsonList.toString());













        System.out.println("\n");

        //JsonReaderAllDef jr2 = new JsonReaderAllDef();
        JsonReader jr2 = new JsonReader();
        //String jsonAllDefString = "{\"JIRA\":{\"bugs\":" + jr2.readJsonAllDef(System.getProperty("user.home") + "//downloads//list_response.json") + "}}";
        //String jsonAllDefString = jr2.readJsonAllDef(System.getProperty("user.home") + "//downloads//list_response.json");

        String jsonAllDefString = jr2.readJson(System.getProperty("user.home") + "//downloads//list_response.json");

        //System.out.println(jsonAllDefString);


        //List<String>jsonListAllDef = JsonPath.read(jsonAllDefString,"$..bugs[?(@.featureName=='CRM-90290')]");
        List<String>jsonListAllDef = JsonPath.read(jsonAllDefString,"$..[?(@.featureName=='CRM-90290')].firstCommitAuthor");


        System.out.println(jsonListAllDef);
        System.out.println(jsonListAllDef.isEmpty());


    }

}
