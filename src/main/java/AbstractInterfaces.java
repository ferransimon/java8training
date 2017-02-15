
@FunctionalInterface
public interface AbstractInterfaces {

    void abstractMethod();

    default void defaultMethodImplementation(){
        System.out.println("Print from default implementation");
    }
}
