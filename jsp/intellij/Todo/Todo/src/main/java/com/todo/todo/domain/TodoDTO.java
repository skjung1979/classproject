package com.todo.todo.domain;

public class TodoDTO {

    private long tno;
    private String todo;
    private String memo; // 상세설명
    private String dueDate; // 마감일자
    private boolean finished;

    // 기본 생성자
    public TodoDTO() {
    }

    // 변수 생성자
    public TodoDTO(long tno, String todo, String memo, String dueDate, boolean finished) {
        this.tno = tno;
        this.todo = todo;
        this.memo = memo;
        this.dueDate = dueDate;
        this.finished = finished;
    }

    public long getTno() {
        return tno;
    }

    public void setTno(long tno) {
        this.tno = tno;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    // boolean 형태는 아래처럼 게터가 생성되지만 EL에서 기존 형식대로 해도 잘 불려온다.
    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "TodoDTO{" +
                "tno=" + tno +
                ", todo='" + todo + '\'' +
                ", memo='" + memo + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", finished=" + finished +
                '}';
    }
}
