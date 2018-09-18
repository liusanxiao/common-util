package lenovo.pcsd.products.common.util.py4j;

import java.util.Arrays;

import lenovo.pcsd.products.common.util.PY4jUtils;

public class Test {

	public static void main(String[] args) {

		final String[] arr = { "ThinkPad X260", "重庆银行", "联想固态硬盘2.5寸 512G", "EXCO 联想 13寸屏幕保护膜 NPG01 WB(FOR YOGA3 PRO)",
				"长沙银行", "便宜坊", "西藏", "藏宝图", "出差", "参加", "列车长" };

		for (String chinese : arr) {
			try {
				String py = PY4jUtils.getSimplePinyin(chinese);
				System.out.println(chinese+"\t"+py);
				
				py = PY4jUtils.getPinyin(chinese);
				System.out.println(chinese+"\t"+py);
				
			} catch (IllegalPinyinException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}
}
