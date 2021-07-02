package cn.syf.csp.fais.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.syf.csp.fais.po.NewStudent;
import cn.syf.csp.fais.po.SubjectCategory;
import cn.syf.csp.fais.service.impl.NewStudentServiceImpl;
import cn.syf.csp.fais.service.impl.SubjectCategoryServiceImpl;

@Controller
@RequestMapping("/newStudent")
public class NewStudentController {

	@Autowired
	private NewStudentServiceImpl newStudentServiceImpl;

	@Autowired
	private SubjectCategoryServiceImpl subjectCategoryServiceImpl;

	@RequestMapping("/selectpage")
	public String select() {
		return "newStudent/select";
	}

	@RequestMapping("/list")
	public String list(ModelMap map) {
		List<NewStudent> newStudents = newStudentServiceImpl.selectAll();
		map.addAttribute("newStudents", newStudents);
		return "newStudent/list";
	}

	@RequestMapping("/edit")
	public String edit(ModelMap map, String operation) {
		return "newStudent/edit";
	}

	@ResponseBody
	@RequestMapping("/toedit")
	public String toedit(ModelMap map, String operation, NewStudent newStudent) {
		List<NewStudent> newStudents = null;
		if (operation.equals("insert")) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String fillDate = df.format(new Date());// new Date()为获取当前系统时间
			newStudent.setFillTime(fillDate);
			String candidateNumber = newStudent.getCandidateNumber();
			newStudents= newStudentServiceImpl.findByCandidateNumber(candidateNumber);
		}
		System.out.println(newStudent);
		if (newStudents != null) {
			return "已提交该同学信息";
		} else {
			return "提交成功";
		}
	}

	@ResponseBody
	@RequestMapping("/selectMajor")
	public List<SubjectCategory> selectMajor(Integer subjectCategoryId) {
		List<SubjectCategory> subjects = subjectCategoryServiceImpl.findByFid(subjectCategoryId);
		return subjects;
	}

	@RequestMapping("/toexport")
	public void exportExcel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		//WritableWorkbook wk = Workbook.createWorkbook(output);
		/// 创建可写入的Excel工作表
		// WritableSheet sheet = wk.createSheet("录取学生表", 0);
		List<NewStudent> NewStudents = newStudentServiceImpl.selectAll();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("countryDB");
		XSSFRow row = sheet.createRow((short) 0);
		XSSFCell cell = null;
		sheet.setColumnWidth(1, 3000);
		sheet.setColumnWidth(2, 1500);
		sheet.setColumnWidth(3, 1500);
		sheet.setColumnWidth(4, 5000);
		sheet.setColumnWidth(5, 3000);
		sheet.setColumnWidth(6, 3000);
		sheet.setColumnWidth(7, 3000);

		cell = row.createCell((short) 0);
		cell.setCellValue("考生号");
		cell = row.createCell((short) 1);
		cell.setCellValue("姓名");
		cell = row.createCell((short) 2);
		cell.setCellValue("专业");
		cell = row.createCell((short) 3);
		cell.setCellValue("联系电话");

		cell = row.createCell((short) 4);

		cell.setCellValue("邮寄地址");

		cell = row.createCell((short) 5);

		cell.setCellValue("成绩");
		cell = row.createCell((short) 6);
		cell.setCellValue("录取时间");
		cell = row.createCell((short) 7);
		cell.setCellValue("顺丰快递");

		for (int i = 0, j = 1; i < NewStudents.size(); i++, j++) {

			row = sheet.createRow(j);
			cell = row.createCell(0);
			cell.setCellValue(NewStudents.get(i).getCandidateNumber());
			cell = row.createCell(1);
			cell.setCellValue(NewStudents.get(i).getName());
			cell = row.createCell(2);
			cell.setCellValue(NewStudents.get(i).getMajorName());
			cell = row.createCell(3);
			cell.setCellValue(NewStudents.get(i).getContact());
			cell = row.createCell(4);
			cell.setCellValue(NewStudents.get(i).getAddress());
			cell = row.createCell(5);
			cell.setCellValue(NewStudents.get(i).getGrade());
			cell = row.createCell(6);
			cell.setCellValue(NewStudents.get(i).getFillTime());
			cell = row.createCell(7);
			cell.setCellValue(NewStudents.get(i).getCourierNumber());
		}
		resp.setContentType("application/vnd.ms-excel;charset=utf-8");
		resp.setHeader("Content-disposition", "attachment; filename=录取学生.xls");
		OutputStream FOut =resp.getOutputStream();
		workbook.write(FOut);
		FOut.flush();
		FOut.close();
	}
}
