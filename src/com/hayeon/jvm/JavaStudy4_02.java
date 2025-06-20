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
    @LogParameters
    public void login(String username) {
        System.out.println("단일 인자 로그인 처리 로직 실행 중...");
    }
    @LogParameters
    public void register(String username, String password, int age) {
        System.out.println("회원가입 처리 로직 실행 중...");
    }
}

public class JavaStudy4_02 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        UserService userService = new UserService();

        Object[][] testCases  = {
                {"login", new Class[]{String.class, String.class}, new Object[]{"ha_yeon", "1234"}},
                {"login", new Class[]{String.class}, new Object[]{"ha_yeon"}},
                {"register", new Class[]{String.class, String.class, int.class}, new Object[]{"hy", "pw", 22}}
        };

        for (Object[] testCase : testCases) {
            String methodName = (String) testCase[0];
            Class<?>[] paramTypes = (Class<?>[]) testCase[1];
            Object[] params = (Object[]) testCase[2];

            try {
                Method method = UserService.class.getDeclaredMethod(methodName, paramTypes);
                if (method.isAnnotationPresent(LogParameters.class)) {
                    System.out.println("[LOG] " + method.getName() + " called with parameters: " + Arrays.toString(params));
                    method.invoke(userService, params);
                }
            } catch (NoSuchMethodException e) {
                System.out.println("해당 메서드 없음: " + methodName + Arrays.toString(paramTypes));
            }
        }
    }
}
