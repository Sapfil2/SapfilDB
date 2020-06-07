package com.sapfil.db.core.xml;

import com.sapfil.db.api.DataBase;
import com.sapfil.db.api.Table;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Set;

public abstract class XmlDataBase implements DataBase {

    protected Document rDoc;
    protected final HashMap<String, Table> tables = new HashMap<>();
    protected final String xmlFileName;

    public XmlDataBase(String xmlFileName) {
        this.xmlFileName = xmlFileName;

        // подготовка JAVA-отображения
        DocumentBuilder db = null;
        try {
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        File file = new File(xmlFileName);

        // парсинг файла в JAVA_ отображение
        try (InputStream inputStream = new FileInputStream(file)){
            rDoc = db.parse(inputStream);
        } catch (SAXException e) {
            e.printStackTrace();
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
        return xmlFileName;
    }

    @Override
    public void saveDataBase(){
        //not yet implemented
    }

}
