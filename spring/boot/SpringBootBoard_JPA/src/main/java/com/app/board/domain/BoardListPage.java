package com.app.board.domain;

import com.app.board.entity.Board;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BoardListPage {

    // 페이지당 출력할 게시물 개수 (받아야함)
    private int countPerPage;

    // 현재 페이지 번호 (받아야함)
    private int pageNum;

    // 표현 게시물의 리스트 (받아야함)
    //private List<BoardArticleDTO> list;
    private List<Board> list;

    // 전체 게시물의 개수 (받아야함)
    private int totalCount;

    // 페이징의 시작 번호 (내부 연산)
    private int startNum;

    // 페이징의 끝 번호 (내부 연산)
    private int endNum;

    // 이전 버튼 출력 여부 (내부 연산)
    private boolean prev;

    // 다름 버튼 출력 여부 (내부 연산)
    private boolean next;

    // 생성자
    public BoardListPage(int countPerPage, int pageNum, List<Board> list, int totalCount) {
        this.countPerPage = countPerPage;
        this.pageNum = pageNum;
        this.list = list;
        this.totalCount = totalCount;
        calPageInfo();
    }

    private void calPageInfo() {

        // 끝 번호 (페이지 넘버를 10개씩 보이게 할 경우)
//        this.endNum = (int) (Math.ceil((this.pageNum * 1.0) / 10)) * 10; // 1페이지요청: 1.0 => 여기에 나누기 10 => ....
//        this.startNum = this.endNum - 9;

        // 끝 번호 (페이지 넘버를 5개씩 보이게 할 경우)
        this.endNum = (int) (Math.ceil((this.pageNum * 1.0) / 5)) * 5; // 1페이지요청: 1.0 => 여기에 나누기 10 => ....
        this.startNum = this.endNum - 4;

        // 전체 페이지의 실제 끝 번호
        int realEndNum = (int) (Math.ceil((this.totalCount * 1.0) / countPerPage));

        // 구간의 마지막 번호보다 실제 페이지의 끝 번호가 작으면 endNum은 실제 끝 번호가 되어야 한다! / 끝 번호와 실제 끝번호를 비교하여 끝 번호를 다시 세팅함
        this.endNum = realEndNum < this.endNum ? realEndNum : this.endNum; // => 마지막 페이지의 끝 번호는 루틴 끝 번호보다 작으므로!!!

        this.prev = this.startNum > 1;

        this.next = this.endNum < realEndNum;


    }
}
