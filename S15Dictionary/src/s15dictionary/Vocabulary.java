package s15dictionary;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trong
 */
public class Vocabulary {
    private String English;
    private String Vietnamese;

    /**
     * Constructor for class VocabularyManagement using.
     * @param en This parameter will catch value for attribute.
     * @param vn This parameter will catch value for attribute.
     */
    public Vocabulary(String en, String vn) {
        this.English = en;
        this.Vietnamese = vn;
    }

    /**
     * Method getEn().
     * This method will get English value from attribute. 
     * @return English The value in attribute.
     */
    public String getEn() {
        return English;
    }

    /**
     * Method setEn().
     * This method will set value for attribute.
     * In this method have parameter:
     * @param en This parameter will set value for attribute.
     */
    public void setEn(String en) {
        this.English = en;
    }

    /**
     * Method getVn().
     * This method will get attribute from attribute.
     * @return Vietnamese The value in attribute.
     */
    public String getVn() {
        return Vietnamese;
    }

    /**
     * Method setEn().
     * This method will set value for attribute.
     * In this method have parameter:
     * @param vn This parameter will set value for attribute.
     */
    public void setVn(String vn) {
        this.Vietnamese = vn;
    }
    
    
}
