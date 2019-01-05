import com.guocai.mp.mybatis.entity.Table;
import com.guocai.mp.mybatis.mapper.TableMapper;
import com.guocai.mp.mybatis.util.Constants;
import com.guocai.mp.mybatis.util.GeneratorUtil;
import com.guocai.mp.mybatis.util.MapperMethodSwitch;
import com.guocai.mp.mybatis.util.StringUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.velocity.VelocityContext;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java类简单作用描述
 *
 * @ClassName: TestMybatis
 * @Package: PACKAGE_NAME
 * @Description: < 快速生成前后端代码 >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/7/27 20:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TestMybatis {

	public static void main(String[] args) {
		// testByMyCustomize("PES_","PES_MAT_MATERIAL","myClass.mat","MyMatMaterial");
		test("PES_","PES_PRO_BASK_RECORD","信息表");
	}

	MapperMethodSwitch methodSwitch = new MapperMethodSwitch();


	public MapperMethodSwitch getMethodSwitch() {
		return methodSwitch;
	}



	public void setMethodSwitch(MapperMethodSwitch methodSwitch) {
		this.methodSwitch = methodSwitch;
	}

	public static void test(String fileSurfixName,String tableName,String tableDesc){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession session = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =
					new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println(sqlSessionFactory);
			session = sqlSessionFactory.openSession();
			TableMapper mapper = session.getMapper(TableMapper.class);
			System.out.println("mapper = " + mapper);
			Map<String,Object> map = new HashMap<String,Object>();

			map.put("tablePrefix",fileSurfixName);
			map.put("tableName",tableName);
			List<Table> tables = mapper.getTablesByPrefix(map);
			for (Table table : tables) {
				table.setTablePrefix(fileSurfixName);
				table.setTableName(table.getTableName());
				System.out.println("table--->" + table);
				if (StringUtil.isNotEmpty(tableDesc)) {
					table.setTableDesc(tableDesc);
				}
			}
			TestMybatis myThis = new TestMybatis();

			//String templateRelativePath = "ExtJsStoreTemplate.vm";

			/*String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
					Constants.JAVA_BASE_PATH + Constants.FILE_SEPERATOR;
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			//生成ExtJs Store文件
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			System.out.println("entityContent = " + entityContent);
			String path = basePath +  "store" + Constants.FILE_SEPERATOR +
					t.getModuleName() + Constants.FILE_SEPERATOR +
					t.getFirstLetterLowerEntityName() + Constants.FILE_SEPERATOR;
			System.out.println("path = " + path);
			String fileName = t.getEntityName() + "store";
			System.out.println("fileName = " + fileName);
			GeneratorUtil.writeFile(entityContent, path, fileName, true);*/
			myThis.generateEntity(tables, "EntityTemplate.vm", ".java");
			myThis.generateController(tables, "ControllerTemplate.vm", "Controller.java");
			myThis.generateJavaMapper(tables, "MapperTemplate.vm",  "Mapper.java");
			myThis.generateService(tables, "ServiceTemplate.vm", "Service.java");
			myThis.generateServiceImpl(tables, "ServiceImplTemplate.vm", "ServiceImpl.java");
			myThis.generateXMLMapper(tables, "XmlMapperTemplate.vm", "Mapper.xml");
//		this.generateGeneratorConfig(tables);
//		this.generatePackageInfo(tables);   ---struts2架构需要

			myThis.generateI18nTranslations(tables);
			myThis.generateExtJsStore(tables, "ExtJsStoreTemplate.vm", "Store.js");
			myThis.generateExtJsModel(tables, "ExtJsModelTemplate.vm", "Model.js");
			myThis.generateExtJsView(tables, "ExtJsViewTemplate.vm", "View.js");
			myThis.generateExtJsQueryForm(tables, "ExtJsQueryFormTemplate.vm", "QueryForm.js");
			myThis.generateExtJsListGrid(tables, "ExtJsListGridTemplate.vm", "ListGrid.js");
			myThis.generateExtJsViewController(tables, "ExtJsViewControllerTemplate.vm", "Controller.js");
			myThis.generateExtJsWindow(tables, "ExtJsWindowTemplate.vm", "Win.js");
			myThis.generateExtJsWinController(tables, "ExtJsWinViewControllerTemplate.vm", "WinController.js");


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

// 	public static void testByMyCustomize(String fileSurfixName,String tableName,String myPath,String entiyName){
// 		String resource = "mybatis-config.xml";
// 		InputStream inputStream = null;
// 		SqlSession session = null;
// 		try {
// 			inputStream = Resources.getResourceAsStream(resource);
// 			SqlSessionFactory sqlSessionFactory =
// 					new SqlSessionFactoryBuilder().build(inputStream);
// 			System.out.println(sqlSessionFactory);
// 			session = sqlSessionFactory.openSession();
// 			TableMapper mapper = session.getMapper(TableMapper.class);
// 			System.out.println("mapper = " + mapper);
// 			Map<String,Object> map = new HashMap.java<String,Object>();
//
// 			map.put("tablePrefix",fileSurfixName);
// 			map.put("tableName",tableName);
// 			List<Table> tables = mapper.getTablesByPrefix(map);
// 			for (Table table : tables) {
// 				table.setTablePrefix(fileSurfixName);
// 				table.setTableName(table.getTableName());
// 				if(StringUtil.isNotEmpty(myPath)){
// 					table.setEntityPackage("com.sgai."+myPath+".entity");
// 					table.setControllerPackage("com.sgai."+myPath+".controller");
// 					table.setServicePackage("com.sgai."+myPath+".service");
// 					table.setJavaMapperPackage("com.sgai."+myPath+".mapper");
// 					table.setXmlMapperPackage("com.sgai."+myPath+".mapper");
// 					table.setServiceImplPackage("com.sgai."+myPath+".service.impl");
//
// 				}
// 				table.setEntityName(entiyName);
// 				System.out.println("table--->" + table);
// 			}
// 			TestMybatis myThis = new TestMybatis();
// 			//String templateRelativePath = "ExtJsStoreTemplate.vm";
//
// 			/*String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
// 					Constants.JAVA_BASE_PATH + Constants.FILE_SEPERATOR;
// 			VelocityContext velocityCtx = new VelocityContext();
// 			velocityCtx.put("table", t);
// 			velocityCtx.put("Author", Constants.AUTHOR);
// 			velocityCtx.put("Version", Constants.VERSION);
// 			velocityCtx.put("Date", Constants.GENERATE_DATE);
// 			//生成ExtJs Store文件
// 			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
// 			System.out.println("entityContent = " + entityContent);
// 			String path = basePath +  "store" + Constants.FILE_SEPERATOR +
// 					t.getModuleName() + Constants.FILE_SEPERATOR +
// 					t.getFirstLetterLowerEntityName() + Constants.FILE_SEPERATOR;
// 			System.out.println("path = " + path);
// 			String fileName = t.getEntityName() + "store";
// 			System.out.println("fileName = " + fileName);
// 			GeneratorUtil.writeFile(entityContent, path, fileName, true);*/
// 			myThis.generateEntity(tables, "EntityTemplate.vm", ".java");
// 			myThis.generateController(tables, "ControllerTemplate.vm", "Controller.java");
// 			myThis.generateJavaMapper(tables, "MapperTemplate.vm",  "Mapper.java");
// 			myThis.generateService(tables, "ServiceTemplate.vm", "Service.java");
// 			myThis.generateServiceImpl(tables, "ServiceImplTemplate.vm", "ServiceImpl.java");
// 			myThis.generateI18nTranslations(tables);
// 			myThis.generateXMLMapper(tables, "XmlMapperTemplate.vm", "Mapper.xml");
// //		this.generateGeneratorConfig(tables);
// //		this.generatePackageInfo(tables);   ---struts2架构需要
//
// 			myThis.generateExtJsStore(tables, "ExtJsStoreTemplate.vm", "Store.js");
// 			myThis.generateExtJsModel(tables, "ExtJsModelTemplate.vm", "Model.js");
// 			myThis.generateExtJsView(tables, "ExtJsViewTemplate.vm", "View.js");
// 			myThis.generateExtJsQueryForm(tables, "ExtJsQueryFormTemplate.vm", "QueryForm.js");
// 			myThis.generateExtJsListGrid(tables, "ExtJsListGridTemplate.vm", "ListGrid.js");
// 			myThis.generateExtJsViewController(tables, "ExtJsViewControllerTemplate.vm", "Controller.js");
// 			myThis.generateExtJsWindow(tables, "ExtJsWindowTemplate.vm", "Win.js");
// 			myThis.generateExtJsWinController(tables, "ExtJsWinViewControllerTemplate.vm", "WinController.js");
//
//
// 		} catch (IOException e) {
// 			e.printStackTrace();
// 		} finally {
// 			session.close();
// 		}
//
// 	}


	/**
	 * 生成Java实体
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateEntity(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.JAVA_BASE_PATH + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath  + t.getEntityPackage().replace(".",  Constants.FILE_SEPERATOR);
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}
	/**
	 * 生成Controller
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateController(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.JAVA_BASE_PATH + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath +  t.getControllerPackage().replace(".",  Constants.FILE_SEPERATOR);
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}
	/**
	 * 生成Java Mapper
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateJavaMapper(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.JAVA_BASE_PATH + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath +  t.getJavaMapperPackage().replace(".",  Constants.FILE_SEPERATOR);
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}
	/**
	 * 生成Service
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateService(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.JAVA_BASE_PATH + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath +  t.getServicePackage().replace(".",  Constants.FILE_SEPERATOR);
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}
	/**
	 * 生成Service Implements
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateServiceImpl(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.JAVA_BASE_PATH + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath +  t.getServiceImplPackage().replace(".",  Constants.FILE_SEPERATOR);
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}
	/**
	 * 生成I18n国际化配置
	 * @param tables
	 */
	private void generateI18nTranslations(List<Table> tables) {
		String path = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.WEB_APP_BASE + Constants.FILE_SEPERATOR + "translations";

		VelocityContext velocityCtx = new VelocityContext();
		velocityCtx.put("tables", tables);
		velocityCtx.put("Author", Constants.AUTHOR);
		velocityCtx.put("Version", Constants.VERSION);
		velocityCtx.put("Date", Constants.GENERATE_DATE);
		String entityContent = GeneratorUtil.generate(velocityCtx, "TranslationTemplate.vm");
		String fileName = tables.get(0).getEntityName()+"_business-lan-zh_CN.js";
		GeneratorUtil.writeFile(entityContent, path, fileName, true);

	}
	/**
	 * 生成Mybatis XML Mapper
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateXMLMapper(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.XML_MAPPER_BASE + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			velocityCtx.put("methodSwitch", this.getMethodSwitch());
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath +  t.getXmlMapperPackage().replace(".",  Constants.FILE_SEPERATOR);
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}
	/**
	 * 生成GeneratorConfig.xml文件
	 * @param tables
	 */
	private void generateGeneratorConfig(List<Table> tables) {
		VelocityContext velocityCtx = new VelocityContext();
		velocityCtx.put("tables", tables);
		velocityCtx.put("Author", Constants.AUTHOR);
		velocityCtx.put("Version", Constants.VERSION);
		velocityCtx.put("Date", Constants.GENERATE_DATE);
		String path = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR;
		String entityContent = GeneratorUtil.generate(velocityCtx, "GeneratorConfigTemplate.vm");
		String fileName = "generatorConfig.xml";
		GeneratorUtil.writeFile(entityContent, path, fileName, true);
	}
	/**
	 * 生成packege-info.javal文件
	 * @param tables
	 */
	private void generatePackageInfo(List<Table> tables) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.JAVA_BASE_PATH + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			String entityContent = GeneratorUtil.generate(velocityCtx, "PackageInfoTemplate.vm");
			String path = basePath +  t.getControllerPackage().replace(".",  Constants.FILE_SEPERATOR);
			String fileName = "package-info.java";
			GeneratorUtil.writeFile(entityContent, path, fileName, false);
		}
	}
	/**
	 * 生成ExtJs store文件
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateExtJsStore(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.WEB_APP_BASE + Constants.FILE_SEPERATOR + "app" + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			//生成ExtJs Store文件
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath +  "store" + Constants.FILE_SEPERATOR +
					t.getModuleName() + Constants.FILE_SEPERATOR +
					t.getFirstLetterLowerEntityName() + Constants.FILE_SEPERATOR;
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}
	/**
	 * 生成ExtJs model文件
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateExtJsModel(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.WEB_APP_BASE + Constants.FILE_SEPERATOR + "app" + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			//生成ExtJs model文件
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath +  "model" + Constants.FILE_SEPERATOR +
					t.getModuleName() + Constants.FILE_SEPERATOR +
					t.getFirstLetterLowerEntityName() + Constants.FILE_SEPERATOR;
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}
	/**
	 * 生成ExtJs view文件
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateExtJsView(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.WEB_APP_BASE + Constants.FILE_SEPERATOR + "app" + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			//生成ExtJs View文件
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath +  "view" + Constants.FILE_SEPERATOR +
					t.getModuleName() + Constants.FILE_SEPERATOR +
					t.getFirstLetterLowerEntityName() + Constants.FILE_SEPERATOR;
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}
	/**
	 * 生成ExtJs query form文件
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateExtJsQueryForm(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.WEB_APP_BASE + Constants.FILE_SEPERATOR + "app" + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);

			//生成ExtJs query form文件
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath +  "view" + Constants.FILE_SEPERATOR +
					t.getModuleName() + Constants.FILE_SEPERATOR +
					t.getFirstLetterLowerEntityName() + Constants.FILE_SEPERATOR;
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}
	/**
	 * 生成ExtJs list grid文件
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateExtJsListGrid(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.WEB_APP_BASE + Constants.FILE_SEPERATOR + "app" + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			//生成ExtJs list grid文件
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath +  "view" + Constants.FILE_SEPERATOR +
					t.getModuleName() + Constants.FILE_SEPERATOR +
					t.getFirstLetterLowerEntityName() + Constants.FILE_SEPERATOR;
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}
	/**
	 * 生成ExtJs view controller文件
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateExtJsViewController(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.WEB_APP_BASE + Constants.FILE_SEPERATOR + "app" + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			//生成ExtJs view controller文件
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath +  "view" + Constants.FILE_SEPERATOR +
					t.getModuleName() + Constants.FILE_SEPERATOR +
					t.getFirstLetterLowerEntityName() + Constants.FILE_SEPERATOR;
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}
	/**
	 * 生成ExtJs文件
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateExtJsWindow(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.WEB_APP_BASE + Constants.FILE_SEPERATOR + "app" + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			//生成ExtJs Window文件
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath +  "view" + Constants.FILE_SEPERATOR +
					t.getModuleName() + Constants.FILE_SEPERATOR +
					t.getFirstLetterLowerEntityName() + Constants.FILE_SEPERATOR;
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}
	/**
	 * 生成ExtJs文件
	 * @param tables
	 * @param templateRelativePath
	 * @param fileSurfixName
	 */
	private void generateExtJsWinController(List<Table> tables, String templateRelativePath, String fileSurfixName) {
		String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
				Constants.WEB_APP_BASE + Constants.FILE_SEPERATOR + "app" + Constants.FILE_SEPERATOR;
		for (Table t:tables) {
			VelocityContext velocityCtx = new VelocityContext();
			velocityCtx.put("table", t);
			velocityCtx.put("Author", Constants.AUTHOR);
			velocityCtx.put("Version", Constants.VERSION);
			velocityCtx.put("Date", Constants.GENERATE_DATE);
			//生成ExtJs window view controller文件
			String entityContent = GeneratorUtil.generate(velocityCtx, templateRelativePath);
			String path = basePath +  "view" + Constants.FILE_SEPERATOR +
					t.getModuleName() + Constants.FILE_SEPERATOR +
					t.getFirstLetterLowerEntityName() + Constants.FILE_SEPERATOR;
			String fileName = t.getEntityName() + fileSurfixName;
			GeneratorUtil.writeFile(entityContent, path, fileName, true);
		}
	}

}
