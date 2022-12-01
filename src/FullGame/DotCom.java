package FullGame;

import java.util.ArrayList;

public class DotCom {
    // Переменные экземпляра класса DotCom
    private ArrayList<String> locationCells;// ArrayList с ячейками, описывающими местоположение.
    private String name;// Имя "сайта".

    public void setLocationCells(ArrayList<String> loc) {// Сеттер, который обновляет местоположение "сайта"(случайный адрес,
        // предоставляемый методом placeDotCom() из класса GameHelper).
        locationCells = loc;
    }

    public void setName(String n) {// Ваш простой сеттер.
        name = n;
    }

    public String checkYouself(String userImput) {
        String result = "Мимо";
        int index = locationCells.indexOf(userImput);// Метод indexOf() из ArrayList в действии! Если ход пользователя совпал с одним
        // из элементов ArrayList, то метод indexOf() вернёт его местоположение. Если нет, то indexOf() вернёт -1.

        if (index >= 0) {
            locationCells.remove(index);// Применяем метод remove() из ArrayList для удаления элемента.

            if (locationCells.isEmpty()) {// Используем метод Empty(), чтобы проверить, все ли адреса были разгаданы.
                result = "Потопил";
                System.out.println("Ой! ВЫ потопили " + name + " : ( ");// Сообщает пользователю о потоплении "сайта".
            } else {
                result = "Попал";
            }
        }
        return result;// Возвращаем "Мимо", "Попал" или "Потопил".
    }
}
