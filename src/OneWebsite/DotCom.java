package OneWebsite;

import java.util.ArrayList;

public class DotCom {

    private ArrayList<String> locationCells;// Изменяем строковый массив на ArrayList, чтобы хранить объекты String
    // private int numsOfHits;
    //сейчас нам это не нужно

    public void setLocationCells(ArrayList<String> loc) {// Изменяем строковый массив на ArrayList, чтобы хранить объекты String
        locationCells = loc;
    }

    public String checkYouself(String userImput) {//Новое и усовершенствованное имя аргумента
        String result = "Мимо";

        //Проверяем, содержится ли заданная пользователем ячейка внутри ArrayList, запрашивая её индекс.
        //Если её нет в списке, то indexOf() возвращает -1.
        int index = locationCells.indexOf(userImput);

        //Если индекс >= 0, то загаданная пользователем ячейка определенно находится в списке, поэтому удаляем её.
        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {// Если список пустойЮ значит, это было роковое попадание!
                result = "Потопил";
            } else {
                result = "Попал";
            }
        }
        return result;
    }


}