package Test;

public class SimpleDotComTestDrive {
    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom(); //создаем экземпляр класса Test.SimpleDotCom
        // Создаем массив для местоположения "сайта"(три последовательных числа из семи)
        int[] location = {2, 3, 4};
        dot.setLocationCells(location);// Вызываем сеттер "сайта"

        String userGuest = "2";// Делаем ход от имени пользователя
        String result = dot.checkYouself(userGuest); // Вызываем метод checkYouSelf() объекта Test.SimpleDotCom
//        String testResult = "Неудача";
//        if (result.equals("Попал")) {
//            testResult = "Пройден";
//        }
//
//        System.out.println(testResult);
    }
}
