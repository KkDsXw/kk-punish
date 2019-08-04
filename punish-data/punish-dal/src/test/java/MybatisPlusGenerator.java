import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * mybatis-plus 自动代码生成
 */
public class MybatisPlusGenerator {
	/**数据库配置*/
	String url = "jdbc:mysql://47.97.189.222:3309/vision?useSSL=false&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
	String username = "root";
	String password = "root_pwd";

	/**多个使用 , 相连*/
	String [] tables = new String [] {"tbl_banned_ip_log"};
	/**基础包名 文件将在这个包下生成*/
	String packageName = "com.bxm.vision.dal";
	/**输出路径*/
	String outputDir = "punish-data\\punish-dal\\src\\test\\java";
	/**作者*/
	String author = "kk.xie";
	/**表前缀替换为空字符*/
	String [] tablePrefix = new String[] {"tbl_"};

	public static void main(String[] args) {
		MybatisPlusGenerator mpg = new MybatisPlusGenerator();
		mpg.executePart();
	}

	public void executePart(){
		//自定义包名，需要生成代码的表集
		generateByTables(packageName, tables);
	}

	private void generateByTables(String packageName, String... tableNames){
		//全局配置
		GlobalConfig config = new GlobalConfig();
		config
				//作者
				.setAuthor(author)
				//开启 Kotlin 模式
//	        .setKotlin(true)
				// 文件生成路径
				.setOutputDir(outputDir)
				// XML 二级缓存
				.setEnableCache(false)
				// XML ResultMap
				.setBaseResultMap(true)
				//自动生成ID
				.setIdType(IdType.INPUT)
				// 不需要ActiveRecord特性的请改为false
				.setActiveRecord(false)
				// XML columList
				.setBaseColumnList(true)
				//mapper类后缀
				.setMapperName("%sMapper")
				//xml后缀
				.setXmlName("%sMapper")
				//service 后缀
				.setServiceName("%sService")
				//serviceImpl 后缀
				.setServiceImplName("%sServiceImpl")
				//是否覆盖已有文件
				.setFileOverride(true);

		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.MYSQL)
				.setUrl(url)
				.setUsername(username)
				.setPassword(password)
				.setDriverName("com.mysql.jdbc.Driver");

		//表--类 策略配置
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig
				//是否大写命名
				.setCapitalMode(true)
				// 此处可以修改为您的表前缀
				.setTablePrefix(tablePrefix)
				//【实体】是否为lombok模型（默认 false）
				.setEntityLombokModel(false)
				//表名、字段名、是否使用下划线命名（默认 false）
				.setDbColumnUnderline(true)
				//下划线转驼峰命名
				.setNaming(NamingStrategy.underline_to_camel)
				//实体类父类
//                .setSuperEntityClass("com.telant.daas.mybatis.entity.BaseEntity")
				//servic父类
//                .setSuperServiceClass("com.telant.daas.mybatis.service.BaseService")
				//serviceImpl 父类
//                .setSuperServiceImplClass("com.telant.daas.mybatis.service.BaseServiceImpl")
				//修改替换成你需要的表名，多个表名传数组
				.setInclude(tableNames);


		//自动生成文件类
		new AutoGenerator()
				//全局配置
				.setGlobalConfig(config)
				//数据源配置
				.setDataSource(dataSourceConfig)
				//表--类策略配置
				.setStrategy(strategyConfig)
				//包名策略配置
				.setPackageInfo(
						new PackageConfig()
								.setParent(packageName)
								.setEntity("model")
								.setMapper("mapper")
								.setService("service")
								.setController("controller")
				).execute();
	}
}
