import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class LambdaFour {
/*
I developed the first solution entirely on my own,
using the skills and knowledge I've accumulated so far.
However, ChatGPT provided feedback on potential inefficiencies
in my approach and suggested an alternative solution that
avoids instantiating streams unnecessarily. I decided to keep both
implementations to showcase my thought process and the improvement
suggested, demonstrating my ability to write functional code while
also learning and refining my approach.
 */

                             //My solution
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstList = first.toList();//the problem is here I have to create lists
        List<T> secondList = second.toList();//which ruins the laziness of streams
        List<T> combList = new ArrayList<>();
        int minLength = Math.min(firstList.size(), secondList.size());
        boolean isFirst = true;
        for (int i = 0; 2 * minLength > i; i++) {
            if (isFirst) combList.add(firstList.get(i / 2));
            else combList.add(secondList.get(i / 2));
            isFirst = !isFirst;
        }
        return combList.stream();
    }


                                //ChatGPT improved version with no instances of memory occupying objects
//    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
//        Iterator<T> firstIterator = first.iterator();
//        Iterator<T> secondIterator = second.iterator();
//        Iterator<T> zippedIterator = new Iterator<>() {
//            private boolean isFirst = true;
//            @Override
//            public boolean hasNext() {
//                return (isFirst && firstIterator.hasNext()) || (!isFirst && secondIterator.hasNext());
//            }
//            @Override
//            public T next() {
//                if (isFirst && firstIterator.hasNext()) {
//                    isFirst = false;
//                    return firstIterator.next();
//                } else if (!isFirst && secondIterator.hasNext()) {
//                    isFirst = true;
//                    return secondIterator.next();
//                }
//                throw new java.util.NoSuchElementException();
//            }
//        };
//        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(zippedIterator, 0), false);
//    }


}

class LambdaFourSandBox {
    public static void main(String[] args) {
        Stream<String> left = Stream.iterate("left", s -> s).limit(3);
        Stream<String> right = Stream.iterate("right", s -> s).limit(5);

        LambdaFour.zip(left, right).forEach(System.out::println);

        Stream<Integer> odds = Arrays.stream(new Integer[]{1, 3, 5, 7, 9});
        Stream<Integer> pair = Arrays.stream(new Integer[]{2, 4, 6, 8, 10, 12, 14});

        LambdaFour.zip(odds, pair).forEach(System.out::println);
    }
}