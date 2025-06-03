/*
송하연
 */
package com.hayeon.jvm;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Arrays;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogParameters {
}

class UserService {

    @LogParameters
    public void login(String username, String password) {
        System.out.println("로그인 처리 로직 실행 중...");
    }
}
public class JavaStudy4_02 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        UserService userService = new UserService();

        String methodName = "login";
        Object[] params = {"ha_yeon", "1234"};

        for (Method method : UserService.class.getDeclaredMethods()) {
            if (method.getName().equals(methodName) && method.isAnnotationPresent(LogParameters.class)) {
                System.out.println("[LOG] " + method.getName() + " called with parameters: " + Arrays.toString(params));
                method.invoke(userService, params); // 실제 메서드 실행
            }
        }
    }
}
