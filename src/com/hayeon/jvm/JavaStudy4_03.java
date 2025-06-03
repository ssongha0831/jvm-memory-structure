/*
송하연
 */
package com.hayeon.jvm;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

public class JavaStudy4_03 {
    public static void main(String[] args) throws IOException {

        try {
            FileWriter myWriter = new FileWriter("sample.txt");
            myWriter.write("hello world\njava stream is fun\nanonymous class example");
            myWriter.close();
            System.out.println("파일을 성공적으로 만들었습니다.");
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 에러가 발생했습니다.");
            e.printStackTrace();
        }

        Function<String, String> toUpper = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        try (Stream<String> lines = Files.lines(Paths.get("sample.txt"))) {
            lines.map(toUpper)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
