package chapter2;

import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

class CollectorsExample {

  private static final Properties properties = new Properties();

  public static void main(String[] args) {
    properties.put("com.application.setting1", "value1");
    properties.put("com.application.setting2", "value2");
    properties.put("com.test.testSetting", "testValue");

    System.out.println("prefix=com.application");
    getSubProperties("com.application")
        .forEach((key, value) -> System.out.println(key + ", " + value));

    System.out.println("\nprefix=com.test");
    getSubProperties("com.test")
        .forEach((key, value) -> System.out.println(key + ", " + value));

    System.out.println("\nprefix=com.missing");
    getSubProperties("com.missing")
      .forEach((key, value) -> System.out.println(key + ", " + value));
  }

  static Map<String, String> getSubProperties(String prefix) {
    return properties.stringPropertyNames()
        .stream()
        .filter(key -> key.startsWith(prefix))
        .collect(Collectors.toMap(Function.identity(), properties::getProperty));
  }
}
