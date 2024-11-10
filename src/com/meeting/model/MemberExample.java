package com.meeting.model;
import java.util.ArrayList;
import java.util.List;
public class MemberExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public MemberExample() {
		oredCriteria = new ArrayList<>();
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
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
	public int getPageRows() {
		return pageRows;
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
			criteria = new ArrayList<>();
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
		public Criteria andIdIsNotNull(){
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
			addCriterion("id >=", value, "Id");
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
		public Criteria andIdLike(Integer value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}
		public Criteria andIdNotLike(Integer value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}
		public Criteria andStafIdIsNull() {
			addCriterion("staf_id is null");
			return (Criteria) this;
		}
		public Criteria andStafIdIsNotNull(){
			addCriterion("staf_id is not null");
			return (Criteria) this;
		}
		public Criteria andStafIdEqualTo(Integer value) {
			addCriterion("staf_id =", value, "stafId");
			return (Criteria) this;
		}
		public Criteria andStafIdNotEqualTo(Integer value) {
			addCriterion("staf_id <>", value, "stafId");
			return (Criteria) this;
		}
		public Criteria andStafIdGreaterThan(Integer value) {
			addCriterion("staf_id >", value, "stafId");
			return (Criteria) this;
		}
		public Criteria andStafIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("staf_id >=", value, "StafId");
			return (Criteria) this;
		}
		public Criteria andStafIdLessThan(Integer value) {
			addCriterion("staf_id <", value, "stafId");
			return (Criteria) this;
		}
		public Criteria andStafIdLessThanOrEqualTo(Integer value) {
			addCriterion("staf_id <=", value, "stafId");
			return (Criteria) this;
		}
		public Criteria andStafIdIn(List<Integer> values) {
			addCriterion("staf_id in", values, "stafId");
			return (Criteria) this;
		}
		public Criteria andStafIdNotIn(List<Integer> values) {
			addCriterion("staf_id not in", values, "stafId");
			return (Criteria) this;
		}
		public Criteria andStafIdBetween(Integer value1, Integer value2) {
			addCriterion("staf_id between", value1, value2, "stafId");
			return (Criteria) this;
		}
		public Criteria andStafIdNotBetween(Integer value1, Integer value2) {
			addCriterion("staf_id not between", value1, value2, "stafId");
			return (Criteria) this;
		}
		public Criteria andStafIdLike(Integer value) {
			addCriterion("staf_id like", value, "stafId");
			return (Criteria) this;
		}
		public Criteria andStafIdNotLike(Integer value) {
			addCriterion("staf_id not like", value, "stafId");
			return (Criteria) this;
		}
		public Criteria andRealNameIsNull() {
			addCriterion("real_name is null");
			return (Criteria) this;
		}
		public Criteria andRealNameIsNotNull(){
			addCriterion("real_name is not null");
			return (Criteria) this;
		}
		public Criteria andRealNameEqualTo(String value) {
			addCriterion("real_name =", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameNotEqualTo(String value) {
			addCriterion("real_name <>", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameGreaterThan(String value) {
			addCriterion("real_name >", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameGreaterThanOrEqualTo(String value) {
			addCriterion("real_name >=", value, "RealName");
			return (Criteria) this;
		}
		public Criteria andRealNameLessThan(String value) {
			addCriterion("real_name <", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameLessThanOrEqualTo(String value) {
			addCriterion("real_name <=", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameIn(List<String> values) {
			addCriterion("real_name in", values, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameNotIn(List<String> values) {
			addCriterion("real_name not in", values, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameBetween(String value1, String value2) {
			addCriterion("real_name between", value1, value2, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameNotBetween(String value1, String value2) {
			addCriterion("real_name not between", value1, value2, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameLike(String value) {
			addCriterion("real_name like", value, "realName");
			return (Criteria) this;
		}
		public Criteria andRealNameNotLike(String value) {
			addCriterion("real_name not like", value, "realName");
			return (Criteria) this;
		}
		public Criteria andCelphoneIsNull() {
			addCriterion("celphone is null");
			return (Criteria) this;
		}
		public Criteria andCelphoneIsNotNull(){
			addCriterion("celphone is not null");
			return (Criteria) this;
		}
		public Criteria andCelphoneEqualTo(String value) {
			addCriterion("celphone =", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneNotEqualTo(String value) {
			addCriterion("celphone <>", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneGreaterThan(String value) {
			addCriterion("celphone >", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneGreaterThanOrEqualTo(String value) {
			addCriterion("celphone >=", value, "Celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneLessThan(String value) {
			addCriterion("celphone <", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneLessThanOrEqualTo(String value) {
			addCriterion("celphone <=", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneIn(List<String> values) {
			addCriterion("celphone in", values, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneNotIn(List<String> values) {
			addCriterion("celphone not in", values, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneBetween(String value1, String value2) {
			addCriterion("celphone between", value1, value2, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneNotBetween(String value1, String value2) {
			addCriterion("celphone not between", value1, value2, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneLike(String value) {
			addCriterion("celphone like", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andCelphoneNotLike(String value) {
			addCriterion("celphone not like", value, "celphone");
			return (Criteria) this;
		}
		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}
		public Criteria andEmailIsNotNull(){
			addCriterion("email is not null");
			return (Criteria) this;
		}
		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}
		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}
		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}
		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "Email");
			return (Criteria) this;
		}
		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}
		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}
		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}
		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}
		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}
		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}
		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}
		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}
		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}
		public Criteria andRemarkIsNotNull(){
			addCriterion("remark is not null");
			return (Criteria) this;
		}
		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "Remark");
			return (Criteria) this;
		}
		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}
		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIsNotNull(){
			addCriterion("create_time is not null");
			return (Criteria) this;
		}
		public Criteria andCreateTimeEqualTo(String value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotEqualTo(String value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThan(String value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("create_time >=", value, "CreateTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLessThan(String value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLessThanOrEqualTo(String value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeIn(List<String> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotIn(List<String> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeBetween(String value1, String value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotBetween(String value1, String value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeLike(String value) {
			addCriterion("create_time like", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andCreateTimeNotLike(String value) {
			addCriterion("create_time not like", value, "createTime");
			return (Criteria) this;
		}
		public Criteria andMeetingIdIsNull() {
			addCriterion("meeting_id is null");
			return (Criteria) this;
		}
		public Criteria andMeetingIdIsNotNull(){
			addCriterion("meeting_id is not null");
			return (Criteria) this;
		}
		public Criteria andMeetingIdEqualTo(Integer value) {
			addCriterion("meeting_id =", value, "meetingId");
			return (Criteria) this;
		}
		public Criteria andMeetingIdNotEqualTo(Integer value) {
			addCriterion("meeting_id <>", value, "meetingId");
			return (Criteria) this;
		}
		public Criteria andMeetingIdGreaterThan(Integer value) {
			addCriterion("meeting_id >", value, "meetingId");
			return (Criteria) this;
		}
		public Criteria andMeetingIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("meeting_id >=", value, "MeetingId");
			return (Criteria) this;
		}
		public Criteria andMeetingIdLessThan(Integer value) {
			addCriterion("meeting_id <", value, "meetingId");
			return (Criteria) this;
		}
		public Criteria andMeetingIdLessThanOrEqualTo(Integer value) {
			addCriterion("meeting_id <=", value, "meetingId");
			return (Criteria) this;
		}
		public Criteria andMeetingIdIn(List<Integer> values) {
			addCriterion("meeting_id in", values, "meetingId");
			return (Criteria) this;
		}
		public Criteria andMeetingIdNotIn(List<Integer> values) {
			addCriterion("meeting_id not in", values, "meetingId");
			return (Criteria) this;
		}
		public Criteria andMeetingIdBetween(Integer value1, Integer value2) {
			addCriterion("meeting_id between", value1, value2, "meetingId");
			return (Criteria) this;
		}
		public Criteria andMeetingIdNotBetween(Integer value1, Integer value2) {
			addCriterion("meeting_id not between", value1, value2, "meetingId");
			return (Criteria) this;
		}
		public Criteria andMeetingIdLike(Integer value) {
			addCriterion("meeting_id like", value, "meetingId");
			return (Criteria) this;
		}
		public Criteria andMeetingIdNotLike(Integer value) {
			addCriterion("meeting_id not like", value, "meetingId");
			return (Criteria) this;
		}
		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}
		public Criteria andTitleIsNotNull(){
			addCriterion("title is not null");
			return (Criteria) this;
		}
		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "Title");
			return (Criteria) this;
		}
		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}
		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}
		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}
		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}
		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}
		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}
		public Criteria andStartTimeIsNull() {
			addCriterion("start_time is null");
			return (Criteria) this;
		}
		public Criteria andStartTimeIsNotNull(){
			addCriterion("start_time is not null");
			return (Criteria) this;
		}
		public Criteria andStartTimeEqualTo(String value) {
			addCriterion("start_time =", value, "startTime");
			return (Criteria) this;
		}
		public Criteria andStartTimeNotEqualTo(String value) {
			addCriterion("start_time <>", value, "startTime");
			return (Criteria) this;
		}
		public Criteria andStartTimeGreaterThan(String value) {
			addCriterion("start_time >", value, "startTime");
			return (Criteria) this;
		}
		public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
			addCriterion("start_time >=", value, "StartTime");
			return (Criteria) this;
		}
		public Criteria andStartTimeLessThan(String value) {
			addCriterion("start_time <", value, "startTime");
			return (Criteria) this;
		}
		public Criteria andStartTimeLessThanOrEqualTo(String value) {
			addCriterion("start_time <=", value, "startTime");
			return (Criteria) this;
		}
		public Criteria andStartTimeIn(List<String> values) {
			addCriterion("start_time in", values, "startTime");
			return (Criteria) this;
		}
		public Criteria andStartTimeNotIn(List<String> values) {
			addCriterion("start_time not in", values, "startTime");
			return (Criteria) this;
		}
		public Criteria andStartTimeBetween(String value1, String value2) {
			addCriterion("start_time between", value1, value2, "startTime");
			return (Criteria) this;
		}
		public Criteria andStartTimeNotBetween(String value1, String value2) {
			addCriterion("start_time not between", value1, value2, "startTime");
			return (Criteria) this;
		}
		public Criteria andStartTimeLike(String value) {
			addCriterion("start_time like", value, "startTime");
			return (Criteria) this;
		}
		public Criteria andStartTimeNotLike(String value) {
			addCriterion("start_time not like", value, "startTime");
			return (Criteria) this;
		}
		public Criteria andEndTimeIsNull() {
			addCriterion("end_time is null");
			return (Criteria) this;
		}
		public Criteria andEndTimeIsNotNull(){
			addCriterion("end_time is not null");
			return (Criteria) this;
		}
		public Criteria andEndTimeEqualTo(String value) {
			addCriterion("end_time =", value, "endTime");
			return (Criteria) this;
		}
		public Criteria andEndTimeNotEqualTo(String value) {
			addCriterion("end_time <>", value, "endTime");
			return (Criteria) this;
		}
		public Criteria andEndTimeGreaterThan(String value) {
			addCriterion("end_time >", value, "endTime");
			return (Criteria) this;
		}
		public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
			addCriterion("end_time >=", value, "EndTime");
			return (Criteria) this;
		}
		public Criteria andEndTimeLessThan(String value) {
			addCriterion("end_time <", value, "endTime");
			return (Criteria) this;
		}
		public Criteria andEndTimeLessThanOrEqualTo(String value) {
			addCriterion("end_time <=", value, "endTime");
			return (Criteria) this;
		}
		public Criteria andEndTimeIn(List<String> values) {
			addCriterion("end_time in", values, "endTime");
			return (Criteria) this;
		}
		public Criteria andEndTimeNotIn(List<String> values) {
			addCriterion("end_time not in", values, "endTime");
			return (Criteria) this;
		}
		public Criteria andEndTimeBetween(String value1, String value2) {
			addCriterion("end_time between", value1, value2, "endTime");
			return (Criteria) this;
		}
		public Criteria andEndTimeNotBetween(String value1, String value2) {
			addCriterion("end_time not between", value1, value2, "endTime");
			return (Criteria) this;
		}
		public Criteria andEndTimeLike(String value) {
			addCriterion("end_time like", value, "endTime");
			return (Criteria) this;
		}
		public Criteria andEndTimeNotLike(String value) {
			addCriterion("end_time not like", value, "endTime");
			return (Criteria) this;
		}
		public Criteria andRoomIdIsNull() {
			addCriterion("room_id is null");
			return (Criteria) this;
		}
		public Criteria andRoomIdIsNotNull(){
			addCriterion("room_id is not null");
			return (Criteria) this;
		}
		public Criteria andRoomIdEqualTo(Integer value) {
			addCriterion("room_id =", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdNotEqualTo(Integer value) {
			addCriterion("room_id <>", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdGreaterThan(Integer value) {
			addCriterion("room_id >", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("room_id >=", value, "RoomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdLessThan(Integer value) {
			addCriterion("room_id <", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
			addCriterion("room_id <=", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdIn(List<Integer> values) {
			addCriterion("room_id in", values, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdNotIn(List<Integer> values) {
			addCriterion("room_id not in", values, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdBetween(Integer value1, Integer value2) {
			addCriterion("room_id between", value1, value2, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
			addCriterion("room_id not between", value1, value2, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdLike(Integer value) {
			addCriterion("room_id like", value, "roomId");
			return (Criteria) this;
		}
		public Criteria andRoomIdNotLike(Integer value) {
			addCriterion("room_id not like", value, "roomId");
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
