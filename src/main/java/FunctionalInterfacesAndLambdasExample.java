
public class FunctionalInterfacesAndLambdasExample {

    public static void main(String[] args){
        //Java7
        Runnable rjava7 = new Runnable(){
            @Override
            public void run() {
                System.out.println("My Runnable java7");
            }};

        Thread t = new Thread(rjava7);
        t.start();

        //Java8
        Runnable rjava8 = () -> System.out.println("My Runnable java8");
        Thread t2 = new Thread(rjava8);
        t2.start();

        AbstractInterface2 test = () -> System.out.println("Providing functional interface implementation");

        test.abstractMethod2();

    }

}
