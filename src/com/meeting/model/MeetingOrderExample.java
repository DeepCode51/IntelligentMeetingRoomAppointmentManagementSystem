package com.meeting.model;
import java.util.ArrayList;
import java.util.List;
public class MeetingOrderExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public MeetingOrderExample() {
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
		public Criteria andUidIsNull() {
			addCriterion("uid is null");
			return (Criteria) this;
		}
		public Criteria andUidIsNotNull(){
			addCriterion("uid is not null");
			return (Criteria) this;
		}
		public Criteria andUidEqualTo(Integer value) {
			addCriterion("uid =", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidNotEqualTo(Integer value) {
			addCriterion("uid <>", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidGreaterThan(Integer value) {
			addCriterion("uid >", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("uid >=", value, "Uid");
			return (Criteria) this;
		}
		public Criteria andUidLessThan(Integer value) {
			addCriterion("uid <", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidLessThanOrEqualTo(Integer value) {
			addCriterion("uid <=", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidIn(List<Integer> values) {
			addCriterion("uid in", values, "uid");
			return (Criteria) this;
		}
		public Criteria andUidNotIn(List<Integer> values) {
			addCriterion("uid not in", values, "uid");
			return (Criteria) this;
		}
		public Criteria andUidBetween(Integer value1, Integer value2) {
			addCriterion("uid between", value1, value2, "uid");
			return (Criteria) this;
		}
		public Criteria andUidNotBetween(Integer value1, Integer value2) {
			addCriterion("uid not between", value1, value2, "uid");
			return (Criteria) this;
		}
		public Criteria andUidLike(Integer value) {
			addCriterion("uid like", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUidNotLike(Integer value) {
			addCriterion("uid not like", value, "uid");
			return (Criteria) this;
		}
		public Criteria andUdepartIdIsNull() {
			addCriterion("udepart_id is null");
			return (Criteria) this;
		}
		public Criteria andUdepartIdIsNotNull(){
			addCriterion("udepart_id is not null");
			return (Criteria) this;
		}
		public Criteria andUdepartIdEqualTo(Integer value) {
			addCriterion("udepart_id =", value, "udepartId");
			return (Criteria) this;
		}
		public Criteria andUdepartIdNotEqualTo(Integer value) {
			addCriterion("udepart_id <>", value, "udepartId");
			return (Criteria) this;
		}
		public Criteria andUdepartIdGreaterThan(Integer value) {
			addCriterion("udepart_id >", value, "udepartId");
			return (Criteria) this;
		}
		public Criteria andUdepartIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("udepart_id >=", value, "UdepartId");
			return (Criteria) this;
		}
		public Criteria andUdepartIdLessThan(Integer value) {
			addCriterion("udepart_id <", value, "udepartId");
			return (Criteria) this;
		}
		public Criteria andUdepartIdLessThanOrEqualTo(Integer value) {
			addCriterion("udepart_id <=", value, "udepartId");
			return (Criteria) this;
		}
		public Criteria andUdepartIdIn(List<Integer> values) {
			addCriterion("udepart_id in", values, "udepartId");
			return (Criteria) this;
		}
		public Criteria andUdepartIdNotIn(List<Integer> values) {
			addCriterion("udepart_id not in", values, "udepartId");
			return (Criteria) this;
		}
		public Criteria andUdepartIdBetween(Integer value1, Integer value2) {
			addCriterion("udepart_id between", value1, value2, "udepartId");
			return (Criteria) this;
		}
		public Criteria andUdepartIdNotBetween(Integer value1, Integer value2) {
			addCriterion("udepart_id not between", value1, value2, "udepartId");
			return (Criteria) this;
		}
		public Criteria andUdepartIdLike(Integer value) {
			addCriterion("udepart_id like", value, "udepartId");
			return (Criteria) this;
		}
		public Criteria andUdepartIdNotLike(Integer value) {
			addCriterion("udepart_id not like", value, "udepartId");
			return (Criteria) this;
		}
		public Criteria andRidIsNull() {
			addCriterion("rid is null");
			return (Criteria) this;
		}
		public Criteria andRidIsNotNull(){
			addCriterion("rid is not null");
			return (Criteria) this;
		}
		public Criteria andRidEqualTo(Integer value) {
			addCriterion("rid =", value, "rid");
			return (Criteria) this;
		}
		public Criteria andRidNotEqualTo(Integer value) {
			addCriterion("rid <>", value, "rid");
			return (Criteria) this;
		}
		public Criteria andRidGreaterThan(Integer value) {
			addCriterion("rid >", value, "rid");
			return (Criteria) this;
		}
		public Criteria andRidGreaterThanOrEqualTo(Integer value) {
			addCriterion("rid >=", value, "Rid");
			return (Criteria) this;
		}
		public Criteria andRidLessThan(Integer value) {
			addCriterion("rid <", value, "rid");
			return (Criteria) this;
		}
		public Criteria andRidLessThanOrEqualTo(Integer value) {
			addCriterion("rid <=", value, "rid");
			return (Criteria) this;
		}
		public Criteria andRidIn(List<Integer> values) {
			addCriterion("rid in", values, "rid");
			return (Criteria) this;
		}
		public Criteria andRidNotIn(List<Integer> values) {
			addCriterion("rid not in", values, "rid");
			return (Criteria) this;
		}
		public Criteria andRidBetween(Integer value1, Integer value2) {
			addCriterion("rid between", value1, value2, "rid");
			return (Criteria) this;
		}
		public Criteria andRidNotBetween(Integer value1, Integer value2) {
			addCriterion("rid not between", value1, value2, "rid");
			return (Criteria) this;
		}
		public Criteria andRidLike(Integer value) {
			addCriterion("rid like", value, "rid");
			return (Criteria) this;
		}
		public Criteria andRidNotLike(Integer value) {
			addCriterion("rid not like", value, "rid");
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
		public Criteria andUsingIntroIsNull() {
			addCriterion("using_intro is null");
			return (Criteria) this;
		}
		public Criteria andUsingIntroIsNotNull(){
			addCriterion("using_intro is not null");
			return (Criteria) this;
		}
		public Criteria andUsingIntroEqualTo(String value) {
			addCriterion("using_intro =", value, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroNotEqualTo(String value) {
			addCriterion("using_intro <>", value, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroGreaterThan(String value) {
			addCriterion("using_intro >", value, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroGreaterThanOrEqualTo(String value) {
			addCriterion("using_intro >=", value, "UsingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroLessThan(String value) {
			addCriterion("using_intro <", value, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroLessThanOrEqualTo(String value) {
			addCriterion("using_intro <=", value, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroIn(List<String> values) {
			addCriterion("using_intro in", values, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroNotIn(List<String> values) {
			addCriterion("using_intro not in", values, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroBetween(String value1, String value2) {
			addCriterion("using_intro between", value1, value2, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroNotBetween(String value1, String value2) {
			addCriterion("using_intro not between", value1, value2, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroLike(String value) {
			addCriterion("using_intro like", value, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andUsingIntroNotLike(String value) {
			addCriterion("using_intro not like", value, "usingIntro");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusIsNull() {
			addCriterion("meeting_status is null");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusIsNotNull(){
			addCriterion("meeting_status is not null");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusEqualTo(Integer value) {
			addCriterion("meeting_status =", value, "meetingStatus");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusNotEqualTo(Integer value) {
			addCriterion("meeting_status <>", value, "meetingStatus");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusGreaterThan(Integer value) {
			addCriterion("meeting_status >", value, "meetingStatus");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("meeting_status >=", value, "MeetingStatus");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusLessThan(Integer value) {
			addCriterion("meeting_status <", value, "meetingStatus");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusLessThanOrEqualTo(Integer value) {
			addCriterion("meeting_status <=", value, "meetingStatus");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusIn(List<Integer> values) {
			addCriterion("meeting_status in", values, "meetingStatus");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusNotIn(List<Integer> values) {
			addCriterion("meeting_status not in", values, "meetingStatus");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusBetween(Integer value1, Integer value2) {
			addCriterion("meeting_status between", value1, value2, "meetingStatus");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("meeting_status not between", value1, value2, "meetingStatus");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusLike(Integer value) {
			addCriterion("meeting_status like", value, "meetingStatus");
			return (Criteria) this;
		}
		public Criteria andMeetingStatusNotLike(Integer value) {
			addCriterion("meeting_status not like", value, "meetingStatus");
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
		public Criteria andTotalHoursIsNull() {
			addCriterion("total_hours is null");
			return (Criteria) this;
		}
		public Criteria andTotalHoursIsNotNull(){
			addCriterion("total_hours is not null");
			return (Criteria) this;
		}
		public Criteria andTotalHoursEqualTo(Double value) {
			addCriterion("total_hours =", value, "totalHours");
			return (Criteria) this;
		}
		public Criteria andTotalHoursNotEqualTo(Double value) {
			addCriterion("total_hours <>", value, "totalHours");
			return (Criteria) this;
		}
		public Criteria andTotalHoursGreaterThan(Double value) {
			addCriterion("total_hours >", value, "totalHours");
			return (Criteria) this;
		}
		public Criteria andTotalHoursGreaterThanOrEqualTo(Double value) {
			addCriterion("total_hours >=", value, "TotalHours");
			return (Criteria) this;
		}
		public Criteria andTotalHoursLessThan(Double value) {
			addCriterion("total_hours <", value, "totalHours");
			return (Criteria) this;
		}
		public Criteria andTotalHoursLessThanOrEqualTo(Double value) {
			addCriterion("total_hours <=", value, "totalHours");
			return (Criteria) this;
		}
		public Criteria andTotalHoursIn(List<Double> values) {
			addCriterion("total_hours in", values, "totalHours");
			return (Criteria) this;
		}
		public Criteria andTotalHoursNotIn(List<Double> values) {
			addCriterion("total_hours not in", values, "totalHours");
			return (Criteria) this;
		}
		public Criteria andTotalHoursBetween(Double value1, Double value2) {
			addCriterion("total_hours between", value1, value2, "totalHours");
			return (Criteria) this;
		}
		public Criteria andTotalHoursNotBetween(Double value1, Double value2) {
			addCriterion("total_hours not between", value1, value2, "totalHours");
			return (Criteria) this;
		}
		public Criteria andTotalHoursLike(Double value) {
			addCriterion("total_hours like", value, "totalHours");
			return (Criteria) this;
		}
		public Criteria andTotalHoursNotLike(Double value) {
			addCriterion("total_hours not like", value, "totalHours");
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
