package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.entity.ExportExcel;
import com.entity.ImportExcel;

public class AnalyseAction
{
    
    public AnalyseAction()
    {
        super();
    }
    
    // 获取文件进行保存到List集合中
    public String analyseFiles(HttpServletRequest request, HttpServletResponse response)
    {
        String exportFileName = "";
        String importFileName = "";
        try
        {
            // 通过new String 获取正确的文件名
            exportFileName = new String((request.getParameter("exportName")).getBytes("ISO-8859-1"), "UTF-8");
            importFileName = new String((request.getParameter("importName")).getBytes("ISO-8859-1"), "UTF-8");
            
            System.out.println("exportFileName"+exportFileName+ " importFileName"+importFileName);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        // 读取文件
        File exportFile = new File(request.getSession().getServletContext().getRealPath("/Compare/" + exportFileName));
        File importFile = new File(request.getSession().getServletContext().getRealPath("/Compare/" + importFileName));

        // 读取excel 文件 存入集合中
        List<ExportExcel> listExport = readExportExcel(exportFileName, exportFile);
        List<ImportExcel> listImoirt = readImportExcel(importFileName, importFile);
        return "ajax";
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
            Iterator<Row> rows = sheet.rowIterator();
            System.out.println(  "LastRowNum"+ sheet.getLastRowNum() );
            while (rows.hasNext())
            {
        
                // 获得行数据
                Row row = rows.next();
                System.out.println("Row #" + row.getRowNum()); // 获得行号从0开始
                Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器
                while (cells.hasNext())
                {
                    Cell cell = cells.next();
                    System.out.println("Cell #" + cell.getColumnIndex());
                    // 根cell 中的类型输出数据
               
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_STRING:
                            System.out.println(cell.getStringCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            System.out.println(String.valueOf(cell.getNumericCellValue()));
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            System.out.println(String.valueOf(cell.getBooleanCellValue()));
                            break;
                        case HSSFCell.CELL_TYPE_BLANK:
                            System.out.println("null");                   
                }
                }
                
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    private List<ExportExcel> readExportExcel(String exportFileName, File exportFile)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
