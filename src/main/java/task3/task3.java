package task3;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class task3 {

    public static void main(String[] args) {


        String valuesPath = args[0];
        String testsPath = args[1];
        String reportPath = args[2];

        try {
            JSONParser parser = new JSONParser();

            Object valuesObj = parser.parse(new FileReader(valuesPath));
            JSONArray values = new JSONArray();
            values.add(valuesObj);
            //org.json.JSONArray values = (org.json.JSONArray) parser.parse(new FileReader(valuesPath));
            JSONObject tests = (JSONObject) parser.parse(new FileReader(testsPath));

            fillReport(tests, values);

            FileWriter fileWriter = new FileWriter(reportPath);
            fileWriter.write(tests.toJSONString());
            fileWriter.close();

            System.out.println("Report generated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void fillReport(JSONObject tests, JSONArray values) {
        for (Object key : tests.keySet()) {
            Object value = tests.get(key);

            if (value instanceof JSONObject) {
                fillReport((JSONObject) value, values);
            } else if (value instanceof JSONArray) {
                for (Object obj : (JSONArray) value) {
                    fillReport((JSONObject) obj, values);
                }
            } else if (value instanceof String && "id".equals(key)) {
                String id = (String) value;
                for (Object obj : values) {
                    JSONObject val = (JSONObject) obj;
                    if (id.equals(val.get("id"))) {
                        tests.put("value", val.get("value"));
                        break;
                    }
                }
            }
        }
    }
}
