package com.meeting.model;
import java.util.ArrayList;
import java.util.List;
public class RoomMsgExample {
	protected String orderByClause;
	protected boolean distinct;
	protected int startRow;
	protected int pageRows;
	protected List<Criteria> oredCriteria;
	public RoomMsgExample() {
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
		public Criteria andRoomNoIsNull() {
			addCriterion("room_no is null");
			return (Criteria) this;
		}
		public Criteria andRoomNoIsNotNull(){
			addCriterion("room_no is not null");
			return (Criteria) this;
		}
		public Criteria andRoomNoEqualTo(String value) {
			addCriterion("room_no =", value, "roomNo");
			return (Criteria) this;
		}
		public Criteria andRoomNoNotEqualTo(String value) {
			addCriterion("room_no <>", value, "roomNo");
			return (Criteria) this;
		}
		public Criteria andRoomNoGreaterThan(String value) {
			addCriterion("room_no >", value, "roomNo");
			return (Criteria) this;
		}
		public Criteria andRoomNoGreaterThanOrEqualTo(String value) {
			addCriterion("room_no >=", value, "RoomNo");
			return (Criteria) this;
		}
		public Criteria andRoomNoLessThan(String value) {
			addCriterion("room_no <", value, "roomNo");
			return (Criteria) this;
		}
		public Criteria andRoomNoLessThanOrEqualTo(String value) {
			addCriterion("room_no <=", value, "roomNo");
			return (Criteria) this;
		}
		public Criteria andRoomNoIn(List<String> values) {
			addCriterion("room_no in", values, "roomNo");
			return (Criteria) this;
		}
		public Criteria andRoomNoNotIn(List<String> values) {
			addCriterion("room_no not in", values, "roomNo");
			return (Criteria) this;
		}
		public Criteria andRoomNoBetween(String value1, String value2) {
			addCriterion("room_no between", value1, value2, "roomNo");
			return (Criteria) this;
		}
		public Criteria andRoomNoNotBetween(String value1, String value2) {
			addCriterion("room_no not between", value1, value2, "roomNo");
			return (Criteria) this;
		}
		public Criteria andRoomNoLike(String value) {
			addCriterion("room_no like", value, "roomNo");
			return (Criteria) this;
		}
		public Criteria andRoomNoNotLike(String value) {
			addCriterion("room_no not like", value, "roomNo");
			return (Criteria) this;
		}
		public Criteria andRaddressIsNull() {
			addCriterion("raddress is null");
			return (Criteria) this;
		}
		public Criteria andRaddressIsNotNull(){
			addCriterion("raddress is not null");
			return (Criteria) this;
		}
		public Criteria andRaddressEqualTo(String value) {
			addCriterion("raddress =", value, "raddress");
			return (Criteria) this;
		}
		public Criteria andRaddressNotEqualTo(String value) {
			addCriterion("raddress <>", value, "raddress");
			return (Criteria) this;
		}
		public Criteria andRaddressGreaterThan(String value) {
			addCriterion("raddress >", value, "raddress");
			return (Criteria) this;
		}
		public Criteria andRaddressGreaterThanOrEqualTo(String value) {
			addCriterion("raddress >=", value, "Raddress");
			return (Criteria) this;
		}
		public Criteria andRaddressLessThan(String value) {
			addCriterion("raddress <", value, "raddress");
			return (Criteria) this;
		}
		public Criteria andRaddressLessThanOrEqualTo(String value) {
			addCriterion("raddress <=", value, "raddress");
			return (Criteria) this;
		}
		public Criteria andRaddressIn(List<String> values) {
			addCriterion("raddress in", values, "raddress");
			return (Criteria) this;
		}
		public Criteria andRaddressNotIn(List<String> values) {
			addCriterion("raddress not in", values, "raddress");
			return (Criteria) this;
		}
		public Criteria andRaddressBetween(String value1, String value2) {
			addCriterion("raddress between", value1, value2, "raddress");
			return (Criteria) this;
		}
		public Criteria andRaddressNotBetween(String value1, String value2) {
			addCriterion("raddress not between", value1, value2, "raddress");
			return (Criteria) this;
		}
		public Criteria andRaddressLike(String value) {
			addCriterion("raddress like", value, "raddress");
			return (Criteria) this;
		}
		public Criteria andRaddressNotLike(String value) {
			addCriterion("raddress not like", value, "raddress");
			return (Criteria) this;
		}
		public Criteria andRhyssbIsNull() {
			addCriterion("rhyssb is null");
			return (Criteria) this;
		}
		public Criteria andRhyssbIsNotNull(){
			addCriterion("rhyssb is not null");
			return (Criteria) this;
		}
		public Criteria andRhyssbEqualTo(String value) {
			addCriterion("rhyssb =", value, "rhyssb");
			return (Criteria) this;
		}
		public Criteria andRhyssbNotEqualTo(String value) {
			addCriterion("rhyssb <>", value, "rhyssb");
			return (Criteria) this;
		}
		public Criteria andRhyssbGreaterThan(String value) {
			addCriterion("rhyssb >", value, "rhyssb");
			return (Criteria) this;
		}
		public Criteria andRhyssbGreaterThanOrEqualTo(String value) {
			addCriterion("rhyssb >=", value, "Rhyssb");
			return (Criteria) this;
		}
		public Criteria andRhyssbLessThan(String value) {
			addCriterion("rhyssb <", value, "rhyssb");
			return (Criteria) this;
		}
		public Criteria andRhyssbLessThanOrEqualTo(String value) {
			addCriterion("rhyssb <=", value, "rhyssb");
			return (Criteria) this;
		}
		public Criteria andRhyssbIn(List<String> values) {
			addCriterion("rhyssb in", values, "rhyssb");
			return (Criteria) this;
		}
		public Criteria andRhyssbNotIn(List<String> values) {
			addCriterion("rhyssb not in", values, "rhyssb");
			return (Criteria) this;
		}
		public Criteria andRhyssbBetween(String value1, String value2) {
			addCriterion("rhyssb between", value1, value2, "rhyssb");
			return (Criteria) this;
		}
		public Criteria andRhyssbNotBetween(String value1, String value2) {
			addCriterion("rhyssb not between", value1, value2, "rhyssb");
			return (Criteria) this;
		}
		public Criteria andRhyssbLike(String value) {
			addCriterion("rhyssb like", value, "rhyssb");
			return (Criteria) this;
		}
		public Criteria andRhyssbNotLike(String value) {
			addCriterion("rhyssb not like", value, "rhyssb");
			return (Criteria) this;
		}
		public Criteria andRoomTypeIsNull() {
			addCriterion("room_type is null");
			return (Criteria) this;
		}
		public Criteria andRoomTypeIsNotNull(){
			addCriterion("room_type is not null");
			return (Criteria) this;
		}
		public Criteria andRoomTypeEqualTo(Integer value) {
			addCriterion("room_type =", value, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeNotEqualTo(Integer value) {
			addCriterion("room_type <>", value, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeGreaterThan(Integer value) {
			addCriterion("room_type >", value, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("room_type >=", value, "RoomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeLessThan(Integer value) {
			addCriterion("room_type <", value, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeLessThanOrEqualTo(Integer value) {
			addCriterion("room_type <=", value, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeIn(List<Integer> values) {
			addCriterion("room_type in", values, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeNotIn(List<Integer> values) {
			addCriterion("room_type not in", values, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeBetween(Integer value1, Integer value2) {
			addCriterion("room_type between", value1, value2, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("room_type not between", value1, value2, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeLike(Integer value) {
			addCriterion("room_type like", value, "roomType");
			return (Criteria) this;
		}
		public Criteria andRoomTypeNotLike(Integer value) {
			addCriterion("room_type not like", value, "roomType");
			return (Criteria) this;
		}
		public Criteria andNumIsNull() {
			addCriterion("num is null");
			return (Criteria) this;
		}
		public Criteria andNumIsNotNull(){
			addCriterion("num is not null");
			return (Criteria) this;
		}
		public Criteria andNumEqualTo(Integer value) {
			addCriterion("num =", value, "num");
			return (Criteria) this;
		}
		public Criteria andNumNotEqualTo(Integer value) {
			addCriterion("num <>", value, "num");
			return (Criteria) this;
		}
		public Criteria andNumGreaterThan(Integer value) {
			addCriterion("num >", value, "num");
			return (Criteria) this;
		}
		public Criteria andNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("num >=", value, "Num");
			return (Criteria) this;
		}
		public Criteria andNumLessThan(Integer value) {
			addCriterion("num <", value, "num");
			return (Criteria) this;
		}
		public Criteria andNumLessThanOrEqualTo(Integer value) {
			addCriterion("num <=", value, "num");
			return (Criteria) this;
		}
		public Criteria andNumIn(List<Integer> values) {
			addCriterion("num in", values, "num");
			return (Criteria) this;
		}
		public Criteria andNumNotIn(List<Integer> values) {
			addCriterion("num not in", values, "num");
			return (Criteria) this;
		}
		public Criteria andNumBetween(Integer value1, Integer value2) {
			addCriterion("num between", value1, value2, "num");
			return (Criteria) this;
		}
		public Criteria andNumNotBetween(Integer value1, Integer value2) {
			addCriterion("num not between", value1, value2, "num");
			return (Criteria) this;
		}
		public Criteria andNumLike(Integer value) {
			addCriterion("num like", value, "num");
			return (Criteria) this;
		}
		public Criteria andNumNotLike(Integer value) {
			addCriterion("num not like", value, "num");
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
