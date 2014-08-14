package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.entity.ImportExcel;

public class AnalyseAction
{
    
    public AnalyseAction()
    {
        super();
    }
    
    // 获取显示excel 的信息
    public String getDetail(HttpServletRequest request, HttpServletResponse response)
    {
        // 获得第几张sheet
        int sheetId = Integer.parseInt(request.getParameter("sheetId"));
        String fileName = "";
        try
        {
            // 获得文件名
            fileName = new String((request.getParameter("fileName")).getBytes("ISO-8859-1"), "UTF-8");
            // 获得文件对象
            File file = new File(request.getSession().getServletContext().getRealPath("/Compare/" + fileName));
            
            // 调用方法获得要显示的数据
            String data = readExcelDetail(sheetId, file, fileName, null, null);
            // 设置输出编码格式是UTF-8 防止乱码
            response.setCharacterEncoding("UTF-8");
            
            PrintWriter out = response.getWriter();
            
            out.println(data);
            out.flush();
            out.close();
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "ajax";
        
    }
    
    public String getDataByDate(HttpServletRequest request, HttpServletResponse response)
    {
        String fileName = "";
        try
        {
            fileName = new String((request.getParameter("fileName")).getBytes("ISO-8859-1"), "UTF-8");
            int index = Integer.parseInt(request.getParameter("index"));
            String start = request.getParameter("start");
            String end = request.getParameter("end");
            File file = new File(request.getSession().getServletContext().getRealPath("/Compare/" + fileName));
            String data = readExcelDetail(index, file, fileName, start, end);
            response.setCharacterEncoding("UTF-8");
            
            PrintWriter out = response.getWriter();
            
            out.println(data);
            out.flush();
            out.close();
            
            
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return "ajax";
    }
    
    private String readExcelDetail(int sheetId, File file, String fileName, String start, String end)
    {
        StringBuffer sb = new StringBuffer();
        boolean rightData = false;
        // 定义表头
        sb.append("<table border='1'  cellpadding='0' cellspacing='0'>");
        try
        {
            // 判断是不是excel 2007
            boolean isE2007 = false;
            if (fileName.endsWith("xlsx"))
            {
                isE2007 = true;
            }
            InputStream imStream = new FileInputStream(file);
            Workbook wb = null;
            // 根据文件格式（2003或者2007）来初始化
            if (isE2007)
            {
                wb = new XSSFWorkbook(imStream);
            }
            else
            {
                wb = new HSSFWorkbook(imStream);
            }
            // 获取某一个sheet
            Sheet sheet = wb.getSheetAt(sheetId);
            // 获取表单迭代器
            Iterator<Row> rows = sheet.rowIterator();
            int i = 0;
            while (rows.hasNext())
            {
                // 如果是表头设置表头格式
                if (i == 0)
                {
                    sb.append("<tr bgcolor='#6699FF'>");
                }
                else
                {
                    // 奇数偶数行分别不同样式
                    if (i % 2 == 0)
                    {
                        sb.append("<tr bgcolor='EEF1F5'>");
                    }
                    else
                    {
                        sb.append("<tr>");
                    }
                    
                }
                // 获得行数据
                Row row = rows.next();
                // System.out.println("Row #" + row.getRowNum()); // 获得行号从0开始
                
                // 定义map 存放数值
                Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器

                while (cells.hasNext())
                {
                    Cell cell = cells.next();
                    // 如果是标题那么都剧中使用ListTitle 样式
                    if (i == 0)
                    {
                        sb.append("<td width align='center' class='ListTitle' nowrap>");
                        switch (cell.getCellType())
                        {
                            case HSSFCell.CELL_TYPE_STRING:
                                sb.append(cell.getStringCellValue());
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                sb.append(String.valueOf(cell.getNumericCellValue()));
                                break;
                            case HSSFCell.CELL_TYPE_BOOLEAN:
                                sb.append(String.valueOf(cell.getBooleanCellValue()));
                                break;
                            case HSSFCell.CELL_TYPE_BLANK:
                                sb.append("empty");
                        }
                        sb.append("</td>");
                    }
                    
                    else if (start== null || end ==null)
                    {
                       
                        sb.append("<td width='' align='left' class='textS2' nowrap>");
                        switch (cell.getCellType())
                        {
                            case HSSFCell.CELL_TYPE_STRING:
                                sb.append(cell.getStringCellValue());
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                sb.append(String.valueOf(cell.getNumericCellValue()));
                                break;
                            case HSSFCell.CELL_TYPE_BOOLEAN:
                                sb.append(String.valueOf(cell.getBooleanCellValue()));
                                break;
                            case HSSFCell.CELL_TYPE_BLANK:
                                sb.append("&nbsp;");
                        }
                        sb.append("</td>");
                    }
                    // 需要比较时间
                    else
                    {
                        Cell dataecell = row.getCell(8);
                        String value = "";
                        int date=0;
                        int startDate = Integer.parseInt(start.replaceAll("-",""));
                        int endDate = Integer.parseInt(end.replaceAll("-",""));
                            
                        switch (dataecell.getCellType())
                        {
                            case HSSFCell.CELL_TYPE_STRING:
                                value = dataecell.getStringCellValue();
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                value = String.valueOf(dataecell.getNumericCellValue());
                                break;
                            case HSSFCell.CELL_TYPE_BOOLEAN:
                                value = String.valueOf(dataecell.getBooleanCellValue());
                                break;
                            case HSSFCell.CELL_TYPE_BLANK:
                                value = "&nbsp;";
                         }
                        if(value=="&nbsp;")
                        {
                            break;
                        }
                        date = Integer.parseInt(value.substring(1, 9));
                        if( startDate<=date && date<=endDate)
                        {                         
                        
                        sb.append("<td width='' align='left' class='textS2' nowrap>");

                            switch (cell.getCellType())
                            {
                                case HSSFCell.CELL_TYPE_STRING:
                                    sb.append(cell.getStringCellValue());
                                    break;
                                case HSSFCell.CELL_TYPE_NUMERIC:
                                    sb.append(String.valueOf(cell.getNumericCellValue()));
                                    break;
                                case HSSFCell.CELL_TYPE_BOOLEAN:
                                    sb.append(String.valueOf(cell.getBooleanCellValue()));
                                    break;
                                case HSSFCell.CELL_TYPE_BLANK:
                                    sb.append("&nbsp;");
                            }   
                            sb.append("</td>");
                        }


                    }
                }
                i++;
                sb.append("</tr>");
            }
            // 表尾部追加 表头
            sb.append("<tr bgcolor='#6699FF'> ");
            Row row = sheet.getRow(0);
            Iterator<Cell> cells = row.cellIterator();
            while (cells.hasNext())
            {
                Cell cell = cells.next();
                // 如果是标题那么都剧中使用ListTitle 样式
                sb.append("<td width align='center' class='ListTitle' nowrap>");
                switch (cell.getCellType())
                {
                    case HSSFCell.CELL_TYPE_STRING:
                        sb.append(cell.getStringCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_NUMERIC:
                        sb.append(String.valueOf(cell.getNumericCellValue()));
                        break;
                    case HSSFCell.CELL_TYPE_BOOLEAN:
                        sb.append(String.valueOf(cell.getBooleanCellValue()));
                        break;
                    case HSSFCell.CELL_TYPE_BLANK:
                        sb.append("--");
                }
                sb.append("</td>");
            }
            sb.append("</tr></table>");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    public String analyseExcel(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession(true);
        
        String fileName = "";
        String flg = "";
        try
        {
            // 通过new String 获取正确的文件名
            fileName = new String((request.getParameter("fileName")).getBytes("ISO-8859-1"), "UTF-8");
            flg = new String((request.getParameter("flg")).getBytes("ISO-8859-1"), "UTF-8");
            // 通过服务器路径 找到正确的文件
            
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        
        File file = new File(request.getSession().getServletContext().getRealPath("/Compare/" + fileName));
        if ("first".equals(flg))
        {
            
        }
        List lstExcel = readExportExcel(fileName, file);
        session.setAttribute("maps", lstExcel);
        
        return "ajax";
    }
    
    // 获取文件进行保存到List集合中
    public String analyseFiles(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession(true);
        String exportFileName = "";
        String importFileName = "";
        try
        {
            // 通过new String 获取正确的文件名
            exportFileName = new String((request.getParameter("exportName")).getBytes("ISO-8859-1"), "UTF-8");
            importFileName = new String((request.getParameter("importName")).getBytes("ISO-8859-1"), "UTF-8");
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // 读取文件
        File exportFile = new File(request.getSession().getServletContext().getRealPath("/Compare/" + exportFileName));
        File importFile = new File(request.getSession().getServletContext().getRealPath("/Compare/" + importFileName));
        
        // 读取excel 文件 存入集合中
        session.setAttribute("exSheet", findSheets(exportFileName, exportFile));
        session.setAttribute("imSheet", findSheets(importFileName, importFile));
        session.setAttribute("exFilenName", exportFileName);
        session.setAttribute("imFilenName", importFileName);
        return "success";
    }
    
    private List<String> findSheets(String fileName, File file)
    {
        List<String> lstSheet = null;
        // 判断是不是excel 2007
        boolean isE2007 = false;
        if (fileName.endsWith("xlsx"))
        {
            isE2007 = true;
        }
        try
        {
            InputStream is = new FileInputStream(file);
            Workbook wb = null;
            // 根据文件格式（2003或者2007）来初始化
            if (isE2007)
            {
                wb = new XSSFWorkbook(is);
            }
            else
            {
                wb = new HSSFWorkbook(is);
            }
            // 获得Sheet的个数
            int numberOfSheet = wb.getNumberOfSheets();
            
            lstSheet = new ArrayList<String>();
            // 把Sheet的名字加入集合中
            for (int i = 0; i < numberOfSheet; i++)
            {
                lstSheet.add(wb.getSheetAt(i).getSheetName());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return lstSheet;
        
    }
    
    private List<ImportExcel> readImportExcel(String exportFileName, File importFile)
    {
        
        // 判断是不是excel 2007
        boolean isE2007 = false;
        if (exportFileName.endsWith("xlsx"))
        {
            isE2007 = true;
        }
        try
        {
            InputStream imStream = new FileInputStream(importFile);
            Workbook wb = null;
            System.out.println(isE2007);
            // 根据文件格式（2003或者2007）来初始化
            if (isE2007)
            {
                wb = new XSSFWorkbook(imStream);
                System.out.println("2007");
            }
            else
            {
                wb = new HSSFWorkbook(imStream);
            }
            // 获取第一个Sheet
            Sheet sheet = wb.getSheetAt(0);
            // 获取表单迭代器
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    private List readExportExcel(String exportFileName, File exportFile)
    {
        List list = new ArrayList();
        // 判断是不是excel 2007
        boolean isE2007 = false;
        if (exportFileName.endsWith("xlsx"))
        {
            isE2007 = true;
        }
        try
        {
            InputStream is = new FileInputStream(exportFile);
            Workbook wb = null;
            if (isE2007)
            {
                wb = new XSSFWorkbook(is);
            }
            else
            {
                wb = new HSSFWorkbook(is);
            }
            // 获取第一个Sheet
            Sheet sheet = wb.getSheetAt(1);
            // 获取表单迭代器
            Iterator<Row> rows = sheet.rowIterator();
            while (rows.hasNext())
            {
                // 获得行数据
                Row row = rows.next();
                // System.out.println("Row #" + row.getRowNum()); // 获得行号从0开始
                
                // 定义map 存放数值
                Map<String, String> map = new HashMap<String, String>();
                Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器
                while (cells.hasNext())
                {
                    Cell cell = cells.next();
                    
                    // 根cell 中的类型输出数据
                    String value = "";
                    switch (cell.getCellType())
                    {
                        case HSSFCell.CELL_TYPE_STRING:
                            value = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            value = String.valueOf(cell.getNumericCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            value = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_BLANK:
                            value = "empty";
                    }
                    switch (cell.getColumnIndex() + 1)
                    {
                        case 1:
                            map.put("No", value);
                            break;
                        case 2:
                            map.put("orderNumber", value);
                            break;
                        case 3:
                            map.put("lineNimber", value);
                            break;
                        case 4:
                            map.put("productName", value);
                            break;
                        case 5:
                            map.put("productNumber", value);
                            break;
                        case 6:
                            map.put("quantity", value);
                            break;
                        case 7:
                            map.put("price", value);
                            break;
                        case 8:
                            map.put("totalPrice", value);
                            break;
                        default:
                            map.put("sendOrderNumber", value);
                            break;
                    }
                    
                }
                list.add(map);
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("size" + list.size());
        
        return list;
    }
}
