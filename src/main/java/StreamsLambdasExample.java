import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Streams and Lambdas example
 */
public class StreamsLambdasExample {

    public static void main(String[] args){

        List<Integer> myList = new ArrayList<Integer>();
        for(int i=1; i<1000; i++) myList.add(i);

        //Add some nulls in the list
        myList.add(null);
        myList.add(null);

        //Transform list in java7
        List<String> newList = new ArrayList<>();
        for(Integer num : myList){
            if(num != null) {
                newList.add(String.valueOf(num));
            }
        }

        //Transform list in java8
        newList = myList.stream()
                .filter(v -> v != null)
                .map(String::valueOf)
                .collect(Collectors.toList());

        //ParallelStream
        List<Integer> unorderedList = new ArrayList<>();
        unorderedList.add(5);
        unorderedList.add(1);
        unorderedList.add(3);

        System.out.println("Unordered: "+unorderedList.toString());
        List<Integer> sortedList = unorderedList.parallelStream().sorted().collect(Collectors.toList());
        System.out.println("Sorted: "+sortedList.toString());

        //Find with optionals
        myList.stream().filter(v -> v % 2 == 0)
                .findFirst()
                .ifPresent(
                        v -> System.out.println("First pair element Java8: "+ v)
                );

        //Java 7
        Optional<Integer> num = findFirstPairElementJava7(myList);
        if(num.isPresent()){
            System.out.println("First pair element Java7: "+ num);
        }

        //FlatMap example
        List<FlatMapTest> flatMapTestList = new ArrayList<>();
        flatMapTestList.add(new FlatMapTest(Arrays.asList("a","b")));
        flatMapTestList.add(new FlatMapTest(Arrays.asList("c","d")));

        List<String> names = flatMapTestList.stream()
                .map(FlatMapTest::getNames)
                .flatMap(v -> v.stream())
                .collect(Collectors.toList());

        System.out.println("List flatMap: "+names);

    }

    public static Optional<Integer> findFirstPairElementJava7(List<Integer> list){
        for(Integer num : list){
            if(num % 2 == 0){
                return Optional.of(num);
            }
        }

        return Optional.empty();
    }

    public static class FlatMapTest{

        private List<String> names;

        public FlatMapTest(List<String> names){
            this.names = names;
        }


        public List<String> getNames() {
            return names;
        }

        public void setNames(List<String> names) {
            this.names = names;
        }
    }

}
