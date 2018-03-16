package com.hydra.skye.ward.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DozenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DozenExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andKindIdIsNull() {
            addCriterion("kind_id is null");
            return (Criteria) this;
        }

        public Criteria andKindIdIsNotNull() {
            addCriterion("kind_id is not null");
            return (Criteria) this;
        }

        public Criteria andKindIdEqualTo(Long value) {
            addCriterion("kind_id =", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotEqualTo(Long value) {
            addCriterion("kind_id <>", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdGreaterThan(Long value) {
            addCriterion("kind_id >", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdGreaterThanOrEqualTo(Long value) {
            addCriterion("kind_id >=", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdLessThan(Long value) {
            addCriterion("kind_id <", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdLessThanOrEqualTo(Long value) {
            addCriterion("kind_id <=", value, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdIn(List<Long> values) {
            addCriterion("kind_id in", values, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotIn(List<Long> values) {
            addCriterion("kind_id not in", values, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdBetween(Long value1, Long value2) {
            addCriterion("kind_id between", value1, value2, "kindId");
            return (Criteria) this;
        }

        public Criteria andKindIdNotBetween(Long value1, Long value2) {
            addCriterion("kind_id not between", value1, value2, "kindId");
            return (Criteria) this;
        }

        public Criteria andLastOpUserIdIsNull() {
            addCriterion("last_op_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLastOpUserIdIsNotNull() {
            addCriterion("last_op_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastOpUserIdEqualTo(Long value) {
            addCriterion("last_op_user_id =", value, "lastOpUserId");
            return (Criteria) this;
        }

        public Criteria andLastOpUserIdNotEqualTo(Long value) {
            addCriterion("last_op_user_id <>", value, "lastOpUserId");
            return (Criteria) this;
        }

        public Criteria andLastOpUserIdGreaterThan(Long value) {
            addCriterion("last_op_user_id >", value, "lastOpUserId");
            return (Criteria) this;
        }

        public Criteria andLastOpUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("last_op_user_id >=", value, "lastOpUserId");
            return (Criteria) this;
        }

        public Criteria andLastOpUserIdLessThan(Long value) {
            addCriterion("last_op_user_id <", value, "lastOpUserId");
            return (Criteria) this;
        }

        public Criteria andLastOpUserIdLessThanOrEqualTo(Long value) {
            addCriterion("last_op_user_id <=", value, "lastOpUserId");
            return (Criteria) this;
        }

        public Criteria andLastOpUserIdIn(List<Long> values) {
            addCriterion("last_op_user_id in", values, "lastOpUserId");
            return (Criteria) this;
        }

        public Criteria andLastOpUserIdNotIn(List<Long> values) {
            addCriterion("last_op_user_id not in", values, "lastOpUserId");
            return (Criteria) this;
        }

        public Criteria andLastOpUserIdBetween(Long value1, Long value2) {
            addCriterion("last_op_user_id between", value1, value2, "lastOpUserId");
            return (Criteria) this;
        }

        public Criteria andLastOpUserIdNotBetween(Long value1, Long value2) {
            addCriterion("last_op_user_id not between", value1, value2, "lastOpUserId");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNull() {
            addCriterion("total_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNotNull() {
            addCriterion("total_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCountEqualTo(Integer value) {
            addCriterion("total_count =", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotEqualTo(Integer value) {
            addCriterion("total_count <>", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThan(Integer value) {
            addCriterion("total_count >", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_count >=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThan(Integer value) {
            addCriterion("total_count <", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_count <=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountIn(List<Integer> values) {
            addCriterion("total_count in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotIn(List<Integer> values) {
            addCriterion("total_count not in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountBetween(Integer value1, Integer value2) {
            addCriterion("total_count between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_count not between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andLeftCountIsNull() {
            addCriterion("left_count is null");
            return (Criteria) this;
        }

        public Criteria andLeftCountIsNotNull() {
            addCriterion("left_count is not null");
            return (Criteria) this;
        }

        public Criteria andLeftCountEqualTo(Integer value) {
            addCriterion("left_count =", value, "leftCount");
            return (Criteria) this;
        }

        public Criteria andLeftCountNotEqualTo(Integer value) {
            addCriterion("left_count <>", value, "leftCount");
            return (Criteria) this;
        }

        public Criteria andLeftCountGreaterThan(Integer value) {
            addCriterion("left_count >", value, "leftCount");
            return (Criteria) this;
        }

        public Criteria andLeftCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("left_count >=", value, "leftCount");
            return (Criteria) this;
        }

        public Criteria andLeftCountLessThan(Integer value) {
            addCriterion("left_count <", value, "leftCount");
            return (Criteria) this;
        }

        public Criteria andLeftCountLessThanOrEqualTo(Integer value) {
            addCriterion("left_count <=", value, "leftCount");
            return (Criteria) this;
        }

        public Criteria andLeftCountIn(List<Integer> values) {
            addCriterion("left_count in", values, "leftCount");
            return (Criteria) this;
        }

        public Criteria andLeftCountNotIn(List<Integer> values) {
            addCriterion("left_count not in", values, "leftCount");
            return (Criteria) this;
        }

        public Criteria andLeftCountBetween(Integer value1, Integer value2) {
            addCriterion("left_count between", value1, value2, "leftCount");
            return (Criteria) this;
        }

        public Criteria andLeftCountNotBetween(Integer value1, Integer value2) {
            addCriterion("left_count not between", value1, value2, "leftCount");
            return (Criteria) this;
        }

        public Criteria andTotalAreaIsNull() {
            addCriterion("total_area is null");
            return (Criteria) this;
        }

        public Criteria andTotalAreaIsNotNull() {
            addCriterion("total_area is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAreaEqualTo(Double value) {
            addCriterion("total_area =", value, "totalArea");
            return (Criteria) this;
        }

        public Criteria andTotalAreaNotEqualTo(Double value) {
            addCriterion("total_area <>", value, "totalArea");
            return (Criteria) this;
        }

        public Criteria andTotalAreaGreaterThan(Double value) {
            addCriterion("total_area >", value, "totalArea");
            return (Criteria) this;
        }

        public Criteria andTotalAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("total_area >=", value, "totalArea");
            return (Criteria) this;
        }

        public Criteria andTotalAreaLessThan(Double value) {
            addCriterion("total_area <", value, "totalArea");
            return (Criteria) this;
        }

        public Criteria andTotalAreaLessThanOrEqualTo(Double value) {
            addCriterion("total_area <=", value, "totalArea");
            return (Criteria) this;
        }

        public Criteria andTotalAreaIn(List<Double> values) {
            addCriterion("total_area in", values, "totalArea");
            return (Criteria) this;
        }

        public Criteria andTotalAreaNotIn(List<Double> values) {
            addCriterion("total_area not in", values, "totalArea");
            return (Criteria) this;
        }

        public Criteria andTotalAreaBetween(Double value1, Double value2) {
            addCriterion("total_area between", value1, value2, "totalArea");
            return (Criteria) this;
        }

        public Criteria andTotalAreaNotBetween(Double value1, Double value2) {
            addCriterion("total_area not between", value1, value2, "totalArea");
            return (Criteria) this;
        }

        public Criteria andLeftAreaIsNull() {
            addCriterion("left_area is null");
            return (Criteria) this;
        }

        public Criteria andLeftAreaIsNotNull() {
            addCriterion("left_area is not null");
            return (Criteria) this;
        }

        public Criteria andLeftAreaEqualTo(Double value) {
            addCriterion("left_area =", value, "leftArea");
            return (Criteria) this;
        }

        public Criteria andLeftAreaNotEqualTo(Double value) {
            addCriterion("left_area <>", value, "leftArea");
            return (Criteria) this;
        }

        public Criteria andLeftAreaGreaterThan(Double value) {
            addCriterion("left_area >", value, "leftArea");
            return (Criteria) this;
        }

        public Criteria andLeftAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("left_area >=", value, "leftArea");
            return (Criteria) this;
        }

        public Criteria andLeftAreaLessThan(Double value) {
            addCriterion("left_area <", value, "leftArea");
            return (Criteria) this;
        }

        public Criteria andLeftAreaLessThanOrEqualTo(Double value) {
            addCriterion("left_area <=", value, "leftArea");
            return (Criteria) this;
        }

        public Criteria andLeftAreaIn(List<Double> values) {
            addCriterion("left_area in", values, "leftArea");
            return (Criteria) this;
        }

        public Criteria andLeftAreaNotIn(List<Double> values) {
            addCriterion("left_area not in", values, "leftArea");
            return (Criteria) this;
        }

        public Criteria andLeftAreaBetween(Double value1, Double value2) {
            addCriterion("left_area between", value1, value2, "leftArea");
            return (Criteria) this;
        }

        public Criteria andLeftAreaNotBetween(Double value1, Double value2) {
            addCriterion("left_area not between", value1, value2, "leftArea");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("update_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("update_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Date value) {
            addCriterion("update_at =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Date value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Date value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Date value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Date> values) {
            addCriterion("update_at in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Date> values) {
            addCriterion("update_at not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Date value1, Date value2) {
            addCriterion("update_at between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("update_at not between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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