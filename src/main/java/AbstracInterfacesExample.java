
public class AbstracInterfacesExample implements AbstractInterfaces, AbstractInterface2{

    @Override
    public void abstractMethod() {

    }

    @Override
    public void abstractMethod2() {

    }

    /***
     * In order to avoid diamond problem from multiple inheritance, we need to implement the default implementation here
     */
    @Override
    public void defaultMethodImplementation() {
        AbstractInterface2.staticMethod();
    }
}
