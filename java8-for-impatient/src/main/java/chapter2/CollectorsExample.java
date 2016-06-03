package chapter2;

import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsExample {

  public static void main(String[] args) {

    final Properties properties = new Properties();
    properties.put("com.application.setting1", "value1");
    properties.put("com.application.setting2", "value2");
    properties.put("com.test.testSetting", "testValue");

    System.out.println("prefix=com.application");
    Map<String, String> subProperties1 = properties.stringPropertyNames().stream()
        .filter(key -> key.startsWith("com.application"))
        .collect(Collectors.toMap(Function.identity(), properties::getProperty));

    subProperties1.forEach((key, value) -> System.out.println(key + ", " + value));

    System.out.println("\nprefix=com.test");
    Map<String, String> subProperties2 = properties.stringPropertyNames().stream()
        .filter(key -> key.startsWith("com.test"))
        .collect(Collectors.toMap(Function.identity(), properties::getProperty));

    subProperties2.forEach((key, value) -> System.out.println(key + ", " + value));

    System.out.println("\nprefix=com.missing");
    Map<String, String> subProperties3 = properties.stringPropertyNames().stream()
        .filter(key -> key.startsWith("com.missing"))
        .collect(Collectors.toMap(Function.identity(), properties::getProperty));

    subProperties3.forEach((key, value) -> System.out.println(key + ", " + value));
  }
}
