package net.togogo.praise.entity;

import javax.persistence.*;

@Table(name = "t_praise")
public class TPraise {
    @Id
    @Column(name = "praise_id")
    private Integer praiseId;

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "class_teacher")
    private String classTeacher;

    @Column(name = "praise_time")
    private String praiseTime;

    @Column(name = "praise_score")
    private Integer praiseScore;

    /**
     * @return praise_id
     */
    public Integer getPraiseId() {
        return praiseId;
    }

    /**
     * @param praiseId
     */
    public void setPraiseId(Integer praiseId) {
        this.praiseId = praiseId;
    }

    /**
     * @return student_id
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * @param studentId
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

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
     * @return praise_time
     */
    public String getPraiseTime() {
        return praiseTime;
    }

    /**
     * @param praiseTime
     */
    public void setPraiseTime(String praiseTime) {
        this.praiseTime = praiseTime == null ? null : praiseTime.trim();
    }

    /**
     * @return praise_score
     */
    public Integer getPraiseScore() {
        return praiseScore;
    }

    /**
     * @param praiseScore
     */
    public void setPraiseScore(Integer praiseScore) {
        this.praiseScore = praiseScore;
    }
}