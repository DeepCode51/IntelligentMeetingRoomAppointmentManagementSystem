package com.meeting.model;
import java.util.ArrayList;
import java.util.List;
public class NoticeMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public NoticeMsgExample() {
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
		public Criteria andNoticeNameIsNull() {
			addCriterion("notice_name is null");
			return (Criteria) this;
		}
		public Criteria andNoticeNameIsNotNull(){
			addCriterion("notice_name is not null");
			return (Criteria) this;
		}
		public Criteria andNoticeNameEqualTo(String value) {
			addCriterion("notice_name =", value, "noticeName");
			return (Criteria) this;
		}
		public Criteria andNoticeNameNotEqualTo(String value) {
			addCriterion("notice_name <>", value, "noticeName");
			return (Criteria) this;
		}
		public Criteria andNoticeNameGreaterThan(String value) {
			addCriterion("notice_name >", value, "noticeName");
			return (Criteria) this;
		}
		public Criteria andNoticeNameGreaterThanOrEqualTo(String value) {
			addCriterion("notice_name >=", value, "NoticeName");
			return (Criteria) this;
		}
		public Criteria andNoticeNameLessThan(String value) {
			addCriterion("notice_name <", value, "noticeName");
			return (Criteria) this;
		}
		public Criteria andNoticeNameLessThanOrEqualTo(String value) {
			addCriterion("notice_name <=", value, "noticeName");
			return (Criteria) this;
		}
		public Criteria andNoticeNameIn(List<String> values) {
			addCriterion("notice_name in", values, "noticeName");
			return (Criteria) this;
		}
		public Criteria andNoticeNameNotIn(List<String> values) {
			addCriterion("notice_name not in", values, "noticeName");
			return (Criteria) this;
		}
		public Criteria andNoticeNameBetween(String value1, String value2) {
			addCriterion("notice_name between", value1, value2, "noticeName");
			return (Criteria) this;
		}
		public Criteria andNoticeNameNotBetween(String value1, String value2) {
			addCriterion("notice_name not between", value1, value2, "noticeName");
			return (Criteria) this;
		}
		public Criteria andNoticeNameLike(String value) {
			addCriterion("notice_name like", value, "noticeName");
			return (Criteria) this;
		}
		public Criteria andNoticeNameNotLike(String value) {
			addCriterion("notice_name not like", value, "noticeName");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailIsNull() {
			addCriterion("notice_detail is null");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailIsNotNull(){
			addCriterion("notice_detail is not null");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailEqualTo(String value) {
			addCriterion("notice_detail =", value, "noticeDetail");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailNotEqualTo(String value) {
			addCriterion("notice_detail <>", value, "noticeDetail");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailGreaterThan(String value) {
			addCriterion("notice_detail >", value, "noticeDetail");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailGreaterThanOrEqualTo(String value) {
			addCriterion("notice_detail >=", value, "NoticeDetail");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailLessThan(String value) {
			addCriterion("notice_detail <", value, "noticeDetail");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailLessThanOrEqualTo(String value) {
			addCriterion("notice_detail <=", value, "noticeDetail");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailIn(List<String> values) {
			addCriterion("notice_detail in", values, "noticeDetail");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailNotIn(List<String> values) {
			addCriterion("notice_detail not in", values, "noticeDetail");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailBetween(String value1, String value2) {
			addCriterion("notice_detail between", value1, value2, "noticeDetail");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailNotBetween(String value1, String value2) {
			addCriterion("notice_detail not between", value1, value2, "noticeDetail");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailLike(String value) {
			addCriterion("notice_detail like", value, "noticeDetail");
			return (Criteria) this;
		}
		public Criteria andNoticeDetailNotLike(String value) {
			addCriterion("notice_detail not like", value, "noticeDetail");
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
