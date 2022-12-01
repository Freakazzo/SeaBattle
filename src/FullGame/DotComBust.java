package FullGame;

import java.util.ArrayList;

public class DotComBust {
    // Объявляем и инициализируем переменные, которые нам понадобятся.
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        // Создадим несколько "сайтов" и присвоим им адреса.
        // Создаем три объекта DotCom, даём им имена и помещаем в ArrayList.
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        // Выводим краткие инструкции для пользователя.
        System.out.println("Ваша цель - потопить три  <cайта>.");
        System.out.println("Pets.com, eToys.com, go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");


        for (DotCom dotComToSet : dotComList) { // Повторяем с каждым объектом DotCom в списке.
            ArrayList<String> newLocation = helper.placeDotCom(3);// Запрашиваем у вспомогательного объекта адрес "сайта".
            dotComToSet.setLocationCells(newLocation);// Вызываем сеттер из объекта DotCom, чтобы передать ему местоположение,
            // которое только что получили от вспомогательного объекта.
        }
    }

    private void startPlaying() {
        while (!dotComList.isEmpty()) {// До тех пор, пока список объектов DotCom не станет пустым.
            String userGuess = helper.getUserInput("Сделайте ход");// Получаем пользовательский ввод.
            checkUserGuess(userGuess);// Вызываем наш метод checkUserGuess
        }
        finishGame();// Вызывааем наш метод finishGame.
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;// Инкрементируем количество попыток, которые сделал пользователь.
        String result = "Мимо";// Подразумеваем промах, пока не выяснили обратного.

        for (DotCom dotComToTest : dotComList) {// Повторяем это для всех объектов DotCom в списке.
            result = dotComToTest.checkYouself(userGuess);// Просим DotCom проверить ход пользователя, ищем попадание(или потопление).
            if (result.equals("Попал")) {
                break;// Выбираемся из цикла раньше времени, нет смысла проверять другие "сайты".
            }
            if (result.equals("Потопил")) {
                dotComList.remove(dotComToTest);// Ему пришел конец, так что удаляем его из списка "сайтов" и выходим из цикла.
                break;
            }
        }
        System.out.println(result);// Выводим для пользователя результат.
    }

    private void finishGame() {// Выводим сообщение как пользователь прошёл игру.
        System.out.println("Игра окончена!");
        if (numOfGuesses <= 18) {
            System.out.println("Игра закончена меньше чем за: 18 ходов. Да ты крут!");
        } else
            System.out.println("Игра закончена больше чем за: 18 ходов. Ты лузер!");
    }


    public static void main(String[] args) {
        DotComBust game = new DotComBust();// Создаём игровой объект.
        game.setUpGame();// Говорим игровому объекту подготовить игру.
        game.startPlaying();// Говорим игровому объекту начать главный игровой цикл(продолжаем запрашивать пользовательский ввод
        // и проверять полученные данные).
    }
}
