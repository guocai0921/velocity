import com.guocai.mp.mybatis.entity.User;
import com.guocai.mp.mybatis.util.Constants;
import com.guocai.mp.mybatis.util.GeneratorUtil;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import org.apache.velocity.VelocityContext;

import java.io.*;
import java.util.*;

/**
 * java类简单作用描述
 *
 * @ClassName: ExcelFormatEntity
 * @Package: PACKAGE_NAME
 * @Description: 由Excel转换成java实体类
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2018-10-09-20:37
 */
public class ExcelFormatEntity {

    public static void main(String[] args) {
        format("E:\\formatExcel\\excel\\example-java-templates.xls","com.sgai.message.lg.qm");


    }

    public static void format(String filePath,String packagePath) {
        File file = new File(filePath);
        List<Map> excelList = readExcel(file);
        for (Map map:excelList) {
            String sheetName = (String) map.get("sheetName");
            List list = (List) map.get("list");
            System.out.println(sheetName);
            System.out.println(list);
            List<User> users = new ArrayList<User>();
            for (int i = 0; i <list.size(); i++) {
                List lists = (List) list.get(i);
                User user = new User();
                for (int j = 0; j < lists.size(); j++) {
                    System.out.print(lists.get(j)+" ");
                    if(j==0){
                        user.setName((String) lists.get(j));
                    } else if (j==1){
                        user.setContent((String) lists.get(j));
                    } else if (j==2) {
                        user.setType((String) lists.get(j));
                    }

                }
                users.add(user);
                System.out.println();
            }
            for (User user : users) {
                user.setLowerField(lowerCaseField(user.getName()));
                user.setUpperField(upperCaseField(user.getName()));
                if(user.getType().equals("C")){
                    user.setType("String");
                } else if (user.getType().equals("N")) {
                    user.setType("Integer");
                }
                System.out.println("user = " + user);
            }
            String basePath = Constants.TARGET_BASE_PARTH + Constants.FILE_SEPERATOR +
                    Constants.JAVA_BASE_PATH + Constants.FILE_SEPERATOR;
            VelocityContext velocityCtx = new VelocityContext();
            velocityCtx.put("users", users);
            velocityCtx.put("packagePath", packagePath);
            velocityCtx.put("msgName", sheetName.substring(1));
            velocityCtx.put("sheetName", sheetName);
            String entityContent = GeneratorUtil.generate(velocityCtx, "MessageTemplate.vm");
            String path = basePath  ;
            String fileName = sheetName+".java";
            GeneratorUtil.writeFile(entityContent, path, fileName, true);
        }
        System.out.println("list中的数据打印出来");
    }

    public static String  upperCaseField(String str) {
        String s = str.toLowerCase();
        String[] arr = s.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<arr.length;i++) {
            //String concat = arr[i];
            String concat = arr[i].substring(0, 1).toUpperCase().concat(arr[i].substring(1).toLowerCase());
            sb.append(concat);
        }
        return sb.toString();
    }

    public static String  lowerCaseField(String str) {
        String s = str.toLowerCase();
        String[] arr = s.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<arr.length;i++) {
            //String concat = arr[i];
            String concat = arr[i].substring(0, 1).toUpperCase().concat(arr[i].substring(1).toLowerCase());
            sb.append(concat);
        }
        String a = sb.toString();
        return a.substring(0,1).toLowerCase().concat(a.substring(1));
    }

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public static List<Map> readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            // jxl提供的Workbook类
            WorkbookSettings workbookSettings = new WorkbookSettings();
//            可以设置为UTF-8或者GBK或者ISO-8859-1
            workbookSettings.setEncoding("GBK");

            Workbook wb = Workbook.getWorkbook(is,workbookSettings);
            List<Map> sheetList=new ArrayList<Map>();
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                Map<String,Object> map=new HashMap<String,Object>();
                List<List> outerList=new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                String sheetName = sheet.getName();
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    List innerList=new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        innerList.add(cellinfo);
                        System.out.print(cellinfo);
                    }
                    outerList.add(i, innerList);
                    System.out.println();
                }
                map.put("sheetName",sheetName);
                map.put("list",outerList);
                sheetList.add(map);
            }
            return sheetList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
