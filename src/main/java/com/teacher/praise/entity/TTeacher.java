package com.teacher.praise.entity;

import javax.persistence.*;

@Table(name = "t_teacher")
public class TTeacher {
    @Id
    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_account")
    private String teacherAccount;

    @Column(name = "teacher_password")
    private String teacherPassword;

    @Column(name = "teacher_score")
    private String teacherScore;

    /**
     * @return teacher_id
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * @param teacherId
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * @return teacher_name
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    /**
     * @return teacher_account
     */
    public String getTeacherAccount() {
        return teacherAccount;
    }

    /**
     * @param teacherAccount
     */
    public void setTeacherAccount(String teacherAccount) {
        this.teacherAccount = teacherAccount == null ? null : teacherAccount.trim();
    }

    /**
     * @return teacher_password
     */
    public String getTeacherPassword() {
        return teacherPassword;
    }

    /**
     * @param teacherPassword
     */
    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword == null ? null : teacherPassword.trim();
    }

    /**
     * @return teacher_score
     */
    public String getTeacherScore() {
        return teacherScore;
    }

    /**
     * @param teacherScore
     */
    public void setTeacherScore(String teacherScore) {
        this.teacherScore = teacherScore == null ? null : teacherScore.trim();
    }
}