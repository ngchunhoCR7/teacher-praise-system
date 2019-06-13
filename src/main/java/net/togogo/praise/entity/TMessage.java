package net.togogo.praise.entity;

import javax.persistence.*;

@Table(name = "t_message")
public class TMessage {
    @Id
    @Column(name = "message_id")
    private Integer messageId;

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "message_time")
    private String messageTime;

    private String note;

    /**
     * @return message_id
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * @param messageId
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
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
     * @return message_time
     */
    public String getMessageTime() {
        return messageTime;
    }

    /**
     * @param messageTime
     */
    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime == null ? null : messageTime.trim();
    }

    /**
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}