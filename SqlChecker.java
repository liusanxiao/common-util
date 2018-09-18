package lenovo.pcsd.products.common.util;

import java.util.regex.Pattern;


public class SqlChecker
{
	static final private String reg = ".*[create|select|update|delete|drop|show|and|use|truncate|add|alter|if|when|case|grant|;|'|\"]*";
	static final private Pattern p = Pattern.compile(reg);

	static final private String keyStr = "create |select |update |delete |drop |show |and |use |truncate |add |alter "
			+ "|if|when|case|grant|;|'|\"|(|)|sleep";
	static private String[] keys = null;
	static
	{
		keys = keyStr.split("\\|");
	}

	static public String checkSql(String sqlParam)
	{
		if(StringUtils.isEmpty(sqlParam))
		{
			return sqlParam;
		}
		sqlParam = sqlParam.toLowerCase();
		for (int k = 0; k < keys.length; k++)
		{
			if (sqlParam.contains(keys[k]))
			{
				sqlParam = sqlParam.replace(keys[k], " ");
			}
		}
		return sqlParam;
	}

	/*public static void main(String[] s)
	{

		System.out.println(checkSql("c ;b  ' a \" xdda and"));
	}*/
}
