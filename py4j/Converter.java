package lenovo.pcsd.products.common.util.py4j;

/**
 * @author Ricky Fung
 */
public interface Converter {

    String[] getPinyin(char ch) throws IllegalPinyinException;

    String getPinyin(String chinese) throws IllegalPinyinException;
    
    String getSimplePinyin(String chinese) throws IllegalPinyinException;
}
