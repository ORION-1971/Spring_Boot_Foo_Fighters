package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        List<String> list2 = new ArrayList<>(list);

        for (String s : list2) {
            System.out.println(s);
        }

       /* List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);

        List<Integer> list1 = list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list1.add(list.get(i));
            }
        }

        ArrayList<String> cities = new ArrayList<String>();
        Collections.addAll(cities, "Париж", "Лондон", "Мадрид");
        // получаем поток
        // применяем фильтрацию по длине строки
        // выводим отфильтрованные строки на консоль
        for (String s : cities) {
            if (s.length() == 6) {
                System.out.println(s);
            }
        }

        cities.stream()
                .filter(s -> s.equals("Лондон"))
                .collect(Collectors.toList())
                .stream().findFirst()
                .ifPresent(System.out::println);*/
    }
}
