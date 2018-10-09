import com.guocai.mp.mybatis.entity.User;
import com.guocai.mp.mybatis.util.Constants;
import com.guocai.mp.mybatis.util.GeneratorUtil;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import org.apache.velocity.VelocityContext;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        File file = new File("E:\\formatExcel\\excel\\example-java-templates.xls");
        List excelList = readExcel(file);
        System.out.println("list中的数据打印出来");
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < excelList.size(); i++) {
            List list = (List) excelList.get(i);
            User user = new User();
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j)+" ");
                if(j==0){
                    user.setName((String) list.get(j));
                } else if (j==1){
                    user.setContent((String) list.get(j));
                } else if (j==2) {
                    user.setType((String) list.get(j));
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
        velocityCtx.put("Author", Constants.AUTHOR);
        velocityCtx.put("Version", Constants.VERSION);
        velocityCtx.put("Date", Constants.GENERATE_DATE);
        String entityContent = GeneratorUtil.generate(velocityCtx, "MessageTemplate.vm");
        String path = basePath  ;
        String fileName = "a.java";
        GeneratorUtil.writeFile(entityContent, path, fileName, true);

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
    public static List readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            // jxl提供的Workbook类
            WorkbookSettings workbookSettings = new WorkbookSettings();
//            可以设置为UTF-8或者GBK或者ISO-8859-1
            workbookSettings.setEncoding("GBK");

            Workbook wb = Workbook.getWorkbook(is,workbookSettings);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                List<List> outerList=new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
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
                return outerList;
            }
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
