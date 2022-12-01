package OneWebsite;

public class DotComGame {

    public static void main(String[] args) {
        int numOfGuesse = 0;//Создаем переменную, чтобы следить за количеством ходов пользователя
        GameHelper helper = new GameHelper();//Это спец. класс, который содержит метод для приёма пользовательского ввода.
        // Пока сделаем вид, что это часть Java
        DotCom theDotCom = new DotCom();// Создаём объект "Сайт"

        // Генерируем случайное число для первой ячейки и используем его для формирования массива ячеек
        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};

//        theDotCom.setLocationCells(locations);// Передаём "сайту" местоположение его ячеек(массив)


        //Создаём булеву переменную, чтобы проверять в цикле, не закончилась ли игра
        boolean isAlive = true;
        while (isAlive == true) {

            String guess = helper.getUserInput("Введите число");//Получаем строку, вводимую пользователем
            String result = theDotCom.checkYouself(guess);//Просим "сайт" проверить полученные данные: сохраняем возвращенный
            //результат в переменную типа String
            numOfGuesse++;//Инкриминируем количество попыток

            //Потоплен ли "сайт"? Если да то присваиваем isAlive значение false(т.к. не хотим продолжать цикл)
            // и выводить на экран количество попыток
            if (result.equals("Потопил")) {
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuesse + " попыток(и)");
            }
        }
    }
}