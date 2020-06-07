package com.sapfil.db.core.html;

import com.sapfil.db.api.DAO;
import com.sapfil.db.api.Key;
import com.sapfil.db.api.Table;
import org.htmlcleaner.TagNode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Отображение таблицы из XML-представления
 * @param <K> ключ
 * @param <D> DAO-значение
 */
public abstract class HtmlTable<K extends Key, D extends DAO> implements Table<K, D> {

    protected final HashMap<K, D> index = new HashMap<>();
    protected final Map<String, String> attributesMap;
    protected final String name;

    protected HtmlTable(TagNode tagNode) {

        // имя
        name = tagNode.getName();

        // аттрибуты

        attributesMap = tagNode.getAttributes();

        // вложенные элементы
        TagNode[] children = tagNode.getChildTags();

        for (TagNode node : children){
            parseNodeContent(node);
        }
    }

    protected abstract void parseNodeContent(TagNode tagNode);

    @Override
    public Collection<D> getAllEntries() {

        return index.values();

    }

    @Override
    public D getEntry(K key){

        return index.get(key);

    }

    @Override
    public void deleteEntry(D entry) {
        //TODO
    }

    @Override
    public void addEntry(D entry) {
        //TODO
    }

    @Override
    public String getName() {
        return name;
    }


}
