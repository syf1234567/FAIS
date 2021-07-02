package cn.syf.csp.fais.po;

import java.util.ArrayList;
import java.util.List;

public class ScholarshipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScholarshipExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberIsNull() {
            addCriterion("candidate_number is null");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberIsNotNull() {
            addCriterion("candidate_number is not null");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberEqualTo(String value) {
            addCriterion("candidate_number =", value, "candidateNumber");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberNotEqualTo(String value) {
            addCriterion("candidate_number <>", value, "candidateNumber");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberGreaterThan(String value) {
            addCriterion("candidate_number >", value, "candidateNumber");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberGreaterThanOrEqualTo(String value) {
            addCriterion("candidate_number >=", value, "candidateNumber");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberLessThan(String value) {
            addCriterion("candidate_number <", value, "candidateNumber");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberLessThanOrEqualTo(String value) {
            addCriterion("candidate_number <=", value, "candidateNumber");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberLike(String value) {
            addCriterion("candidate_number like", value, "candidateNumber");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberNotLike(String value) {
            addCriterion("candidate_number not like", value, "candidateNumber");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberIn(List<String> values) {
            addCriterion("candidate_number in", values, "candidateNumber");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberNotIn(List<String> values) {
            addCriterion("candidate_number not in", values, "candidateNumber");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberBetween(String value1, String value2) {
            addCriterion("candidate_number between", value1, value2, "candidateNumber");
            return (Criteria) this;
        }

        public Criteria andCandidateNumberNotBetween(String value1, String value2) {
            addCriterion("candidate_number not between", value1, value2, "candidateNumber");
            return (Criteria) this;
        }

        public Criteria andSubjectCategoryIdIsNull() {
            addCriterion("subject_category_id is null");
            return (Criteria) this;
        }

        public Criteria andSubjectCategoryIdIsNotNull() {
            addCriterion("subject_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectCategoryIdEqualTo(Integer value) {
            addCriterion("subject_category_id =", value, "subjectCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubjectCategoryIdNotEqualTo(Integer value) {
            addCriterion("subject_category_id <>", value, "subjectCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubjectCategoryIdGreaterThan(Integer value) {
            addCriterion("subject_category_id >", value, "subjectCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubjectCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_category_id >=", value, "subjectCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubjectCategoryIdLessThan(Integer value) {
            addCriterion("subject_category_id <", value, "subjectCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubjectCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("subject_category_id <=", value, "subjectCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubjectCategoryIdIn(List<Integer> values) {
            addCriterion("subject_category_id in", values, "subjectCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubjectCategoryIdNotIn(List<Integer> values) {
            addCriterion("subject_category_id not in", values, "subjectCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubjectCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("subject_category_id between", value1, value2, "subjectCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubjectCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_category_id not between", value1, value2, "subjectCategoryId");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Float value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Float value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Float value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Float value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Float value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Float value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Float> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Float> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Float value1, Float value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Float value1, Float value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberIsNull() {
            addCriterion("volunteer_number is null");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberIsNotNull() {
            addCriterion("volunteer_number is not null");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberEqualTo(String value) {
            addCriterion("volunteer_number =", value, "volunteerNumber");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberNotEqualTo(String value) {
            addCriterion("volunteer_number <>", value, "volunteerNumber");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberGreaterThan(String value) {
            addCriterion("volunteer_number >", value, "volunteerNumber");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberGreaterThanOrEqualTo(String value) {
            addCriterion("volunteer_number >=", value, "volunteerNumber");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberLessThan(String value) {
            addCriterion("volunteer_number <", value, "volunteerNumber");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberLessThanOrEqualTo(String value) {
            addCriterion("volunteer_number <=", value, "volunteerNumber");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberLike(String value) {
            addCriterion("volunteer_number like", value, "volunteerNumber");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberNotLike(String value) {
            addCriterion("volunteer_number not like", value, "volunteerNumber");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberIn(List<String> values) {
            addCriterion("volunteer_number in", values, "volunteerNumber");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberNotIn(List<String> values) {
            addCriterion("volunteer_number not in", values, "volunteerNumber");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberBetween(String value1, String value2) {
            addCriterion("volunteer_number between", value1, value2, "volunteerNumber");
            return (Criteria) this;
        }

        public Criteria andVolunteerNumberNotBetween(String value1, String value2) {
            addCriterion("volunteer_number not between", value1, value2, "volunteerNumber");
            return (Criteria) this;
        }

        public Criteria andMajorIdIsNull() {
            addCriterion("major_id is null");
            return (Criteria) this;
        }

        public Criteria andMajorIdIsNotNull() {
            addCriterion("major_id is not null");
            return (Criteria) this;
        }

        public Criteria andMajorIdEqualTo(Integer value) {
            addCriterion("major_id =", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotEqualTo(Integer value) {
            addCriterion("major_id <>", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdGreaterThan(Integer value) {
            addCriterion("major_id >", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("major_id >=", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdLessThan(Integer value) {
            addCriterion("major_id <", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdLessThanOrEqualTo(Integer value) {
            addCriterion("major_id <=", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdIn(List<Integer> values) {
            addCriterion("major_id in", values, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotIn(List<Integer> values) {
            addCriterion("major_id not in", values, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdBetween(Integer value1, Integer value2) {
            addCriterion("major_id between", value1, value2, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("major_id not between", value1, value2, "majorId");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andFillTimeIsNull() {
            addCriterion("fill_time is null");
            return (Criteria) this;
        }

        public Criteria andFillTimeIsNotNull() {
            addCriterion("fill_time is not null");
            return (Criteria) this;
        }

        public Criteria andFillTimeEqualTo(String value) {
            addCriterion("fill_time =", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeNotEqualTo(String value) {
            addCriterion("fill_time <>", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeGreaterThan(String value) {
            addCriterion("fill_time >", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeGreaterThanOrEqualTo(String value) {
            addCriterion("fill_time >=", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeLessThan(String value) {
            addCriterion("fill_time <", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeLessThanOrEqualTo(String value) {
            addCriterion("fill_time <=", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeLike(String value) {
            addCriterion("fill_time like", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeNotLike(String value) {
            addCriterion("fill_time not like", value, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeIn(List<String> values) {
            addCriterion("fill_time in", values, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeNotIn(List<String> values) {
            addCriterion("fill_time not in", values, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeBetween(String value1, String value2) {
            addCriterion("fill_time between", value1, value2, "fillTime");
            return (Criteria) this;
        }

        public Criteria andFillTimeNotBetween(String value1, String value2) {
            addCriterion("fill_time not between", value1, value2, "fillTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}