package com.teacher.praise.entity;

import javax.persistence.*;

@Table(name = "t_class")
public class TClass {
    @Id
    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "class_name")
    private String className;

    @Column(name = "class_size")
    private Integer classSize;

    @Column(name = "class_teacher")
    private String classTeacher;

    @Column(name = "class_start_time")
    private String classStartTime;

    @Column(name = "class_end_time")
    private String classEndTime;

    @Column(name = "class_type")
    private String classType;

    /**
     * @return class_id
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * @param classId
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * @return class_name
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * @return class_size
     */
    public Integer getClassSize() {
        return classSize;
    }

    /**
     * @param classSize
     */
    public void setClassSize(Integer classSize) {
        this.classSize = classSize;
    }

    /**
     * @return class_teacher
     */
    public String getClassTeacher() {
        return classTeacher;
    }

    /**
     * @param classTeacher
     */
    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher == null ? null : classTeacher.trim();
    }

    /**
     * @return class_start_time
     */
    public String getClassStartTime() {
        return classStartTime;
    }

    /**
     * @param classStartTime
     */
    public void setClassStartTime(String classStartTime) {
        this.classStartTime = classStartTime == null ? null : classStartTime.trim();
    }

    /**
     * @return class_end_time
     */
    public String getClassEndTime() {
        return classEndTime;
    }

    /**
     * @param classEndTime
     */
    public void setClassEndTime(String classEndTime) {
        this.classEndTime = classEndTime == null ? null : classEndTime.trim();
    }

    /**
     * @return class_type
     */
    public String getClassType() {
        return classType;
    }

    /**
     * @param classType
     */
    public void setClassType(String classType) {
        this.classType = classType == null ? null : classType.trim();
    }
}