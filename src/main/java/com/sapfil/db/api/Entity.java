package com.sapfil.db.api;

/**
 * Общий функционал всех сущностей БД
 */
public interface Entity {

    /**
     * @return для таблиц - это имя таблицы
     */
    String getName();
}
