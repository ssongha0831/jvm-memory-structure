## 1. JVM 메모리 구조 정리

┌───────────────┐
│  Method Area  │
├───────────────┤
│     Heap      │  ← (비선형/리전형, GC 관리)
├───────────────┤
│   Stack #1    │  ← (선형, 스레드별)
│   Stack #2    │
│   ...         │
├───────────────┤
│ PC Register   │
│ Native Stack  │
└───────────────┘
Stack: 선형 메모리 구조, 메서드 호출 시 프레임이 쌓이고 사라짐
Heap: 비선형/리전형 메모리 구조, 객체와 배열 저장, GC(G1 GC 등) 관리
Method Area: 클래스 정보, static 변수 등 저장

## 4. Design Pattern - Decorator 과제 정리
🔹 정의
기존 객체에 기능을 **동적으로 추가**하는 디자인 패턴.  
**상속 없이도 유연하게 기능을 확장**할 수 있는 구조를 제공한다.

🔹 구조
- **Component**: 인터페이스  
  예) `Coffee`
- **ConcreteComponent**: 기본 구현 클래스  
  예) `Americano`
- **Decorator**: 추상 클래스, Component를 감싸는 역할  
  예) `CoffeeDecorator`
- **ConcreteDecorator**: 기능을 확장하는 실제 클래스  
  예) `ShotDecorator`, `SugarDecorator`

🔹 장점
- 객체를 조합하여 기능을 **자유롭게 확장** 가능
- **OCP (개방-폐쇄 원칙)** 만족
- 코드 **재사용성**과 **유연성**이 뛰어남

🔹 실생활 예시
- Java I/O API  
  예) `BufferedReader(new InputStreamReader(...))`
- Spring Framework  
  예) `HttpServletRequestWrapper`

🔹 본 과제 구현 요약
- 기본 커피 `Americano`를 생성
- `ShotDecorator`, `SugarDecorator` 를 사용하여 기능을 동적으로 추가
- 데코레이터를 **중첩 조합**하여 다음과 같이 사용

```java
Coffee coffee = new SugarDecorator(new ShotDecorator(new Americano()));