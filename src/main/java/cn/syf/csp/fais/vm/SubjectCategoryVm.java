package cn.syf.csp.fais.vm;

import cn.syf.csp.fais.po.SubjectCategory;

public class SubjectCategoryVm extends SubjectCategory{
	
		public SubjectCategoryVm(Integer id, String subjectName, Integer fid) {
		super(id, subjectName, fid);
		// TODO Auto-generated constructor stub
	}

		private SubjectCategory subjectCategory;

		public SubjectCategory getSubjectCategory() {
			return subjectCategory;
		}

		public void setSubjectCategory(SubjectCategory subjectCategory) {
			this.subjectCategory = subjectCategory;
		}

		@Override
		public String toString() {
			return "SubjectCategoryVm [subjectCategory=" + subjectCategory + "]";
		}
		
}
