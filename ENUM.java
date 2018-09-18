package lenovo.pcsd.products.common.util;

/**
 * Hello world!
 *
 */
public class ENUM
{
	public enum Platform
	{
		NO_Platform(0, ""),

		Think_PC(8, "http://www.thinkworldshop.com.cn"), Think_WAP(5,
				"http://mobile.thinkworldshop.com.cn"), Think_Product(11, "http://products.thinkworld.com.cn"),
				// Think_APP(7),
				// Think_WX(6),

		Lenovo_PC(4, "http://www.lenovo.com.cn"), Lenovo_WAP(1, "http://m.lenovo.com.cn"), Lenovo_APP(3,
				"http://m.lenovo.com.cn/android"), Lenovo_WX(2, "http://m.lenovo.com.cn/weixin"),

		EPP_PC(22, "http://www.lenovovip.com.cn"), EPP_WAP(20, "http://m.lenovovip.com.cn"),

		Roaming(30, "");

		private Integer code;
		private String domain;

		Platform(Integer code, String domain)
		{
			this.code = code;
			this.domain = domain;
		}

		public Integer getCode()
		{
			return this.code;
		}

		public String getDomain()
		{
			return domain;
		}

		public static Platform valueOf(int code)
		{
			switch (code)
			{
			case 1:
				return Platform.Lenovo_WAP;
			case 2:
				return Platform.Lenovo_WX;
			case 3:
				return Platform.Lenovo_APP;
			case 4:
				return Platform.Lenovo_PC;

			case 5:
				return Platform.Think_WAP;
			// case 6: return Platform.Think_WX;
			// case 7: return Platform.Think_APP;
			case 8:
				return Platform.Think_PC;
			case 11:
				return Platform.Think_Product;

			case 20:
				return Platform.EPP_WAP;
			case 22:
				return Platform.EPP_PC;

			case 30:
				return Platform.Roaming;

			default:
				return Platform.NO_Platform;
			}
		}

		/**
		 * 判断两个平台是否是同一商城
		 *
		 * @param knowPlatForm
		 *            需要对比的平台code
		 * @param othersPlatForm
		 *            未知的平台code
		 * @return
		 */
		public static boolean platformIsSameShop(Integer knowPlatForm, Integer othersPlatForm)
		{
			if (null != knowPlatForm && null != othersPlatForm)
			{
				if (knowPlatForm == othersPlatForm)
				{
					return true;
				}
				// lenovo商城1,2,3,4
				if ((knowPlatForm > 0 && knowPlatForm < 5) && (othersPlatForm > 0 && othersPlatForm < 5))
				{
					return true;
				}
				// think商城 5,6,7,8
				if ((knowPlatForm > 4 && knowPlatForm < 9 || knowPlatForm == 11)
						&& (othersPlatForm > 4 && othersPlatForm < 9 || othersPlatForm == 11))
				{
					return true;
				}
				// epp商城20,22
				if ((knowPlatForm == 20 || knowPlatForm == 22) && (othersPlatForm == 20 || othersPlatForm == 22))
				{
					return true;
				}
				// roming 30
			}
			return false;
		}

	}

	public enum ENV
	{
		DEV("dev"), TEST("test"), UAT("uat"), PRODUCT("product");

		private String value;

		ENV(String value)
		{
			this.value = value;
		}

		public String getValue()
		{
			return this.value;
		}
	}

	public enum RedisKey
	{
		// 平台商品基本数据缓存
		ProductInfo("productInfo"),
		// 库存查询参数缓存
		GoodsInfo("goodsInfo"),
		// 服务商品列表缓存
		ServiceList("servicelist"),

		// 热销榜list
		HotList("hotlist"),

		// 猜你喜欢
		GuessULike("guessulike"),

		// 买了又买
		BuyAgain("buyagain"),

		// 依旧换新list
		OldChangeNew("oldchangenew"),

		// 大侠码
		DXCode("jydxproduct"),

		// c2c商品
		C2cProductList("c2cproductlist"),

		// 用户类型 c2c:0 大侠：1 other : -1
		MemberType("c2cmember"),

		// c2c用户类型
		C2cUserType("c2cusertypelist"),

		// 新品
		NewProductList("NewProductList"),

		// 推荐商品
		Recommends("Recommends"),

		// c2c邮箱
		C2cEmail("c2cemail"),

		// 买了又买
		ViewRecommends("ViewRecommends"),

		// 买了又买 + 推荐指数
		ViewRecommendsMap("ViewRecommendsMap"),

		// epp 组绑定信息
		MemberGroup("memberGroup:"),

		// 精英大侠用户信息
		DXInfo("jydxinfo"),

		// 精英大侠轮播图
		DXScorll("scorll"),

		// app 缓存数据
		AppData("AppData"),

		// 分类平台相关信息MinGangChen
		GoodsCategories("rootGoodsCategory"),

		// o2o cities
		O2OCities("o2ocities"),

		/** 商品详细信息 */
		ProductDetail("product_detail"),

		/**
		 * 商品价格信息 若为EPP商城，需拼接上EPP分组code
		 **/
		ProductPrice("product_price"),

		// roaming products list
		RoamingProducts("roamingproducts"),

		/** 商品收藏 */
		Favorite("favorite"),

		/** 产品组信息 **/
		ProductGroup("product_group"),

		/**懂的通信*/
		UnderstandCommunication("understand_communication"),

		/**懂得通讯套餐**/
		UnderstandCacpackage("cac_package"),

		/**懂的通信号码列表*/
		UnderstandPhoneList("understand_phone"),

		/**懂的通信号码详情*/
		UnderstandPhoneDetile("understand_phone_detail"),

		/**懂的通信号码详情*/
		UnderstandGoodsInfoes("understand_goodsinfoes"),

		/**物料 商品编码映射 **/
		MaterialToGoodscode("material_codes"),

		/**流量和话费分类商品列表**/
		FlowTypeGoods("flow_type_goods"),
		
		/**短链缓存**/
		ShortUrl("short_url"),
		
		/**thinko2o商品关联的省市信息**/
		O2oProvinceCity("o2o_province_city"),
		
		/**商品规格**/
		Specifications("specifications")
		;

		private String key;

		RedisKey(String key)
		{
			this.key = key;
		}

		public String getKey()
		{
			return this.key;
		}
	}

	public enum BigPlatform
	{
		NOP(0, new Platform[] { Platform.NO_Platform }), PC(1,
				new Platform[] { Platform.Lenovo_PC, Platform.Think_PC, Platform.EPP_PC }), WAP(2,
						new Platform[] { Platform.Lenovo_WAP, Platform.Think_WAP, Platform.EPP_WAP }), APP(3,
								new Platform[] { Platform.Lenovo_APP }), WeiXin(4,
										new Platform[] { Platform.Lenovo_WX });
		Integer code;
		Platform[] platforms;

		BigPlatform(Integer code, Platform[] pls)
		{
			this.code = code;
			this.platforms = pls;
		}

		public Platform[] getPlatforms()
		{
			return this.platforms;
		}

		public Integer getCode()
		{
			return this.code;
		}

		public static BigPlatform getBigPlatform(Platform pl)
		{
			switch (pl)
			{
			case Lenovo_PC:

			case Think_PC:

			case EPP_PC:
				return BigPlatform.PC;

			case Lenovo_WAP:

			case Think_WAP:

			case EPP_WAP:
				return BigPlatform.WAP;

			case Lenovo_APP:

				// case Think_APP:
				return BigPlatform.APP;
			default:
				return BigPlatform.NOP;
			}

		}

		public static BigPlatform getBigPlatform(SalesPlat salesPlat)
		{
			switch (salesPlat)
			{
			case PC:
				return PC;
			case APP:
				return APP;
			case WeiXin:
				return WeiXin;
			case WAP:
				return WAP;
			default:
				return NOP;
			}

		}
	}

	public enum ExpandValueType
	{
		TEXT(0, "普通文本"), DOPDOWN(1, "下拉框"), UPLOAD(2, "图片上传"), UEDITOR(3, "富文本");

		Integer code;

		String name;

		ExpandValueType(Integer code, String name)
		{
			this.code = code;
			this.name = name;
		}

		public static ExpandValueType valueOf(int code)
		{
			switch (code)
			{
			case 0:
				return TEXT;
			case 1:
				return DOPDOWN;
			case 2:
				return UPLOAD;
			case 3:
				return UEDITOR;
			default:
				return TEXT;
			}
		}

		public String getName()
		{
			return this.name;
		}

		public Integer getCode()
		{
			return this.code;
		}
	}

	public enum ExpandBusinessType
	{
		GOODSINFO(0, "商品"), PRODUCTS(1, "平台商品");

		Integer code;

		String name;

		ExpandBusinessType(Integer code, String name)
		{
			this.code = code;
			this.name = name;

		}

		public static ExpandBusinessType valueOf(int code)
		{
			switch (code)
			{
			case 0:
				return GOODSINFO;
			case 1:
				return PRODUCTS;
			default:
				return GOODSINFO;
			}
		}

		public String getName()
		{
			return this.name;
		}

		public Integer getCode()
		{
			return this.code;
		}
	}

	public enum PlatGoodsDirPath
	{

		Think_PC_PATH("pm"), Think_WAP_PATH("pm"),

		Lenovo_PC_PATH("product"), Lenovo_WAP_PATH("product"), Lenovo_APP_PATH("product"),;

		private String key;

		PlatGoodsDirPath(String key)
		{
			this.key = key;
		}

		public String getKey()
		{
			return this.key;
		}
	}

	/**
	 * @see com.lenovo.enums.ENUM.SalesType
	 */
	@Deprecated
	public static enum SaleType
	{
		General(Integer.valueOf(0), "普通商品"), Presell(Integer.valueOf(2), "预售"), TryBeforeBuy(Integer.valueOf(3),
				"先试后买"), KCode(Integer.valueOf(4), "K码商品"), Custom(Integer.valueOf(5),
						"定制"), OldForNew(Integer.valueOf(6), "以旧换新"), GroupBuying(Integer.valueOf(94),
								"团购"), TryNew(Integer.valueOf(95), "新品试用"), CTO(Integer.valueOf(96),
										"CTO"), Crowdfunding(Integer.valueOf(97), "众筹"), O2O(Integer.valueOf(98),
												"O2O"), ThinkProductCenter(Integer.valueOf(99), "Think产品中心");

		Integer type;
		String name;

		private SaleType(Integer type, String name)
		{
			this.type = type;
			this.name = name;
		}

		public Integer getType()
		{
			return this.type;
		}

		public static SaleType valueOf(Integer type)
		{
			switch (type.intValue())
			{
			case 0:
				return General;
			case 2:
				return Presell;
			case 3:
				return TryBeforeBuy;
			case 4:
				return KCode;
			case 5:
				return Custom;
			case 6:
				return OldForNew;
			case 94:
				return GroupBuying;
			case 95:
				return TryNew;
			case 96:
				return CTO;
			case 97:
				return Crowdfunding;
			case 98:
				return O2O;
			case 99:
				return ThinkProductCenter;
			}

			return General;
		}
	}

	public enum SalesType
	{
		General(0, "普通商品"), // Purchase(1, "闪购"),
		Presell(2, "预售"),
							// TryBeforeBuy(3, "先试后买"), KCode(4, "K码商品"),
							// Custom(5, "定制"), OldForNew(6,
							// "以旧换新"),GroupBuying(94, "团购"),TryNew(95, "新品试用"),
		CTO(96, "CTO"), Crowdfunding(97, "众筹"), O2O(98, "O2O");
							// , ThinkProductCenter(99, "Think产品中心");

		Integer code;
		String name;

		SalesType(Integer code, String name)
		{
			this.code = code;
			this.name = name;
		}

		public Integer getCode()
		{
			return this.code;
		}

		public String getName()
		{
			return this.name;
		}

		public static SalesType valueOf(Integer code)
		{

			switch (code)
			{
			case 0:
				return SalesType.General;
			case 2:
				return SalesType.Presell;
			/*
			 * case 1: return SalesType.Purchase;
			 * case 3: return SalesType.TryBeforeBuy; case 4:
			 * return SalesType.KCode; case 5: return SalesType.Custom; case 6:
			 * return SalesType.OldForNew;
			 *
			 * case 94: return SalesType.GroupBuying; case 95: return
			 * SalesType.TryNew;
			 */
			case 96:
				return SalesType.CTO;
			case 97:
				return SalesType.Crowdfunding;
			case 98:
				return SalesType.O2O;
			// case 99:
			// return SalesType.ThinkProductCenter;

			default:
				return SalesType.General;
			}
		}

	}

	public enum BuOwnerType
	{
		Lenovo_None(0,"lenovonone"),
		Lenovo_PC(10, "lenovopc"),
		Lenovo_MBG(20, "lenovombg"),
		Lenovo_Service(30, "lenovoservice"),
		Lenovo_Pad(40,"lenovopad"),
		Lenovo_Think(50, "lenovothink"),
		/* Lenovo_Other(60,"其他"), */
		Lenovo_TV(70, "lenovotv"),
		Lenovo_Rmodel(80, "lenovormodel"),
		DongDe(90, "dongde"),
		/*Lenovo MBG Service */
		Lenovo_MBG_Service(100,"lenovombgservice"),
		/* lenovo选件 */
		Lenovo_Option(110,"lenovooption"),
		/* think选件 */
		Think_Option(120,"thinkoption"),
		/* lenovo 打印机 */
		Lenovo_Printer(130,"lenovoprinter"),

		/* 懂得非号码商品 */
		DongDe_NO_Number(140,"dongdenonumber"),

		/* 积分商城 */
		SMB_Integral_Mall(150,"smbintegralmall"),
		/* smb直营 */
		SMB_Direct_Market(160,"smbdirectmarket"),
		/* smb代理 */
		SMB_Agent_Market(170,"smbagentmarket"),
		/* 电脑管家 */
		Lenovo_PCSD(180,"PCSD"),
		
		Moto(500, "moto");

		Integer code;
		String name;

		BuOwnerType(Integer code, String name)
		{
			this.code = code;
			this.name = name;
		}

		public Integer getCode()
		{
			return this.code;
		}

		public String getName()
		{
			return this.name;
		}

		public static BuOwnerType valueOf(Integer type)
		{
			switch (type)
			{
				case 10:
					return BuOwnerType.Lenovo_PC;
				case 20:
					return BuOwnerType.Lenovo_MBG;
				case 30:
					return BuOwnerType.Lenovo_Service;
				case 40:
					return BuOwnerType.Lenovo_Pad;
				case 50:
					return BuOwnerType.Lenovo_Think;
				case 70:
					return BuOwnerType.Lenovo_TV;
				case 80:
					return BuOwnerType.Lenovo_Rmodel;
				case 500:
					return BuOwnerType.Moto;
				case 90:
					return BuOwnerType.DongDe;
				case 100:
					return BuOwnerType.Lenovo_MBG_Service;
				case 110:
					return BuOwnerType.Lenovo_Option;
				case 120:
					return BuOwnerType.Think_Option;
				case 130:
					return BuOwnerType.Lenovo_Printer;
				case 140:
					return BuOwnerType.DongDe_NO_Number;
				case 150:
					return BuOwnerType.SMB_Integral_Mall;
				case 160:
					return BuOwnerType.SMB_Direct_Market;
				case 170:
					return BuOwnerType.SMB_Agent_Market;
				case 0:
					return BuOwnerType.Lenovo_None;
				default:
					return BuOwnerType.Lenovo_PC;
			}
		}

	}

	public enum MallType
	{
		Lenovo(1, "Lenovo商城"), Think(2, "Think商城"), EPP(3, "EPP商城"), Roaming(4, "Roaming商城"), MOTO(5,
				"MOTO商城"), DongDe(6, "懂得商城"), ThinkCenter(7, "Think产品中心"),SMB(8,"17商城"),SMBJF(9,"17积分商城");

		private Integer code;

		private String name;

		MallType(Integer code, String name)
		{
			this.code = code;
			this.name = name;
		}

		public Integer getCode()
		{
			return this.code;
		}

		public String getName()
		{
			return this.name;
		}

		public static MallType valueOf(int code)
		{
			switch (code)
			{
			case 1:
				return Lenovo;
			case 2:
				return Think;
			case 3:
				return EPP;
			case 4:
				return Roaming;
			case 5:
				return MOTO;
			case 6:
				return DongDe;
			case 7:
				return ThinkCenter;
			case 8:
				return SMB;
			case 9:
				return SMBJF;
			default:
				return Lenovo;
			}
		}

		public static Platform[] getPlatforms(Integer code)
		{
			switch (code)
			{
			case 1:
				return new Platform[] { Platform.Lenovo_PC, Platform.Lenovo_WAP, Platform.Lenovo_APP,
						Platform.Lenovo_WX };
			case 2:
				return new Platform[] { Platform.Think_PC, Platform.Think_WAP };
			case 3:
				return new Platform[] { Platform.EPP_PC, Platform.EPP_WAP };
			case 7:
				return new Platform[] { Platform.Think_Product };
			default:
				return new Platform[] {};
			}
		}

		public static MallType getMallType(Platform pl)
		{
			switch (pl)
			{
			case Lenovo_PC:
			case Lenovo_WAP:
			case Lenovo_APP:
			case Lenovo_WX:
				return Lenovo;
			case Think_PC:
			case Think_WAP:
				return MallType.Think;
			case Think_Product:
				return ThinkCenter;
			case EPP_PC:
			case EPP_WAP:
				return EPP;
			default:
				return null;
			}
		}

	}

	public enum SalesPlat
	{

		PC(1, "PC端"), WAP(2, "移动端"), APP(3, "APP端"), WeiXin(4, "微信"), NONE(0, "");

		private Integer code;
		private String name;

		SalesPlat(Integer code, String name)
		{
			this.code = code;
			this.name = name;
		}

		public Integer getCode()
		{
			return this.code;
		}

		public String getName()
		{
			return this.name;
		}

		public static SalesPlat valueOf(int code)
		{
			switch (code)
			{
			case 1:
				return PC;
			case 2:
				return WAP;
			case 3:
				return APP;
			case 4:
				return WeiXin;
			default:
				return PC;
			}
		}

		public static SalesPlat getSalePlat(Integer platCode)
		{
			switch (platCode)
			{
			case 1:
			case 5:
			case 20:
				return SalesPlat.WAP;
			case 2:
				return SalesPlat.WeiXin;
			case 3:
				return SalesPlat.APP;
			case 4:
			case 8:
			case 22:
				return SalesPlat.PC;
			default:
				return SalesPlat.NONE;
			}
		}

		public static Platform getPlatForm(Integer mallType, Integer salesPlat)
		{
			BigPlatform bigPlat = BigPlatform.getBigPlatform(valueOf(salesPlat));
			Platform[] platforms = MallType.getPlatforms(mallType);
			for (Platform plat : platforms)
			{
				Platform[] bigPlatform = bigPlat.getPlatforms();
				for (Platform bPlat : bigPlatform)
				{
					if (plat.getCode().equals(bPlat.getCode()))
					{
						return plat;
					}
				}
			}
			return Platform.Lenovo_PC;
		}

	}

	public enum PicDomain
	{
		PicDomain1(1, "http://pic.shop.lenovo.com.cn/g1"), PicDomain2(2,
				"http://pic.shop.lenovo.com.cn/g1"), PicDomain3(3, "http://pic.shop.lenovo.com.cn/g1"), PicDomain4(4,
						"http://pic.shop.lenovo.com.cn/g1");

		private Integer code;
		private String domain;

		PicDomain(Integer code, String domain)
		{
			this.code = code;
			this.domain = domain;
		}

		public Integer getCode()
		{
			return this.code;
		}

		public String getDomain()
		{
			return domain;
		}

		public static PicDomain valueOf(int code)
		{
			switch (code)
			{
			case 1:
				return PicDomain.PicDomain1;
			case 2:
				return PicDomain.PicDomain2;
			case 3:
				return PicDomain.PicDomain3;
			case 4:
				return PicDomain.PicDomain4;

			default:
				return PicDomain.PicDomain1;
			}
		}

	}

	public enum ChannelEnum
	{

		LENOVOPC("01", "lenovo PC", "pc频道"), THINK("02", "think产品", "think频道"), LENOVOMOBILE("03", "lenovo手机",
				"手机频道"), SERVICE("04", "我要服务", "服务频道"), EPPPC("05", "EPP PC", "epp pc频道");

		private ChannelEnum(String id, String name, String desc)
		{
			this.id = id;
			this.cname = name;
			this.desc = desc;
		}

		private String id;
		private String cname;
		private String desc;

		public String getId()
		{
			return id;
		}

		public void setId(String id)
		{
			this.id = id;
		}

		public String getDesc()
		{
			return desc;
		}

		public void setDesc(String desc)
		{
			this.desc = desc;
		}

		public String getCname()
		{
			return cname;
		}

		public void setCname(String cname)
		{
			this.cname = cname;
		}
	}

	public enum StockResult
	{

		STOCK_SUCCESS("1000", "操作成功"), STOCK_NOTHINH("1001", "库存不存在"), STOCK_MORE("1002", "存在多条库存"), STOCK_EMPTY("1003",
				"参数有误"), STOCK_SHORT("1004", "库存数量不满足"), STOCK_NOT_MEET("1005", "操作条件不满足"), STOCK_OUT_TIME("1006",
						"库存操作超时"), STOCK_FAIL("1007", "库存操作失败"), STOCK_REPEAT("1008", "重复操作"), STOCK_EXCEED("1009",
								"超出库存上限"), ORDER_STATE_INVALID("1009", "订单状态无效"), ORDER_SUBMIT_REPEAT("1010",
										"订单重复提交"), FIND_ADDRESS_NULL("1011", "地址查询为空"), ADDRESS_ERROR("1012",
												"地址查询异常"), FIND_WAREHOUSE_NULL("1013", "无此库存地信息"), FIND_WAREHOUSE_EXIST(
														"1014", "库存地信息已经存在"), STOCK_ERROR("9999", "库存发生异常");

		public String name;
		public String code;

		StockResult(String code, String name)
		{
			this.code = code;
			this.name = name;
		}

		public String getEnumName(String code)
		{
			switch (code)
			{
			case "1000":
				return STOCK_SUCCESS.name;
			case "1001":
				return STOCK_NOTHINH.name;
			case "1002":
				return STOCK_MORE.name;
			case "1003":
				return STOCK_EMPTY.name;
			case "1004":
				return STOCK_SHORT.name;
			case "1005":
				return STOCK_NOT_MEET.name;
			case "1006":
				return STOCK_OUT_TIME.name;
			case "1007":
				return STOCK_FAIL.name;
			case "1008":
				return STOCK_REPEAT.name;
			case "1009":
				return ORDER_SUBMIT_REPEAT.name;
			case "1010":
				return STOCK_SUCCESS.name;
			case "1011":
				return FIND_ADDRESS_NULL.name;
			case "1012":
				return ADDRESS_ERROR.name;
			case "1013":
				return FIND_WAREHOUSE_NULL.name;
			case "1014":
				return FIND_WAREHOUSE_EXIST.name;
			case "9999":
				return STOCK_ERROR.name;
			default:
				return "";
			}
		}

	}

	/**
	 * 是否失效
	 *
	 */
	public enum Disabled
	{
		NO(0, "不失效"), YES(1, "失效");

		Integer code;

		String name;

		Disabled(Integer code, String name)
		{
			this.code = code;
			this.name = name;

		}

		public static Disabled valueOf(int code)
		{
			switch (code)
			{
			case 0:
				return NO;
			case 1:
				return YES;
			default:
				return NO;
			}
		}

		public String getName()
		{
			return this.name;
		}

		public Integer getCode()
		{
			return this.code;
		}
	}

	/**
	 * 规格显示方式
	 *
	 */
	public enum DisplayMode
	{
		pingpu(0, "平铺"), xiala(1, "下拉");

		Integer code;

		String name;

		DisplayMode(Integer code, String name)
		{
			this.code = code;
			this.name = name;

		}

		public static DisplayMode valueOf(int code)
		{
			switch (code)
			{
			case 0:
				return pingpu;
			case 1:
				return xiala;
			default:
				return pingpu;
			}
		}

		public String getName()
		{
			return this.name;
		}

		public Integer getCode()
		{
			return this.code;
		}
	}

	/**
	 *
	 * 规格显示类型
	 *
	 */
	public enum DisplayType
	{
		wenzi(0, "文字"), tupian(1, "图片");

		Integer code;

		String name;

		DisplayType(Integer code, String name)
		{
			this.code = code;
			this.name = name;

		}

		public static DisplayType valueOf(int code)
		{
			switch (code)
			{
			case 0:
				return wenzi;
			case 1:
				return tupian;
			default:
				return wenzi;
			}
		}

		public String getName()
		{
			return this.name;
		}

		public Integer getCode()
		{
			return this.code;
		}
	}

	/**
	 *
	 * 业务类型
	 *
	 */
	public enum BusinessType
	{
		computer(0, "电脑"), phone(1, "手机"), service(2, "服务");

		Integer code;

		String name;

		BusinessType(Integer code, String name)
		{
			this.code = code;
			this.name = name;
		}

		public static BusinessType valueOf(int code)
		{
			switch (code)
			{
			case 0:
				return computer;
			case 1:
				return phone;
			case 2:
				return service;
			default:
				return computer;
			}
		}

		public String getName()
		{
			return this.name;
		}

		public Integer getCode()
		{
			return this.code;
		}
	}

	/**
	 *
	 * 审核 状态
	 *
	 */
	public enum CheckStatus
	{
		newStatus(0, "新建"), reject(1, "审核未通过"), posted(2, "审核通过"), notCheck(3, "未审核");

		Integer code;
		String name;

		CheckStatus(Integer code, String name)
		{
			this.code = code;
			this.name = name;
		}

		public static CheckStatus valueOf(int code)
		{
			switch (code)
			{
			case 0:
				return newStatus;
			case 1:
				return reject;
			case 2:
				return posted;
			case 3:
				return notCheck;
			default:
				return newStatus;
			}
		}

		public String getName()
		{
			return this.name;
		}

		public Integer getCode()
		{
			return this.code;
		}
	}

	/**
	 *
	 * 绑定 状态
	 *
	 */
	public enum BindStatus
	{
		relation(0, "已绑定（待上架）"), delete(1, "已解绑（待上架）"), modify(2, "已绑定"), determine(3, "已修改（待上架）");// 服务已修改

		Integer code;
		String name;

		BindStatus(Integer code, String name)
		{
			this.code = code;
			this.name = name;
		}

		public String getName()
		{
			return this.name;
		}

		public Integer getCode()
		{
			return this.code;
		}

		public static BindStatus valueOf(int code)
		{
			switch (code)
			{
			case 1:
				return delete;
			case 2:
				return modify;
			case 3:
				return determine;
			default:
				return modify;

			}
		}
	}

	/**
	 * 枚举是与否
	 *
	 * @author chenjq5
	 *
	 */
	public enum TrueOrFalse
	{
		True(1, "是"), False(0, "否");

		String name;
		Integer code;

		TrueOrFalse(Integer code, String name)
		{
			this.name = name;
			this.code = code;
		}

		public String getName()
		{
			return this.name;
		}

		public Integer getCode()
		{
			return this.code;
		}

		public static TrueOrFalse valueOf(int code)
		{
			switch (code)
			{
			case 0:
				return False;
			case 1:
				return True;
			default:
				return False;
			}
		}
	}

	/**
	 *
	 * 运营商
	 *
	 */
	public enum Operators
	{
		ChinaMobile(1, "中国移动"), ChinaUnicom(2, "中国联通"), ChinaTelecom(3, "中国电信");

		Integer code;

		String name;

		Operators(Integer code, String name)
		{
			this.code = code;
			this.name = name;

		}

		public static Operators valueOf(int code)
		{
			switch (code)
			{

			case 1:
				return ChinaMobile;
			case 2:
				return ChinaUnicom;
			case 3:
				return ChinaTelecom;
			default:
				return ChinaMobile;
			}
		}

		public String getName()
		{
			return this.name;
		}

		public Integer getCode()
		{
			return this.code;
		}
	}

	public enum TempalteType
	{
		NO_Group(0, "无分组"),
		Service(1, "服务"),
		Pomotion(2, "促销"),
		Coupon(3, "优惠券"),
		Think_O2O(4, "think_o2o"),
		Think_Center_Ordinary_Goods(5, "Think产品中心普通商品"),
		Think_Center_Service_Goods(6, "Think产品中心服务&配件"),
		Specifications(7, "规格"),
		Win_Pic(8, "橱窗图"),
		Goods_Base_Info(9, "商品基础信息"),
		Header(10, "详情页header"),
		Data_Init(11, "初始化数据碎片"),
		Crumbs(12, "面包屑"),
		Product_Confit_Info(13, "商品配置信息"),
		Product_Detail_Info(14, "商品详情信息"),
		Product_Customization_Characteristics(15, "商品定制特性"),
		Product_Detail_Evaluate_Tab(16, "商品详情配置评价tab"),
		By_Stages(17, "分期文案"),
		Personal_Tailor(18, "私人订制"),
		Product_Detail_Frame(19, "详情页框架-detail"),
		Seo_Comment(20,"seo评论");


		private Integer code;
		private String comment;

		TempalteType(Integer code, String comment)
		{
			this.code = code;
			this.comment = comment;
		}

		public Integer getCode()
		{
			return this.code;
		}

		public String getComment()
		{
			return comment;
		}

		public static TempalteType valueOf(int code)
		{
			switch (code)
			{
			case 0:
				return TempalteType.NO_Group;
			case 1:
				return TempalteType.Service;
			case 2:
				return TempalteType.Pomotion;
			case 3:
				return TempalteType.Coupon;
			case 4:
				return TempalteType.Think_O2O;
			case 5:
				return TempalteType.Think_Center_Ordinary_Goods;
			case 6:
				return TempalteType.Think_Center_Service_Goods;
			case 7:
				return TempalteType.Specifications;
			case 8:
				return TempalteType.Win_Pic;
			case 9:
				return TempalteType.Goods_Base_Info;
			case 10:
				return TempalteType.Header;
			case 11:
				return TempalteType.Data_Init;
			case 12:
				return TempalteType.Crumbs;
			case 13:
				return TempalteType.Product_Confit_Info;
			case 14:
				return TempalteType.Product_Detail_Info;
			case 15:
				return TempalteType.Product_Customization_Characteristics;
			case 16:
				return TempalteType.Product_Detail_Evaluate_Tab;
			case 17:
				return TempalteType.By_Stages;
			case 18:
				return TempalteType.Personal_Tailor;
			case 19:
				return TempalteType.Product_Detail_Frame;
			case 20:
				return TempalteType.Seo_Comment;

			default:
				return TempalteType.NO_Group;
			}
		}
	}
	
	public enum DetailTempalteType
	{
		Goods_detail(1, "商品详情页"),
		Series(2, "系列详情页");


		private Integer code;
		private String comment;

		DetailTempalteType(Integer code, String comment)
		{
			this.code = code;
			this.comment = comment;
		}

		public Integer getCode()
		{
			return this.code;
		}

		public String getComment()
		{
			return comment;
		}

		public static DetailTempalteType valueOf(int code)
		{
			switch (code)
			{
			case 1:
				return DetailTempalteType.Goods_detail;
			case 2:
				return DetailTempalteType.Series;

			default:
				return DetailTempalteType.Goods_detail;
			}
		}
	}
	
	public enum ServiceType{
		
		Normal(0,"普通商品"),Normal_Service(1,"普通服务商品"),Service_Number(2,"服务码商品"),XiaoXin_CloudDisk(3,"小新云盘服务");
		
		private Integer code;
		private String name;
		
		ServiceType(Integer code,String name){
			this.code = code;
			this.name = name;
		}

		public Integer getCode() {
			return code;
		}

		public String getName() {
			return name;
		}
		
		public static ServiceType valueOf(int code){
			switch(code){
			case 0:
				return ServiceType.Normal;
			case 1:
				return ServiceType.Normal_Service;
			case 2:
				return ServiceType.Service_Number;
			case 3:
				return ServiceType.XiaoXin_CloudDisk;
			default :
				return ServiceType.Normal;
			}
		}
		
	}

}
