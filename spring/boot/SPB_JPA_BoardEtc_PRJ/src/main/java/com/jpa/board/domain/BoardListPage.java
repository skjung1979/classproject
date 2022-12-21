package com.jpa.board.domain;

import com.jpa.board.entity.board.Board;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BoardListPage {

    private int countPerPage;

    private int pageNum;

    private List<Board> list;

    private int totalCount;

    private int startNum;

    private int endNum;

    private boolean prev;

    private boolean next;

    public BoardListPage(
            int countPerPage,
            int pageNum,
            List<Board> list,
            int totalCount) {
        this.countPerPage = countPerPage;
        this.pageNum = pageNum;
        this.list = list;
        this.totalCount = totalCount;
        calPageInfo();
    }

    private void calPageInfo(){

        // 끝번호
        this.endNum = (int)(Math.ceil((this.pageNum * 1.0) / 5)) * 5;

        // 시작 번호
        // 페이지에 10개씩 보이게 하려함.
        // 5개씩 보이게 하려면 끝번호 계산에서 나누고 곲하는 값을 10대신 5로 변경하고
        // 시작 번호는 끝번호에서 4를 빼준다.
        this.startNum = this.endNum - 4;

        // 전체 페이지의 끝번호
        int realEndNum = (int)(Math.ceil((this.totalCount * 1.0) / countPerPage));

        // 구간의 마지막 번호 보다 실제 페이지 끝번호가 작으면 endNum은 실제 끝번호가 되어야 한다.
        this.endNum = realEndNum < this.endNum ? realEndNum : this.endNum;

        // 이전 구간으로 이동 가능한지
        this.prev = this.startNum > 1;

        // 다음 구간으로 이동 가능한지
        this.next = this.endNum < realEndNum;

    }
}
