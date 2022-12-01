package Test;

public class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;

    String checkYouself(String stringGuest) {
        int guess = Integer.parseInt(stringGuest);// Преобразуем тип String в int
        String result = "Мимо";// Создаем переменную для хранения результата, который будем возвращать.
                               // Присваиваем по умолчанию строковаое значение "Мимо"(то есть подразумеваем промах)
        for (int cell : locationCells) {// Повторяем с каждой ячейкой из массива locationCells(местоположение ячейки объекта)
            if (guess == cell) {// Сравниваем ход пользователя с этим элементом(ячейкой) массива
                result = "Попал";// Мы обнаружили попадание
                numOfHits++;// Мы обнаружили попадание
                break;// Выбираемся из цикла: другие ячейки проверять не нужно
            }

        }
        if (numOfHits == locationCells.length) {
            result = "Потопил";// Вышли из цикла, но посмотрим, не потопили ли нас(три попадания),
                               //и при необходимости изменим результат на "Потопил"
        }
        System.out.println(result);// Выводим пользователю результат("Мимо", если он не был изменён на "Попал" или "Потопил"
        return result;// Возвращаем результат в вызывающий метод
    }


    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }
}
