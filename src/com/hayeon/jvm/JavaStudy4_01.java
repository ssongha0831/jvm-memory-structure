/*
송하연
메모리 구조 정리 : https://github.com/ssongha0831/jvm-memory-structure/blob/main/README.md
*/
package com.hayeon.jvm;

public class JavaStudy4_01 {
    static class MyObject {
        private int[] largeArray = new int[1_000_000]; // Heap에 큰 객체 할당

        @Override
        protected void finalize() throws Throwable {
            System.out.println("MyObject가 GC에 의해 수거되었습니다!");
        }
    }

    public static void main(String[] args) {
        // 객체 생성 (Heap에 할당)
        MyObject obj = new MyObject();
        System.out.println("MyObject 생성됨!");

        // 객체 참조 해제
        obj = null;
        System.out.println("MyObject 참조 해제됨!");

        // GC 요청 (실제로 바로 동작하지 않을 수도 있음)
        System.gc();

        // GC가 동작할 때까지 대기
        try {
            Thread.sleep(2000); // 2초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("프로그램 종료!");
    }
}
