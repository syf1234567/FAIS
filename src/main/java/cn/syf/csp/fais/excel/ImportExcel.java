package cn.syf.csp.fais.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.multipart.MultipartFile;

import cn.syf.csp.fais.po.NewStudent;

public class ImportExcel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<NewStudent> importXLS(String fileName) {

		List<NewStudent> list = new java.util.ArrayList<NewStudent>();

		try {
			// 1、获取文件输入流
			InputStream inputStream = new FileInputStream(
					fileName);
			// 2、获取Excel工作簿对象
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			// 3、得到Excel工作表对象
			HSSFSheet sheetAt = workbook.getSheetAt(0);
			// 4、循环读取表格数据
			for (Row row : sheetAt) {
				// 首行（即表头）不读取
				if (row.getRowNum() == 0) {
					continue;
				}
				NewStudent newStudent = new NewStudent();
				// 每一行有几个单元格
//				int physicalNumberOfCells = row.getPhysicalNumberOfCells();
//				for(int i=0 ; i<physicalNumberOfCells ; i++) {
//					;
//				}			
				// 读取当前行中单元格数据，索引从0开始
				String candidateNumber = row.getCell(0).getStringCellValue();
				if(candidateNumber==""||candidateNumber==null) {
					break;
				}
				String name = row.getCell(1).getStringCellValue();
				String majorName = row.getCell(2).getStringCellValue();
				String contact = row.getCell(3).getStringCellValue();
				String address = row.getCell(4).getStringCellValue();
				double grade = row.getCell(5).getNumericCellValue();
				String fillTime = getCellValue(row.getCell(6));
				String courierNumber = getCellValue(row.getCell(7));
				newStudent.setName(name);
				newStudent.setCandidateNumber(candidateNumber);
				newStudent.setMajorName(majorName);
				newStudent.setGrade((float) grade);
				newStudent.setContact(contact);
				newStudent.setAddress(address);
				newStudent.setFillTime(fillTime);
				newStudent.setCourierNumber(courierNumber);
				list.add(newStudent);
			}
			// 5、关闭流
			workbook.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings({ "deprecation", "unlikely-arg-type" })
	public String getCellValue(Cell cell) {
		if (cell == null)
			return "";
		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
			return cell.getCellFormula();
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			short format = cell.getCellStyle().getDataFormat();
		//	System.out.println("format:" + format + ";;;;;value:" + cell.getNumericCellValue());
			SimpleDateFormat sdf = null;
			if (format == 14 || format == 31 || format == 57 || format == 58 || (176 <= format && format <= 178)
					|| (182 <= format && format <= 196) || (210 <= format && format <= 213) || (208 == format)) { // 日期
				sdf = new SimpleDateFormat("yyyy-MM-dd");
			} else if (format == 20 || format == 32 || format == 183 || (200 <= format && format <= 209)) { // 时间
				sdf = new SimpleDateFormat("HH:mm");
			} else { // 不是日期格式
				return String.valueOf(cell.getNumericCellValue());
			}
			double value = cell.getNumericCellValue();
			Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
			if (date == null || "".equals(date)) {
				return "";
			}
			String result = "";
			try {
				result = sdf.format(date);
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
			return result;
		}
		return "";
	}
}
