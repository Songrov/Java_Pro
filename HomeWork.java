package lesson7.homework;

import lesson2.crossword.A;

import java.util.*;
import java.util.stream.Collectors;

public class HomeWork {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(
                Arrays.asList(
                        new Person("Anton", new Address("Wallstr", "3")),
                        new Person("Ivsn", new Address("Frankfurterstr", "4")),
                        new Person("Andrei", new Address("Berlinerstr", "1"))
                )
        );

        System.out.println(getAddresses(persons));

        System.out.println(
                compare(Arrays.asList(1,2,3,4,12), Arrays.asList(5,2,3,3,0))
        );


        List<Integer> a = Arrays.asList(1,2,3);
        System.out.println("before: " + a);
        reverse(a);
        System.out.println("after: " + a);


        System.out.println(
                findSecondMax(new ArrayList<>(Arrays.asList(1,3,4,2)))
        );

    }



    public static int findSecondMax(List<Integer> a)
    {
        Collections.sort(a); // сортируем
        int last = a.get(a.size() - 1); // значение максимума
        a.removeAll(Arrays.asList(last)); // удаляем все такие элементы
        return a.get(a.size() - 1); // возвращаем последний
    }



    public static void reverse(List<Integer> a)
    {   // 0 1 2 i: a.size() - 1 - i
        // 1 2 3
        for(int i = 0; i < a.size() / 2 ; i++)
        {
            int temp = a.get(i);
            a.set(i, a.get(a.size() - 1 - i));
            a.set(a.size() - 1 - i, temp);
        }
    }



    public static List<String> compare(List<Integer> a, List<Integer> b)
    {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < a.size(); i++)
        {
            result.add(
                    a.get(i).equals(b.get(i)) ? "Yes" : "No"

            );
        }
        return result;
    }



    public static List<Address> getAddresses(List<Person> persons)
    {

        return persons.stream().map(Person::getAddress).collect(Collectors.toList());
    }
}
