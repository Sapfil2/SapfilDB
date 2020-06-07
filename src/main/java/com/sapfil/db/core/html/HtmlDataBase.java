package com.sapfil.db.core.html;

import com.sapfil.db.api.DataBase;
import com.sapfil.db.api.Table;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Set;

public abstract class HtmlDataBase implements DataBase {

    protected TagNode root;
    protected final HashMap<String, Table> tables = new HashMap<>();
    protected final String htmlFileName;

    public HtmlDataBase(String htmlFileName) {
        this.htmlFileName = htmlFileName;

        File file = new File(htmlFileName);
        HtmlCleaner cleaner = new HtmlCleaner();

        // парсинг файла в JAVA_ отображение
        try (InputStream inputStream = new FileInputStream(file)){
            root = cleaner.clean(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<String> getTableNames() {
        return tables.keySet();
    }

    @Override
    public Table getDataBaseTable(String tableName) {
        return tables.get(tableName);
    }

    @Override
    public String getName() {
        return htmlFileName;
    }

    @Override
    public void saveDataBase(){
        //not yet implemented
    }

}
