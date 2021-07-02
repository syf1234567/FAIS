package cn.syf.csp.fais.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import cn.syf.csp.fais.excel.ImportExcel;
import cn.syf.csp.fais.po.NewStudent;
import cn.syf.csp.fais.po.SubjectCategory;
import cn.syf.csp.fais.service.impl.NewStudentServiceImpl;
import cn.syf.csp.fais.service.impl.SubjectCategoryServiceImpl;

@RestController
@RequestMapping("/excel")
public class NewStudentExcelApi {

	@Autowired
	private NewStudentServiceImpl newStudentServiceImpl;

	@RequestMapping("/newStudent/toimport")
	public Map<String,Object> importExcel(@RequestParam("file") MultipartFile multfile) throws IOException {
		
		Map<String,Object> maps = new HashMap<String,Object>();
		Map<String,Object> maps2 = new HashMap<String,Object>();
		String fileName = multfile.getOriginalFilename();
		// 获取文件后缀
		String prefix = fileName.substring(fileName.lastIndexOf("."));
		// 用uuid作为文件名，防止生成的临时文件重复

		final File excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), prefix);
		// 将MultipartFile转为File

		multfile.transferTo(excelFile);

		System.out.println("contextLoads--》》测试成功");
		ImportExcel excel = new ImportExcel();
		List<NewStudent> newStudents = new ArrayList<NewStudent>();

		newStudents = excel.importXLS(excelFile.toString());
		// 程序结束时，删除临时文件
		deleteFile(excelFile);
		for (int i = 0; i < newStudents.size(); i++) {
			String candidateNumber = newStudents.get(i).getCandidateNumber();
			int count = newStudentServiceImpl.findCountByCandidateNumber(candidateNumber);
			if(count == 0) {
				newStudentServiceImpl.insert(newStudents.get(i));
			}
			 else {
				List<NewStudent> existNewStudents = newStudentServiceImpl.findByCandidateNumber(candidateNumber);
				int id = existNewStudents.get(0).getId();
				newStudents.get(i).setId(id);
				newStudentServiceImpl.update(newStudents.get(i));
			}
		}
		maps2.put("msg", "导入excel成功,请刷新页面");
		maps.put("code","0");
		maps.put("msg", "");
		maps.put("data", maps2);
		return maps;
	}

	/**
	 * 删除临时文件
	 * 
	 * @param files
	 */
	private void deleteFile(File... files) {
		for (File file : files) {
			if (file.exists()) {
				file.delete();
			}
		}
	}

}
