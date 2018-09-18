package lenovo.pcsd.products.common.util;

import lenovo.pcsd.products.common.util.py4j.Converter;
import lenovo.pcsd.products.common.util.py4j.IllegalPinyinException;
import lenovo.pcsd.products.common.util.py4j.PinyinConverter;

public class PY4jUtils {

	private static Converter converter = new PinyinConverter();;

	public static String[] getPinyin(char ch) throws IllegalPinyinException {
		return converter.getPinyin(ch);
	}

	public static String getPinyin(String chinese) throws IllegalPinyinException {
		return converter.getPinyin(chinese);
	}

	public static String getSimplePinyin(String chinese) throws IllegalPinyinException {
		return converter.getSimplePinyin(chinese);
	}

}
