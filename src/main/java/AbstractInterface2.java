
@FunctionalInterface
public interface AbstractInterface2 {

    void abstractMethod2();

    default void defaultMethodImplementation(){
        System.out.println("Print from default implementation");
    }

    static void staticMethod(){
        System.out.println("Print from static implementation");
    }

}
