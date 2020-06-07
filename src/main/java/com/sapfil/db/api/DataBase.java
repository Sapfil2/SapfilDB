package com.sapfil.db.api;

import java.util.Set;

/**
 * Отображение одной БД, содержащей несколько таблиц
 * Для текущих потребностей предполагается прогружать всю БД целиком.
 *
 * Например, это будет БД, содержащая все объекты уровня.
 *
 *
 *
 *
 * Для текущей XML-реализации БД предлагается такая огранизация:
 *
 * 1) XML содержит один верхнеуровневый тэг. Именем БД можно считать имя тэга.
 *
 * 2) Тэги второго уровня являются "таблицами". Имеют атрибуты - дефолтные значения всех параметров
 * хранящихся объектов. Именем таблицы является имя тэга.
 *
 * 3) Тэги третьего уровня - записи в таблицах.
 * Их набор параметров в рамках одной таблицы должен быть одинаковым и совпадать с именами
 * дефолтных параметров в родительском тэге. Если параметра в дочернем тэге нет - берется параметр
 * из родительского.
 */
public interface DataBase extends Entity {

    /**
     * @return имена всех таблиц в БД
     */
    Set<String> getTableNames();

    /**
     * @param tableName имя таблицы
     * @return таблица БД
     */
    Table getDataBaseTable(String tableName);

    /**
     * Сохранить текущее состояние БД в файл
     */
    void saveDataBase();

}