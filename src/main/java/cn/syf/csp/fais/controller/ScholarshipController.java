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

import cn.syf.csp.fais.po.Scholarship;
import cn.syf.csp.fais.po.SubjectCategory;
import cn.syf.csp.fais.service.impl.ScholarshipServiceImpl;
import cn.syf.csp.fais.service.impl.SubjectCategoryServiceImpl;

@Controller
@RequestMapping("/scholarship")
public class ScholarshipController {

	@Autowired
	private ScholarshipServiceImpl scholarshipServiceImpl;
	@Autowired
	private SubjectCategoryServiceImpl subjectCategoryServiceImpl;
	
	@RequestMapping("/list")
	public String list(ModelMap map) {
		List<Scholarship> scholarships = scholarshipServiceImpl.selectAll();
		map.addAttribute("scholarships", scholarships);
		return "scholarship/list";
	}
	
	@RequestMapping("/edit")
	public String edit(ModelMap map, String operation) {
		return "scholarship/edit";
	}

	@ResponseBody
	@RequestMapping("/toedit")
	public String toedit(ModelMap map, String operation, Scholarship scholarship) {
		int count = 0;
		if (operation.equals("insert")) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String fillDate = df.format(new Date());// new Date()为获取当前系统时间
			scholarship.setFillTime(fillDate);
			String candidateNumber = scholarship.getCandidateNumber();
			count = scholarshipServiceImpl.findByCandidateNumber(candidateNumber);
		}
		if (count > 0) {
			return "已提交该同学信息";
		} else {
			scholarshipServiceImpl.insert(scholarship);
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
	public String exportExcel(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		List<Scholarship> scholarships = scholarshipServiceImpl.selectAll();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("countryDB");
		XSSFRow row = sheet.createRow((short) 0);
		XSSFCell cell = null;
		
		sheet.setColumnWidth(1, 3000);
		sheet.setColumnWidth(4, 3000);
		sheet.setColumnWidth(5, 5000);
		sheet.setColumnWidth(6, 3000);
		sheet.setColumnWidth(7, 6000);
		
		cell = row.createCell((short) 0);
		cell.setCellValue("姓名");
		cell = row.createCell((short) 1);
		cell.setCellValue("考生号");
		cell = row.createCell((short) 2);
		cell.setCellValue("科类");
		cell = row.createCell((short) 3);
		cell.setCellValue("分数");
		cell = row.createCell((short) 4);
		cell.setCellValue("预填志愿号");
		cell = row.createCell((short) 5);
		cell.setCellValue("预填专业");
		cell = row.createCell((short) 6);
		cell.setCellValue("联系方式");
		cell = row.createCell((short) 7);
		cell.setCellValue("填报时间");

		for (int i = 0, j = 1; i < scholarships.size(); i++, j++) {

			row = sheet.createRow(j);
			cell = row.createCell(0);
			cell.setCellValue(scholarships.get(i).getName());
			cell = row.createCell(1);
			cell.setCellValue(scholarships.get(i).getCandidateNumber());
			cell = row.createCell(2);
			SubjectCategory subject = subjectCategoryServiceImpl.findById(scholarships.get(i).getSubjectCategoryId());
			cell.setCellValue(subject.getSubjectName());
			cell = row.createCell(3);	
			cell.setCellValue(scholarships.get(i).getGrade());
			cell = row.createCell(4);
			cell.setCellValue(scholarships.get(i).getVolunteerNumber());
			cell = row.createCell(5);
			subject = subjectCategoryServiceImpl.findById(scholarships.get(i).getMajorId());
			cell.setCellValue(subject.getSubjectName());
			cell = row.createCell(6);
			cell.setCellValue(scholarships.get(i).getContact());
			cell = row.createCell(7);
			cell.setCellValue(scholarships.get(i).getFillTime());
		}
		resp.setContentType("application/vnd.ms-excel;charset=utf-8");
		resp.setHeader("Content-disposition", "attachment; filename=奖学金.xls");
		OutputStream FOut =resp.getOutputStream();
		workbook.write(FOut);
		//FileOutputStream FOut = new FileOutputStream(outputFile);
		//workbook.write(FOut);
		FOut.flush();
		FOut.close();
		return "导出excel成功到c盘下";
	}
}
