package chapter2;

import java.util.Properties;

public class CollectorsExample {

  public static void main(String[] args) {

    final Properties properties = new Properties();
    properties.put("com.application.setting1", "value1");
    properties.put("com.application.setting2", "value2");
    properties.put("com.test.testSetting", "testValue");

    String prefix = "com.application";

    properties.stringPropertyNames().stream()
        .filter(key -> key.startsWith(prefix))
        .collect(CollectorsExample)
  }
}
